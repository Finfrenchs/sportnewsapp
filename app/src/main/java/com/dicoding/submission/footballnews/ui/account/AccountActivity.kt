package com.dicoding.submission.footballnews.ui.account

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.submission.footballnews.R

class AccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}