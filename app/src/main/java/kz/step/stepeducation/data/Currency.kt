package kz.step.stepeducation.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Currency {
    @SerializedName("rates")
    @Expose
    private var rates: Rates? = null
    @SerializedName("base")
    @Expose
    private var base: String? = null
    @SerializedName("date")
    @Expose
    private var date: String? = null

    inner class Rates {
        @SerializedName("CAD")
        @Expose
        var cad: Double? = null

        @SerializedName("HKD")
        @Expose
        var hkd: Double? = null

        @SerializedName("ISK")
        @Expose
        var isk: Double? = null

        @SerializedName("PHP")
        @Expose
        var php: Double? = null

        @SerializedName("DKK")
        @Expose
        var dkk: Double? = null

        @SerializedName("HUF")
        @Expose
        var huf: Double? = null

        @SerializedName("CZK")
        @Expose
        var czk: Double? = null

        @SerializedName("AUD")
        @Expose
        var aud: Double? = null

        @SerializedName("RON")
        @Expose
        var ron: Double? = null

        @SerializedName("SEK")
        @Expose
        var sek: Double? = null

        @SerializedName("IDR")
        @Expose
        var idr: Double? = null

        @SerializedName("INR")
        @Expose
        var inr: Double? = null

        @SerializedName("BRL")
        @Expose
        var brl: Double? = null

        @SerializedName("RUB")
        @Expose
        var rub: Double? = null

        @SerializedName("HRK")
        @Expose
        var hrk: Double? = null

        @SerializedName("JPY")
        @Expose
        var jpy: Double? = null

        @SerializedName("THB")
        @Expose
        var thb: Double? = null

        @SerializedName("CHF")
        @Expose
        var chf: Double? = null

        @SerializedName("SGD")
        @Expose
        var sgd: Double? = null

        @SerializedName("PLN")
        @Expose
        var pln: Double? = null

        @SerializedName("BGN")
        @Expose
        var bgn: Double? = null

        @SerializedName("TRY")
        @Expose
        var `try`: Double? = null

        @SerializedName("CNY")
        @Expose
        var cny: Double? = null

        @SerializedName("NOK")
        @Expose
        var nok: Double? = null

        @SerializedName("NZD")
        @Expose
        var nzd: Double? = null

        @SerializedName("ZAR")
        @Expose
        var zar: Double? = null

        @SerializedName("USD")
        @Expose
        var usd: Double? = null

        @SerializedName("MXN")
        @Expose
        var mxn: Double? = null

        @SerializedName("ILS")
        @Expose
        var ils: Double? = null

        @SerializedName("GBP")
        @Expose
        var gbp: Double? = null

        @SerializedName("KRW")
        @Expose
        var krw: Double? = null

        @SerializedName("MYR")
        @Expose
        var myr: Double? = null

        override fun toString(): String {
            return "Rates(cad=$cad, hkd=$hkd, isk=$isk, php=$php, dkk=$dkk, huf=$huf, czk=$czk, aud=$aud, ron=$ron, sek=$sek, idr=$idr, inr=$inr, brl=$brl, rub=$rub, hrk=$hrk, jpy=$jpy, thb=$thb, chf=$chf, sgd=$sgd, pln=$pln, bgn=$bgn, `try`=$`try`, cny=$cny, nok=$nok, nzd=$nzd, zar=$zar, usd=$usd, mxn=$mxn, ils=$ils, gbp=$gbp, krw=$krw, myr=$myr)"
        }

    }

    fun getRates(): Rates? {
        return rates
    }

    fun setRates(rates: Rates?) {
        this.rates = rates
    }

    fun getBase(): String? {
        return base
    }

    fun setBase(base: String?) {
        this.base = base
    }

    fun getDate(): String? {
        return date
    }

    fun setDate(date: String?) {
        this.date = date
    }

    override fun toString(): String {
        return "Currency(rates=$rates, base=$base, date=$date)"
    }
}