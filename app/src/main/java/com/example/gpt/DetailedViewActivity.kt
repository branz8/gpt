package com.example.gpt


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detailed_view.*

class DetailedViewActivity : AppCompatActivity() {
    private lateinit var morningTimes: List<Int>
    private lateinit var afternoonTimes: List<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        morningTimes = intent.getIntegerArrayListExtra("morningTimes")!!
        afternoonTimes = intent.getIntegerArrayListExtra("afternoonTimes")!!

        val totalMorning = morningTimes.sum()
        val totalAfternoon = afternoonTimes.sum()
        val total = totalMorning + totalAfternoon
        val average = total / (morningTimes.size + afternoonTimes.size)

        tvDetailedView.text = "Total Morning Time: $totalMorning minutes\n" +
                "Total Afternoon Time: $totalAfternoon minutes\n" +
                "Average Time: $average minutes"

        btnBack.setOnClickListener {
            finish()
        }
    }
}
