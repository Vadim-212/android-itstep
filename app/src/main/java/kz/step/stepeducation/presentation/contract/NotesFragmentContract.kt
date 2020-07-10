package kz.step.stepeducation.presentation.contract

import kz.step.stepeducation.data.Note
import kz.step.stepeducation.presentation.base.BaseContract

interface NotesFragmentContract {
    interface View : BaseContract.BaseView{
        fun initializePresenter()

        fun initializeLayoutManager()

        fun initializeAdapter()

        fun initiateUpdateAdapter()

        fun processData(notes: ArrayList<Note>)
    }

    interface Presenter : BaseContract.BasePresenter<View>{
        fun initializeData()

        fun addNote(note: Note)
    }
}