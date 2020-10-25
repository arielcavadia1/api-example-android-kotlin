package com.necomplus.demo.main.modules

import com.necomplus.demo.adapters.ArtistAdapter
import com.necomplus.demo.adapters.TracksAdapter
import com.necomplus.demo.main.viewmodels.HomeViewModel
import com.necomplus.demo.main.viewmodels.TracksViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    viewModel{ HomeViewModel() }
    single { ArtistAdapter() }
}

val tracksModule = module {
    viewModel { TracksViewModel() }
    single { TracksAdapter() }
}