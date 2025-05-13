package com.example.deneme123.ui.voting

import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.deneme123.R
import com.example.deneme123.api.VoteRequest
import com.example.deneme123.network.RetrofitClient
import kotlinx.coroutines.launch

class VotingActivity : AppCompatActivity() {

    private lateinit var rgCandidates: RadioGroup
    private lateinit var btnSubmitVote: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_voting)

        rgCandidates  = findViewById(R.id.rgCandidates)
        btnSubmitVote = findViewById(R.id.btnSubmitVote)

        btnSubmitVote.setOnClickListener {
            val checkedId = rgCandidates.checkedRadioButtonId
            if (checkedId == -1) {
                Toast.makeText(this, "Lütfen bir aday seçin.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // candidateId’yi belirleyin (rbCandidate1 → 1, rbCandidate2 → 2, rbCandidate3 → 3)
            val candidateId = when (checkedId) {
                R.id.rbCandidate1 -> 1
                R.id.rbCandidate2 -> 2
                R.id.rbCandidate3 -> 3
                else -> {
                    Toast.makeText(this, "Geçersiz aday seçimi", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

            // API çağrısını başlat
            lifecycleScope.launch {
                try {
                    val token = getSharedPreferences("MyAppPrefs", MODE_PRIVATE)
                        .getString("auth_token", "") ?: ""

                    val response = RetrofitClient.voteApi.vote(
                        "Bearer $token",
                        VoteRequest(candidateId = candidateId)
                    )

                    if (response.isSuccessful && response.body()?.success == true) {
                        Toast.makeText(
                            this@VotingActivity,
                            "Oy kaydedildi!",
                            Toast.LENGTH_SHORT
                        ).show()
                        finish()
                    } else {
                        Toast.makeText(
                            this@VotingActivity,
                            "Oy kaydedilemedi: ${response.code()}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } catch (e: Exception) {
                    Toast.makeText(
                        this@VotingActivity,
                        "Sunucuya bağlanılamıyor",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}
