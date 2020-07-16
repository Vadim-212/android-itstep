package kz.step.stepeducation.data.api

import io.reactivex.Observable
import kz.step.stepeducation.data.Currency
import retrofit2.Call
import retrofit2.Response

class APIImplementation: APIInterface {
    constructor() {
        var api = APIConnection().initializeAPI()
    }

    override fun currencies(): Call<Currency> {
        TODO("Not yet implemented")
    }

    override fun currencies(base: String): Call<Currency> {
        TODO("Not yet implemented")
    }

    override fun initiateGetCurrencies(): Observable<Response<Currency>> {
        TODO("Not yet implemented")
    }
}