package kz.step.stepeducation.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentsGroupDao {
    @Insert
    fun initiateInsertGroup(group: StudentsGroup)

    @Insert
    fun initiateInsertGroupsList(groups: List<StudentsGroup>)

    @Query("SELECT * FROM studentsgroup")
    fun initiateGetGroups(): ArrayList<StudentsGroup>

    @Query("SELECT * FROM studentsgroup WHERE id = :id")
    fun initiateGetGroupById(id: Long): StudentsGroup

    @Query("DELETE FROM studentsgroup")
    fun initiateDeleteGroups()

    @Query("DELETE FROM studentsgroup WHERE id = :id")
    fun initiateDeleteGroupById(id: Long)
}