package kz.step.stepeducation.di.component

import dagger.Component
import kz.step.stepeducation.di.module.NetworkModule
import kz.step.stepeducation.presentation.presenters.CurrenciesFragmentPresenter

@Component(modules = arrayOf(NetworkModule::class))
interface NetworkComponent {
    fun inject(currenciesFragmentPresenter: CurrenciesFragmentPresenter)
}