package com.example.diana.finalapplication


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.diana.finalapplication.MainActivity
import com.example.diana.finalapplication.R
import com.example.diana.finalapplication.entity.Contact
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setSupportActionBar(main_toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportActionBar?.setHomeButtonEnabled(true)

        val contact = intent.getSerializableExtra("contact") as ContactModel

        tvName.text = contact.name
        tvMobile.text = contact.mobile
        tvHome.text = contact.home
        tvWork.text = contact.work

        if (contact.imageUrl != "")
            Glide.with(this).load(contact.imageUrl).into(main_backdrop)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            android.R.id.home -> {
                val intent = Intent (this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        return true
    }

}

