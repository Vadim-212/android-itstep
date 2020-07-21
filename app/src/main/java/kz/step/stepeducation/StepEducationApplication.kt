package kz.step.stepeducation

import android.app.Application

class StepEducationApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: StepEducationApplication
            private set
    }
}