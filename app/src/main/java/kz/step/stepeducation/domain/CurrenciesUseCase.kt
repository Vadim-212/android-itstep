package kz.step.stepeducation.domain

import android.util.Log
import kz.step.stepeducation.data.Currency
import kz.step.stepeducation.data.api.APIConnection
import retrofit2.Call
import retrofit2.Response

class CurrenciesUseCase {
    fun initiateCurrencyToCurrenciesArray(currency: Currency): ArrayList<kz.step.stepeducation.domain.Currency> {
        val currencies: ArrayList<kz.step.stepeducation.domain.Currency> = ArrayList()

        currencies.add(kz.step.stepeducation.domain.Currency("CAD", currency.getRates()?.cad!!))
        currencies.add(kz.step.stepeducation.domain.Currency("HKD", currency.getRates()?.hkd!!))
        currencies.add(kz.step.stepeducation.domain.Currency("ISK", currency.getRates()?.isk!!))
        currencies.add(kz.step.stepeducation.domain.Currency("PHP", currency.getRates()?.php!!))
        currencies.add(kz.step.stepeducation.domain.Currency("DKK", currency.getRates()?.dkk!!))
        currencies.add(kz.step.stepeducation.domain.Currency("HUF", currency.getRates()?.huf!!))
        currencies.add(kz.step.stepeducation.domain.Currency("CZK", currency.getRates()?.czk!!))
        currencies.add(kz.step.stepeducation.domain.Currency("AUD", currency.getRates()?.aud!!))
        currencies.add(kz.step.stepeducation.domain.Currency("RON", currency.getRates()?.ron!!))
        currencies.add(kz.step.stepeducation.domain.Currency("SEK", currency.getRates()?.sek!!))
        currencies.add(kz.step.stepeducation.domain.Currency("IDR", currency.getRates()?.idr!!))
        currencies.add(kz.step.stepeducation.domain.Currency("INR", currency.getRates()?.inr!!))
        currencies.add(kz.step.stepeducation.domain.Currency("BRL", currency.getRates()?.brl!!))
        currencies.add(kz.step.stepeducation.domain.Currency("RUB", currency.getRates()?.rub!!))
        currencies.add(kz.step.stepeducation.domain.Currency("HRK", currency.getRates()?.hrk!!))
        currencies.add(kz.step.stepeducation.domain.Currency("JPY", currency.getRates()?.jpy!!))
        currencies.add(kz.step.stepeducation.domain.Currency("THB", currency.getRates()?.thb!!))
        currencies.add(kz.step.stepeducation.domain.Currency("CHF", currency.getRates()?.chf!!))
        currencies.add(kz.step.stepeducation.domain.Currency("SGD", currency.getRates()?.sgd!!))
        currencies.add(kz.step.stepeducation.domain.Currency("PLN", currency.getRates()?.pln!!))
        currencies.add(kz.step.stepeducation.domain.Currency("BGN", currency.getRates()?.bgn!!))
        currencies.add(kz.step.stepeducation.domain.Currency("TRY", currency.getRates()?.`try`!!))
        currencies.add(kz.step.stepeducation.domain.Currency("CNY", currency.getRates()?.cny!!))
        currencies.add(kz.step.stepeducation.domain.Currency("NOK", currency.getRates()?.nok!!))
        currencies.add(kz.step.stepeducation.domain.Currency("NZD", currency.getRates()?.nzd!!))
        currencies.add(kz.step.stepeducation.domain.Currency("ZAR", currency.getRates()?.zar!!))
        currencies.add(kz.step.stepeducation.domain.Currency("USD", currency.getRates()?.usd!!))
        currencies.add(kz.step.stepeducation.domain.Currency("MXN", currency.getRates()?.mxn!!))
        currencies.add(kz.step.stepeducation.domain.Currency("ILS", currency.getRates()?.ils!!))
        currencies.add(kz.step.stepeducation.domain.Currency("GBP", currency.getRates()?.gbp!!))
        currencies.add(kz.step.stepeducation.domain.Currency("KRW", currency.getRates()?.krw!!))
        currencies.add(kz.step.stepeducation.domain.Currency("MYR", currency.getRates()?.myr!!))

        return currencies
    }
}