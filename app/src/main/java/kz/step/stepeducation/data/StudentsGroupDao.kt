package kz.step.stepeducation.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction


@Dao
interface StudentsGroupDao {
    @Insert
    fun initiateInsertGroup(group: StudentsGroup)

    @Insert
    fun initiateInsertGroupsList(groups: List<StudentsGroup>)

    @Query("SELECT * FROM studentsgroup")
    fun initiateGetGroups(): List<StudentsGroup>

    @Query("SELECT * FROM studentsgroup WHERE id = :id")
    fun initiateGetGroupById(id: Int): StudentsGroup

    @Query("DELETE FROM studentsgroup")
    fun initiateDeleteGroups()

    @Query("DELETE FROM studentsgroup WHERE id = :id")
    fun initiateDeleteGroupById(id: Int)

    @Transaction
    @Query("SELECT * FROM studentsgroup")
    fun initiateLoadStudentsGroup(): List<GroupWithStudents>?

    @Transaction
    @Query("SELECT * FROM studentsgroup WHERE id = :groupId")
    fun initiateGetStudentsGroupById(groupId: Int?): GroupWithStudents?
}