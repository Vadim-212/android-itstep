package kz.step.stepeducation

import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers.isRoot
import org.hamcrest.Matcher

class WaitAction(delay: Long): ViewAction {

    var delay: Long

    init {
        this.delay = delay
    }

    override fun getConstraints(): Matcher<View> {
        return isRoot()
    }

    override fun getDescription(): String {
        return "wait during $delay millis."
    }

    override fun perform(uiController: UiController, view: View) {
        uiController.loopMainThreadForAtLeast(delay)
    }
}