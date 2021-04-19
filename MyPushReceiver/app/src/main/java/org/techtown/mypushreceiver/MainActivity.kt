package org.techtown.mypushreceiver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {
    private val firebaseToken :TextView by lazy{
        findViewById<TextView>(R.id.firebaseToken)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseMessaging.getInstance().token.addOnCompleteListener {
            task ->
                if (task.isSuccessful){
                    firebaseToken.text = task.result
                }
        }
    }
}