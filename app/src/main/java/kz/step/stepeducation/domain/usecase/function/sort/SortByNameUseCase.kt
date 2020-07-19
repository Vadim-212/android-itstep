package kz.step.stepeducation.domain.usecase.function.sort

import kz.step.stepeducation.domain.Student

class SortByNameUseCase {
    companion object {
        fun initiateSortByName(students: ArrayList<Student>): ArrayList<Student> {
            return students.apply { sortBy { student -> student.name } }
        }
    }
}