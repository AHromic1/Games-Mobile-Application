package com.example.rma23_19084_projekat

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

//import org.junit.Assert.*
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.PositionAssertions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Assert.assertEquals
import org.hamcrest.CoreMatchers.`is` as Is
import org.junit.Assert.assertTrue
import org.junit.Rule


@RunWith(AndroidJUnit4::class)
class TestLayout {
    /*
    fun hasItemCount(n: Int) = object : ViewAssertion {
        override fun check(view: View?, noViewFoundException: NoMatchingViewException?) {
            if (noViewFoundException != null) {
                throw noViewFoundException
            }
            assertTrue("View nije tipa RecyclerView", view is RecyclerView)
            var rv: RecyclerView = view as RecyclerView
            assertThat(
                "GetItemCount RecyclerView broj elementa: ",
                rv.adapter?.itemCount,
                Is(n)
            )
        }
    }

    @get:Rule
    var homeRule:ActivityScenarioRule<HomeActivity> = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun elementsTest(){ //raspored problem
        onView(withId(R.id.logo_image)).check(isCompletelyLeftOf(withId(R.id.home_button)))  //radi
        onView(withId(R.id.home_button)).check(isTopAlignedWith(withChild(withId(R.id.home_button)))) // radi
        onView(withId(R.id.details_button)).check(isTopAlignedWith(withId(R.id.home_button)))  // radi
        onView(withId(R.id.search_button)).check(isCompletelyBelow(withId(R.id.home_button))) //radi
        onView(withId(R.id.search_button)).check(isTopAlignedWith(withId(R.id.search_query_edittext)))//radi
    }

    @Test
    fun recyclerViewTest(){
        onView(withId(R.id.game_list)).perform(RecyclerViewActions.scrollToPosition<ViewHolder>(0)).check(matches(allOf(
            hasDescendant(withId(R.id.game_title_textview)),  //ima
             hasDescendant(withId(R.id.game_rating_textview)),  //ima
            hasDescendant(withId(R.id.game_release_date_textview)), //test greska bila
            hasDescendant(withId(R.id.game_platform_textview)),
            hasDescendant(withId(R.id.game_rating_textview))
        )))

        onView(withId(R.id.game_list)).perform(RecyclerViewActions.scrollToPosition<ViewHolder>(0)).check(
            matches(hasDescendant(withId(R.id.game_title_textview)).also { isTopAlignedWith(
                withChild(withId(R.id.game_title_textview))
            ) }))
        onView(withId(R.id.game_list)).perform(RecyclerViewActions.scrollToPosition<ViewHolder>(0)).check(
            matches(hasDescendant(withId(R.id.game_title_textview)).also { isCompletelyRightOf(
                withId(R.id.game_rating_textview)
            ) }))
        onView(withId(R.id.game_list)).perform(RecyclerViewActions.scrollToPosition<ViewHolder>(0)).check(
            matches(hasDescendant(withId(R.id.game_rating_textview)).also { isCompletelyLeftOf(
                withId(R.id.game_platform_textview)
            ) }))
    }

    @Test
    fun recyclerViewTest2(){  // radi
        var prvaIgra = GameData.getAll()[0]
        onView(withId(R.id.game_list)).perform(RecyclerViewActions.scrollTo<ViewHolder>(allOf(
            hasDescendant(withText(prvaIgra.title)),
            hasDescendant(withText(prvaIgra.releaseDate)),
            hasDescendant(withText(prvaIgra.rating.toString()))
        )))
    }
    @Test
    fun recyclerViewTest3(){  //problem je sto treba da se otvori direkt iz recycle view - SADA RADIIII
        var prvaIgra = GameData.getAll().get(0)
        onView(withId(R.id.game_list)).perform(RecyclerViewActions.actionOnItem<ViewHolder>(allOf(
            hasDescendant(withText(prvaIgra.title)),
            hasDescendant(withText(prvaIgra.releaseDate)),
            hasDescendant(withText(prvaIgra.rating.toString()))
        ),click()))
        onView(withText(prvaIgra.description)).check(matches(isCompletelyDisplayed()))
        onView(instanceOf(RecyclerView::class.java)).check(hasItemCount(prvaIgra.userImpressions.size))
    }
    @Test
    fun detailsDugmeNakonItemClick(){  //  -radi
        var prvaIgra = GameData.getAll().get(0)
        onView(withId(R.id.game_list)).perform(RecyclerViewActions.actionOnItem<ViewHolder>(allOf(
            hasDescendant(withText(prvaIgra.title)),
            hasDescendant(withText(prvaIgra.releaseDate)),
            hasDescendant(withText(prvaIgra.rating.toString()))
        ),click()))
       onView(withId(R.id.home_button)).perform(click()) //p
       onView(withId(R.id.details_button)).perform(click())
        onView(withText(prvaIgra.description)).check(matches(isCompletelyDisplayed()))
    }

     */
}
/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
/*
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.rma23_19084_projekat", appContext.packageName)
    }*/
//}