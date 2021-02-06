package id.ngoprek.testing.simple.withdeps

import id.ngoprek.testing.simple.withdeps.factory.CalculatorFactory
import io.mockk.every
import io.mockk.mockk
import org.junit.Test

class AdvancedCalculatorTest {

    //Mocking dependencies
    private val factory: CalculatorFactory = mockk()

    private val advancedCalculator = AdvancedCalculator(factory)

    @Test
    fun addition() {
        //Given
        val a = 2
        val b = 3
        val expectedResult = 5

        //Mocking Behaviour Override function 'addition' in CalculatorFactory Method
        every {
            factory.addition(any(), any())
        } returns expectedResult

        //When
        val actual = advancedCalculator.addition(a, b)

        //Then
        assert(actual == expectedResult)
    }

    @Test
    fun subtraction() {
        //Given
        val a = 2
        val b = 3
        val expectedResult = -1

        //Mocking Behaviour Override function 'subtraction' in CalculatorFactory Method
        every {
            factory.subtraction(any(), any())
        } returns expectedResult

        //When
        val actual = advancedCalculator.subtraction(a, b)

        //Then
        assert(actual == expectedResult)
    }

    @Test
    fun multiple() {
        //Given
        val a = 2
        val b = 3
        val expectedResult = 6

        //Mocking Behaviour function 'multiple' in CalculatorFactory Method
        every {
            factory.multiple(any(), any())
        } returns expectedResult

        //When
        val actual = advancedCalculator.multiple(a, b)

        //Then
        assert(actual == expectedResult)
    }
}