package com.nikak.linadom.testsubject2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        sign_out_btn.setOnClickListener{
          val  intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
