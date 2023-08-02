package com.thuctran.testnavigation.view.fragment

import androidx.fragment.app.viewModels
import com.thuctran.sampleprojectforall.viewmodel.CommonVM
import com.thuctran.testnavigation.databinding.FragmentDetailBinding

class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    var TAG: String = SplashFragment::class.java.name
    private val viewModel by viewModels<CommonVM>()     //phải khai báo như thế này thì mới sd được viewmodel trong Flagment


    override fun initViewBinding(): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        //do nothing

    }
}