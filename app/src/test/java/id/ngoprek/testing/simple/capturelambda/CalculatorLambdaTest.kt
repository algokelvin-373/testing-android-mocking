package id.ngoprek.testing.simple.capturelambda

import org.junit.Test

class CalculatorLambdaTest {

    @Test
    fun addition_onSuccess() {
        //Given
        val a = 2
        val b = 3
        val expectedResult = 5

        val calculatorLambda = CalculatorLambda(a, b)

        //When
        calculatorLambda.addition({
            //Then
            assert(it == expectedResult)
        }, {})

    }

    @Test
    fun addition_onError() {
        //Given
        val a = 2
        val b = 3
        val expectedResult = 5
        val expectedError = Throwable("")

        val calculatorLambda = CalculatorLambda(a, b)

        //When
        calculatorLambda.addition({
            //Then
            assert(it != expectedResult)
        }, {
            //Then
            assert(it == expectedError)
        })

    }
}