package com.example.testaufgabe.di

import com.example.testaufgabe.data.mapper.SWItemMapper
import com.example.testaufgabe.data.mapper.SWItemMapperImpl
import com.example.testaufgabe.data.repository.SwapiResourceRepositoryImpl
import com.example.testaufgabe.domain.repository.SwapiResourceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideGenericItemMapper(): SWItemMapper =
        SWItemMapperImpl()

    @Provides
    @Singleton
    fun provideSwapiResourceRepository(
        impl: SwapiResourceRepositoryImpl
    ): SwapiResourceRepository = impl
}
