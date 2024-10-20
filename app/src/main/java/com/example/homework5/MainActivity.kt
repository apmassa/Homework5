package com.example.homework5

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var score = 0
    private var currentQuestionIndex = 0

    private val questions = arrayOf(
        "Who created Tesla?",
        "What color is the sky?",
        "What holiday is on December 25th?",
        "Who was the president in 2010?",
        "How many inches are in a foot?",
        "How many states are there in the USA?",
        "How many months are there in 1 year?"
    )

    private val options = arrayOf(
        arrayOf("Steve Jobs", "Elon Musk", "Jeff Bezos", "Bill Gates"),
        arrayOf("Green", "Blue", "Red", "Yellow"),
        arrayOf("Halloween", "Thanksgiving", "Christmas", "Easter"),
        arrayOf("George Bush", "Barack Obama", "Donald Trump", "Bill Clinton"),
        arrayOf("10", "11", "12", "13"),
        arrayOf("48", "49", "50", "51"),
        arrayOf("10", "11", "12", "13")
    )

    private val correctAnswers = arrayOf(
        "Elon Musk",
        "Blue",
        "Christmas",
        "Barack Obama",
        "12",
        "50",
        "12"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showQuestion()

        val confirmButton = findViewById<Button>(R.id.confirm_button)
        confirmButton.setOnClickListener {
            checkAnswer()
        }
    }

    private fun showQuestion() {
        val questionText = findViewById<TextView>(R.id.question_text)
        val radioGroup = findViewById<RadioGroup>(R.id.radio_group)

        questionText.text = questions[currentQuestionIndex]

        val radioButton1 = findViewById<RadioButton>(R.id.radio_button_1)
        val radioButton2 = findViewById<RadioButton>(R.id.radio_button_2)
        val radioButton3 = findViewById<RadioButton>(R.id.radio_button_3)
        val radioButton4 = findViewById<RadioButton>(R.id.radio_button_4)

        radioButton1.text = options[currentQuestionIndex][0]
        radioButton2.text = options[currentQuestionIndex][1]
        radioButton3.text = options[currentQuestionIndex][2]
        radioButton4.text = options[currentQuestionIndex][3]

        radioGroup.clearCheck()
    }

    private fun checkAnswer() {
        val radioGroup = findViewById<RadioGroup>(R.id.radio_group)
        val selectedButton = findViewById<RadioButton>(radioGroup.checkedRadioButtonId)

        if (selectedButton != null) {
            val answer = selectedButton.text.toString()

            if (answer == correctAnswers[currentQuestionIndex]) {
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
                score += 100
            } else {
                Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
            }


            if (currentQuestionIndex < questions.size - 1) {
                currentQuestionIndex++
                showQuestion()
            } else {

                val intent = Intent(this@MainActivity, StatsActivity::class.java)
                intent.putExtra("SCORE", score)
                startActivity(intent)
                finish()
            }
        } else {
            Toast.makeText(this, "Please select an answer!", Toast.LENGTH_SHORT).show()
        }
    }
}
