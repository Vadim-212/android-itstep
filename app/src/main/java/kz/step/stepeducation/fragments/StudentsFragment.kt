package kz.step.stepeducation.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.step.stepeducation.R
import kz.step.stepeducation.adapter.StudentsAdapter
import kz.step.stepeducation.data.Student


class StudentsFragment : Fragment() {
    var rootView: View? = null
    var students: ArrayList<Student> = ArrayList()
    var filteredStudentsList: ArrayList<Student> = ArrayList()
    var recyclerViewStudents: RecyclerView? = null
    var studentsAdapter: StudentsAdapter? = null

    var filtrationByNameButton: Button? = null
    var filtrationByMarkButton: Button? = null
    var randonFiltrationButton: Button? = null
    var searchEditText: EditText? = null
    var clearSearchQueryButton: Button? = null

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
        initializeListeners()

        return rootView
    }

    fun initializeViews(){
        recyclerViewStudents = rootView?.findViewById(R.id.recyclerview_fragment_students)

        filtrationByNameButton = rootView?.findViewById(R.id.button_fragment_students_filtration_by_name)
        filtrationByMarkButton = rootView?.findViewById(R.id.button_fragment_students_filtration_by_mark)
        randonFiltrationButton = rootView?.findViewById(R.id.button_fragment_students_random_filtration)
        searchEditText = rootView?.findViewById(R.id.edittext_fragment_students_search_query)
        clearSearchQueryButton = rootView?.findViewById(R.id.button_fragment_students_clear_query)
    }

    fun initializeListeners() {
        filtrationByNameButton?.setOnClickListener {
            filteredStudentsList.sortBy { it.name }
            studentsAdapter?.notifyDataSetChanged()
        }

        filtrationByMarkButton?.setOnClickListener {
            filteredStudentsList.sortByDescending { it.mark }
            studentsAdapter?.notifyDataSetChanged()
        }

        randonFiltrationButton?.setOnClickListener {
            filteredStudentsList.shuffle()
            studentsAdapter?.notifyDataSetChanged()
        }

        searchEditText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) { }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                filteredStudentsList.clear()
                filteredStudentsList.addAll(students.filter { it.name.toLowerCase().contains(searchEditText?.text.toString().toLowerCase()) || it.name.toLowerCase() == searchEditText?.text.toString().toLowerCase() } as ArrayList<Student>)
                studentsAdapter?.notifyDataSetChanged()
            }
        })

        clearSearchQueryButton?.setOnClickListener {
            searchEditText?.setText("")
            filteredStudentsList.clear()
            filteredStudentsList.addAll(students)
            studentsAdapter?.notifyDataSetChanged()
        }
    }

    fun initializeLayoutManager(){
        recyclerViewStudents?.layoutManager = LinearLayoutManager(context)
    }

    fun initializeAdapter(){
        studentsAdapter = StudentsAdapter(context, filteredStudentsList)
        recyclerViewStudents?.adapter = studentsAdapter
    }

    fun initializeData(){
        students.add(Student("Vasya", "Bad Student", "Group 1", 10F))
        students.add(Student("John", "Good Student", "Group 1", 11.5F))
        students.add(Student("Log", "Average Student", "Group 2", 11F))
        filteredStudentsList.addAll(students)
    }
}