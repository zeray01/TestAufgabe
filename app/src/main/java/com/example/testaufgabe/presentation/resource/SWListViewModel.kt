package com.example.testaufgabe.presentation.resource

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.testaufgabe.domain.model.SWItem
import com.example.testaufgabe.domain.model.SwapiResourceType
import com.example.testaufgabe.domain.usecase.GetResourcePagingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class SWListViewModel @Inject constructor(
    private val getResourcePagingUseCase: GetResourcePagingUseCase
) : ViewModel() {

    fun pagingFlowFor(type: SwapiResourceType): Flow<PagingData<SWItem>> =
        getResourcePagingUseCase(type).cachedIn(viewModelScope)
}
