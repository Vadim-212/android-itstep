package kz.step.stepeducation.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_students.*
import kz.step.stepeducation.R
import kz.step.stepeducation.adapter.StudentsAdapter
import kz.step.stepeducation.data.Student


class StudentsFragment : Fragment() {
    var rootView: View? = null
    var students: ArrayList<Student> = ArrayList()
    var filteredStudentsList: ArrayList<Student> = ArrayList()
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

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeData()
        initializeLayoutManager()
        initializeAdapter()
        initializeListeners()
    }

    fun initializeListeners() {
        button_fragment_students_filtration_by_name?.setOnClickListener {
            filteredStudentsList.sortBy { it.name }
            studentsAdapter?.notifyDataSetChanged()
        }

        button_fragment_students_filtration_by_mark?.setOnClickListener {
            filteredStudentsList.sortByDescending { it.mark }
            studentsAdapter?.notifyDataSetChanged()
        }

        button_fragment_students_random_filtration?.setOnClickListener {
            filteredStudentsList.shuffle()
            studentsAdapter?.notifyDataSetChanged()
        }

        edittext_fragment_students_search_query?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) { }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                filteredStudentsList.clear()
                filteredStudentsList.addAll(students.filter { it.name.toLowerCase().contains(edittext_fragment_students_search_query?.text.toString().toLowerCase()) || it.name.toLowerCase() == edittext_fragment_students_search_query?.text.toString().toLowerCase() } as ArrayList<Student>)
                studentsAdapter?.notifyDataSetChanged()
            }
        })

        button_fragment_students_clear_query?.setOnClickListener {
            edittext_fragment_students_search_query?.setText("")
            filteredStudentsList.clear()
            filteredStudentsList.addAll(students)
            studentsAdapter?.notifyDataSetChanged()
        }

        button_fragment_students_top_three_by_mark?.setOnClickListener {
            filteredStudentsList.clear()
            filteredStudentsList.addAll(students)
            filteredStudentsList.addAll(getTop3StudentsByMark(filteredStudentsList))
            studentsAdapter?.notifyDataSetChanged()
        }
    }

    fun initializeLayoutManager() {
        recyclerview_fragment_students?.layoutManager = LinearLayoutManager(context)
    }

    fun initializeAdapter() {
        studentsAdapter = StudentsAdapter(context, filteredStudentsList)
        recyclerview_fragment_students?.adapter = studentsAdapter
    }

    fun initializeData() {
        students.add(Student("Vasya", "Bad Student", "Group 1", 10F))
        students.add(Student("John", "Good Student", "Group 1", 11.5F))
        students.add(Student("Log", "Average Student", "Group 2", 11F))
        filteredStudentsList.addAll(students)
    }

    fun getTop3StudentsByMark(studentsList: ArrayList<Student>): ArrayList<Student> {
        val top3StudentsByMark: ArrayList<Student> = ArrayList()
        var topStudent: Student

        for (i: Int in 0 until 3) {
            topStudent = studentsList.first()
            for (student in studentsList) {
                if(student.mark > topStudent.mark) {
                    topStudent = student
                }
            }
            top3StudentsByMark.add(topStudent)
            studentsList.remove(topStudent)
        }

        return top3StudentsByMark
    }
}