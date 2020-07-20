package kz.step.stepeducation.data

import androidx.room.Embedded
import androidx.room.Relation

class GroupWithStudents {
    @Embedded
    lateinit var group: StudentsGroup
    @Relation(parentColumn = "id", entity = Student::class, entityColumn = "groupId")
    lateinit var students: List<Student>

    override fun toString(): String {
        return "GroupWithStudents(group=${group.toString()},studentsListSize=${students.size})"
    }
}