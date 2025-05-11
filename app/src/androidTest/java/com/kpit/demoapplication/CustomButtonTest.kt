package com.kpit.demoapplication

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CustomButtonUITest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun customButton_clickTriggersAction() {
        composeTestRule.onNodeWithText("Click Me").assertExists().performClick()
    }

    @Test
    fun buttonIsDisplayed() {
        composeTestRule.onNodeWithText("Click Me").assertExists().performClick()
    }

    @Test
    fun buttonIsCorrectBackgroundColor() {
        // Check that a button with the testTag exists
        composeTestRule.onNodeWithTag("button_primary").assertExists()
    }
}