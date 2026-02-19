package com.example.testaufgabe.di

import com.example.testaufgabe.domain.repository.SwapiResourceRepository
import com.example.testaufgabe.domain.usecase.GetResourcePagingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetResourcePagingUseCase(
        repository: SwapiResourceRepository
    ): GetResourcePagingUseCase = GetResourcePagingUseCase(repository)
}
