package com.example.testaufgabe.domain.usecase

import androidx.paging.PagingData
import com.example.testaufgabe.domain.model.SWItem
import com.example.testaufgabe.domain.model.SwapiResourceType
import com.example.testaufgabe.domain.repository.SwapiResourceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetResourcePagingUseCase @Inject constructor(
    private val repository: SwapiResourceRepository
) {

    operator fun invoke(
        type: SwapiResourceType
    ): Flow<PagingData<SWItem>> = repository.getResourcePagingData(type)
}
