package com.example.expt2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //Declarations
    private lateinit var tvTitle: TextView
    private lateinit var tvSubtitle: TextView
    private lateinit var btnStart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //TypeCasting
        tvTitle = findViewById(R.id.tvTitle)
        tvSubtitle = findViewById(R.id.tvSubtitle)
        btnStart = findViewById(R.id.btnStart)

        //Btn setOnClickListener
        btnStart.setOnClickListener {
            val intent = Intent(this, Expenses::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}