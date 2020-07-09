package kz.step.stepeducation.presentation.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_students.*
import kz.step.stepeducation.R
import kz.step.stepeducation.presentation.adapter.StudentsAdapter
import kz.step.stepeducation.data.Student
import kz.step.stepeducation.presentation.contract.StudentsFragmentContract
import kz.step.stepeducation.presentation.presenters.StudentsFragmentPresenter


class StudentsFragment : Fragment(), StudentsFragmentContract.View, View.OnClickListener {
    var rootView: View? = null
    var students: ArrayList<Student> = ArrayList()
    var filteredStudentsList: ArrayList<Student> = ArrayList()
    var studentsAdapter: StudentsAdapter? = null
    lateinit var presenter: StudentsFragmentPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = LayoutInflater.from(context).inflate(
            R.layout.fragment_students,
            container,
            false)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
        initializePresenter()
        initializeLayoutManager()
        initializeAdapter()
        initializeListeners()
        presenter.initializeData()
    }

    override fun initializePresenter() {
        presenter = StudentsFragmentPresenter(context!!)
        presenter.attach(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button_fragment_students_filtration_by_name -> {
                presenter.initializeSortStudentsByName()
            }
            R.id.button_fragment_students_filtration_by_mark -> {
                presenter.initializeSortStudentsByMark()
            }
            R.id.button_fragment_students_random_filtration -> {
                presenter.initializeSortStudentsRandom()
            }
            R.id.button_fragment_students_clear_query -> {
                edittext_fragment_students_search_query?.setText("")
                presenter.initializeData()
            }
            R.id.button_fragment_students_top_three_by_mark -> {
                presenter.initiateTopThreeStudentsByMark()
            }
        }
    }

    override fun initializeListeners() {
        button_fragment_students_filtration_by_name?.setOnClickListener(this)

        button_fragment_students_filtration_by_mark?.setOnClickListener(this)

        button_fragment_students_random_filtration?.setOnClickListener(this)

        button_fragment_students_clear_query?.setOnClickListener(this)

        button_fragment_students_top_three_by_mark?.setOnClickListener(this)

        edittext_fragment_students_search_query?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) { }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                presenter.initiateSortStudentsByQuery(edittext_fragment_students_search_query?.text.toString())
//                filteredStudentsList.clear()
//                filteredStudentsList.addAll(students.filter { it.name.toLowerCase().contains(edittext_fragment_students_search_query?.text.toString().toLowerCase()) || it.name.toLowerCase() == edittext_fragment_students_search_query?.text.toString().toLowerCase() } as ArrayList<Student>)
//                studentsAdapter?.notifyDataSetChanged()
            }
        })
    }

    override fun initializeViews() {
        recyclerview_fragment_students?.visibility = View.VISIBLE
    }

    override fun initializeLayoutManager() {
        recyclerview_fragment_students?.layoutManager = LinearLayoutManager(context)
    }

    override fun initializeAdapter() {
        studentsAdapter = StudentsAdapter(context, students)
        recyclerview_fragment_students?.adapter = studentsAdapter
    }

    override fun initiateUpdateAdapter() {
        studentsAdapter?.notifyDataSetChanged()
    }

    override fun processData(students: ArrayList<Student>) {
        this.students.clear()
        this.students.addAll(students)
    }

    override fun initializeArguments() { }

    override fun initializeDependencies() { }

//    fun getTop3StudentsByMark(studentsList: ArrayList<Student>): ArrayList<Student> {
//        val top3StudentsByMark: ArrayList<Student> = ArrayList()
//        var topStudent: Student
//
//        for (i: Int in 0 until 3) {
//            topStudent = studentsList.first()
//            for (student in studentsList) {
//                if(student.mark > topStudent.mark) {
//                    topStudent = student
//                }
//            }
//            top3StudentsByMark.add(topStudent)
//            studentsList.remove(topStudent)
//        }
//
//        return top3StudentsByMark
//    }
}