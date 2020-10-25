package com.necomplus.demo.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.necomplus.demo.R
import com.necomplus.demo.models.Artist
import com.necomplus.demo.models.Track
import kotlinx.android.synthetic.main.item_artist.view.*

class TracksAdapter : RecyclerView.Adapter<TracksAdapter.Viewholder>() {

    var trackList = ArrayList<Track>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TracksAdapter.Viewholder {
        return Viewholder(LayoutInflater.from(parent.context).inflate(R.layout.item_artist,parent, false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: TracksAdapter.Viewholder, position: Int) {
        holder.itemView.apply {
            txtName.text = trackList[position].name
            txtReproductions.text = "Reproducciones: " + trackList[position].listeners
        }
    }

    override fun getItemCount() = trackList.size

    inner class Viewholder(itemView : View) :RecyclerView.ViewHolder(itemView)
}