package kz.step.stepeducation.domain.usecase.function.sort

import kz.step.stepeducation.domain.Student

class SortByMarkUseCase {
    companion object {
        fun initiateSortByMark(students: ArrayList<Student>): ArrayList<Student> {
            return students.apply { sortByDescending { student -> student.mark } }
        }
    }
}