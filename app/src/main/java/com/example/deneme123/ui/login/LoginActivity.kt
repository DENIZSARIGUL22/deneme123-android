package com.example.deneme123.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.deneme123.R
import com.example.deneme123.model.LoginRequest
import com.example.deneme123.model.LoginResponse
import com.example.deneme123.network.RetrofitClient
import com.example.deneme123.ui.main.MainActivity
import kotlinx.coroutines.launch
import retrofit2.HttpException

class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail   : EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin  : Button
    private lateinit var tvError   : TextView
    private lateinit var tvForgot  : TextView  // “Forgot Password?” metni

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // View’leri bağla
        etEmail    = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin   = findViewById(R.id.btnLogin)
        tvError    = findViewById(R.id.tvErrorMessage)
        tvForgot   = findViewById(R.id.tvForgotPassword)

        // “Forgot Password?” tıklaması
        tvForgot.setOnClickListener {
            startActivity(Intent(this, ResetPasswordActivity::class.java))
        }

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val pass  = etPassword.text.toString()
            tvError.visibility = View.GONE

            // Basit validasyon
            if (email.isEmpty() || pass.isEmpty()) {
                tvError.text = "Email ve şifre boş olamaz"
                tvError.visibility = View.VISIBLE
                return@setOnClickListener
            }

            // API üzerinden giriş yap
            lifecycleScope.launch {
                try {
                    val response = RetrofitClient.authApi.login(
                        LoginRequest(email, pass)
                    )

                    if (response.isSuccessful) {
                        val body: LoginResponse? = response.body()
                        if (body?.success == true) {
                            val token = body.token.orEmpty()

                            // Token’ı SharedPreferences’a kaydet
                            getSharedPreferences("MyAppPrefs", MODE_PRIVATE)
                                .edit()
                                .putString("auth_token", token)
                                .apply()

                            // Dashboard’a geç
                            startActivity(
                                Intent(this@LoginActivity, MainActivity::class.java)
                            )
                            finish()
                        } else {
                            // Sunucudan dönen message alanı varsa göster
                            tvError.text = body?.message ?: "Failed"
                            tvError.visibility = View.VISIBLE
                        }
                    } else {
                        // HTTP hata kodu varsa göster
                        tvError.text = "Giriş başarısız: ${response.code()}"
                        tvError.visibility = View.VISIBLE
                    }
                } catch (e: HttpException) {
                    tvError.text = "Sunucu hatası: ${e.code()}"
                    tvError.visibility = View.VISIBLE
                } catch (e: Exception) {
                    // Ağ bağlantı hatası vb.
                    tvError.text = "Sunucuya bağlanılamıyor"
                    tvError.visibility = View.VISIBLE
                }
            }
        }
    }
}
