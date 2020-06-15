package kz.step.stepeducation

class StudentsSortUseCase {
    fun initiateSortStudentsByName(students: List<String>) : List<String> {
        return students.sorted()
    }

    fun initiateSortStudentsRandom(students: List<String>) : List<String> {
        return students.shuffled()
    }
}