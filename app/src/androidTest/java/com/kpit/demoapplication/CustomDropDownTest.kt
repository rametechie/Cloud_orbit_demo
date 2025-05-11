package com.kpit.demoapplication

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CustomDropDownUITest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun dropdown_displaysAllOptions_whenExpanded() {
        // Click to expand dropdown
        composeTestRule.onNodeWithText("Select an option").performClick()

        // Verify all options are shown
        listOf("Option 1", "Option 2", "Option 3").forEach { option ->
            composeTestRule.onNodeWithText(option).assertExists()
        }
    }

    @Test
    fun dropdown_selectsNewOption() {
        // Initial state
        composeTestRule.onNodeWithText("Select an option").assertExists().performClick()

        // Select an item from the dropdown
        composeTestRule.onNodeWithText("Option 2").performClick()

        // Verify the selection updated
        composeTestRule.onNodeWithText("Option 2").assertExists()
    }
}