package kz.step.stepeducation.presentation.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import kz.step.stepeducation.R
import kz.step.stepeducation.data.Movie
import kz.step.stepeducation.presentation.fragments.MovieDetailFragment
import kz.step.stepeducation.presentation.fragments.ViewPagerFragment
import kz.step.stepeducation.presentation.viewholder.MovieHolder

class MoviesAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder> {
    var context: Context?
    var movies: ArrayList<Movie>

    constructor(context: Context, movies: ArrayList<Movie>) {
        this.context = context
        this.movies = movies
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.viewholder_movie, parent, false)
        return MovieHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            val fragment = MovieDetailFragment()
            val args = Bundle()
            args.putString("movieTitle", movies.get(position).title)
            args.putString("movieDescription", movies.get(position).description)
            args.putFloat("movieRate", movies.get(position).rate)
            args.putByteArray("movieImage", movies.get(position).image)
            fragment.arguments = args
            val fragmentManager = (it.context as FragmentActivity).supportFragmentManager
            var fragmentTransaction = fragmentManager.beginTransaction()
            fragmentManager.executePendingTransactions()
            fragmentTransaction.add(
                R.id.relativelayout_activity_movies_fragment_container,
                fragment,
                fragment.javaClass.name ?: ""
            )

            fragmentTransaction.addToBackStack("Name")
            fragmentTransaction.commit()
        }
        (holder as MovieHolder).initiateBind(movies.get(position))
    }
}