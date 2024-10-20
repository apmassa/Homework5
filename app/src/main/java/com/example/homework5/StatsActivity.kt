package com.example.homework5

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StatsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)

        val score = intent.getIntExtra("SCORE", 0)

        val totalQuestions = 7
        val percentage = (score.toFloat() / (totalQuestions * 100)) * 100

        val scoreTextView = findViewById<TextView>(R.id.score_text_view)
        scoreTextView.text = "Your Score: ${percentage.toInt()}%"
    }
}
