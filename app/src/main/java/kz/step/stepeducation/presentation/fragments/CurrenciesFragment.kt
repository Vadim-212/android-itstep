package kz.step.stepeducation.presentation.fragments

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_currencies.*
import kz.step.stepeducation.R
import kz.step.stepeducation.data.api.APIConnection
import kz.step.stepeducation.di.component.DaggerCurrencyComponent
import kz.step.stepeducation.di.module.CurrencyModule
import kz.step.stepeducation.domain.CurrenciesUseCase
import kz.step.stepeducation.domain.Currency
import kz.step.stepeducation.presentation.adapter.CurrencyAdapter
import kz.step.stepeducation.presentation.contract.CurrenciesFragmentContract
import kz.step.stepeducation.presentation.presenters.CurrenciesFragmentPresenter
import retrofit2.Call
import retrofit2.Response
import java.util.ArrayList
import javax.inject.Inject

class CurrenciesFragment: Fragment(), CurrenciesFragmentContract.View, View.OnClickListener {
    var rootView: View? = null
    lateinit var presenter: CurrenciesFragmentContract.Presenter
    var currencyAdapter: CurrencyAdapter? = null
    val currencies: ArrayList<Currency> = ArrayList()
    var currency: kz.step.stepeducation.data.Currency? = null
    @Inject lateinit var currenciesUseCase: CurrenciesUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = LayoutInflater.from(context).inflate(
            R.layout.fragment_currencies,
            container,
            false
        )

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // dagger
        DaggerCurrencyComponent.builder().currencyModule(CurrencyModule()).build().inject(this)

        initializeViews()
        initializePresenter()
        initializeLayoutManager()
        initializeAdapter()
        //initializeListeners()
        presenter.initializeData()
        // retrofit
        val call = APIConnection().initializeAPI().currencies()
        call.enqueue(object : retrofit2.Callback<kz.step.stepeducation.data.Currency> {
            override fun onFailure(call: Call<kz.step.stepeducation.data.Currency>, t: Throwable) {
                Toast.makeText(context, "Can't get currency", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<kz.step.stepeducation.data.Currency>,
                response: Response<kz.step.stepeducation.data.Currency>
            ) {
                currency = response.body()
                textview_fragment_currencies_base_currency?.setText(currency?.getBase())
                presenter.initiateCurrencyToCurrenciesArray(currency!!)
            }
        })

    }

    override fun initializeListeners() {
        TODO("Not yet implemented")
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

    override fun initializePresenter() {
        presenter = CurrenciesFragmentPresenter(context!!)
        presenter.attach(this)
    }

    override fun initializeLayoutManager() {
        recyclerview_fragment_currencies?.layoutManager = LinearLayoutManager(context!!)
    }

    override fun initializeAdapter() {
    currencyAdapter = CurrencyAdapter(context!!, currencies, presenter as CurrenciesFragmentPresenter)
        recyclerview_fragment_currencies?.adapter = currencyAdapter
    }

    override fun initiateUpdateAdapter() {
        currencyAdapter?.notifyDataSetChanged()
    }

    override fun processData(currencies: ArrayList<Currency>) {
        this.currencies.clear()
        this.currencies.addAll(currencies)
    }

    override fun initializeViews() { }

    override fun initializeArguments() { }

    override fun initializeDependencies() { }


}