package kz.step.stepeducation.domain

import android.util.Log
import kotlinx.android.synthetic.main.fragment_students.*
import kz.step.stepeducation.data.Student

class StudentsSortUseCase {
    fun initiateSortStudentsByName(students: ArrayList<Student>) : ArrayList<Student> {
        return students.apply { sortBy { student -> student.name } }
    }

    fun initiateSortStudentsRandom(students: ArrayList<Student>) : ArrayList<Student> {
        return students.apply { shuffle() }
    }

    fun initiateSortStudentsByMark(students: ArrayList<Student>) : ArrayList<Student> {
        return students.apply { sortByDescending { student -> student.mark } }
    }

    fun initiateSortStudentsByQuery(students: ArrayList<Student>, query: String) : ArrayList<Student> {
        return students.apply { filter { student -> student.name.toLowerCase().contains(query.toLowerCase()) || student.name.toLowerCase() == query.toLowerCase() } }
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