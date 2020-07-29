package kz.step.stepeducation.presentation.fragments

import android.icu.lang.UCharacter
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_movies.*
import kz.step.stepeducation.R
import kz.step.stepeducation.data.Movie
import kz.step.stepeducation.presentation.adapter.MoviesAdapter
import kz.step.stepeducation.presentation.base.BaseFragment
import kz.step.stepeducation.presentation.contract.MoviesFragmentContract
import kz.step.stepeducation.presentation.presenters.MoviesFragmentPresenter
import kz.step.stepeducation.presentation.utils.SortTypes

class MoviesFragment(val sortType: SortTypes): BaseFragment(), MoviesFragmentContract.View {
    var rootView: View? = null
    var presenter: MoviesFragmentPresenter? = null
    var moviesAdapter: MoviesAdapter? = null
    var movies: ArrayList<Movie> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = LayoutInflater.from(context).inflate(R.layout.fragment_movies, container, false)
        return rootView
    }

    override fun onClick(v: View?) { }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()
        initializePresenter()
        initializeLayoutManager()
        presenter?.initializeData()
        initializeAdapter()
        initializeListeners()
        presenter?.sortMovies(sortType)
    }

    override fun initializePresenter() {
        presenter = MoviesFragmentPresenter(context!!)
        presenter?.attach(this)
    }

    override fun initializeLayoutManager() {
        recyclerview_fragment_movies?.layoutManager = GridLayoutManager(context, 2)
        recyclerview_fragment_movies.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))
    }

    override fun initializeAdapter() {
        moviesAdapter = MoviesAdapter(context!!, movies)
        recyclerview_fragment_movies?.adapter = moviesAdapter
    }

    override fun initializeUpdateAdapter() {
        moviesAdapter?.notifyDataSetChanged()
    }

    override fun proccessData(movies: ArrayList<Movie>) {
        this.movies.clear()
        this.movies.addAll(movies)
    }

    override fun initializeViews() { }

    override fun initializeListeners() {
        swiperefreshlayout_fragment_movies?.setOnRefreshListener {
            val runnable = Runnable {
                presenter?.initializeData()
                presenter?.sortMovies(sortType)
                swiperefreshlayout_fragment_movies?.isRefreshing = false
            }

            Handler().postDelayed(
                runnable, 3000.toLong()
            )
        }
    }

    override fun initializeArguments() { }

    override fun initializeDependencies() { }

}