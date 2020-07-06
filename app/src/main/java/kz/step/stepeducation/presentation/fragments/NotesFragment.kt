package kz.step.stepeducation.presentation.fragments

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_notes2.*
import kotlinx.android.synthetic.main.fragment_notes.*
import kz.step.stepeducation.R
import kz.step.stepeducation.data.Note
import kz.step.stepeducation.presentation.adapter.NotesAdapter
import kz.step.stepeducation.presentation.contract.NotesFragmentContract
import kz.step.stepeducation.presentation.presenters.NotesFragmentPresenter

class NotesFragment : Fragment(), NotesFragmentContract.View, View.OnClickListener {
    var rootView: View? = null
    var notes: ArrayList<Note> = ArrayList()
    var notesAdapter: NotesAdapter? = null
    lateinit var presenter: NotesFragmentPresenter
    var addedNote: Note? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = LayoutInflater.from(context).inflate(
            R.layout.fragment_notes,
            container,
            false)
        if (arguments != null) {
            addedNote = arguments!!.getSerializable("addedNote") as Note
        }

        return rootView
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
        initializePresenter()
        initializeLayoutManager()
        initializeAdapter()
        initializeListeners()
        presenter.initializeData()
        if(addedNote != null) {
            presenter.addNote(addedNote!!)
        }
    }

    override fun onClick(v: View?) { }

    override fun initializePresenter() {
        presenter = NotesFragmentPresenter()
        presenter.attach(this)
    }

    override fun initializeLayoutManager() {
        recyclerview_fragment_notes?.layoutManager = LinearLayoutManager(context)
    }

    override fun initializeAdapter() {
        notesAdapter = NotesAdapter(context, notes)
        recyclerview_fragment_notes?.adapter = notesAdapter
    }

    override fun initiateUpdateAdapter() {
        notesAdapter?.notifyDataSetChanged()
    }

    override fun processData(notes: ArrayList<Note>) {
        this.notes.clear()
        this.notes.addAll(notes)
    }

    override fun initializeViews() { }

    override fun initializeListeners() { }

    override fun initializeArguments() { }

    override fun initializeDependencies() { }



}