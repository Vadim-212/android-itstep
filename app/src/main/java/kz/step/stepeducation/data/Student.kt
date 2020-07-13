package kz.step.stepeducation.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

//@Entity(foreignKeys = arrayOf(ForeignKey(
//    entity = StudentsGroup::class,
//    parentColumns = arrayOf("id"),
//    childColumns = arrayOf("groupId"),
//    onDelete = CASCADE)))
@Entity
class Student {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    var name: String = ""

    var groupId: Int = 0

    override fun toString(): String {
        return "Student(id=$id,name='$name',groupId=$groupId)"
//        var returnString = "Student(id=$id,"
//        if(!name.isNullOrEmpty())
//            returnString += "name='$name',"
//        if(groupId != 0)
//            returnString += "groupId=$groupId"
//        returnString += ")"
//        return returnString
    }
}