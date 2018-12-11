package com.example.diana.finalapplication

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.item.*
import org.koin.android.ext.android.inject

class AddActivity : AppCompatActivity(), AddActivity.View {

    override val presenter: AddActivity.Presenter by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        addButton.setOnClickListener {
            addContact (tvName.text.toString(),
                    tvMobile.text.toString(),
                    tvHome.text.toString() ,
                    tvWork.text.toString())
        }

        presenter.attachView(this)
    }

    private fun addContact(name: String, mobile: String, home: String, work: String) {
        presenter.addContact(name, mobile, home, work)
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onSuccess(contact : ContactModel) {
        val returnIntent = Intent()
        returnIntent.putExtra("news", contact)
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
    }

    override fun onError() {
        val returnIntent = Intent()
        setResult(Activity.RESULT_CANCELED, returnIntent)
        finish()
    }
}
