package kz.step.stepeducation.data

class Student {
    var name: String = ""
    var description: String = ""
    var group: String = ""
    var mark: Float = 0F

    constructor(name: String, description: String, group: String, mark: Float) {
        this.name = name
        this.description = description
        this.group = group
        this.mark = mark
    }
}