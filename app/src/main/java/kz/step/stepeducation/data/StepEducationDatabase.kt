package kz.step.stepeducation.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Student::class, StudentsGroup::class), version = 4)
abstract class StepEducationDatabase: RoomDatabase() {
    abstract fun getStudentDao(): StudentDao

    abstract fun getStudentsGroupDao(): StudentsGroupDao
}