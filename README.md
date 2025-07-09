# CiceroOCR

Contoh proyek Android sederhana untuk melakukan OCR menggunakan dua pendekatan populer:

1. **Google ML Kit (on-device)** – contoh implementasi menggunakan CameraX untuk menangkap gambar dan menjalankan OCR langsung di perangkat.
2. **Tesseract (tess-two)** – contoh implementasi memproses bitmap dan menyalin file `traineddata` dari `assets`. Contoh ini membuat gambar berisi teks secara programatis sehingga repository tidak menyertakan aset binari.

Direktori `app/` berisi konfigurasi Gradle serta kode sumber Android. `MainActivity` menyediakan menu menuju dua contoh tersebut.

## Persyaratan
- Android Studio 4.0 atau lebih baru
- Gradle versi 7.0 atau lebih baru
- Minimum SDK 21

## Cara Menjalankan
1. Clone repository dan buka di Android Studio.
2. Pastikan file `eng.traineddata` pada folder `app/src/main/assets` diganti dengan file sebenarnya dari proyek tessdata.
3. Jalankan aplikasi di perangkat atau emulator.
4. Pilih menu "CameraX + ML Kit" untuk mendemokan OCR on-device, atau pilih "Tesseract" untuk contoh menggunakan tess-two.
