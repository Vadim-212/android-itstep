package kz.step.stepeducation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class StudentsActivity : AppCompatActivity() {
    var buttonSortByName: Button? = null
    var buttonSortRandom: Button? = null
    var listViewStudents: ListView? = null
    var studentsList: List<String> = listOf("Иван", "Дмитрий", "Владимир", "Александр", "Борис")
    var studentsSortUseCase: StudentsSortUseCase = StudentsSortUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students)
        initializeViews()
        initializeStudentsList()
        initializeListeners()
    }

    private fun initializeViews() {
        buttonSortByName = findViewById(R.id.button_activity_students_sort_byname)
        buttonSortRandom = findViewById(R.id.button_activity_students_sort_random)
        listViewStudents = findViewById(R.id.listview_activity_students_list)
    }

    @SuppressLint("ResourceType")
    fun initializeStudentsList() {
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, studentsList)
        listViewStudents?.adapter = adapter
    }

    private fun initializeListeners() {
        buttonSortByName?.setOnClickListener(View.OnClickListener {
            studentsList = studentsSortUseCase.initiateSortStudentsByName(studentsList)
            initializeStudentsList()
        })

        buttonSortRandom?.setOnClickListener(View.OnClickListener {
            studentsList = studentsSortUseCase.initiateSortStudentsRandom(studentsList)
            initializeStudentsList()
        })
    }
}
