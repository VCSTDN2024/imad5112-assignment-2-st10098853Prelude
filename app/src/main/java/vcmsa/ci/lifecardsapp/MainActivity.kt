package vcmsa.ci.lifecardsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val welcomeMessage: TextView = findViewById(R.id.welcomeMessage)
        welcomeMessage.text = "Welcome To Life Cards App! "

        val descriptionText: TextView = findViewById(R.id.descriptionText)
        descriptionText.text = "Ace Your Life :-)"

        val nextButton: Button= findViewById(R.id.nextBtn)
        nextButton.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }

        val QuitButton: Button = findViewById(R.id.quitBtn)
        QuitButton.setOnClickListener {
            finish()
        }
    }
}