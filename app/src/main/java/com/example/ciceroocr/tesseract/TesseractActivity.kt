package com.example.ciceroocr.tesseract

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ciceroocr.R
import com.googlecode.tesseract.android.TessBaseAPI
import java.io.File
import java.io.FileOutputStream

class TesseractActivity : AppCompatActivity() {
    private lateinit var tess: TessBaseAPI
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tesseract)

        val imageView = findViewById<ImageView>(R.id.imageView)
        textResult = findViewById(R.id.textResult)

        // create a simple bitmap with text instead of loading from resources
        val bitmap = Bitmap.createBitmap(300, 100, Bitmap.Config.ARGB_8888)
        Canvas(bitmap).apply {
            drawColor(Color.WHITE)
            val paint = Paint().apply {
                color = Color.BLACK
                textSize = 48f
                isAntiAlias = true
            }
            drawText("Sample Text", 10f, 60f, paint)
        }
        imageView.setImageBitmap(bitmap)

        // copy traineddata from assets to files directory if needed
        val dataPath = filesDir.absolutePath + "/tesseract/"
        prepareTessData(dataPath)

        tess = TessBaseAPI()
        tess.init(dataPath, "eng")

        findViewById<Button>(R.id.btn_process).setOnClickListener {
            tess.setImage(bitmap)
            textResult.text = tess.utF8Text
        }
    }

    private fun prepareTessData(dataPath: String) {
        val dir = File(dataPath + "tessdata")
        if (!dir.exists()) {
            dir.mkdirs()
        }
        val file = File(dir, "eng.traineddata")
        if (!file.exists()) {
            assets.open("eng.traineddata").use { input ->
                FileOutputStream(file).use { output ->
                    input.copyTo(output)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        tess.end()
    }
}
