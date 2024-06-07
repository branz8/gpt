package com.example.gpt



import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val morningTimes = mutableListOf<Int>()
    private val afternoonTimes = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd.setOnClickListener {
            val morningTime = etMorningTime.text.toString().toIntOrNull()
            val afternoonTime = etAfternoonTime.text.toString().toIntOrNull()

            if (morningTime != null && afternoonTime != null) {
                morningTimes.add(morningTime)
                afternoonTimes.add(afternoonTime)
                etMorningTime.text.clear()
                etAfternoonTime.text.clear()
            } else {
                // Handle error
            }
        }

        btnDetailedView.setOnClickListener {
            val intent = Intent(this, DetailedViewActivity::class.java).apply {
                putExtra("morningTimes", ArrayList(morningTimes))
                putExtra("afternoonTimes", ArrayList(afternoonTimes))
            }
            startActivity(intent)
        }

        btnClear.setOnClickListener {
            morningTimes.clear()
            afternoonTimes.clear()
        }
    }
}
