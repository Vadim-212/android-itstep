package kz.step.stepeducation.presentation.viewholder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.viewholder_student_full_info.view.*
import kz.step.stepeducation.domain.Student

class StudentsFullInfoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var context: Context? = null

    fun initiateBind(student: Student) {
        itemView?.textview_viewholder_student_full_info_name?.setText(student.name)
        itemView?.textview_viewholder_student_full_info_description?.setText(student.description)
        itemView?.textview_viewholder_student_full_info_group?.setText(student.group)
        itemView?.textview_viewholder_student_full_info_mark?.setText(student.mark.toString())
    }
}