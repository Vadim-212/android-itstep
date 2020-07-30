package kz.step.stepeducation.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import kz.step.stepeducation.domain.usecase.DatabaseUseCase

@Module
class DatabaseModule(var context: Context) {
    @Provides
    fun providesDatabaseUseCase(): DatabaseUseCase {
        return DatabaseUseCase(context)
    }
}