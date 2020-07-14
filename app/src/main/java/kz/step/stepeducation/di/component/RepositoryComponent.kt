package kz.step.stepeducation.di.component

import android.content.Context
import androidx.fragment.app.Fragment
import dagger.Component
import kz.step.stepeducation.di.module.RepositoryModule
import kz.step.stepeducation.domain.StudentsSortUseCase
import kz.step.stepeducation.presentation.fragments.StudentsFragment

@Component(modules = arrayOf(RepositoryModule::class))
interface RepositoryComponent {
    fun inject(studentsFragment: StudentsFragment)
}