package kz.step.stepeducation.presentation.viewholder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.viewholder_student.view.*
import kz.step.stepeducation.domain.Student

class StudentsHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var context: Context? = null

    fun initiateBind(student: Student){
        itemView?.textview_viewholder_student_name?.setText(student.name)
        itemView?.textview_viewholder_student_description?.setText(student.description)
    }
}