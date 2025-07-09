# CiceroOCR

Repository ini berisi contoh sederhana setup proyek Android untuk melakukan Optical Character Recognition (OCR) menggunakan dua pendekatan populer:

1. **Google ML Kit (on-device)** - Solusi OCR dari Google yang berjalan langsung di perangkat tanpa memerlukan koneksi internet.
2. **Tesseract (tess-two)** - Library OCR open-source yang dapat diintegrasikan ke aplikasi Android melalui proyek tess-two.

## Persyaratan
- Android Studio 4.0 atau lebih baru
- Gradle versi 7.0 atau lebih baru
- Minimum SDK 21

## Langkah-langkah umum
1. **Buat proyek Android baru** di Android Studio.
2. **Tambahkan dependensi** sesuai metode yang dipilih (atau keduanya):
   - Google ML Kit: tambahkan dependency `com.google.mlkit:text-recognition:16.0.0` (atau versi terbaru) di file `build.gradle` modul app.
   - Tesseract: tambahkan dependency `org.jetbrains.tess-two:tess-two:9.1.0` (atau versi terbaru) di file `build.gradle` modul app.
3. **Konfigurasi izin** jika diperlukan (contoh akses kamera atau penyimpanan).
4. **Implementasi kode** untuk memuat gambar dan memprosesnya dengan OCR.

## Contoh kode singkat
### Google ML Kit (on-device)
```kotlin
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.TextRecognizerOptions

val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
val image = InputImage.fromBitmap(bitmap, 0)
recognizer.process(image)
    .addOnSuccessListener { visionText ->
        // Gunakan visionText.text
    }
    .addOnFailureListener { e ->
        // Tangani error
    }
```

### Tesseract (tess-two)
```kotlin
import com.googlecode.tesseract.android.TessBaseAPI

val tess = TessBaseAPI()
val datapath = filesDir.absolutePath + "/tesseract/"
val language = "eng" // Sesuaikan bahasa

// Pastikan file training data (eng.traineddata) sudah ada di datapath + "tessdata"
tess.init(datapath, language)
tess.setImage(bitmap)
val resultText = tess.utF8Text
```

## Tips tambahan
- Untuk tess-two, Anda perlu menempatkan file *traineddata* di folder `tessdata` di direktori internal aplikasi.
- Google ML Kit cenderung lebih mudah digunakan dan tidak memerlukan file eksternal.
- Keduanya dapat dikombinasikan sesuai kebutuhan performa atau akurasi.

