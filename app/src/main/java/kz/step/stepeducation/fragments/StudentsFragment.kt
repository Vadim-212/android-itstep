package kz.step.stepeducation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.step.stepeducation.R
import kz.step.stepeducation.adapter.StudentsAdapter
import kz.step.stepeducation.data.Student

class StudentsFragment : Fragment() {
    var rootView: View? = null

    var students: ArrayList<Student> = ArrayList()

    var recyclerViewStudents: RecyclerView? = null

    var studentsAdapter: StudentsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView= LayoutInflater.from(context).inflate(
            R.layout.fragment_students,
            container,
            false)

        initializeViews()
        initializeData()
        initializeLayoutManager()
        initializeAdapter()

        return rootView
    }

    fun initializeViews(){
        recyclerViewStudents = rootView?.findViewById(R.id.recyclerview_fragment_students)
    }

    fun initializeLayoutManager(){
        recyclerViewStudents?.layoutManager = LinearLayoutManager(context)
    }

    fun initializeAdapter(){
        studentsAdapter = StudentsAdapter(context, students)
        recyclerViewStudents?.adapter = studentsAdapter
    }

    fun initializeData(){
        students.add(Student("Vasya", "Good Student", ""))
        students.add(Student("John", "Bad Student", "Group 1"))
        students.add(Student("Log", "Average Student", "Group 1"))
    }
}