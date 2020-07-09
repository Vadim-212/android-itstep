package kz.step.stepeducation.presentation.presenters

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.util.Log
import androidx.core.content.ContextCompat
import kz.step.stepeducation.R
import kz.step.stepeducation.data.Student
import kz.step.stepeducation.domain.StudentsSortUseCase
import kz.step.stepeducation.presentation.contract.StudentsFragmentContract

class StudentsFragmentPresenter : StudentsFragmentContract.Presenter {
    var view: StudentsFragmentContract.View? = null
    var studentsSortUseCase: StudentsSortUseCase
    var students: ArrayList<Student> = ArrayList()
    var context: Context? = null

    constructor(context: Context) {
        this.studentsSortUseCase = StudentsSortUseCase()
        this.context = context
    }

    override fun attach(view: StudentsFragmentContract.View) {
        this.view = view
    }

    override fun initializeData() {
        context?.assets
        view?.processData(students.apply {
            add(Student("Alex", "Good Student","Group 2",12F, BitmapFactory.decodeStream(context?.assets?.open("camera_stub_image.png"))))
            add(Student("Roland", "Bad Student", "Group 1",11F, BitmapFactory.decodeStream(context?.assets?.open("camera_stub_image.png"))))
            add(Student("Force", "Average Student","Group 2",10.5F, BitmapFactory.decodeStream(context?.assets?.open("camera_stub_image.png"))))
        })
        view?.initiateUpdateAdapter()
    }

    override fun initializeSortStudentsByName() {
        studentsSortUseCase.initiateSortStudentsByName(students)
        view?.processData(students)
        view?.initiateUpdateAdapter()
    }

    override fun initializeSortStudentsRandom() {
        studentsSortUseCase.initiateSortStudentsRandom(students)
        view?.processData(students)
        view?.initiateUpdateAdapter()
    }

    override fun initializeSortStudentsByMark() {
        studentsSortUseCase.initiateSortStudentsByMark(students)
        view?.processData(students)
        view?.initiateUpdateAdapter()
    }

    override fun initiateSortStudentsByQuery(query: String) {
        studentsSortUseCase.initiateSortStudentsByQuery(students, query)
        view?.processData(students)
        view?.initiateUpdateAdapter()
    }

    override fun initiateTopThreeStudentsByMark() {
        studentsSortUseCase.initiateTopThreeStudentsByMark(students)
        view?.processData(students)
        view?.initiateUpdateAdapter()
    }

    override fun onStop() {
        view = null
    }
}