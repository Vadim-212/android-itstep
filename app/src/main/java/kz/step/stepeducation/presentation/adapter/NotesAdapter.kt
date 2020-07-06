package kz.step.stepeducation.presentation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.ColorFilter
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import kz.step.stepeducation.R
import kz.step.stepeducation.data.Note
import kz.step.stepeducation.data.Student
import kz.step.stepeducation.presentation.viewholder.NotesHolder
import kz.step.stepeducation.presentation.viewholder.NotesWithPhotoHolder
import kz.step.stepeducation.presentation.viewholder.StudentsFullInfoHolder
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class NotesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {
    var context: Context? = null
    var notes: ArrayList<Note> = ArrayList()
    val NOTE_WITH_PHOTO = 1
    val NOTE_WITHOUT_PHOTO = 2

    constructor(context: Context?, notes: ArrayList<Note>){
        this.context = context
        this.notes = notes
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType) {
            NOTE_WITH_PHOTO -> return NotesWithPhotoHolder(LayoutInflater.from(context).inflate(R.layout.viewholder_note_with_photo, parent, false))
            else -> return NotesHolder(LayoutInflater.from(context).inflate(R.layout.viewholder_note, parent, false))
        }
        //var view = LayoutInflater.from(context).inflate(R.layout.viewholder_note, parent, false)
        //return StudentsFullInfoHolder(view)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("ResourceAsColor", "ResourceType")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //(holder as StudentsHolder).initiateBind(students.get(position))
        val date = LocalDate.parse(notes.get(position).dueDate, DateTimeFormatter.ISO_LOCAL_DATE)
        if(LocalDate.now().equals(date)) {
            holder.itemView.setBackgroundColor(Color.parseColor(context?.resources?.getString(R.color.color_light_red)))
            holder.itemView.invalidate()
        }

        when(holder.itemViewType) {
            NOTE_WITH_PHOTO -> (holder as NotesWithPhotoHolder).initiateBind(notes.get(position))
            else -> (holder as NotesHolder).initiateBind(notes.get(position))
        }
        //(holder as StudentsFullInfoHolder).initiateBind(students.get(position))
    }

    override fun getItemViewType(position: Int): Int {
        return if(notes[position].photo != null) NOTE_WITH_PHOTO
        else NOTE_WITHOUT_PHOTO
    }
}