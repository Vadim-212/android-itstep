package kz.step.stepeducation.presentation.contract

import kz.step.stepeducation.data.GroupWithStudents
import kz.step.stepeducation.data.StudentsGroup
import kz.step.stepeducation.domain.Student
import kz.step.stepeducation.presentation.base.BaseContract

interface StudentsFragmentContract {
    interface View : BaseContract.BaseView{
        fun initializePresenter()

        fun initializeLayoutManager()

        fun initializeAdapter()

        fun initializeGroupsAdapter()

        fun initiateUpdateAdapter()

        fun processData(students: ArrayList<Student>)

        fun processDataGroups(groupWithStudents: List<GroupWithStudents>)
    }

    interface Presenter : BaseContract.BasePresenter<View>{
        fun initializeData()

        fun initializeSortStudentsByName()

        fun initializeSortStudentsRandom()

        fun initializeSortStudentsByMark()

        fun initiateSortStudentsByQuery(query: String)

        fun initiateTopThreeStudentsByMark()

        fun initiateAddStudent(student: Student)
    }
}