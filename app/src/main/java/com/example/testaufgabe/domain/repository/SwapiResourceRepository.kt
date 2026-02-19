package com.example.testaufgabe.domain.repository

import androidx.paging.PagingData
import com.example.testaufgabe.domain.model.SWItem
import com.example.testaufgabe.domain.model.SwapiResourceType
import kotlinx.coroutines.flow.Flow

interface SwapiResourceRepository {

    fun getResourcePagingData(
        type: SwapiResourceType
    ): Flow<PagingData<SWItem>>
}
