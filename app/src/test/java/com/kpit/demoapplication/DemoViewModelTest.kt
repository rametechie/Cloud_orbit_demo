package com.kpit.demoapplication

import com.kpit.demoapplication.viewmodel.DemoViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class DemoViewModelTest {

    private lateinit var viewModel: DemoViewModel

    @Before
    fun setUp() {
        viewModel = DemoViewModel()
    }

    @Test
    fun `initial text should be empty`() = runTest {
        assertEquals("", viewModel.text.first())
    }

    @Test
    fun `onTextChanged updates text`() = runTest {
        viewModel.onTextChanged("hello")
        assertEquals("hello", viewModel.text.first())
    }

    @Test
    fun `initial selected option should be empty`() = runTest {
        assertEquals("", viewModel.selected.first())
    }

    @Test
    fun `onSelectionChanged updates selected option`() = runTest {
        viewModel.onSelectionChanged("Option 2")
        assertEquals("Option 2", viewModel.selected.first())
    }
}