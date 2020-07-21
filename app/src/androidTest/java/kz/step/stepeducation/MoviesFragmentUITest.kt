package kz.step.stepeducation

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeDown
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import kz.step.stepeducation.presentation.activity.MoviesActivity
import kz.step.stepeducation.presentation.viewholder.MovieHolder
import org.hamcrest.Matchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoviesFragmentUITest {

    @Rule
    @JvmField var activityRule: ActivityTestRule<MoviesActivity> = ActivityTestRule(MoviesActivity::class.java)

    @Before
    fun initiateBeforeTest(){
        BaseUIConfiguration()
    }

    @After
    fun initiateAfterTest(){

    }

    @Test
    fun initiateUITest(){
        onView(ViewMatchers.isRoot()).perform(WaitAction(1000))
        onView(withId(R.id.button_activity_main_goto_movies_activity)).perform(ViewActions.click())

        onView(ViewMatchers.isRoot()).perform(WaitAction(1000))
        onView(withId(R.id.tablayout_activity_movies)).perform(CustomViewActions.selectTabAtPosition(0))

        onView(ViewMatchers.isRoot()).perform(WaitAction(1000))
        onView(withId(R.id.tablayout_activity_movies)).perform(CustomViewActions.selectTabAtPosition(1))

        onView(ViewMatchers.isRoot()).perform(WaitAction(1000))
        onView(withId(R.id.tablayout_activity_movies)).perform(CustomViewActions.selectTabAtPosition(2))

        onView(ViewMatchers.isRoot()).perform(WaitAction(1000))
//        onData(withId(R.id.recyclerview_fragment_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<MovieHolder>(0, click()))
        onView(allOf(withId(R.id.recyclerview_fragment_movies), isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition<MovieHolder>(0, click()))

        onView(ViewMatchers.isRoot()).perform(WaitAction(1000))
        onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())

        onView(ViewMatchers.isRoot()).perform(WaitAction(1000))
        onView(allOf(withId(R.id.swiperefreshlayout_fragment_movies), isDisplayed())).perform(CustomViewActions.withCustomConstraints(swipeDown(), isDisplayingAtLeast(85)))
    }
}