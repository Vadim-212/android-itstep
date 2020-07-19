package kz.step.stepeducation.domain

import kz.step.stepeducation.domain.usecase.function.sort.SortByMarkUseCase
import kz.step.stepeducation.domain.usecase.function.sort.SortByNameUseCase
import kz.step.stepeducation.domain.usecase.function.sort.SortByQueryUseCase
import kz.step.stepeducation.domain.usecase.function.sort.SortByRandomUseCase

class StudentsSortUseCase {
    fun initiateSortStudentsByName(students: ArrayList<Student>) : ArrayList<Student> {
        return SortByNameUseCase.initiateSortByName(students)
    }

    fun initiateSortStudentsRandom(students: ArrayList<Student>) : ArrayList<Student> {
        return SortByRandomUseCase.initiateSortRandom(students)
    }

    fun initiateSortStudentsByMark(students: ArrayList<Student>) : ArrayList<Student> {
        return SortByMarkUseCase.initiateSortByMark(students)
    }

    fun initiateSortStudentsByQuery(students: ArrayList<Student>, query: String) : ArrayList<Student> {
        return SortByQueryUseCase.initiateSortByQuery(students, query)
    }

    fun initiateTopThreeStudentsByMark(students: ArrayList<Student>) : ArrayList<Student> {
        val top3StudentsByMark: ArrayList<Student> = ArrayList()
        var topStudent: Student

        for (i: Int in 0 until 3) {
            topStudent = students.first()
            for (student in students) {
                if(student.mark > topStudent.mark) {
                    topStudent = student
                }
            }
            top3StudentsByMark.add(topStudent)
            students.remove(topStudent)
        }
        return top3StudentsByMark
    }
}