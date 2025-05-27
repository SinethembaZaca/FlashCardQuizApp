package vcmsa.ci.flashcardquizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("score", 0)

        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        val feedbackTextView = findViewById<TextView>(R.id.feedbackTextView)
        val exitButton = findViewById<Button>(R.id.exitButton)

        val scoreMessage = getString(R.string.score_text, score)
        scoreTextView.text = scoreMessage

        if (score >= 3) {
            feedbackTextView.text = getString(R.string.well_done)
        } else {
            feedbackTextView.text = getString(R.string.play_again)
        }

       val reviewButton = findViewById<button>(R.id.reviewButton)
        reviewButton.setOnClickListener {
            val intent = Intent(this, ReviewActivity::class.java)
            startActivity(Intent(this, ReviewActivity::class.java))
        }

        exitButton.setOnClickListener {
            finishAffinity()
        }
    }
}