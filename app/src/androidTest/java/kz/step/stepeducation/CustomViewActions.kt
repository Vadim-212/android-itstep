package kz.step.stepeducation

import android.view.View
import androidx.test.espresso.PerformException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.google.android.material.tabs.TabLayout
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher

class CustomViewActions {
    companion object {
        fun selectTabAtPosition(tabIndex: Int): ViewAction {
            return object : ViewAction {
                override fun getDescription() = "with tab at index $tabIndex"

                override fun getConstraints() =
                    allOf(isDisplayed(), isAssignableFrom(TabLayout::class.java))

                override fun perform(uiController: UiController, view: View) {
                    val tabLayout = view as TabLayout
                    val tabAtIndex: TabLayout.Tab = tabLayout.getTabAt(tabIndex)
                        ?: throw PerformException.Builder()
                            .withCause(Throwable("No tab at index $tabIndex"))
                            .build()

                    tabAtIndex.select()
                }
            }
        }

        fun withCustomConstraints(action: ViewAction, constraints: Matcher<View>): ViewAction? {
            return object : ViewAction {
                override fun getConstraints(): Matcher<View> {
                    return constraints
                }

                override fun getDescription(): String {
                    return action.description
                }

                override fun perform(uiController: UiController, view: View) {
                    action.perform(uiController, view)
                }
            }
        }
    }
}