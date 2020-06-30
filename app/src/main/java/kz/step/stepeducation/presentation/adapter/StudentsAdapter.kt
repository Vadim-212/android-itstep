package kz.step.stepeducation.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.step.stepeducation.R
import kz.step.stepeducation.data.Student
import kz.step.stepeducation.presentation.viewholder.StudentsFullInfoHolder

class StudentsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {

    var context: Context? = null
    lateinit var students: ArrayList<Student>

    constructor(context: Context?, students: ArrayList<Student>){
        this.context = context
        this.students = students
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        when(viewType) {
//            STUDENT_WITH_GROUP -> return StudentsFullInfoHolder(LayoutInflater.from(context).inflate(R.layout.viewholder_student_full_info, parent, false))
//            else -> return StudentsHolder(LayoutInflater.from(context).inflate(R.layout.viewholder_student, parent, false))
//        }
        var view = LayoutInflater.from(context).inflate(R.layout.viewholder_student_full_info, parent, false)
        return StudentsFullInfoHolder(view)
    }

    override fun getItemCount(): Int {
        return students?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //(holder as StudentsHolder).initiateBind(students.get(position))
//        when(holder.itemViewType) {
//            STUDENT_WITH_GROUP -> (holder as StudentsFullInfoHolder).initiateBind(students.get(position))
//            else -> (holder as StudentsHolder).initiateBind(students.get(position))
//        }
        (holder as StudentsFullInfoHolder).initiateBind(students.get(position))
    }

//    override fun getItemViewType(position: Int): Int {
//        return if(students[position].group != null && students[position].group != "") STUDENT_WITH_GROUP
//        else STUDENT_WITHOUT_GROUP
//    }
}