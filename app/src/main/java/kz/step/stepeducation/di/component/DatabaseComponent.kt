package kz.step.stepeducation.di.component

import dagger.Component
import kz.step.stepeducation.di.module.DatabaseModule
import kz.step.stepeducation.presentation.presenters.MoviesFragmentPresenter
import kz.step.stepeducation.presentation.presenters.StudentsFragmentPresenter

@Component(modules = arrayOf(DatabaseModule::class))
interface DatabaseComponent {
    fun inject(moviesFragmentPresenter: MoviesFragmentPresenter)

    fun inject(studentsFragmentPresenter: StudentsFragmentPresenter)
}