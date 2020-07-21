package kz.step.stepeducation

import android.content.Context
import android.content.Intent
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until

class BasicConfiguration {

    lateinit var device: UiDevice

    lateinit var context: Context

    lateinit var packageName: String

    var launchIntent: Intent? = null

    private val LAUNCH_TIMEOUT = 5000L
    private val BASIC_PACKAGE = "kz.education.stepeducation"

    constructor(){
        initializeUiDevice()
        initializeContext()
        initializePackage()
        initiatePressHome()
        waitForLauncher()
        initializeLaunchIntent()
        launchIntent()
        waitForApp()
    }

    fun initializeUiDevice(){
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
    }

    fun initializeContext(){
        context = StepEducationApplication.instance.applicationContext
    }

    fun initializePackage(){
        packageName = InstrumentationRegistry.getInstrumentation().targetContext.getPackageName();
    }

    fun initiatePressHome(){
        device.pressHome()
    }

    fun waitForLauncher(){
        device.wait(
            Until.hasObject(By.pkg(device.launcherPackageName).depth(0)),
            LAUNCH_TIMEOUT
        )
    }

    fun waitForApp(){
        device.wait(
            Until.hasObject(By.pkg(BASIC_PACKAGE).depth(0)),
            LAUNCH_TIMEOUT
        )
    }

    fun initializeLaunchIntent(){
        launchIntent = context.getPackageManager()
            .getLaunchIntentForPackage(packageName)?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
    }

    fun launchIntent(){
        context.startActivity(launchIntent);
    }
}