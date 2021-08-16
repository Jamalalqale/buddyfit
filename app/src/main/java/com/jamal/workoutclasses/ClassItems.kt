package com.jamal.workoutclasses


class ClassItems(val className: String,
                 val startsAt: String,
                 val endsAt: String,
                 val duration: String,
                 val lang: String,
                 val category: String,
                 val picture: String,
                 val trainerFullName: String,
                 val trainerProfilePicture: String
                 ) {

    companion object {
        fun createClassList(): ArrayList<ClassItems> {
            val classes = ArrayList<ClassItems>()
            return classes
        }
    }
}