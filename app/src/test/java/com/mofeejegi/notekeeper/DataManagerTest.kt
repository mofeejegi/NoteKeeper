package com.mofeejegi.notekeeper

import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DataManagerTest {

    @Before
    fun setUp() {
        DataManager.notes.clear()
        DataManager.initializeNotes()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun addNotes() {
        val course = DataManager.courses["android_async"]!!
        val noteTitle = "This is a test note"
        val noteText = "This is text of my test note"

        val index = DataManager.addNote(course, noteTitle, noteText)
        val note = DataManager.notes[index]

        assertEquals(course, note.course)
        assertEquals(noteTitle, note.title)
        assertEquals(noteText, note.text)
    }

    @Test
    fun findSimilarNotes() {
        val course = DataManager.courses["android_async"]!!
        val noteTitle = "This is a test note"
        val noteText1 = "This is text of my test note"
        val noteText2 = "This is second text of my test note"

        val index1 = DataManager.addNote(course, noteTitle, noteText1)
        val index2 = DataManager.addNote(course, noteTitle, noteText2)

        val note1 = DataManager.findNote(course, noteTitle, noteText1)
        val foundIndex1 = DataManager.notes.indexOf(note1)
        assertEquals(index1, foundIndex1)

        val note2 = DataManager.findNote(course, noteTitle, noteText2)
        val foundIndex2 = DataManager.notes.indexOf(note2)
        assertEquals(index2, foundIndex2)

    }
}