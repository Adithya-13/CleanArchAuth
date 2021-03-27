package com.codext.project.cleanarchauth.di

import com.codext.project.core.domain.usecase.AuthInteractor
import com.codext.project.core.domain.usecase.AuthUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideAuthUseCase(authInteractor: AuthInteractor): AuthUseCase

}
