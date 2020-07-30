package kz.step.stepeducation.domain.usecase

import android.content.Context
import androidx.room.Room
import kz.step.stepeducation.data.*

class DatabaseUseCase {
    private var stepEducationDatabase: StepEducationDatabase

    constructor(context: Context) {
        stepEducationDatabase = Room.databaseBuilder(
            context,
            StepEducationDatabase::class.java,
            "StepEducationDatabase"
            ).build()
    }

    fun initiateInsertStudent(student: Student) {
        stepEducationDatabase.getStudentDao().initiateInsertStudent(student)
    }

    fun initiateInsertStudentsList(students: List<Student>) {
        stepEducationDatabase.getStudentDao().initiateInsertStudentsList(students)
    }

    fun initiateGetStudents(): List<Student> {
        return stepEducationDatabase.getStudentDao().initiateGetStudents()
    }

    fun initiateGetStudentById(id: Int): Student {
        return stepEducationDatabase.getStudentDao().initiateGetStudentById(id)
    }

    fun initiateDeleteStudents() {
        stepEducationDatabase.getStudentDao().initiateDeleteStudents()
    }

    fun initiateDeleteStudentById(id: Int) {
        stepEducationDatabase.getStudentDao().initiateDeleteStudentById(id)
    }

    fun initiateGetStudentsWithGroups(): List<StudentWithGroup> {
        return stepEducationDatabase.getStudentDao().initiateGetStudentsWithGroups()
    }

    fun initiateInsertGroup(group: StudentsGroup) {
        stepEducationDatabase.getStudentsGroupDao().initiateInsertGroup(group)
    }

    fun initiateInsertGroupsList(groups: List<StudentsGroup>) {
        stepEducationDatabase.getStudentsGroupDao().initiateInsertGroupsList(groups)
    }

    fun initiateGetGroups(): List<StudentsGroup> {
        return stepEducationDatabase.getStudentsGroupDao().initiateGetGroups()
    }

    fun initiateGetGroupById(id: Int): StudentsGroup {
        return stepEducationDatabase.getStudentsGroupDao().initiateGetGroupById(id)
    }

    fun initiateDeleteGroups() {
        stepEducationDatabase.getStudentsGroupDao().initiateDeleteGroups()
    }

    fun initiateDeleteGroupById(id: Int) {
        stepEducationDatabase.getStudentsGroupDao().initiateDeleteGroupById(id)
    }

    fun initiateLoadStudentsGroup(): List<GroupWithStudents>? {
        return stepEducationDatabase.getStudentsGroupDao().initiateLoadStudentsGroup()
    }

    fun initiateGetStudentsGroupById(groupId: Int?): GroupWithStudents? {
        return stepEducationDatabase.getStudentsGroupDao().initiateGetStudentsGroupById(groupId)
    }

    fun initiateGetStudentsByGroupId(groupId: Int): List<Student> {
        return stepEducationDatabase.getStudentsGroupDao().initiateGetStudentsByGroupId(groupId)
    }

    fun initiateInsertMovie(movie: Movie) {
        stepEducationDatabase.getMovieDao().initiateInsertMovie(movie)
    }

    fun initiateInsertMovies(movies: List<Movie>) {
        stepEducationDatabase.getMovieDao().initiateInsertMovies(movies)
    }

    fun initiateGetMovies(): List<Movie> {
        return stepEducationDatabase.getMovieDao().initiateGetMovies()
    }

    fun initiateGetMovieById(movieId: Int): Movie {
        return stepEducationDatabase.getMovieDao().initiateGetMovieById(movieId)
    }
}