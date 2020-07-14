package kz.step.stepeducation.di.module

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import kz.step.stepeducation.domain.StudentsSortUseCase

@Module
class RepositoryModule(var fragment: Fragment) {
    @Provides
    fun providesContext(): Context {
        return fragment.context!!
    }

    @Provides
    fun providesStudentsSortUseCase(): StudentsSortUseCase {
        return StudentsSortUseCase()
    }
}