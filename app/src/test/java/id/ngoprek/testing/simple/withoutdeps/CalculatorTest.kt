package id.ngoprek.testing.simple.withoutdeps

import org.junit.Test

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun addition() {
        //Given
        val a = 2
        val b = 3
        val expectedResult = 5

        //When
        val actual = calculator.addition(a, b)

        //Then
        assert(actual == expectedResult)
    }

    @Test
    fun subtraction() {
        //Given
        val a = 2
        val b = 3
        val expectedResult = -1

        //When
        val actual = calculator.subtraction(a, b)

        //Then
        assert(actual == expectedResult)
    }

    @Test
    fun division() {
        //Given
        val a = 6
        val b = 3
        val expectedResult = 2

        //When
        val actual = calculator.division(a, b)

        //Then
        assert(actual == expectedResult)
    }

    @Test
    fun multiple() {
        //Given
        val a = 2
        val b = 3
        val expectedResult = 6

        //When
        val actual = calculator.multiple(a, b)

        //Then
        assert(actual == expectedResult)
    }
}