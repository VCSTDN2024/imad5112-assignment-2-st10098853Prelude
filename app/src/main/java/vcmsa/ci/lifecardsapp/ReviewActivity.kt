package vcmsa.ci.lifecardsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review)

        val reviewTextView = findViewById<TextView>(R.id.reviewTextView)
        val retryButton = findViewById<Button>(R.id.retryBtn)
        val quitButton = findViewById<Button>(R.id.quitBtn)

        //Get the questions array from QuizActivity
        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getByteArrayExtra("answers")

        val reviewText = StringBuilder()
        if (questions != null && answers != null && questions.size == answers.size)
            for (i in questions.indices){
                reviewText.append("${i +1}. ${questions[i]}\n")
                reviewText.append("Answer: ${if (QuizActivity.answers[i])"True" else "False"}\n\n")
            }
        reviewTextView.text = reviewText.toString()

        // Press on click listener for the retry button
        retryButton.setOnClickListener {
            finish()

            //start a new copy of QuizActivity
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }

        // Press click listener for the quit button
        quitButton.setOnClickListener {
            finish()
        }


    }
}