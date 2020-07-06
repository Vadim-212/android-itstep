package kz.step.stepeducation.presentation.viewholder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.viewholder_note.view.*
import kotlinx.android.synthetic.main.viewholder_note_with_photo.view.*
import kz.step.stepeducation.data.Note

class NotesWithPhotoHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var context: Context? = null

    fun initiateBind(note: Note) {
        itemView.textview_viewholder_note_with_photo_title?.setText(note.title)
        itemView.textview_viewholder_note_with_photo_text?.setText(note.text)
        itemView.textview_viewholder_note_with_photo_due_date?.setText(note.dueDate)
        itemView.imageview_viewholder_note_with_photo_photo?.setImageBitmap(note.photo)
    }
}