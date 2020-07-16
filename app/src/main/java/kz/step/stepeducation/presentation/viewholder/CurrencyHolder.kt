package kz.step.stepeducation.presentation.viewholder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.viewholder_currency.view.*
import kz.step.stepeducation.domain.Currency

class CurrencyHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var context: Context? = null

    fun initiateBind(currency: Currency) {
        itemView.textview_viewholder_currency_title?.setText(currency.title)
        itemView.textview_viewholder_currency_rate?.setText(currency.rate.toString())
    }
}