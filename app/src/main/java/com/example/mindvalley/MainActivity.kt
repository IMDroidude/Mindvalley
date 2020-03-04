package com.example.mindvalley

import android.os.Bundle
import com.example.mindvalley.common.BaseActivity
import com.example.mindvalley.databinding.ActivityMainBinding
import com.example.mindvalley.viewmodels.MainActivityViewModel

class MainActivity : BaseActivity<MainActivityViewModel, ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewModel.fetchCategories()
        //mViewModel.fetchEpisode()
        ///mViewModel.fetchChannels()
    }

    override val layoutId: Int = R.layout.activity_main
}
