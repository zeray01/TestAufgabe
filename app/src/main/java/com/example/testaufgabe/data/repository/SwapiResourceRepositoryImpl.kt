package com.example.testaufgabe.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.testaufgabe.data.mapper.SWItemMapper
import com.example.testaufgabe.data.paging.SWPagingSource
import com.example.testaufgabe.data.remote.SwapiService
import com.example.testaufgabe.domain.model.SWItem
import com.example.testaufgabe.domain.model.SwapiResourceType
import com.example.testaufgabe.domain.repository.SwapiResourceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SwapiResourceRepositoryImpl @Inject constructor(
    private val api: SwapiService,
    private val mapper: SWItemMapper
) : SwapiResourceRepository {

    override fun getResourcePagingData(
        type: SwapiResourceType
    ): Flow<PagingData<SWItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                SWPagingSource(api, type, mapper)
            }
        ).flow
    }
}
