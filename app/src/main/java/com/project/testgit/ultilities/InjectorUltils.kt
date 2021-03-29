package com.project.testgit.ultilities

import com.project.testgit.data.QuoteDatabase
import com.project.testgit.data.QuoteRepository
import com.project.testgit.ui.QuoteViewModelFactory

object InjectorUltils {
    fun provideQuoteViewModelFactory():QuoteViewModelFactory{
        val quoteRepository = QuoteRepository.getInstance(QuoteDatabase.getInstance().quoteDao)
        return QuoteViewModelFactory(quoteRepository)
    }
}