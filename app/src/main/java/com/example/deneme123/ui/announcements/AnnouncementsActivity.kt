package com.example.deneme123.ui.announcements

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.lifecycle.lifecycleScope
import com.example.deneme123.databinding.ActivityAnnouncementsBinding
import com.example.deneme123.network.RetrofitClient
import kotlinx.coroutines.launch

class AnnouncementsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnnouncementsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnnouncementsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // RecyclerView ayarları
        binding.rvAnnouncements.apply {
            layoutManager = LinearLayoutManager(this@AnnouncementsActivity)
        }

        // Verileri çek ve adapter’e yükle
        loadAnnouncements()
    }

    private fun loadAnnouncements() {
        lifecycleScope.launch {
            try {
                val response = RetrofitClient.announcementApi.getAll()
                if (response.isSuccessful) {
                    val list = response.body().orEmpty()
                    binding.rvAnnouncements.adapter = AnnouncementAdapter(list)
                } else {
                    Toast.makeText(
                        this@AnnouncementsActivity,
                        "Yükleme hatası: ${response.code()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } catch (e: Exception) {
                Toast.makeText(
                    this@AnnouncementsActivity,
                    "Sunucuya bağlanılamıyor",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
