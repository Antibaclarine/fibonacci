package com.example.memes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Nextpage : AppCompatActivity() {

    lateinit var tvnext: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nextpage)
        tvnext = findViewById(R.id.tvnext)
        tvnext.setOnClickListener {
            val intent = Intent(this, meme3::class.java)
            startActivity(intent)

        }
    }
}