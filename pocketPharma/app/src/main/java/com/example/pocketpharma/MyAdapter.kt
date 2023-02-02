package com.example.pocketpharma

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//import android.widget.ListAdapter
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView


class MyAdapter : ListAdapter<Record, MyAdapter.recordViewHolder>(recordComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): recordViewHolder {
        return recordViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: recordViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)


    }

    class recordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        private val recordItemViewId: TextView = itemView.findViewById(R.id.textViewid)
        private val recordItemViewKodLatky: TextView = itemView.findViewById(R.id.textViewKodLatky)
        private val recordItemViewNazevInn: TextView = itemView.findViewById(R.id.textViewNazevInn)
        private val recordItemViewNazevEn: TextView = itemView.findViewById(R.id.textViewNazevEn)
        private val recordItemViewNazev: TextView = itemView.findViewById(R.id.textViewNazev)

        fun bind(text: Record) {
            recordItemViewId.text = text.id_
            recordItemViewKodLatky.text = text.KOD_LATKY
            recordItemViewNazevInn.text = text.NAZEV_INN
            recordItemViewNazevEn.text = text.NAZEV_EN
            recordItemViewNazev.text = text.NAZEV
        }

        companion object {
            fun create(parent: ViewGroup): recordViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return recordViewHolder(view)
            }
        }
    }

    class recordComparator : DiffUtil.ItemCallback<Record>() {
        override fun areItemsTheSame(oldItem: Record, newItem: Record): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Record, newItem: Record): Boolean {
            return oldItem.KOD_LATKY == newItem.KOD_LATKY
        }
    }
}