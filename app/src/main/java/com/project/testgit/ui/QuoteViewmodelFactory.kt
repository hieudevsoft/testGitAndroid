package com.project.testgit.ui

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.testgit.data.QuoteRepository
import kotlin.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class QuoteViewModelFactory(private val quoteRepository: QuoteRepository):
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(QuoteViewModel::class.java)) return QuoteViewModel(quoteRepository) as T
        throw IllegalArgumentException("Not found QuoteViewModel")
    }
}
