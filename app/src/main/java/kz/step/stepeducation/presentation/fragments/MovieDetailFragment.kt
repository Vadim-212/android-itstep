package kz.step.stepeducation.presentation.fragments

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import kz.step.stepeducation.R
import kz.step.stepeducation.data.Movie
import kz.step.stepeducation.presentation.contract.MoviesFragmentContract
import java.io.ByteArrayInputStream

class MovieDetailFragment : Fragment() {
    var rootView: View? = null
    var movie: Movie? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = LayoutInflater.from(context).inflate(R.layout.fragment_movie_detail, container, false)

        if(arguments != null) {
            movie = Movie().apply {
                title = arguments?.getString("movieTitle")!!
                description = arguments?.getString("movieDescription")!!
                rate = arguments?.getFloat("movieRate")!!
                image = arguments?.getByteArray("movieImage")!!
            }
        }

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
    }

    fun initializeViews() {
        textview_fragment_movie_detail_title?.setText(movie?.title)
        textview_fragment_movie_detail_description?.setText(movie?.description)
        ratingbar_fragment_movie_detail_rate?.rating = movie?.rate!!
        textview_fragment_movie_detail_rate?.setText(movie?.rate!!.toString())

        if(movie?.image != null && movie?.image!!.size != 0) {
            imageview_fragment_movie_detail_image?.setImageBitmap(BitmapFactory.decodeStream(ByteArrayInputStream(movie!!.image)))
        }
    }
}