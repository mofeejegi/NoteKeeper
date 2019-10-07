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

@RunWith(AndroidJUnit4::class)
class CreateNewNoteTest {

    @Rule @JvmField
    val noteListActivity = ActivityTestRule(NoteListActivity::class.java)

//    @Before
//    fun setUp() {
//    }
//
//    @After
//    fun tearDown() {
//    }

    @Test
    fun createNewNote() {
        val course = DataManager.courses["java_core"]
        val noteTitle = "Test note title"
        val noteText = "This is the body of our test note"

        onView(withId(R.id.fab)).perform(click())

        onView(withId(R.id.spinnerCourses)).perform(click())
        //onData(allOf(instanceOf(CourseInfo::class.java), equalTo(course))).perform(click())
        onData(equalTo(course)).perform(click())

        onView(withId(R.id.editNoteTitle)).perform(typeText(noteTitle))
        onView(withId(R.id.editNoteText)).perform(typeText(noteText), closeSoftKeyboard())

        pressBack()

        val newNote = DataManager.notes.last()
        assertEquals(course, newNote.course)
        assertEquals(noteTitle, newNote.title)
        assertEquals(noteText, newNote.text)

    }
}