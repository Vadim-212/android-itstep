package kz.step.stepeducation.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Movie {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    var title: String = ""

    var description: String = ""

    var rate: Float = 0F

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    var image: ByteArray = ByteArray(0)

    override fun toString(): String {
        return "Movie(title=$title,description=$description,rate=$rate,imageSize=${image.size}"
    }
}