package com.example.bullseye1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.bullseye1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var sliderValue = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root // gives us the parent in this case constraint layout
        setContentView(view)
        binding.targetTextView.text = (0..100).random().toString()
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                sliderValue = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })
        binding.hitMeButton.setOnClickListener {
            Log.i("Button Click Event", "you clicked the hit me button")
            showResult()
        }
    }

    private fun showResult() {
        val dialogTitle = getString(R.string.result_dialog_title)
        val dialogMessage = getString(R.string.result_dialog_message,sliderValue)
//        val dialogMessage = "The slider's value is: $sliderValue"
        val builder = AlertDialog.Builder(this)
            .setTitle(dialogTitle)
            .setMessage(dialogMessage)
            .setPositiveButton(R.string.result_dialog_button_text) { dialog, _ ->
                dialog.dismiss()
            }
        builder.create().show()
    }
}