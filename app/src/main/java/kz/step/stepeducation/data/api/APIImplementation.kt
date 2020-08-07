package kz.step.stepeducation.data.api

import io.reactivex.Observable
import kz.step.stepeducation.data.Currency
import retrofit2.Call
import retrofit2.Response

class APIImplementation: APIInterface {
    var api: APIInterface

    constructor() {
        api = APIConnection().initializeAPI()
    }

    override fun currencies(): Call<Currency> {
        return api.currencies()
    }

    override fun currencies(base: String): Call<Currency> {
        return api.currencies(base)
    }

    override fun initiateGetCurrencies(): Observable<Response<Currency>> {
        return api.initiateGetCurrencies()
    }
}