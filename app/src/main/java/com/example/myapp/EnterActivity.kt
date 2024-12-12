package com.example.myapp
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.*

class EnterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter)

        CoroutineScope(Dispatchers.Main).launch {
            delay(5000)
            val intent = Intent(this@EnterActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}