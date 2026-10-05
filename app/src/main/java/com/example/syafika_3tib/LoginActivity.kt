package com.example.syafika_3tib

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.syafika_3tib.databinding.ActivityLoginBinding
import kotlin.math.log

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        val tombolLogin : Button = findViewById(R.id.btnLogin)
//        val username : EditText = findViewById(R.id.edtUsername)
//        val password : EditText = findViewById(R.id.edtPassword)

        binding.btnLogin.setOnClickListener {
            val user = binding.edtUsername.text.toString()
            val pass = binding.edtPassword.text.toString()


            Log.e("Hasil", "Username $user Password $pass")

            Toast.makeText(this, "Username $user Password $pass", Toast.LENGTH_LONG).show()

            val intent = Intent( this,  MainActivity::class.java)
            intent.putExtra("Username", user)
            intent.putExtra("Password", pass)
            intent.putExtra("Umur", 20)
            startActivity(intent)
        }

    }
}