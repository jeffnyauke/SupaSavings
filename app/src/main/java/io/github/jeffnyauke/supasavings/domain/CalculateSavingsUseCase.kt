package io.github.jeffnyauke.supasavings.domain

import kotlinx.datetime.DatePeriod
import kotlinx.datetime.LocalDate
import kotlinx.datetime.plus

class CalculateSavingsUseCase {
    fun calculateSavings(startingAmount: Int): List<WeeklySaving> {
        val startDate = LocalDate(2024, 1, 1)
        var total = 0

        return (1..52).map { week ->
            val amount = startingAmount * week
            total += amount
            WeeklySaving(week, startDate.plus(DatePeriod(days = 7 * (week - 1))), amount, total)
        }
    }
}
