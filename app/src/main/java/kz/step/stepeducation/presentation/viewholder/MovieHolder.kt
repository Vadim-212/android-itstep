package kz.step.stepeducation.presentation.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.viewholder_movie.view.*
import kz.step.stepeducation.data.Movie

class MovieHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun initiateBind(movie: Movie) {
        itemView.textview_viewholder_movie_title.setText(movie.title)
        itemView.textview_viewholder_movie_rate.setText(movie.rate.toString())
    }
}