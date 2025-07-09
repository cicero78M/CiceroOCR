package com.example.ciceroocr

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ciceroocr.camerax.CameraXMLKitActivity
import com.example.ciceroocr.tesseract.TesseractActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<android.widget.Button>(R.id.btn_camerax).setOnClickListener {
            startActivity(Intent(this, CameraXMLKitActivity::class.java))
        }
        findViewById<android.widget.Button>(R.id.btn_tesseract).setOnClickListener {
            startActivity(Intent(this, TesseractActivity::class.java))
        }
    }
}
