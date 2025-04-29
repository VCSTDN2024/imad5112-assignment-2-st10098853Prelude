package vcmsa.ci.lifecardsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.internal.TextScale

class QuizActivity : AppCompatActivity() {

    private lateinit var quizTextView: TextView
    private lateinit var feedbackTextView: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button


    companion object{
        val questionsList = arrayOf(
            "1.Life is basically 10% what happens to you and 90% how you react to it",
            "2.Best things come to those who wait.",
            "3.Laughter is the best medicine.",
            "4.Morning is the best time of day.",
            "5.The best things in life are free.",
            "6.Money can't buy the four letter word LOVE.",
            "7.Dreams are just random brain activity.",
            "8.You can't please everyone.",
            "9.Life is too short to worry about little things."
        )
        val answers = booleanArrayOf(true,true,true,false,true,true,false,true,true)
        val totalQuestions =questionsList.size
        val questionResults = booleanArrayOf(true,true,true,false,true,true,false,true,true)

    }

    private var currentQuestionIndex = 0
    private var question = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)

        // Initialize Ul elements
        quizTextView = findViewById(R.id.questionsTextView)
        feedbackTextView = findViewById(R.id.feedbackTextView)
        trueButton = findViewById(R.id.trueBtn)
        falseButton= findViewById(R.id.falseBtn)
        nextButton = findViewById(R.id.nextBtn)

        //Display the first question
        displayQuestion()

        //Press on click listener for the answer buttons
        trueButton.setOnClickListener {
            checkAnswer(true)
        }
        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        //function to check the answer
         fun checkAnswer(userAnswer: Boolean){
            val correctAnswer = QuizActivity.answers[currentQuestionIndex]
            if (userAnswer == correctAnswer){
                score++
                feedbackTextView.text = "Correct!"
                feedbackTextView.setTextColor(resources.getColor(R.color.green))
            } else {
                feedbackTextView.text = "Incorrect!"
                feedbackTextView.setTextColor(resources.getColor(R.color.red))
            }
            trueButton.isEnabled = false
            falseButton.isEnabled = true
            nextButton.isEnabled = true
        }

        //Press on click listener for the next button
        nextButton.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex< Companion.questionsList.size){
                displayQuestion()
            } else {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("totalQuestions", Companion.totalQuestions)
                intent.putExtra("questionResults", Companion.questionResults)
                startActivity(intent)
            }
        }

    }
    private fun displayQuestion(){
        quizTextView.text = Companion.questionsList[currentQuestionIndex]
    }

    private fun checkAnswer(userAnswer: Boolean){
        val correctAnswer = answers[currentQuestionIndex]
        if (userAnswer == correctAnswer){
            score++
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT)
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT)
        }
    }
}

data class Question(val text: String, val answer: Boolean)