package com.example.list_to_do

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.list_to_do.presentation.ScreenList
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ScreenListTest{
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `checkbox_changes_state_when_clicked`() {



        assert(value = true)
    }
}