package io.github.jeffnyauke.supasavings.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.jeffnyauke.supasavings.domain.CalculateSavingsUseCase
import io.github.jeffnyauke.supasavings.domain.WeeklySaving
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SavingsViewModel : ViewModel() {
    private val _savings = MutableStateFlow<List<WeeklySaving>>(emptyList())
    val savings: StateFlow<List<WeeklySaving>> get() = _savings

    private val calculateSavingsUseCase = CalculateSavingsUseCase()

    fun updateSavings(startingAmount: Int) {
        viewModelScope.launch {
            _savings.value = calculateSavingsUseCase.calculateSavings(startingAmount)
        }
    }
}
