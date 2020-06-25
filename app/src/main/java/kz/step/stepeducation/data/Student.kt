package kz.step.stepeducation.data

class Student {
    var name: String = ""
    var description: String = ""
    var group: String = ""

    constructor(name: String, description: String, group: String) {
        this.name = name
        this.description = description
        this.group = group
    }
}