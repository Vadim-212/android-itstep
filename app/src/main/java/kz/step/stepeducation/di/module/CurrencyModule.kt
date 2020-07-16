package kz.step.stepeducation.di.module

import dagger.Module
import dagger.Provides
import kz.step.stepeducation.domain.CurrenciesUseCase

@Module
class CurrencyModule {
    @Provides
    fun providesCurrenciesUseCase(): CurrenciesUseCase {
        return CurrenciesUseCase()
    }
}