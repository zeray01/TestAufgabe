package com.example.testaufgabe.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.testaufgabe.data.mapper.SWItemMapper
import com.example.testaufgabe.data.remote.SwapiService
import com.example.testaufgabe.domain.model.SWItem
import com.example.testaufgabe.domain.model.SwapiResourceType

class SWPagingSource(
    private val api: SwapiService,
    private val resourceType: SwapiResourceType,
    private val mapper: SWItemMapper
) : PagingSource<Int, SWItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SWItem> {
        return try {
            val page = params.key ?: 1
            val response = api.getResourcePage(resourceType.path, page).body()

            response?.let {
                val items = response.results
                    .map { mapper.map(resourceType, it) }

                val nextPage = response.next
                    ?.substringAfter("page=")
                    ?.toIntOrNull()

                val prevPage = response.previous
                    ?.substringAfter("page=")
                    ?.toIntOrNull()

                LoadResult.Page(
                    data = items,
                    prevKey = prevPage,
                    nextKey = nextPage
                )
            } ?: throw IllegalStateException("SWAPI response body was null")
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, SWItem>): Int? {
        val anchor = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchor) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }
}
