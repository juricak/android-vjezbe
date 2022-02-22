package com.example.vjezba

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vjezbaBtn.setOnClickListener {
            val intent = Intent(this, Vjezba2::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()


        val layout = findViewById<ConstraintLayout>(R.id.layout)
        val rnd = Random
        val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        layout.setBackgroundColor(color)
    }
}