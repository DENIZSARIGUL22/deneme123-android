package com.example.deneme123.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.deneme123.R
import com.example.deneme123.ui.results.ResultsActivity
import com.example.deneme123.ui.settings.SettingsActivity
import com.example.deneme123.ui.voting.VotingActivity
import com.example.deneme123.databinding.ActivityMainBinding
import com.example.deneme123.ui.announcements.AnnouncementsActivity
import com.example.deneme123.ui.candidates.CandidateListActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var binding: ActivityMainBinding

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.dashboard)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.abc)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // ADAY LISTESINE YONLENDIRME İŞLEMLERİ
        val btnAdaylariGoster: Button = findViewById(R.id.btnViewCandidates)

        // Tıklama olayını burada yakalıyoruz
        btnAdaylariGoster.setOnClickListener {
            Toast.makeText(this, "Butona tıkladın!", Toast.LENGTH_SHORT).show()
            // Buraya tıklama sonrası yapılacak işi yazabilirsiniz
            val intent = Intent(this, CandidateListActivity::class.java)
            startActivity(intent)
        }


        // OYLAMA SAYFASINA YÖNLENDİRME İŞLEMLERİ

        val btnOylamaSayfasiniGoster: Button = findViewById(R.id.btnVoteNow)

        btnOylamaSayfasiniGoster.setOnClickListener {
            Toast.makeText(this, "Butona tıkladın!", Toast.LENGTH_SHORT).show()
            // Buraya tıklama sonrası yapılacak işi yazabilirsiniz
            val intent = Intent(this, VotingActivity::class.java)
            startActivity(intent)
        }

        //results sayfasina yonlendirme

        val btnSonuclarSayfasiniGoster: Button = findViewById(R.id.btnViewResults)

        btnSonuclarSayfasiniGoster.setOnClickListener {
            Toast.makeText(this, "Butona tıkladın!", Toast.LENGTH_SHORT).show()
            // Buraya tıklama sonrası yapılacak işi yazabilirsiniz
            val intent = Intent(this, ResultsActivity::class.java)
            startActivity(intent)
        }
        //aciklamalari goster

        val btnAciklamalariGoster: Button = findViewById(R.id.btnAnnouncements)

        btnAciklamalariGoster.setOnClickListener {
            Toast.makeText(this, "Butona tıkladın!", Toast.LENGTH_SHORT).show()
            // Buraya tıklama sonrası yapılacak işi yazabilirsiniz
            val intent = Intent(this, AnnouncementsActivity::class.java)
            startActivity(intent)


        }
        //AYARLARA GIT

        val btnAyarlaraGit: ImageButton = findViewById(R.id.btnProfileSettings)

        btnAyarlaraGit.setOnClickListener {
            Toast.makeText(this, "Butona tıkladın!", Toast.LENGTH_SHORT).show()
            // Buraya tıklama sonrası yapılacak işi yazabilirsiniz
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        }
    }

