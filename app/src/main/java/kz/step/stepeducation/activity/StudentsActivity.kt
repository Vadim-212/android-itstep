package kz.step.stepeducation.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.Fragment
import kz.step.stepeducation.R
import kz.step.stepeducation.fragments.StudentsFragment
import kz.step.stepeducation.StudentsSortUseCase

class StudentsActivity : AppCompatActivity() {
    var buttonSortByName: Button? = null
    var buttonSortRandom: Button? = null
    var listViewStudents: ListView? = null
    var studentsList: List<String> = listOf("Иван", "Дмитрий", "Владимир", "Александр", "Борис")
    var studentsSortUseCase: StudentsSortUseCase =
        StudentsSortUseCase()
    var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students)

        //initializeViews()
        //initializeStudentsList()
        //initializeListeners()

        initializeDefaultFragment()
        //displayFragment(StudentInformationFragment())
    }

    private fun initializeViews() {
        //buttonSortByName = findViewById(R.id.button_activity_students_sort_byname)
        //buttonSortRandom = findViewById(R.id.button_activity_students_sort_random)
        //listViewStudents = findViewById(R.id.listview_activity_students_list)
    }

    @SuppressLint("ResourceType")
    fun initializeStudentsList() {
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, studentsList)
        listViewStudents?.adapter = adapter
    }

    private fun initializeListeners() {
        buttonSortByName?.setOnClickListener {
            studentsList = studentsSortUseCase.initiateSortStudentsByName(studentsList)
            initializeStudentsList()
        }

        buttonSortRandom?.setOnClickListener {
            studentsList = studentsSortUseCase.initiateSortStudentsRandom(studentsList)
            initializeStudentsList()
        }
    }

    fun initializeDefaultFragment(){
        if(currentFragment == null){
            currentFragment = StudentsFragment()
            displayFragment(currentFragment!!)
        }
    }

    fun displayFragment(fragment: Fragment){

        this.currentFragment = fragment
        var fragmentTransaction = supportFragmentManager.beginTransaction()
        supportFragmentManager.executePendingTransactions()
        fragmentTransaction.add(
            R.id.relativelayout_activity_students_fragment_container,
            fragment!!,
            fragment?.javaClass?.name ?: "")

        fragmentTransaction.addToBackStack("Name")
        fragmentTransaction.commit()

    }
}
