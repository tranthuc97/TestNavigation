package com.thuctran.testnavigation.view.fragment

import android.os.Handler
import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.thuctran.testnavigation.R
import com.thuctran.testnavigation.databinding.FragmentHomeBinding
import com.thuctran.testnavigation.viewmodel.MainVewModel
import com.thuctran.testnavigation.viewmodel.MochiModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(){
    val TAG: String = HomeFragment::class.java.name
    private val viewModel by viewModels<MochiModel>()     //phải khai báo như thế này thì mới sd được viewmodel trong Flagment

    override fun initViewBinding(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        Handler().postDelayed({
            NavHostFragment.findNavController(this).navigate(R.id.toDetail)
        },2000)
        initEvents()
    }

    private fun initEvents() {
        viewModel.parseHTTPMochi()       //gọi cả thằng này nếu ko MainVewModel sẽ được hiểu là sử dụng ở nơi khác
        viewModel.loadBannerEvent.observe(this){
            Log.i(TAG,"initViews ... load banner: $it")
        }
    }
}