package kz.step.stepeducation.presentation.presenters

import android.util.Log
import kz.step.stepeducation.data.Student
import kz.step.stepeducation.domain.StudentsSortUseCase
import kz.step.stepeducation.presentation.contract.StudentsFragmentContract

class StudentsFragmentPresenter : StudentsFragmentContract.Presenter {
    var view: StudentsFragmentContract.View? = null
    var studentsSortUseCase: StudentsSortUseCase
    var students: ArrayList<Student> = ArrayList()

    constructor() {
        this.studentsSortUseCase = StudentsSortUseCase()
    }

    override fun attach(view: StudentsFragmentContract.View) {
        this.view = view
    }

    override fun initializeData() {
        view?.processData(students.apply {
            add(Student("Alex", "Good Student","Group 2",12F))
            add(Student("Roland", "Bad Student", "Group 1",11F))
            add(Student("Force", "Average Student","Group 2",10.5F))
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