package com.codext.project.core.di

import com.codext.project.core.data.source.AuthRepository
import com.codext.project.core.domain.repository.IAuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module(includes = [NetworkModule::class])
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(authRepository: AuthRepository): IAuthRepository

}