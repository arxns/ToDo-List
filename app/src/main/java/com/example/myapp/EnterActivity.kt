package com.example.myapp
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
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
        // Устанавливаем статус-бар прозрачным
        window.statusBarColor = android.graphics.Color.TRANSPARENT

        // Включаем режим полной поверхности (если необходимо)
        ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { view, insets ->
            val params = view.layoutParams as? ViewGroup.MarginLayoutParams
            if (params != null) {
                params.topMargin = insets.systemWindowInsetTop
                view.layoutParams = params
            }
            insets
        }
    }
}