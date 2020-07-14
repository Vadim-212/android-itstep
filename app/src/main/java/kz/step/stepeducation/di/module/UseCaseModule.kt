package kz.step.stepeducation.di.module

import dagger.Module
import dagger.Provides
import kz.step.stepeducation.domain.StudentsSortUseCase

@Module
class UseCaseModule {
    @Provides
    fun providesStudentsSortUseCase(): StudentsSortUseCase {
        return StudentsSortUseCase()
    }
}