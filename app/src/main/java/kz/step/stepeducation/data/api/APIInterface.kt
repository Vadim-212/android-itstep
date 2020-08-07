package kz.step.stepeducation.data.api

import io.reactivex.Observable
import kz.step.stepeducation.data.Currency
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    @GET("latest")
    fun currencies(): Call<Currency>

    @GET("latest")
    fun currencies(@Query("base") base: String): Call<Currency>

    @GET("latest")
    fun initiateGetCurrencies(): Observable<Response<Currency>>
}