package kz.step.stepeducation.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIConnection {
    lateinit var retrofit: Retrofit

    fun initializeRetrofit(): Retrofit {
        retrofit = Retrofit.Builder()
            .baseUrl(APIConstants.baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(initializeOkHttpClient())
            .build()

        return retrofit
    }

    fun initializeAPI(): APIInterface {
        return initializeRetrofit().create(APIInterface::class.java)
    }

    fun initializeOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
            .addInterceptor(initializeHttpLogging())
            .build()
        return client
    }

    fun initializeHttpLogging(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }
}