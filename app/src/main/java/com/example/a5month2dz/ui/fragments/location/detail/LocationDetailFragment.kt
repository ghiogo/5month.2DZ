package com.example.a5month2dz.ui.fragments.location.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.a5month2dz.R
import com.example.a5month2dz.base.BaseFragment
import com.example.a5month2dz.databinding.FragmentDetailLocationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationDetailFragment : BaseFragment<FragmentDetailLocationBinding, LocationDetailViewModel>(R.layout.fragment_detail_location){

    override val binding by viewBinding(FragmentDetailLocationBinding::bind)
    override val viewModel: LocationDetailViewModel by viewModels()
    private val args by navArgs<LocationDetailFragmentArgs>()

    override fun setupObserver() {
        viewModel.fetchOneLocation(args.id).observe(viewLifecycleOwner) {
            binding.locationDetailDimension.text = it.dimension
            binding.locationDetailCreated.text = it.created
        }
    }
}