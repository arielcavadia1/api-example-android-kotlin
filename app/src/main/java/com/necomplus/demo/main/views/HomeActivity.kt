package com.necomplus.demo.main.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.necomplus.demo.R
import com.necomplus.demo.Utils.CustomProgress
import com.necomplus.demo.adapters.ArtistAdapter
import com.necomplus.demo.main.viewmodels.HomeViewModel
import com.necomplus.demo.models.Artist
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.custom_progress.*
import org.koin.android.ext.android.inject
import java.util.*
import kotlin.collections.ArrayList

class HomeActivity : AppCompatActivity() {

    private val viewModel : HomeViewModel by inject()
    private val artistAdapter : ArtistAdapter by inject()
    lateinit var progress : CustomProgress
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        observers()
        progress = CustomProgress(this)
        viewModel.getTop10Artist()
    }

    fun observers(){
        viewModel.artistList.observe(this,{
            artistAdapter.artistList = it
            rvArtist.adapter = artistAdapter
        })

        viewModel.isLoading.observe(this,{
            if (it) progress.showProgress() else progress.hideProgress()
        })
    }


}