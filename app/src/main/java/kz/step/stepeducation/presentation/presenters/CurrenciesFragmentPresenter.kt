package kz.step.stepeducation.presentation.presenters

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_currencies.*
import kz.step.stepeducation.R
import kz.step.stepeducation.data.Currency
import kz.step.stepeducation.data.api.APIConnection
import kz.step.stepeducation.data.api.APIImplementation
import kz.step.stepeducation.di.component.DaggerCurrencyComponent
import kz.step.stepeducation.di.component.DaggerNetworkComponent
import kz.step.stepeducation.di.module.CurrencyModule
import kz.step.stepeducation.di.module.NetworkModule
import kz.step.stepeducation.domain.CurrenciesUseCase
import kz.step.stepeducation.presentation.contract.CurrenciesFragmentContract
import okhttp3.internal.userAgent
import retrofit2.Call
import retrofit2.Response
import java.util.ArrayList
import javax.inject.Inject

class CurrenciesFragmentPresenter: CurrenciesFragmentContract.Presenter {
    var view: CurrenciesFragmentContract.View? = null
    var context: Context? = null
    var currencies: ArrayList<kz.step.stepeducation.domain.Currency> = ArrayList()
    //@Inject lateinit var currenciesUseCase: CurrenciesUseCase
    var currenciesUseCase: CurrenciesUseCase = CurrenciesUseCase()
    @Inject lateinit var api: APIImplementation

    constructor(context: Context) {
        this.context = context
        // dagger
        //DaggerCurrencyComponent.builder().currencyModule(CurrencyModule()).build().inject(this)
        //Log.d("DEBUG_CURRENCY", "Presenter: after dagger - $currenciesUseCase")
        DaggerNetworkComponent.builder().networkModule(NetworkModule()).build().inject(this)
    }

    override fun initializeData() {
        // retrofit
        val call = APIConnection().initializeAPI().currencies()
        call.enqueue(object : retrofit2.Callback<kz.step.stepeducation.data.Currency> {
            override fun onFailure(call: Call<Currency>, t: Throwable) {
                Toast.makeText(context, "Can't get currency", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<Currency>,
                response: Response<Currency>
            ) {
                (view as Fragment).textview_fragment_currencies_base_currency.setText(response.body()?.getBase())
                initiateCurrencyToCurrenciesArray(response.body()!!)
            }
        })
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