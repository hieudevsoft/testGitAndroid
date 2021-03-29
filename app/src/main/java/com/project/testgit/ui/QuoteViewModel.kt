package com.project.testgit.ui

import androidx.lifecycle.ViewModel
import com.project.testgit.data.Quote
import com.project.testgit.data.QuoteRepository

class QuoteViewModel(private val quoteRepository: QuoteRepository):ViewModel() {

    fun addQuote(quote:Quote) = quoteRepository.addQuote(quote)
    fun getQuotes() = quoteRepository.getQuotes()
    fun clearListQuote() = quoteRepository.clearListQuote()
}