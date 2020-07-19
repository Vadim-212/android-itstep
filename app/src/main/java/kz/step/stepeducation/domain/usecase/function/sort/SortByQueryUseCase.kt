package kz.step.stepeducation.domain.usecase.function.sort

import kz.step.stepeducation.domain.Student
import java.util.*
import kotlin.collections.ArrayList

class SortByQueryUseCase {
    companion object {
        fun initiateSortByQuery(students: ArrayList<Student>, query: String): ArrayList<Student> {
            return students.apply {
                filter { student ->
                student.name.toLowerCase(Locale.ROOT)
                        .contains(query.toLowerCase(Locale.ROOT)) || student.name.toLowerCase(Locale.ROOT) == query.toLowerCase(
                    Locale.ROOT
                )
                }
            }
        }
    }
}