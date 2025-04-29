package vcmsa.ci.lifecardsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)

        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        val feedbackTextView = findViewById<TextView>(R.id.feedbackTextView)
        val reviewButton = findViewById<Button>(R.id.reviewBtn)
        val quitButton = findViewById<Button>(R.id.quitBtn)

        val score = intent.getIntExtra("score", 0)
        val totalQuestions = intent.getIntExtra("totalQuestions", 0)
        val questionsResults = intent.getBooleanArrayExtra("questionsResults")

        scoreTextView.text = "Your Score: $score/$totalQuestions"

        val feedback = if (score >= totalQuestions * 9){
            "Tewww Good! You Aced Your Life!"
        } else if (score >= totalQuestions * 6){
            "You Did Amazing!"
        }else{
            "Next time,SLAY!"
        }
        feedbackTextView.text = feedback.toString()

        reviewButton.setOnClickListener {
            //Set the ReviewActivity and pass the questions and answers
            val intent = Intent(this, ReviewActivity::class.java)
            intent.putExtra("questions", QuizActivity.Companion.questionsList)
            intent.putExtra("answers", QuizActivity.answers)
            startActivity(intent)
        }

        quitButton.setOnClickListener {
            finish()
        }
    }
}






