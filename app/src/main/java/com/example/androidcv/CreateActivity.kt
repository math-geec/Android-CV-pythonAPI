package com.example.androidcv

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create.*

private const val PICK_PHOTO_CODE = 42
class CreateActivity : AppCompatActivity() {
    private var photoUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        btnGallary.setOnClickListener {
            Log.i("btnGallery", "Open up image picker on device")
            val imagePickerIntent = Intent(Intent.ACTION_GET_CONTENT)
            imagePickerIntent.type = "image/*"
            if (imagePickerIntent.resolveActivity(packageManager) != null) {
                startActivityForResult(imagePickerIntent, PICK_PHOTO_CODE)
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // check the result is requested from the right intent
        if (requestCode == PICK_PHOTO_CODE) {
            // check the user has selected an image
            if (resultCode == Activity.RESULT_OK) {
                photoUri = data?.data
                Log.i("btnGallery", "photoUri $photoUri")
                imageView
            } else {
                Toast.makeText(this, "Image seletion canceled.", Toast.LENGTH_SHORT).show()
            }
        }
    }

}