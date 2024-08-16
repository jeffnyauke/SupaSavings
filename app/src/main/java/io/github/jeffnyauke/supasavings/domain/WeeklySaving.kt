package io.github.jeffnyauke.supasavings.domain

import kotlinx.datetime.LocalDate

data class WeeklySaving(val week: Int, val date: LocalDate, val amount: Int, val total: Int)

