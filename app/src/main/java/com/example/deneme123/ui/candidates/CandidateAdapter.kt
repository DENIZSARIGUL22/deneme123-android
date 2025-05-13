package com.example.deneme123.ui.candidates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.deneme123.R
import com.example.deneme123.model.Candidate

class CandidateAdapter(
    private val onViewProfile: (Candidate) -> Unit,
    private val onVote: (Candidate) -> Unit
) : ListAdapter<Candidate, CandidateAdapter.VH>(DIFF) {

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<Candidate>() {
            override fun areItemsTheSame(a: Candidate, b: Candidate) = a.id == b.id
            override fun areContentsTheSame(a: Candidate, b: Candidate) = a == b
        }
    }

    inner class VH(item: View) : RecyclerView.ViewHolder(item) {
        private val tvName: TextView = item.findViewById(R.id.tvCandidateName)
        private val btnView: Button = item.findViewById(R.id.btnViewProfile)
        private val btnVote: Button = item.findViewById(R.id.btnVote)

        fun bind(c: Candidate) {
            tvName.text = c.name
            btnView.setOnClickListener { onViewProfile(c) }
            btnVote.setOnClickListener { onVote(c) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_candidate, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }
}
