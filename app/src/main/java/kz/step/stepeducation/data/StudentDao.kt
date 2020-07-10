package kz.step.stepeducation.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {
    @Insert
    fun initiateInsertStudent(student: Student)

    @Insert
    fun initiateInsertStudentsList(students: List<Student>)

    @Query("SELECT * FROM student")
    fun initiateGetStudents(): List<Student>

    @Query("SELECT * FROM student WHERE id = :id")
    fun initiateGetStudentById(id: Long): Student

    @Query("DELETE FROM student")
    fun initiateDeleteStudents()

    @Query("DELETE FROM student WHERE id = :id")
    fun initiateDeleteStudentById(id: Long)
}