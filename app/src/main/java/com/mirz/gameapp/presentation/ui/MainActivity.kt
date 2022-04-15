package com.mirz.gameapp.presentation.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.mirz.gameapp.databinding.ActivityMainBinding
import com.mirz.gameapp.presentation.adapter.GameAdapter
import com.mirz.gameapp.presentation.ui.detail.DetailActivity
import com.mirz.gameapp.presentation.ui.detail.DetailActivity.Companion.GAME_ID
import com.mirz.gameapp.utils.Status
import com.mirz.gameapp.utils.gone
import com.mirz.gameapp.utils.isNetworkConnection
import com.mirz.gameapp.utils.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter by lazy {
        GameAdapter {
            startActivity(
                Intent(
                    this,
                    DetailActivity::class.java
                ).putExtra(GAME_ID, it.id)
            )
        }
    }
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initUI()
        observeData()
    }

    private fun initUI() {
        binding.apply {
            rvGame.layoutManager = GridLayoutManager(this@MainActivity, 3)
            rvGame.adapter = adapter
        }
    }

    override fun onResume() {
        super.onResume()
        if (isNetworkConnection())
            viewModel.getGames()
        else
            offlineState()
    }

    private fun offlineState() {
        binding.apply {
            groupContent.gone()
            shimmerLayout.gone()
            groupError.visible()
            btRetry.setOnClickListener {
                viewModel.getGames()
            }
        }
    }


    private fun observeData() {
        viewModel.resultGames.observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.groupContent.visible()
                    binding.shimmerLayout.gone()
                    binding.groupError.gone()
                    it.data?.let { result ->
                        adapter.setItems(result)
                    }
                }
                Status.LOADING -> {
                    binding.groupContent.gone()
                    binding.groupError.gone()
                    binding.shimmerLayout.visible()
                }
                else -> {
                    offlineState()
                }
            }
        }
    }

}