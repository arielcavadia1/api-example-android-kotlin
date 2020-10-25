package com.necomplus.demo.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.necomplus.demo.R
import com.necomplus.demo.main.views.TracksActivity
import com.necomplus.demo.models.Artist
import kotlinx.android.synthetic.main.item_artist.view.*

class ArtistAdapter : RecyclerView.Adapter<ArtistAdapter.Viewholder>() {

    var artistList = ArrayList<Artist>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistAdapter.Viewholder {
        return Viewholder(LayoutInflater.from(parent.context).inflate(R.layout.item_artist,parent, false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ArtistAdapter.Viewholder, position: Int) {
        holder.itemView.apply {
            txtName.text = artistList[position].name
            txtReproductions.text = "Reproducciones: " + artistList[position].listeners
        }

        holder.itemView.setOnClickListener {
            holder.itemView.apply {
                val intent = Intent(context,TracksActivity::class.java)
                intent.putExtra("mbid",artistList[position].mbid)
                intent.putExtra("name",artistList[position].name)
                context.startActivity(intent)

            }
        }
    }

    override fun getItemCount() = artistList.size

    inner class Viewholder(itemView : View) :RecyclerView.ViewHolder(itemView)
}