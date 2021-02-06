package id.ngoprek.testing.simple.staticcalculator

import id.ngoprek.testing.simple.static.Addition
import id.ngoprek.testing.simple.static.StaticCalculator
import io.mockk.every
import io.mockk.mockkObject
import org.junit.Before
import org.junit.Test

class StaticCalculatorTest {

    private val staticCalculator = StaticCalculator()

    //Mocking do something
    @Before
    fun setUp() {
        mockkObject(Addition) // Mocking object 'Addition' before test
    }

    @Test
    fun calc() {
        //Given
        val a = 2
        val b = 3
        val expectedResult = 5

        //Mocking Behaviour Override function 'addition' in CalculatorFactory Method
        every {
            Addition.addition(any(), any())
        } returns expectedResult

        //When
        staticCalculator.calc(a, b)

        //Then
        assert(staticCalculator.result == expectedResult)
    }
}