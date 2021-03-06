package id.ngoprek.testing.arch.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import id.ngoprek.testing.arch.data.Result
import id.ngoprek.testing.arch.data.Success
import id.ngoprek.testing.arch.domain.LoginUseCase
import id.ngoprek.testing.arch.ui.uimodel.LoginUIModel
import id.ngoprek.testing.arch.utils.TestDispatcherProvider
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.spyk
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoginViewModelTest {

    @get:Rule val instanttastEksekutorule = InstantTaskExecutorRule()

    private val useCase: LoginUseCase = mockk()

    private val loginObserver: Observer<Result<LoginUIModel>> = spyk()

    private val dispatcher = TestDispatcherProvider()
    private val loginViewModel = LoginViewModel(useCase, dispatcher)

    @Before
    fun setUp() {
        loginViewModel.login.observeForever(loginObserver)
    }

    @Test
    fun `it should login correctly`() {
        //Given
        val expectedResult = Success(
            LoginUIModel("", "isfa", "", "")
        )

        //Because suspend function, so must be use 'coEvery'
        coEvery {
            useCase(any())
        } returns expectedResult

        //When
        loginViewModel.doLogin("","")

        //Then
        assert(loginViewModel.login.value == expectedResult)
    }
}