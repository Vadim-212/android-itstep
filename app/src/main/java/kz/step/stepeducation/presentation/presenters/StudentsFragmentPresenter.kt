package kz.step.stepeducation.presentation.presenters

import android.content.Context
import android.graphics.BitmapFactory
import android.util.Log
import androidx.room.Room
import kz.step.stepeducation.data.StepEducationDatabase
import kz.step.stepeducation.data.StudentsGroup
import kz.step.stepeducation.domain.Student
import kz.step.stepeducation.data.Student as StudentModel
import kz.step.stepeducation.domain.StudentsSortUseCase
import kz.step.stepeducation.presentation.contract.StudentsFragmentContract

class StudentsFragmentPresenter : StudentsFragmentContract.Presenter {
    var view: StudentsFragmentContract.View? = null
    var studentsSortUseCase: StudentsSortUseCase
    var students: ArrayList<Student> = ArrayList()
    var context: Context? = null
    var stepEducationDatabase: StepEducationDatabase

    constructor(context: Context) {
        this.studentsSortUseCase = StudentsSortUseCase()
        this.context = context
        stepEducationDatabase = Room.databaseBuilder(
            context!!,
            StepEducationDatabase::class.java,
            "StepEducationDatabase").allowMainThreadQueries()
//            .fallbackToDestructiveMigration() // TODO: потеря данных в базе данных, при использовании fallbackToDestructiveMigration()
            .build()
    }

    override fun attach(view: StudentsFragmentContract.View) {
        this.view = view
    }

    override fun initializeData() {
        view?.processData(students.apply {
            add(
                Student(
                    "Alex",
                    "Good Student",
                    "Group 2",
                    12F,
                    BitmapFactory.decodeStream(context?.assets?.open("camera_stub_image.png"))
                )
            )
            add(
                Student(
                    "Roland",
                    "Bad Student",
                    "Group 1",
                    11F,
                    BitmapFactory.decodeStream(context?.assets?.open("camera_stub_image.png"))
                )
            )
            add(
                Student(
                    "Force",
                    "Average Student",
                    "Group 2",
                    10.5F,
                    BitmapFactory.decodeStream(context?.assets?.open("camera_stub_image.png"))
                )
            )
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

    override fun initiateAddStudent(student: Student) {
        students.add(student)
        view?.processData(students)
        view?.initiateUpdateAdapter()
    }

    fun initiazeDataRoomStudents(groupId: Int) {
        var groupWithStudents = stepEducationDatabase.getStudentsGroupDao().initiateGetStudentsGroupById(groupId)
        students.clear()
        if (groupWithStudents != null) {
            for(student in groupWithStudents.students) {
                students.add(Student(student.name, student.description, groupWithStudents.group.title, student.mark, null))
            }
        }

        view?.processData(students)
        view?.initiateUpdateAdapter()
    }

    fun initiazeDataRoomGroupWithStudents() {
        var groupList = stepEducationDatabase.getStudentsGroupDao().initiateLoadStudentsGroup()!!
        view?.processDataGroups(groupList)
        view?.initiateUpdateAdapter()
    }

    override fun onStop() {
        view = null
    }
}