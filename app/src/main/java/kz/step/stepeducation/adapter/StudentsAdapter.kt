package kz.step.stepeducation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.step.stepeducation.R
import kz.step.stepeducation.data.Student
import kz.step.stepeducation.viewholder.StudentsHolder
import kz.step.stepeducation.viewholder.StudentsWithGroupsHolder

class StudentsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {

    var context: Context? = null
    lateinit var students: ArrayList<Student>
    val STUDENT_WITHOUT_GROUP = 0
    val STUDENT_WITH_GROUP = 1

    constructor(context: Context?, students: ArrayList<Student>){
        this.context = context
        this.students = students
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType) {
            STUDENT_WITH_GROUP -> return StudentsWithGroupsHolder(LayoutInflater.from(context).inflate(R.layout.viewholder_student_with_group, parent, false))
            else -> return StudentsHolder(LayoutInflater.from(context).inflate(R.layout.viewholder_student, parent, false))
        }
        //var view = LayoutInflater.from(context).inflate(R.layout.viewholder_student, parent, false)
        //return StudentsHolder(view)
    }

    override fun getItemCount(): Int {
        return students?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //(holder as StudentsHolder).initiateBind(students.get(position))
        when(holder.itemViewType) {
            STUDENT_WITH_GROUP -> (holder as StudentsWithGroupsHolder).initiateBind(students.get(position))
            else -> (holder as StudentsHolder).initiateBind(students.get(position))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(students[position].group != null && students[position].group != "") STUDENT_WITH_GROUP
        else STUDENT_WITHOUT_GROUP
    }
}