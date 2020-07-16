package kz.step.stepeducation.di.component

import dagger.Component
import kz.step.stepeducation.di.module.CurrencyModule
import kz.step.stepeducation.presentation.adapter.CurrencyAdapter
import kz.step.stepeducation.presentation.contract.CurrenciesFragmentContract
import kz.step.stepeducation.presentation.fragments.CurrenciesFragment

@Component(modules = arrayOf(CurrencyModule::class))
interface CurrencyComponent {
    fun inject(fragment: CurrenciesFragment)

    fun inject(currenciesFragmentPresenter: CurrenciesFragmentContract.Presenter)

    fun inject(currencyAdapter: CurrencyAdapter)
}