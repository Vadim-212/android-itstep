package kz.step.stepeducation

import android.app.Instrumentation
import android.content.Context
import android.content.Intent
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until


class BaseUIConfiguration {
    lateinit var device: UiDevice
    lateinit var context: Context
    var packageName: String = ""
    var launchIntent: Intent? = null
    var LAUNCH_TIMEOUT = 3000L
    var BASIC_PACKAGE = "kz.step.stepeducation"

    constructor(){
        initializeContext()

        initializeDevice()

        initializePackage()

        initiatePressHome()

        waitForLauncher()

        initializeLaunchIntent()

        initiateLaunchIntent()

        waitForApp()
    }

    fun initializeContext(){
        this.context = InstrumentationRegistry.getInstrumentation().context
    }

    fun initializeDevice(){
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
    }

    fun initializePackage(){
        packageName =  InstrumentationRegistry.getInstrumentation().targetContext.getPackageName()
    }

    fun initiatePressHome(){
        device.pressHome()
    }

    fun initializeLaunchIntent(){
        launchIntent = context
            .getPackageManager()
            .getLaunchIntentForPackage(packageName)
            ?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
    }

    fun initiateLaunchIntent(){
        context.startActivity(launchIntent)
    }

    fun waitForLauncher(){
        device.wait(
            Until.hasObject(By.pkg(device.launcherPackageName)
                .depth(0)), LAUNCH_TIMEOUT)
    }

    fun waitForApp(){
        device.wait(
            Until.hasObject(By.pkg(BASIC_PACKAGE)
                .depth(0)), LAUNCH_TIMEOUT)
    }
}