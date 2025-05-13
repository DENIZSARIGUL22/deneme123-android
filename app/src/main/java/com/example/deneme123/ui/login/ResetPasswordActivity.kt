package com.example.deneme123.ui.login

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.deneme123.R

class ResetPasswordActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etNewPassword: EditText
    private lateinit var btnSubmitReset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        etEmail = findViewById(R.id.etResetEmail)
        etNewPassword = findViewById(R.id.etNewPassword)
        btnSubmitReset = findViewById(R.id.btnSubmitReset)

        btnSubmitReset.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val newPass = etNewPassword.text.toString()

            if (email.isEmpty() || newPass.isEmpty()) {
                Toast.makeText(this, "E-posta ve şifre boş olamaz", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Burada gerçek back-end çağrısı yoksa sadece simüle edelim:
            Toast.makeText(this, "Şifre başarıyla güncellendi", Toast.LENGTH_LONG).show()
            // İstersen finish() ile bir önceki ekrana dönebilirsin:
            finish()
        }
    }
}
