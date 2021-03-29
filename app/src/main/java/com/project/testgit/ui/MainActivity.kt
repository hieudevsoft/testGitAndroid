package com.project.testgit.ui

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.project.testgit.data.Quote
import com.project.testgit.databinding.ActivityMainBinding
import com.project.testgit.ultilities.InjectorUltils


class MainActivity : AppCompatActivity() {
    lateinit var _binding: ActivityMainBinding
    private val binding get() = _binding
    private lateinit var factory: QuoteViewModelFactory
    private lateinit var viewModel: QuoteViewModel

    companion object {
        private const val TAG = "MainActivity"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(binding.root)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val windowController = window.insetsController
            windowController?.hide(WindowInsets.Type.statusBars())
            windowController?.hide(WindowInsets.Type.navigationBars())
            windowController?.hide(WindowInsets.Type.captionBar())
            windowController?.hide(WindowInsetsController.BEHAVIOR_SHOW_BARS_BY_SWIPE)
        } else {
            supportActionBar?.hide()
            window.decorView.apply {
                systemUiVisibility =
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
            }
        }
        Log.d(TAG, "onCreate: OnCreate")
        factory = InjectorUltils.provideQuoteViewModelFactory()
        viewModel = ViewModelProvider(this, factory).get(QuoteViewModel::class.java)
        initUi()
    }

    private fun initUi() {
        viewModel.getQuotes().observe(this) { quotes ->
            retrieverData()
        }
        binding.buttonAddQuote.setOnClickListener {
            val quote = Quote(
                binding.editTextQuote.text.toString().trim(),
                binding.editTextAuthor.text.toString()
            )
            viewModel.addQuote(quote)
            binding.editTextAuthor.text.clear()
            binding.editTextQuote.text.clear()
        }
        binding.refreshLayout.setOnRefreshListener {
            viewModel.clearListQuote()
            retrieverData()
        }
    }

    private fun retrieverData() {
        viewModel.getQuotes().observe(this) { quotes ->
            binding.refreshLayout.isRefreshing = false
            val stringBuilder = StringBuilder()
            quotes.forEach {
                stringBuilder.append("$it \n\n")
                Log.d(TAG, "initUi: ${viewModel.getQuotes().value?.size}")
            }
            binding.textViewQuotes.text = stringBuilder
        }
    }

    override fun onStart() {
        supportActionBar?.hide()
        window.decorView.apply {
            systemUiVisibility =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
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

