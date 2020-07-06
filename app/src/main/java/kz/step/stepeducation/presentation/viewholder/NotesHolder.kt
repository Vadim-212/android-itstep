package kz.step.stepeducation.presentation.viewholder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.viewholder_note.view.*
import kotlinx.android.synthetic.main.viewholder_student.view.*
import kz.step.stepeducation.data.Note
import kz.step.stepeducation.data.Student

class NotesHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var context: Context? = null

    fun initiateBind(note: Note) {
        itemView.textview_viewholder_note_title?.setText(note.title)
        itemView.textview_viewholder_note_text?.setText(note.text)
        itemView.textview_viewholder_note_due_date?.setText(note.dueDate)
    }
}