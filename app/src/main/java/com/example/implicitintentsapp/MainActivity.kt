package com.example.implicitintentsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val urlEditText = findViewById<EditText>(R.id.urlEditText)
        val phoneEditText = findViewById<EditText>(R.id.phoneEditText)
        val launchButton = findViewById<Button>(R.id.launchButton)
        val ringButton = findViewById<Button>(R.id.ringButton)
        val closeAppButton = findViewById<Button>(R.id.closeAppButton)

        // Open URL in browser
        launchButton.setOnClickListener {
            val url = urlEditText.text.toString()
            if (url.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            } else {
                Toast.makeText(this, "Enter a valid URL", Toast.LENGTH_SHORT).show()
            }
        }

        // Make a phone call
        ringButton.setOnClickListener {
            val phoneNumber = phoneEditText.text.toString()
            if (phoneNumber.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:$phoneNumber")
                startActivity(intent)
            } else {
                Toast.makeText(this, "Enter a valid phone number", Toast.LENGTH_SHORT).show()
            }
        }

        // Close the app
        closeAppButton.setOnClickListener {
            finish()
        }
    }
}
