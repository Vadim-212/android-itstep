package kz.step.stepeducation

import org.junit.After
import org.junit.Before

abstract class BaseUnitTest {
    @Before
    abstract fun beforeTest()

    @After
    abstract fun afterTest()
}