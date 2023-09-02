package com.curso.android.app.practica.comparador.view

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.curso.android.app.practica.comparador.R
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get: Rule
    var rule : ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup(){
    }

    @After
    fun tearDown(){
    }

    @Test
    fun mainActivity_compareTextEquals() {
        val firstTextEdit = Espresso.onView(ViewMatchers.withId(R.id.firstTextEdit))
        val secondTextEdit = Espresso.onView(ViewMatchers.withId(R.id.secondTextEdit))

        firstTextEdit.perform(ViewActions.click())
        firstTextEdit.perform(ViewActions.typeText("Hola"))
        firstTextEdit.perform(ViewActions.closeSoftKeyboard())

        secondTextEdit.perform(ViewActions.click())
        secondTextEdit.perform(ViewActions.typeText("Hola"))
        secondTextEdit.perform(ViewActions.closeSoftKeyboard())

        Espresso.onView(
            ViewMatchers.withId(R.id.compareButton)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.resultText)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Son iguales")
            )
        )
    }


    @Test
    fun mainActivity_compareTextNotEquals() {
        val firstTextEdit = Espresso.onView(ViewMatchers.withId(R.id.firstTextEdit))

        val secondTextEdit = Espresso.onView(ViewMatchers.withId(R.id.secondTextEdit))



        firstTextEdit.perform(ViewActions.click())
        firstTextEdit.perform(ViewActions.typeText("Hola"))
        firstTextEdit.perform(ViewActions.closeSoftKeyboard())


        secondTextEdit.perform(ViewActions.click())
        secondTextEdit.perform(ViewActions.typeText("Chau"))
        secondTextEdit.perform(ViewActions.closeSoftKeyboard())



        Espresso.onView(
            ViewMatchers.withId(R.id.compareButton)
        ).perform(
            ViewActions.click()
        )


        Espresso.onView(
            ViewMatchers.withId(R.id.resultText)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Son distintos")
            )
        )
    }

}