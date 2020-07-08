package kz.step.stepeducation.data

import android.os.Parcel
import android.os.Parcelable

class Student : Parcelable {
    var name: String = ""
    var description: String = ""
    var group: String = ""
    var mark: Float = 0F

    constructor(parcel: Parcel) : this() {
        name = parcel.readString().toString()
        description = parcel.readString().toString()
        group = parcel.readString().toString()
        mark = parcel.readFloat()
    }

    constructor() {
        name = "name"
        description = "description"
        group = "group"
        mark = 12F
    }

    constructor(name: String, description: String, group: String, mark: Float) : this() {
        this.name = name
        this.description = description
        this.group = group
        this.mark = mark
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(group)
        parcel.writeFloat(mark)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Student> {
        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }

        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }
}