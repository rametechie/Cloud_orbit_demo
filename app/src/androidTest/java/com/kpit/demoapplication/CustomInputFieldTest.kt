package com.kpit.demoapplication

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.compose.ui.test.performTextClearance

@RunWith(AndroidJUnit4::class)
class CustomInputFieldUITest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun inputField_displaysCorrectLabelAndHint() {
        // Check label
        composeTestRule.onNodeWithText("Password")
            .assertExists()
            .assertIsDisplayed()

        // Check hint (inside the placeholder)
        composeTestRule.onNodeWithText("Enter password")
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun passwordStrength_calculatesCorrectly() {
        val field = composeTestRule.onNodeWithTag("passwordInput")

        field.performTextClearance()
        field.performTextInput("123")
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithText("Strength: VERY_WEAK").assertExists()

        field.performTextClearance()
        field.performTextInput("abcdefgh")
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithText("Strength: WEAK").assertExists()

        field.performTextClearance()
        field.performTextInput("Abc123!@#456")
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithText("Strength: STRONG").assertExists()
    }

    @Test
    fun inputFieldUpdatesValueAndShowsStrength() {
        val passwordText = "MyPass123!"

        // Type the password
        composeTestRule.onNodeWithText("Enter password")
            .assertExists()
            .performTextInput(passwordText)

        // Confirm password appears in the field
        composeTestRule.onNodeWithText(passwordText).assertExists()
    }

    //extra test
    @Test
    fun togglePasswordVisibilityIconWorks() {
        // Toggle visibility icon (eye icon)
        composeTestRule.onNodeWithContentDescription("Toggle Password Visibility")
            .assertExists()
            .performClick()
    }
}