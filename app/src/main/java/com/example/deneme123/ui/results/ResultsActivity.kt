package com.example.deneme123.ui.results

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.deneme123.R
import com.example.deneme123.api.ResultsResponse
import com.example.deneme123.network.RetrofitClient
import kotlinx.coroutines.launch

class ResultsActivity : AppCompatActivity() {

    private lateinit var tvCandidate1: TextView
    private lateinit var tvCandidate2: TextView
    private lateinit var tvCandidate3: TextView
    private lateinit var btnRefresh: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        tvCandidate1 = findViewById(R.id.tvCandidateName1)
        tvCandidate2 = findViewById(R.id.tvCandidateName2)
        tvCandidate3 = findViewById(R.id.tvCandidateName3)
        btnRefresh   = findViewById(R.id.btnRefreshResults)

        // İlk yükleme
        loadResults()

        // Yenile butonu
        btnRefresh.setOnClickListener {
            loadResults()
            Toast.makeText(this, "Results refreshed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadResults() {
        lifecycleScope.launch {
            try {
                val response = RetrofitClient.resultsApi.getResults()
                if (response.isSuccessful) {
                    val list = response.body().orEmpty()
                    // En az üç aday olduğunu varsayıyoruz:
                    if (list.size >= 3) {
                        val r1 = list[0]
                        val r2 = list[1]
                        val r3 = list[2]
                        tvCandidate1.text = "${r1.name}: ${r1.votes} oy"
                        tvCandidate2.text = "${r2.name}: ${r2.votes} oy"
                        tvCandidate3.text = "${r3.name}: ${r3.votes} oy"
                    } else {
                        Toast.makeText(
                            this@ResultsActivity,
                            "Yeterli sonuç yok",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        this@ResultsActivity,
                        "Yükleme hatası: ${response.code()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } catch (e: Exception) {
                Toast.makeText(
                    this@ResultsActivity,
                    "Sunucuya bağlanılamıyor",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
