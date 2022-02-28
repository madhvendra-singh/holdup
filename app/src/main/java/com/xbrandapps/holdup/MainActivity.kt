package com.xbrandapps.holdup

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.widget.ImageViewCompat
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.load.ImageHeaderParser
import com.bumptech.glide.request.target.ImageViewTarget
import kotlinx.android.synthetic.main.activity_dank.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Starttext.setOnClickListener {
            val start = Intent(this, PickActivity::class.java)
            startActivity(start)
        }
        creditstext.setOnClickListener {
            val credits = Intent(this,CreditsActivity::class.java)
            startActivity(credits)
        }
        exittext.setOnClickListener {
            System.exit(0)
        }

    }

}