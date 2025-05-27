package vcmsa.ci.flashcardquizapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReviewActivity : AppCompatActivity() {

    private val questions = arrayOf(
        "The Berlin Wall fell in 1989",
        "World War II ended in 1945",
        "NATO was funded to support the communist countries",
        "The phrase 'Black Power' was popularized by Malcolm X",
        "Nelson Mandela became South Africa's first black president in 1994"
    )

    private val answers = arrayOf(
        true,
        true,
        false,
        false,
        true
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        val reviewTextView = findViewById<TextView>(R.id.reviewTextView)
        val reviewContent = StringBuilder()

        for (i in questions.indices) {
            reviewContent.append("${i + 1}. ${questions[i]}\nAnswer: ${if (answers[i]) "True" else "False"}\n\n")
        }

        reviewTextView.text = reviewContent.toString()
    }
}