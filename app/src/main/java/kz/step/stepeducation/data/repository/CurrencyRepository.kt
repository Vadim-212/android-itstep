package kz.step.stepeducation.data.repository

import io.reactivex.Observable
import kz.step.stepeducation.data.Currency
import kz.step.stepeducation.data.api.APIImplementation
import kz.step.stepeducation.domain.repository.CurrencyDomainRepository
import java.lang.Exception

class CurrencyRepository: CurrencyDomainRepository {
    var apiImplementation: APIImplementation

    constructor() {
        apiImplementation = APIImplementation()
    }

    override fun initiateGetCurrency(): Observable<Currency> {
        return apiImplementation.initiateGetCurrencies()
            .map{ response ->
                if(response.isSuccessful) {
                    response.body()
                } else {
                    throw Exception()
                }
            }
    }
}