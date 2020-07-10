package kz.step.stepeducation.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class StudentsGroup {
    @PrimaryKey
    var id: Long = 0

    var title: String = ""

    override fun toString(): String {
        return "StudentsGroup(title='${title}')"
    }
}