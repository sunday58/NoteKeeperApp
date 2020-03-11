package com.notekeeping

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers.*
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard as closeSoftKeyboard1
import androidx.test.espresso.action.ViewActions.pressBack as pressBack1

@RunWith(AndroidJUnit4::class)
class CreateNewNoteTest{
    @Rule @JvmField
    val noteListActivity = ActivityTestRule(NoteListActivity::class.java)
    @Test
    fun createNewNote(){
        val course = DataManager.courses["android_async"]
        val noteTitle = "Test note title"
        val noteText = "This is the body of our text note"

        onView(withId(R.id.fab)).perform(click())

        onView(withId(R.id.spinner_Course)).perform(click())
        onData(allOf(instanceOf(CourseInfo::class.java), equalTo(course))).perform(click())

        onView(withId(R.id.text_NoteTitle)).perform(typeText(noteTitle))
        onView(withId(R.id.textNoteText)).perform(typeText(noteText), closeSoftKeyboard1())

        pressBack1()

        val  newNote = DataManager.notes.last()
        assertEquals(course,newNote.course)
        assertEquals(noteTitle,newNote.title)
        assertEquals(noteText,newNote.text)

    }

}