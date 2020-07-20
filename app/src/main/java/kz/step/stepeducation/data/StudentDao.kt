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
    fun initiateGetStudentById(id: Int): Student

    @Query("DELETE FROM student")
    fun initiateDeleteStudents()

    @Query("DELETE FROM student WHERE id = :id")
    fun initiateDeleteStudentById(id: Int)

    @Query("SELECT s.id, s.name, s.description, s.mark, sg.title as groupName FROM student s JOIN studentsgroup sg ON s.groupId = sg.id")
    fun initiateGetStudentsWithGroups(): List<StudentWithGroup>
}