package com.example.demojetpack.ui.screen.home

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.demojetpack.R
import com.example.demojetpack.databinding.FragmentHomeBinding
import com.example.demojetpack.ui.base.BaseFragment
import com.example.demojetpack.ui.screen.home.adapter.UnplashPhotoAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(
            this,
            HomeViewModel.Factory(requireActivity().application)
        )[HomeViewModel::class.java]
    }

    private val photoAdapter: UnplashPhotoAdapter by lazy {
        UnplashPhotoAdapter()
    }

    override fun getLayoutID() = R.layout.fragment_home

    override fun initView() {
        binding!!.rcImage.apply {
            setHasFixedSize(true)
            adapter = photoAdapter
        }
    }

    override fun initViewModel() {
        lifecycleScope.launch {
            viewModel.getPhotos().collectLatest {
                photoAdapter.submitData(it)
            }
        }
    }
}