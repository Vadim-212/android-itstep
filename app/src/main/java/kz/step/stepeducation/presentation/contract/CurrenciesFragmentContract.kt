package kz.step.stepeducation.presentation.contract;

import java.util.ArrayList;

import kz.step.stepeducation.domain.Currency;
import kz.step.stepeducation.presentation.base.BaseContract;

interface CurrenciesFragmentContract {
    interface View: BaseContract.BaseView{
        fun initializePresenter()

        fun initializeLayoutManager()

        fun initializeAdapter()

        fun initiateUpdateAdapter()

        fun processData(currencies: ArrayList<Currency>)
    }

    interface Presenter : BaseContract.BasePresenter<View>{
        fun initializeData()

        fun initiateCurrencyToCurrenciesArray(currency: kz.step.stepeducation.data.Currency)
    }
}
