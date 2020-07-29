package kz.step.stepeducation.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_students.*
import kz.step.stepeducation.R
import kz.step.stepeducation.domain.Student
import kz.step.stepeducation.presentation.base.BaseActivity
import kz.step.stepeducation.presentation.fragments.CurrenciesFragment
import kz.step.stepeducation.presentation.fragments.MoviesFragment
import kz.step.stepeducation.presentation.fragments.StudentsFragment
import kz.step.stepeducation.presentation.fragments.ViewPagerFragment
import java.nio.BufferUnderflowException

class StudentsActivity : BaseActivity() {
    //var buttonSortByName: Button? = null
    //var buttonSortRandom: Button? = null
    //var listViewStudents: ListView? = null
    //var studentsList: List<String> = listOf("Иван", "Дмитрий", "Владимир", "Александр", "Борис")
    //var studentsSortUseCase: StudentsSortUseCase =
    //    StudentsSortUseCase()

    var currentFragment: Fragment? = null
    //var studentsList: ArrayList<Student> = ArrayList()
    //var studentsAdapter: StudentsAdapter? = null
    //var isViewChanged = false
    var fragmentArguments: Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students)

        //initializeViews()
        //initializeStudentsList()
        initializeListeners()

        if(intent.extras?.getParcelable<Student>("student") != null){
            fragmentArguments = Bundle()
            fragmentArguments!!.putParcelable("student", intent.extras?.getParcelable<Student>("student"))
        }

        initializeDefaultFragment()

        //displayFragment(MoviesFragment())
    }

    private fun initializeViews() {
        //buttonSortByName = findViewById(R.id.button_activity_students_sort_byname)
        //buttonSortRandom = findViewById(R.id.button_activity_students_sort_random)
        //listViewStudents = findViewById(R.id.listview_activity_students_list)
    }

//    @SuppressLint("ResourceType")
//    fun initializeStudentsList() {
//        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, studentsList)
//        listViewStudents?.adapter = adapter
//    }
//
    private fun initializeListeners() {
//        buttonSortByName?.setOnClickListener {
//            studentsList = studentsSortUseCase.initiateSortStudentsByName(studentsList)
//            initializeStudentsList()
//        }
//
//        buttonSortRandom?.setOnClickListener {
//            studentsList = studentsSortUseCase.initiateSortStudentsRandom(studentsList)
//            initializeStudentsList()
//        }
//        button_activity_students_change_view?.setOnClickListener {
//            if(isViewChanged) {
//                supportFragmentManager?.popBackStack()
//            } else {
//                displayFragment(ViewPagerFragment())
//            }
//            isViewChanged = !isViewChanged
//        }
    }


    override fun initializeDefaultFragment(){
        if(currentFragment == null){
            currentFragment = StudentsFragment()
            displayFragment(currentFragment!!)
        }
    }

    override fun displayFragment(fragment: Fragment) {
        if(fragmentArguments != null) {
            fragment.arguments = fragmentArguments
        }
        this.currentFragment = fragment
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        supportFragmentManager.executePendingTransactions()
        fragmentTransaction.add(
            R.id.relativelayout_activity_students_fragment_container,
            fragment,
            fragment.javaClass.name)

        fragmentTransaction.addToBackStack("Name")
        fragmentTransaction.commit()

    }

    override fun getActivityInstance(): BaseActivity {
        return this
    }
}
