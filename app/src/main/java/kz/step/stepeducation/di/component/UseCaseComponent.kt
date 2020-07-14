package kz.step.stepeducation.di.component

import dagger.Component
import kz.step.stepeducation.di.module.UseCaseModule
import kz.step.stepeducation.domain.StudentsSortUseCase
import kz.step.stepeducation.presentation.fragments.StudentsFragment

@Component(modules = arrayOf(UseCaseModule::class))
interface UseCaseComponent {
    fun initiateReturnStudentsUseCase(): StudentsSortUseCase

    fun inject(studentsFragment: StudentsFragment)
}