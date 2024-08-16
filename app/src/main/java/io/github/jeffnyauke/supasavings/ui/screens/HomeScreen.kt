package io.github.jeffnyauke.supasavings.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.jeffnyauke.supasavings.domain.WeeklySaving
import io.github.jeffnyauke.supasavings.presentation.SavingsViewModel

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(savingsViewModel: SavingsViewModel = viewModel(), modifier: Modifier) {
    val savings by savingsViewModel.savings.collectAsState()

    LaunchedEffect(Unit) {
        savingsViewModel.updateSavings(50)
    }

    var startingAmount by remember { mutableIntStateOf(50) }

    Column {
        Column(modifier = modifier.padding(16.dp)) {
            OutlinedTextField(
                value = startingAmount.toString(),
                onValueChange = { newValue ->
                    startingAmount = newValue.toIntOrNull() ?: 0
                    savingsViewModel.updateSavings(startingAmount)
                },
                label = { Text("Starting Amount") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            SavingsList(savings)
        }
    }
}

@Composable
fun SavingsList(savings: List<WeeklySaving>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        SavingsListHeaders()
        LazyColumn {
            items(savings) { week ->
                SavingsItem(week)
            }
        }
    }
}

@Composable
fun SavingsListHeaders() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Week",
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Date",
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Amount",
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Total",
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun SavingsItem(week: WeeklySaving) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = week.week.toString().padStart(2, '0'),
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
        Text(
            text = "${
                week.date.dayOfMonth.toString().padStart(2, '0')
            }/${week.date.monthNumber.toString().padStart(2, '0')}",
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
        Text(
            text = "${week.amount}",
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
        Text(
            text = "${week.total}",
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
    }
}

