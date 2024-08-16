package io.github.jeffnyauke.supasavings.domain

import kotlinx.datetime.LocalDate
import org.junit.Assert.assertEquals
import org.junit.Test

class CalculateSavingsUseCaseTest {
    @Test
    fun calculateSavings_correctValues() {
        val useCase = CalculateSavingsUseCase()
        val savings = useCase.calculateSavings(50)

        assertEquals(52, savings.size)

        val firstWeek = savings[0]
        assertEquals(1, firstWeek.week)
        assertEquals(LocalDate(2024, 1, 1), firstWeek.date)
        assertEquals(50, firstWeek.amount)
        assertEquals(50, firstWeek.total)

        val secondWeek = savings[1]
        assertEquals(2, secondWeek.week)
        assertEquals(LocalDate(2024, 1, 8), secondWeek.date)
        assertEquals(100, secondWeek.amount)
        assertEquals(150, secondWeek.total)

        val lastWeek = savings[51]
        assertEquals(52, lastWeek.week)
        assertEquals(LocalDate(2024, 12, 31), lastWeek.date)
        assertEquals(2600, lastWeek.amount)
        assertEquals(68900, lastWeek.total)
    }
}
