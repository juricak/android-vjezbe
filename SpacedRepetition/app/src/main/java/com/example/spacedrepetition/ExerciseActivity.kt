package com.example.spacedrepetition

import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import java.io.*
import kotlin.random.Random


class ExerciseActivity : AppCompatActivity() {

    private val filepath = "MyFileStorage"
    internal var myExternalFile: File?=null
    private val isExternalStorageReadOnly: Boolean get() {
        val extStorageState = Environment.getExternalStorageState()
        return if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            true
        } else {
            false
        }
    }
    private val isExternalStorageAvailable: Boolean get() {
        val extStorageState = Environment.getExternalStorageState()
        return if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            true
        } else{
            false
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {




        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)

        val fileName = findViewById(R.id.editTextFile) as EditText
        val fileData = findViewById(R.id.editTextData) as EditText
        val saveButton = findViewById<Button>(R.id.button_save) as Button
        val viewButton = findViewById(R.id.button_view) as Button

        saveButton.setOnClickListener(View.OnClickListener {
            myExternalFile = File(getExternalFilesDir(filepath), fileName.text.toString())
            try {
                val fileOutPutStream = FileOutputStream(myExternalFile)
                fileOutPutStream.write(fileData.text.toString().toByteArray())
                fileOutPutStream.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            Toast.makeText(applicationContext,"data save",Toast.LENGTH_SHORT).show()
        })

        viewButton.setOnClickListener(View.OnClickListener {
            myExternalFile = File(getExternalFilesDir(filepath), fileName.text.toString())

            val filename = fileName.text.toString()
            myExternalFile = File(getExternalFilesDir(filepath),filename)
            if(filename.toString()!=null && filename.toString().trim()!=""){
                var fileInputStream = FileInputStream(myExternalFile)
                var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
                val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
                val stringBuilder: StringBuilder = StringBuilder()
                var text: String? = null
                while ({ text = bufferedReader.readLine(); text }() != null) {
                    stringBuilder.append(text)
                }
                fileInputStream.close()
                //Displaying data on EditText
                Toast.makeText(applicationContext,stringBuilder.toString(),Toast.LENGTH_SHORT).show()
            }
        })
        if (!isExternalStorageAvailable || isExternalStorageReadOnly) {
            saveButton.isEnabled = false
        }


        val actionBar = supportActionBar

        actionBar!!.title = "Excercise"

        actionBar.setDisplayHomeAsUpEnabled(true)


        }



    override fun onResume() {
        super.onResume()

        val layout = findViewById<ConstraintLayout>(R.id.layout)
        val rnd = Random
        val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        layout.setBackgroundColor(color)
    }

    fun openVideo(view: View) {
        val video = Uri.parse("https://www.youtube.com/watch?v=agUaHwxcXHY")
        val webIntent =  Intent(Intent.ACTION_VIEW, video)

        val activities: List<ResolveInfo> = packageManager.queryIntentActivities(intent,PackageManager.MATCH_DEFAULT_ONLY)
        val isIntentSafe: Boolean = activities.isNotEmpty()

        if(isIntentSafe) {
            startActivity(webIntent)
        }
    }
}


