package kz.step.stepeducation.data

import android.graphics.Bitmap
import java.io.Serializable

class Note: Serializable {
    var title: String = ""
    var text: String = ""
    var dueDate: String = ""
    var photo: Bitmap? = null

    constructor(title: String, text: String, dueDate: String, photo: Bitmap?) {
        this.title = title
        this.text = text
        this.dueDate = dueDate
        this.photo = photo
    }
}