package com.example.deneme123.ui.announcements

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.deneme123.databinding.ItemAnnouncementBinding
import com.example.deneme123.model.Announcement

class AnnouncementAdapter(
    private val items: List<Announcement>
) : RecyclerView.Adapter<AnnouncementAdapter.VH>() {

    inner class VH(private val b: ItemAnnouncementBinding) :
        RecyclerView.ViewHolder(b.root) {
        fun bind(a: Announcement) {
            // Burada xml'de tanımlı olan tvAnnouncementItem ID'sini kullanıyoruz
            b.tvAnnouncementItem.text = a.message
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemAnnouncementBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
