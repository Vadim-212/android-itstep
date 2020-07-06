package kz.step.stepeducation.presentation.presenters

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import androidx.annotation.RequiresApi
import kz.step.stepeducation.data.Note
import kz.step.stepeducation.presentation.contract.NotesFragmentContract
import java.io.IOException
import java.time.LocalDate

class NotesFragmentPresenter : NotesFragmentContract.Presenter {
    var view: NotesFragmentContract.View? = null
    var notes: ArrayList<Note> = ArrayList()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun initializeData() {
        view?.processData(notes.apply {
            add(Note("Заметка 1", "Текст первой заметки", LocalDate.now().toString(),null))
        })
        view?.initiateUpdateAdapter()
    }

    override fun addNote(note: Note) {
        notes.add(note)
        view?.processData(notes)
        view?.initiateUpdateAdapter()
    }

    override fun attach(view: NotesFragmentContract.View) {
        this.view = view
    }

    override fun onStop() {
        view = null
    }

}