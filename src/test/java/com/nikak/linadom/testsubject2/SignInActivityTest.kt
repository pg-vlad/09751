package com.nikak.linadom.testsubject2

import android.support.v7.app.AppCompatActivity
import org.junit.Test

import org.junit.Assert.*

class SignInActivityTest {

    val activity: SignInActivity = SignInActivity()

    @Test
    fun isPasswordValid() {
        assertEquals(true, activity.isPasswordValid("Admin23"))
        assertEquals(false, activity.isPasswordValid("Adm==in23"))
        assertEquals(false, activity.isPasswordValid("weU"))
        assertEquals(false, activity.isPasswordValid("we   U"))
    }


    @Test
    fun isUserNameValid() {
        assertEquals(true, activity.isUserNameValid("Admin23"))
        assertEquals(false, activity.isUserNameValid("Adm==in23"))
        assertEquals(false, activity.isUserNameValid("we  U"))
        assertEquals(false, activity.isPasswordValid("weU"))
    }



}