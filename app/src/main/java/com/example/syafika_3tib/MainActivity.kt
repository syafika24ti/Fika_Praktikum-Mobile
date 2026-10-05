package com.example.syafika_3tib

import android.content.Intent
import android.icu.lang.UCharacter
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.syafika_3tib.databinding.ActivityLoginBinding
import com.example.syafika_3tib.databinding.ActivityMainBinding
import com.example.syafika_3tib.pertemuan5.LimaActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val user = intent.getStringExtra("Username")
        val pass = intent.getStringExtra("Password")
        val umur = intent.getIntExtra("Umur",0)


        Log.d("Hasil","Umur $umur")
        binding.txtUsername.text = user
        binding.txtPassword.setText(pass)

        binding.btnSnackBar.setOnClickListener {
            Snackbar.make(binding.root, "Item dihapus",
                Snackbar.LENGTH_LONG)
                .setAction("BATAL") {
                    val intent = Intent( this, LoginActivity::class.java)
                    startActivity(intent)
                }
                .show()
        }
        binding.btnAlert.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Hapus data")
                .setMessage("Data yang dihapus tidak " +
                        "bisa dikembalikan.")
                .setNegativeButton("Batal", null)
                .setPositiveButton("Hapus") { dialog, _ ->

                    dialog.dismiss()
                }
                .setCancelable(false)
                .show()


            }
        binding.btnKembali.setOnClickListener {
//            val intent = Intent( this, LoginActivity::class.java)
//            startActivity(intent)
            finish()
        }
        binding.btnLima.setOnClickListener {
            startActivity(Intent( this, LimaActivity::class.java))
        }
    }
}