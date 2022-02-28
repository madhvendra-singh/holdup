package com.xbrandapps.holdup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_pick.*

class PickActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick)
        backbtntop.setOnClickListener {
            finish()
        }
        dmemes.setOnClickListener {
            val dankmemes = Intent(this,DankActivity::class.java)
            startActivity(dankmemes)
        }
        dmemes2.setOnClickListener {
            val normmemes = Intent(this,NormActivity::class.java)
            startActivity(normmemes)
        }
        dmemes3.setOnClickListener {
            val random = Intent(this,RandomActivity::class.java)
            startActivity(random)
        }
    }
}