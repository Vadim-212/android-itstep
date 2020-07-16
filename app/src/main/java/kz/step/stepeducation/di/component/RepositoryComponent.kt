package kz.step.stepeducation.di.component

import dagger.Component
import kz.step.stepeducation.di.module.RepositoryModule
import kz.step.stepeducation.presentation.fragments.StudentsFragment

@Component(modules = arrayOf(RepositoryModule::class))
interface RepositoryComponent {
    fun inject(studentsFragment: StudentsFragment)
}