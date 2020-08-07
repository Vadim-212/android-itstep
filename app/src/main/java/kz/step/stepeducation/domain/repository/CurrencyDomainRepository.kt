package kz.step.stepeducation.domain.repository

import io.reactivex.Observable
import kz.step.stepeducation.data.Currency

interface CurrencyDomainRepository {
    fun initiateGetCurrency(): Observable<Currency>
}