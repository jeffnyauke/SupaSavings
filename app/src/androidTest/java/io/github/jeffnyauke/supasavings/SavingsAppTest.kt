package io.github.jeffnyauke.supasavings

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.unit.dp
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.github.jeffnyauke.supasavings.ui.screens.HomeScreen
import io.github.jeffnyauke.supasavings.ui.theme.SupaSavingsTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SavingsAppTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @OptIn(ExperimentalMaterial3Api::class)
    @Test
    fun appLaunchesAndDisplaysContent() {
        composeTestRule.setContent {
            SupaSavingsTheme {
                HomeScreen(modifier = Modifier.padding(16.dp))
            }
        }

        composeTestRule.onNodeWithText("Starting Amount").assertIsDisplayed()

        composeTestRule.onNodeWithText("Supa Savings").assertIsDisplayed()

        composeTestRule.onNodeWithText("01").assertIsDisplayed()
        composeTestRule.onNodeWithText("01/01").assertIsDisplayed()
        composeTestRule.onNodeWithText("Ksh. 50").assertIsDisplayed()
        composeTestRule.onNodeWithText("Ksh. 50").assertIsDisplayed()
    }
}
