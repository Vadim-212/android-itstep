package kz.step.stepeducation.presentation.viewholder

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.viewholder_students_group.view.*
import kz.step.stepeducation.data.GroupWithStudents

class GroupWithStudentsHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun initiateBind(groupWithStudents: GroupWithStudents) {
        itemView.textview_viewholder_students_group_title.setText(groupWithStudents.group.title)
        itemView.textview_viewholder_students_group_students_count.setText(groupWithStudents.students.size.toString())
    }
}