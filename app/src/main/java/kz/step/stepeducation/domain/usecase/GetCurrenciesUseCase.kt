package kz.step.stepeducation.domain.usecase

import io.reactivex.Observable
import kz.step.stepeducation.data.Currency
import kz.step.stepeducation.data.repository.CurrencyRepository
import kz.step.stepeducation.domain.base.BaseNetworkUseCase
import kz.step.stepeducation.domain.repository.CurrencyDomainRepository

class GetCurrenciesUseCase: BaseNetworkUseCase<Currency> {
    var currencyDomainRepository: CurrencyDomainRepository

    constructor() {
        currencyDomainRepository = CurrencyRepository()
    }

    override fun initiateCreateObservable(): Observable<Currency> {
        return currencyDomainRepository.initiateGetCurrency()
    }
}