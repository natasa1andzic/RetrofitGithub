package com.natasaandzic.retrofit.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.natasaandzic.retrofit.R
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        loginBtn.setOnClickListener {
            val intent = Intent(this, UserActivity::class.java)
            intent.putExtra("Username", usernameEt.text.toString())
            startActivity(intent)
        }
    }
}
