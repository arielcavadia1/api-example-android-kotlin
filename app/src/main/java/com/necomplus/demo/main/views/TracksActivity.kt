package com.necomplus.demo.main.views

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.necomplus.demo.R
import com.necomplus.demo.Utils.CustomProgress
import com.necomplus.demo.adapters.ArtistAdapter
import com.necomplus.demo.adapters.TracksAdapter
import com.necomplus.demo.main.viewmodels.TracksViewModel
import kotlinx.android.synthetic.main.activity_tracks.*
import org.koin.android.ext.android.inject

class TracksActivity : AppCompatActivity() {
    private val viewModel : TracksViewModel by inject()
    private val tracksAdapter : TracksAdapter by inject()
    private var mbid = ""
    private var name = ""
    private lateinit var progress : CustomProgress
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracks)
        progress = CustomProgress(this)
        mbid = intent.getStringExtra("mbid")!!
        name = intent.getStringExtra("name")!!
        txtTitle.text = txtTitle.text.toString() + " $name"
        observers()
        viewModel.getTracksFromArtist(mbid)
    }

    fun observers(){
        viewModel.trackList.observe(this,{
            tracksAdapter.trackList = it
            rvTrackList.adapter = tracksAdapter
        })

        viewModel.isLoading.observe(this,{
            if (it) progress.showProgress() else progress.hideProgress()
        })


    }
}