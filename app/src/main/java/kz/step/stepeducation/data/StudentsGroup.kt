package kz.step.stepeducation.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class StudentsGroup {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    var title: String = ""

    override fun toString(): String {
        return "StudentsGroup(id=$id,title='$title')"
    }
}