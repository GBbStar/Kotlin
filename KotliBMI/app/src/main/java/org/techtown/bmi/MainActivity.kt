package org.techtown.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val heightEdit:EditText by lazy {
        findViewById<EditText>(R.id.heightEdit)
    }

    val weightEdit:EditText by lazy {
        findViewById<EditText>(R.id.weightEdit)
    }

    val resultButton:Button by lazy {
        findViewById<Button>(R.id.resultButton)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindViews()
    }

    private fun bindViews(){
        resultButton.setOnClickListener {
            if(heightEdit.text.isEmpty() || weightEdit.text.isEmpty()){
                Toast.makeText(this, "값을 입력해주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val height :Int = heightEdit.text.toString().toInt()
            val weight:Int = weightEdit.text.toString().toInt()

            val intent = Intent(this, Result::class.java)

            intent.putExtra("height", height)
            intent.putExtra("weight", weight)

            startActivity(intent)

        }
    }
}