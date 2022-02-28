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
import kotlinx.android.synthetic.main.activity_dank.*

class DankActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadMeme()

        setContentView(R.layout.activity_dank)
        backdank.setOnClickListener {
            finish()
        }
    }
        private fun loadMeme() {
            val url = "https://meme-api.herokuapp.com/gimme"
            val jsonObjectRequest = JsonObjectRequest(
                Request.Method.GET, url, null,
                Response.Listener { response ->
                    val url = response.getString("url")
                    Glide.with(this).load(url).into(dankmeme)
                },
                Response.ErrorListener {
                    Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show()

                })
            MySingleton.getInstance(this).addToRequestQueue<JsonObjectRequest>(jsonObjectRequest)
        }

    fun NextMeme(view: View) {
        loadMeme()
    }
    fun ShareMeme(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT,"Hi Checkout This Meme From Holdup App")
        val chooser = Intent.createChooser(intent,"Share Meme Using")
        startActivity(chooser)
    }

    fun DownloadMeme(view: View) {
        val request = DownloadManager.Request(Uri.parse("https://i.redd.it/daa514vnssg81.jpg"))
            .setTitle("Meme")
            .setDescription("Download Meme")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setAllowedOverMetered(true)

        val dm = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        dm.enqueue(request)
    }
}
