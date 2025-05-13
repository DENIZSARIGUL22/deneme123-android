package com.example.deneme123.ui.candidates

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.deneme123.R
import com.example.deneme123.model.Candidate
import com.example.deneme123.network.RetrofitClient
import com.example.deneme123.ui.voting.VotingActivity
import kotlinx.coroutines.launch

class CandidateListActivity : AppCompatActivity() {

    private lateinit var rvCandidates: RecyclerView
    private lateinit var progress: ProgressBar
    private lateinit var adapter: CandidateAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Burada artık candidate_list.xml yüklüyoruz
        setContentView(R.layout.candidate_list)

        rvCandidates = findViewById(R.id.rvCandidates)
        progress     = findViewById(R.id.progressCandidates)

        adapter = CandidateAdapter(
            onViewProfile = { candidate ->
                Intent(this, CandidateDetailActivity::class.java).also {
                    it.putExtra("candidate", candidate)
                    startActivity(it)
                }
            },
            onVote = { candidate ->
                Intent(this, VotingActivity::class.java).also {
                    it.putExtra("candidateId", candidate.id)
                    startActivity(it)
                }
            }
        )

        rvCandidates.layoutManager = LinearLayoutManager(this)
        rvCandidates.adapter       = adapter

        loadCandidates()
    }

    private fun loadCandidates() {
        progress.visibility = View.VISIBLE
        lifecycleScope.launch {
            try {
                val resp = RetrofitClient.candidateApi.getAll()
                if (resp.isSuccessful) {
                    val list = resp.body().orEmpty()
                    Toast.makeText(
                        this@CandidateListActivity,
                        "${list.size} aday yüklendi",
                        Toast.LENGTH_SHORT
                    ).show()
                    adapter.submitList(list)
                } else {
                    Toast.makeText(
                        this@CandidateListActivity,
                        "Liste yüklenemedi: ${resp.code()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } catch (e: Exception) {
                Toast.makeText(
                    this@CandidateListActivity,
                    "Ağ hatası: ${e.localizedMessage}",
                    Toast.LENGTH_SHORT
                ).show()
            } finally {
                progress.visibility = View.GONE
            }
        }
    }
}
