package kz.step.stepeducation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.step.stepeducation.R
import kz.step.stepeducation.data.Student
import kz.step.stepeducation.viewholder.StudentsHolder

class StudentsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {

    var context: Context? = null
    lateinit var students: ArrayList<Student>

    constructor(context: Context?, students: ArrayList<Student>){
        this.context = context
        this.students = students
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.viewholder_student, parent, false)
        return StudentsHolder(view)
    }

    override fun getItemCount(): Int {
        return students?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as StudentsHolder).initiateBind(students.get(position))
    }
}