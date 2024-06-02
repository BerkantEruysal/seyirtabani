package com.merberk.seyirtabani.view.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.merberk.seyirtabani.R
import com.merberk.seyirtabani.databinding.FragmentDetailBinding
import com.merberk.seyirtabani.util.ApplicationViewModelFactory
import com.merberk.seyirtabani.util.downloadURL
import com.merberk.seyirtabani.viewmodel.MainViewModel


class DetailFragment : Fragment() {

    val args: DetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentDetailBinding
    private val viewModel : MainViewModel by viewModels {
        ApplicationViewModelFactory(requireActivity().application)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail,container, false)
        viewModel.findByName(args.show.title.toString())
        initUI()
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun initUI() {
        viewModel.show.observe(viewLifecycleOwner) { show ->
            with(binding) {
                Log.d("asd", " ${show}")
                tvShowName.text = show.title
                showPopularityVal.text = show.popularity.toString()
                showStarAvg.text = String.format("%.1f", show.voteAverage)
                showStarCount.text = "(" +  show.voteCount.toString() + ")"
                showExp.text = show.overview
                Glide.with(showImage)
                    .load("https://image.tmdb.org/t/p/w500/" + show.posterPath)
                    .into(showImage)

            }
        }
    }

}