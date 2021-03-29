package com.project.testgit.data

class QuoteRepository private constructor(val quoteDao: QuoteDao) {

    fun addQuote(quote:Quote) = quoteDao.addQuote(quote)
    fun getQuotes() = quoteDao.getQuotes()
    fun clearListQuote() = quoteDao.clearListQuote()
    companion object{
        @JvmStatic
        @Volatile
        private var Instance:QuoteRepository?=null

        fun getInstance(quoteDao: QuoteDao) = Instance?:
        synchronized(this){
            Instance?: QuoteRepository(quoteDao).also { Instance=it }
        }
    }
}