package kz.step.stepeducation.viewholder

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.step.stepeducation.R
import kz.step.stepeducation.data.Student

class StudentsFullInfoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var context: Context? = null
    var textViewName: TextView? = null
    var textViewDescription: TextView? = null
    var textViewGroup: TextView? = null
    var textViewMark: TextView? = null

    init {
        initializeViews()
    }

    fun initializeViews() {
        textViewName = itemView.findViewById(R.id.textview_viewholder_student_full_info_name)
        textViewDescription = itemView.findViewById(R.id.textview_viewholder_student_full_info_description)
        textViewGroup = itemView.findViewById(R.id.textview_viewholder_student_full_info_group)
        textViewMark = itemView.findViewById(R.id.textview_viewholder_student_full_info_mark)
    }

    fun initiateBind(student: Student) {
        textViewName?.setText(student.name)
        textViewDescription?.setText(student.description)
        textViewGroup?.setText(student.group)
        textViewMark?.setText(student.mark.toString())
    }
}