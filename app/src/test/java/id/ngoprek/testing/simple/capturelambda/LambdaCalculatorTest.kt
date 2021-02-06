package id.ngoprek.testing.simple.capturelambda

import io.mockk.every
import io.mockk.invoke
import io.mockk.mockk
import org.junit.Test

class LambdaCalculatorTest {

    //Mocking class CalculatorLambda
    private val calculatorLambda: CalculatorLambda = mockk()

    private val lambdaCalculator = LambdaCalculator(calculatorLambda)

    @Test
    fun onSuccess() {
        //Given
        val expectedResult = 5

        //Mocking Lambda for onSuccess
        every {
            calculatorLambda.addition(captureLambda(), any())
        } answers {
            val onSuccess = lambda<(Int) -> (Int)>()
            onSuccess.invoke(expectedResult)
        }

        //When
        lambdaCalculator.calculator()

        //Then
        assert(lambdaCalculator.result == expectedResult)
    }

    @Test
    fun onError() {
        //Given
        val expectedResult = Throwable("")

        //Mocking Lambda for onError
        every {
            calculatorLambda.addition(any(), captureLambda())
        } answers {
            val onError = lambda<(Throwable) -> (Throwable)>()
            onError.invoke(expectedResult)
        }

        //When
        lambdaCalculator.calculator()

        //Then
        assert(lambdaCalculator.onError == expectedResult)
    }
}