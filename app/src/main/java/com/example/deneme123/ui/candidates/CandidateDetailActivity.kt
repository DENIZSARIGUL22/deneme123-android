package com.example.deneme123.ui.candidates

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.deneme123.R
import com.example.deneme123.model.Candidate

class CandidateDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candidate_detail)

        // Intent ile gelen Candidate objesini al
        val candidate = intent.getSerializableExtra("candidate") as? Candidate
        if (candidate == null) {
            // Data gelmemişse ekrandan çık
            finish()
            return
        }

        // View’leri bul
        val ivPhoto    = findViewById<ImageView>(R.id.imgCandidate)
        val tvName     = findViewById<TextView>(R.id.tvCandidateName)
        val tvBio      = findViewById<TextView>(R.id.tvCandidateBio)
        val tvDetails  = findViewById<TextView>(R.id.tvCandidateDetails)

        // Veriyi ekrana bas
        tvName.text    = candidate.name
        tvBio.text     = candidate.bio
        tvDetails.text = "Department: ${candidate.department}"

        // Eğer fotoğraf URL’iniz varsa Glide/Picasso ile yükleyebilirsiniz:
        // Glide.with(this).load(candidate.photoUrl).into(ivPhoto)
    }
}
