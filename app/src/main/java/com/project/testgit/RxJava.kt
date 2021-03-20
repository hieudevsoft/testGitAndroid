package com.project.testgit

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class RxJava private constructor() {
    private val TAG = "MainActivity"
    object Holder{
        val instance = RxJava()
    }
    companion object{
        val instance : RxJava by lazy { Holder.instance }
    }
    fun just(listItem:MutableList<Int>){
        val observable = Observable.just(listItem)
        val observer = object : Observer<List<Int>>{
            override fun onSubscribe(d: Disposable?) {
                Log.d(TAG, "onSubscribe: onSubscribe")
            }

            override fun onNext(t: List<Int>?) {
                TODO("Not yet implemented")
            }

            override fun onError(e: Throwable?) {
                TODO("Not yet implemented")
            }

            override fun onComplete() {
                TODO("Not yet implemented")
            }

        }

        observable.subscribe(observer)
    }
}