package com.dicoding.submission.footballnews.ui.team

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.submission.footballnews.R

class TeamActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}