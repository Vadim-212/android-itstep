package kz.step.stepeducation.presentation.presenters

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_currencies.*
import kz.step.stepeducation.R
import kz.step.stepeducation.data.Currency
import kz.step.stepeducation.di.component.DaggerCurrencyComponent
import kz.step.stepeducation.di.module.CurrencyModule
import kz.step.stepeducation.domain.CurrenciesUseCase
import kz.step.stepeducation.presentation.contract.CurrenciesFragmentContract
import okhttp3.internal.userAgent
import java.util.ArrayList
import javax.inject.Inject

class CurrenciesFragmentPresenter: CurrenciesFragmentContract.Presenter {
    var view: CurrenciesFragmentContract.View? = null
    var context: Context? = null
    var currencies: ArrayList<kz.step.stepeducation.domain.Currency> = ArrayList()
    //@Inject lateinit var currenciesUseCase: CurrenciesUseCase
    var currenciesUseCase: CurrenciesUseCase = CurrenciesUseCase()

    constructor(context: Context) {
        this.context = context
        // dagger
        //DaggerCurrencyComponent.builder().currencyModule(CurrencyModule()).build().inject(this)
        //Log.d("DEBUG_CURRENCY", "Presenter: after dagger - $currenciesUseCase")
    }

    override fun initializeData() {
        view?.processData(currencies)
        view?.initiateUpdateAdapter()
    }

    override fun initiateCurrencyToCurrenciesArray(currency: Currency) {
        currencies = currenciesUseCase.initiateCurrencyToCurrenciesArray(currency)
        view?.processData(currencies)
        view?.initiateUpdateAdapter()
    }

    override fun attach(view: CurrenciesFragmentContract.View) {
        this.view = view
    }

    override fun onStop() {
        view = null
    }
}