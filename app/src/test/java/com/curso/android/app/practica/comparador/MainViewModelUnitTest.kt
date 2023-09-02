package com.curso.android.app.practica.comparador

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.practica.comparador.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {


    private lateinit var viewModel: MainViewModel

    @get: Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()


    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_checkInitialValues() = runTest {
        val text1 = viewModel.comparador.value?.text1
        val text2 = viewModel.comparador.value?.text2

        assertEquals("", text1)
        assertEquals("", text2)
    }

    @Test
    fun mainViewModel_compareText() = runTest {
        launch {
            viewModel.compare("chau", "hola!")
        }

        advanceUntilIdle()

        var result = viewModel.comparador.value?.resultado
        assertEquals("Son distintos", result)

        launch {
            viewModel.compare("Hola!", "Hola!")
        }

        advanceUntilIdle()
        result = viewModel.comparador.value?.resultado
        assertEquals("Son iguales", result)

    }




}