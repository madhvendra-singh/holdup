package com.xbrandapps.holdup

import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_norm.*
import kotlinx.android.synthetic.main.activity_random.*

class RandomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadRandomMeme()

        setContentView(R.layout.activity_random)
        backrandom.setOnClickListener {
            finish()
        }

    }
    private fun loadRandomMeme() {
        val url3 = "https://meme-api.herokuapp.com/gimme"
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url3, null,
            Response.Listener { response ->
                val url4 = response.getString("url")
                Glide.with(this).load(url4).into(randommemes)
            },
            Response.ErrorListener {
                Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show()

            })
        MySingleton.getInstance(this).addToRequestQueue<JsonObjectRequest>(jsonObjectRequest)
    }

    fun NextButton3(view: View) {
        loadRandomMeme()
    }
    fun ShareButton3(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT,"Hi Checkout This Meme From Holdup App")
        val chooser = Intent.createChooser(intent,"Share Meme Using")
        startActivity(chooser)
    }

    fun DownloadMeme3(view: View) {
        val request = DownloadManager.Request(Uri.parse("https://i.redd.it/daa514vnssg81.jpg"))
            .setTitle("Meme")
            .setDescription("Download Meme")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setAllowedOverMetered(true)

        val dm = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        dm.enqueue(request)
    }
}