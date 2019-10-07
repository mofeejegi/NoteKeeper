package com.mofeejegi.notekeeper

import androidx.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers.*
import org.junit.Rule
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.assertion.ViewAssertions.matches

@RunWith(AndroidJUnit4::class)
class NextThroughNotesTest {

    @Rule @JvmField
    val noteListActivity = ActivityTestRule(NoteListActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun nextThroughNotes() {
        onData(allOf(instanceOf(NoteInfo::class.java), equalTo(DataManager.notes[0]))).perform(click())

        for (index in 0..DataManager.notes.lastIndex) {
            val note = DataManager.notes[index]

            onView(withId(R.id.spinnerCourses)).check(matches(withSpinnerText(note.course?.title)))

            onView(withId(R.id.editNoteTitle)).check(matches(withText(note.title)))
            onView(withId(R.id.editNoteText)).check(matches(withText(note.text)))

            if (index != DataManager.notes.lastIndex) {
                onView(allOf(withId(R.id.action_next), isEnabled())).perform(click())
            }
        }

        onView(withId(R.id.action_next)).check(matches(not(isEnabled())))
    }

}