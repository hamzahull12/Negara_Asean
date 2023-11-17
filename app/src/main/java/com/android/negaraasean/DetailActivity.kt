package com.android.negaraasean

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {
    private lateinit var btnShare: ImageView
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar!!.setDefaultDisplayHomeAsUpEnabled(true)

        btnShare = findViewById(R.id.btn_share)
        var asean = intent.getParcelableExtra<Asean>("key_asean")
        if (asean != null) {
            val image: ImageView = findViewById(R.id.imageView)
            val name: TextView = findViewById(R.id.name_asean)
            val description: TextView = findViewById(R.id.description)

            image.setImageResource(asean.photo)
            name.text = asean.name
            description.text = asean.description

            val message = "${name.text}\\n\\n${description.text}"

            btnShare.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plan"
                intent.putExtra(Intent.EXTRA_TEXT, message)
                val chooser = Intent.createChooser(intent, "Share using...")
                startActivity(chooser)
            }
        }
    }
}