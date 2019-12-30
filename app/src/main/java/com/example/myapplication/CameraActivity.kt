package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.core.content.FileProvider
import androidx.loader.app.LoaderManager
import kotlinx.android.synthetic.main.activity_camera.*
import kotlinx.android.synthetic.main.activity_donationacticity.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class CameraActivity : AppCompatActivity() {
    var currentPath: String? = null
    val TAKE_PICTURE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

      Gallerybutton.setOnClickListener {

      }
        camerabutton.setOnClickListener {
            dispatchCameraIntent()

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TAKE_PICTURE && resultCode == Activity.RESULT_OK){
            try {
                val file = File(currentPath)
                val uri = Uri.fromFile(file)
                imageView.setImageURI(uri)

            }catch (e: IOException){
                e.printStackTrace()
            }

    }

    }

    fun dispatchCameraIntent(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intent.resolveActivity(packageManager) != null ) {
            var photoFile: File? = null
            //you must create a content provder matching the authority
            try{
                photoFile = createImage()

            }catch (e: IOException){
                e.printStackTrace()
            }
            if (photoFile !=null){
                var  photoUri = FileProvider.getUriForFile(this,
                    "com.coutocode.camerawxample.fileprovider",photoFile)
                intent.putExtra(MediaStore.EXTRA_OUTPUT,photoUri)
                startActivityForResult(intent,TAKE_PICTURE)
            }

        }
    }
    fun createImage(): File{
        val timestamp = SimpleDateFormat("yyyyyy_yghjjg").format(Date())
        val imageName = "JPEG_"+timestamp+"_"
        var storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        var image = File.createTempFile(imageName,"jpg",storageDir)
        currentPath =image.absolutePath
        return image
    }
}
