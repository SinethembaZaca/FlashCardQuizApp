package vcmsa.ci.flashcardquizapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    private val questions = arrayOf(
        "The Berlin Wall fell in 1989",
        "World War II ended in 1945",
        "NATO was funded to support the communist countries",
        "The phrase 'Black Power' was popularized by Malcolm X",
        "Nelson Mandela became South Africa's first black president in 1994"
    )

    private val answers = arrayOf(true, false, false, true, true)

    private var currentQuestionIndex = 0
    private var score = 0

    private lateinit var questionTextView: TextView
    private lateinit var feedbackTextView: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        Log.d("QuizActivity", "onCreate called")

        questionTextView = findViewById(R.id.questionTextView)
        feedbackTextView = findViewById(R.id.feedbackTextView)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        nextButton = findViewById(R.id.nextButton)

        loadQuestion()

        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        nextButton.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                loadQuestion()
            } else {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("totalQuestions", questions.size)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun loadQuestion() {
        questionTextView.text = questions[currentQuestionIndex]
        feedbackTextView.text = ""
        trueButton.isEnabled = true
        falseButton.isEnabled = true
        nextButton.isEnabled = false

        Log.d("QuizActivity", "Loaded question #$currentQuestionIndex")
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = answers[currentQuestionIndex]

        if (userAnswer == correctAnswer) {
            feedbackTextView.setText(R.string.correct_feedback)
            score++
        } else {
            feedbackTextView.setText(R.string.incorrect_feedback)
        }

        trueButton.isEnabled = false
        falseButton.isEnabled = false
        nextButton.isEnabled = true

        Log.d("QuizActivity", "User answered: $userAnswer, correct: $correctAnswer, score: $score")
    }
}