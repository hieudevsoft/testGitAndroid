package com.project.testgit

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


//Change 1 commit

class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "MainActivity"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.R){
            val windowController = window.insetsController
            windowController?.hide(WindowInsets.Type.statusBars())
            windowController?.hide(WindowInsets.Type.navigationBars())
            windowController?.hide(WindowInsets.Type.captionBar())
            windowController?.hide(WindowInsetsController.BEHAVIOR_SHOW_BARS_BY_SWIPE)
        }else
        {
            supportActionBar?.hide()
            window.decorView.apply {
                systemUiVisibility  =  View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
            }
        }
        findViewById<EditText>(R.id.testText).addTextChangedListener(
            object : TextWatcher{
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                      window.decorView.systemUiVisibility =
                                         (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                         or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                         or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                         or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                         or View.SYSTEM_UI_FLAG_FULLSCREEN
                                         or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
                }

                override fun afterTextChanged(s: Editable?) {

                }

            }
        )
        Log.d(TAG, "onCreate: OnCreate")
    }

    override fun onStart() {
        supportActionBar?.hide()
        window.decorView.apply {
            systemUiVisibility  =  View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }
        super.onStart()
        Log.d(TAG, "onStart: OnStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: onDestroy")
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && hasFocus) {
            window.decorView.apply {
                systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
            }
        }
    }
}

