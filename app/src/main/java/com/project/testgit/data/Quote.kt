package com.project.testgit.data

data class Quote(val quoteText:String?=null,val author:String?=null){
    override fun toString(): String {
        return "$quoteText - $author"
    }
}