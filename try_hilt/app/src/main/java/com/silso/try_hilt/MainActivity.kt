package com.silso.try_hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getUserDataByViewModel()
        showUserData()
    }

    private fun getId(): Int {
        return if (input_id_edit.text.isNotEmpty()) {
            input_id_edit.text.toString().toInt()
        } else {
            1
        }
    }

    private fun getUserDataByViewModel() {
        check_id_button.setOnClickListener {
            viewModel.getUserFromServer(getId())
        }
    }

    private fun showUserData() {
        viewModel.post.observe(this, {
            show_content_text.text = it.toString()
        })

        viewModel.errorMessage.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }
}