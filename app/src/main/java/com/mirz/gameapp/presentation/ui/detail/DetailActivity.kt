package com.mirz.gameapp.presentation.ui.detail

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_LEGACY
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mirz.gameapp.R
import com.mirz.gameapp.databinding.ActivityDetailBinding
import com.mirz.gameapp.utils.Status
import com.mirz.gameapp.utils.convertStringDate
import com.mirz.gameapp.utils.gone
import com.mirz.gameapp.utils.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }
    private val viewModel: DetailViewModel by viewModels()
    private val id by lazy { intent.getIntExtra(GAME_ID, 0) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.getGame(id)
        observeData()
    }

    private fun observeData() {
        viewModel.resultGame.observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.groupContent.visible()
                    binding.shimmerLayout.gone()
                    it.data?.let { data ->
                        binding.apply {
                            Glide.with(this@DetailActivity)
                                .load(data.image)
                                .placeholder(R.drawable.ic_baseline_image_24)
                                .error(R.drawable.ic_baseline_image_24)
                                .into(ivBanner)
                            tvTitle.text = data.name
                            tvDesc.text = HtmlCompat.fromHtml(data.description, FROM_HTML_MODE_LEGACY)
                            tvRelease.text = data.releaseDate.convertStringDate()
                        }
                    }
                }
                Status.LOADING -> {
                    binding.groupContent.gone()
                    binding.shimmerLayout.visible()
                }
                else -> {
                    binding.groupContent.gone()
                    binding.shimmerLayout.gone()
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    companion object {
        const val GAME_ID = "game_id"
    }
}