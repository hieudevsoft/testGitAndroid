package com.project.testgit.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class QuoteDao {
    private val quoteList = mutableListOf<Quote>()
    private val quotesObserver = MutableLiveData<List<Quote>>()

    init {
        quotesObserver.value = quoteList
    }

    fun addQuote(quote: Quote){
        quoteList.add(quote)
        quotesObserver.value = quoteList
    }
    fun clearListQuote() = quoteList.clear()
    fun getQuotes() = quotesObserver as LiveData<List<Quote>>
}