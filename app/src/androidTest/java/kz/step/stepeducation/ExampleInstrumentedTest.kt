package kz.step.stepeducation

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Before
    fun initializeTest(){
        BasicConfiguration()
    }

    @After
    fun initiateCompleteTest(){}

    @Test
    fun useAppContext() {
        // Context of the app under test.
        onView(withId(R.id.button_activity_main_action)).perform(ViewActions.click())
        InstrumentationRegistry.getInstrumentation().context
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("kz.step.stepeducation", appContext.packageName)
    }
}