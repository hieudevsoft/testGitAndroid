package com.project.testgit.data

import com.project.testgit.RxJava


class QuoteDatabase private constructor() {
    val quoteDao = QuoteDao()
    companion object{
        @JvmStatic
        @Volatile
        private var Instance:QuoteDatabase?=null

        fun getInstance() = Instance?:
        synchronized(this){
            Instance?:QuoteDatabase().also { Instance=it }
        }
    }
}