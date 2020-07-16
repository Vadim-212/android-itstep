package kz.step.stepeducation.presentation.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_currencies.*
import kz.step.stepeducation.R
import kz.step.stepeducation.data.api.APIConnection
import kz.step.stepeducation.di.component.DaggerCurrencyComponent
import kz.step.stepeducation.di.module.CurrencyModule
import kz.step.stepeducation.domain.CurrenciesUseCase
import kz.step.stepeducation.domain.Currency
import kz.step.stepeducation.presentation.presenters.CurrenciesFragmentPresenter
import kz.step.stepeducation.presentation.viewholder.CurrencyHolder
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject


class CurrencyAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder> {
    var context: Context? = null
    var currencies: ArrayList<Currency> = ArrayList()
    @Inject lateinit var currenciesUseCase: CurrenciesUseCase
    var presenter: CurrenciesFragmentPresenter? = null

    constructor(context: Context, currencies: ArrayList<Currency>, presenter: CurrenciesFragmentPresenter) {
        this.context = context
        this.currencies = currencies
        DaggerCurrencyComponent.builder().currencyModule(CurrencyModule()).build().inject(this)
        this.presenter = presenter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context!!).inflate(R.layout.viewholder_currency, parent, false)
        return CurrencyHolder(view)
    }

    override fun getItemCount(): Int {
        return currencies.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            val call = APIConnection().initializeAPI().currencies(currencies[position].title)
            call.enqueue(object : retrofit2.Callback<kz.step.stepeducation.data.Currency> {
                override fun onFailure(call: Call<kz.step.stepeducation.data.Currency>, t: Throwable) {
                    Log.e("RETROFIT_GETCURRENCIES", "Can't get currency")
                }

                override fun onResponse(call: Call<kz.step.stepeducation.data.Currency>, response: Response<kz.step.stepeducation.data.Currency>) {
                    presenter?.initiateCurrencyToCurrenciesArray(response.body()!!)
                    (presenter?.view as Fragment).textview_fragment_currencies_base_currency.setText(currencies[position].title)
                }
            })
        }

        (holder as CurrencyHolder).initiateBind(currencies.get(position))
    }
}