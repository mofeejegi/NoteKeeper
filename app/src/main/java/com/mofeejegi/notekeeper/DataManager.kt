package com.mofeejegi.notekeeper

import java.util.*
import kotlin.collections.ArrayList

object DataManager {

    val courses = TreeMap<String, CourseInfo>()

    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourses()
        initializeNotes()
    }

    fun addNote(course: CourseInfo, noteTitle: String, noteText: String): Int {
        val note = NoteInfo(course, noteTitle, noteText)
        notes.add(note)

        return notes.lastIndex
    }

    fun findNote(course: CourseInfo, noteTitle: String, noteText: String) : NoteInfo? {

        for (note in notes) {
            if (course == note.course &&
                    noteTitle == note.title &&
                    noteText == note.text)
                return note
        }

        return null
    }

    private fun initializeCourses() {
        var course = CourseInfo("android_intents", "Android Programming with Intents")
        courses[course.courseId] = course

        course = CourseInfo("android_async", "Android Async Programming and Services")
        courses[course.courseId] = course

        course = CourseInfo(title = "Java Fundamentals: The Java Language", courseId = "java_lang")
        courses[course.courseId] = course

        course = CourseInfo("java_core", "Java Fundamentals: The Core Platform")
        courses[course.courseId] = course
    }

    fun initializeNotes() {
        var note = courses["android_intents"]?.let {
            NoteInfo(
                it,
                "Dynamic intent resolution", "These are awesome")
        }

        note?.let { notes.add(it) }

        note = courses["java_lang"]?.let {
            NoteInfo(
                it,
                "What is Java?", "Who knows?")
        }

        note?.let { notes.add(it) }
    }


}