package com.example.deneme123.ui.settings

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.deneme123.R
import com.example.deneme123.ui.main.MainActivity

class SettingsActivity : AppCompatActivity() {

    private lateinit var switchDarkMode: Switch
    private lateinit var spinnerLanguage: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // View’leri bul
        switchDarkMode = findViewById(R.id.switchDarkMode)
        spinnerLanguage = findViewById(R.id.spinnerLanguage)

        // ———— Dil Spinner’ını doldur (eğer XML’de android:entries kullanmadıysan) ————
        // val languages = resources.getStringArray(R.array.language_options)
        // ArrayAdapter(this, android.R.layout.simple_spinner_item, languages).also { adapter ->
        //     adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        //     spinnerLanguage.adapter = adapter
        // }

        // ———— Dark Mode Switch Listener ————
        switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        // **İsteğe bağlı**: Spinner seçimine bir listener ekleyebilirsin
        // spinnerLanguage.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        //     override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
        //         // position == 0 -> English seçili
        //     }
        //     override fun onNothingSelected(parent: AdapterView<*>) {}
        // }
        val btncikisyap: Button = findViewById(R.id.btnExit)

        btncikisyap.setOnClickListener {
            Toast.makeText(this, "Butona tıkladın!", Toast.LENGTH_SHORT).show()
            // Buraya tıklama sonrası yapılacak işi yazabilirsiniz
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}