package com.thuctran.testnavigation.view.fragment

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.thuctran.testnavigation.R
import com.thuctran.testnavigation.databinding.FragmentSplashBinding
import com.thuctran.testnavigation.viewmodel.SplashViewModel


class SplashFragment : BaseFragment<FragmentSplashBinding>() {
    var TAG: String = SplashFragment::class.java.name
    private val viewModel by viewModels<SplashViewModel>()     //phải khai báo như thế này thì mới sd được viewmodel trong Flagment


    override fun initViewBinding(): FragmentSplashBinding {
        return FragmentSplashBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        //2s sau chạy sang MainFragment
        //android.os.Handler().postDelayed({
        //            goToHomeScreen()
        //        },2000)
        binding?.prSplash?.max = 100

        viewModel.startProgressBar()
        viewModel.TIMEDATAL.observe(this) {
            binding!!.prSplash.progress = it
            Log.i(TAG, "progressBar run: $it")
            viewModel.LOADEVENT.observe(this) { lv ->
                if (lv == true) {
                    Log.i(TAG,"xong chưa? $lv")
                    goToHomeScreen()
                }
            }
        }


    }

    private fun goToHomeScreen() {
        //NavHostFragment.findNavController(this)
        //            .navigate(com.thuctran.testnavigation.R.id.toHome)    //trỏ tới id của thằng action toHome tạo ở nav_graph

        //cả cái đoạn dưới này thay thế cái đoạn trên bị lỗi khi gọi tới action toHome :3 :3 :3 :3, méo hiểu sao chạy, chẹo
        fun Fragment.findNavControllerSafely(id: Int): NavController? {
            return if (findNavController().currentDestination?.id == id) {
                findNavController()
            } else {
                null
            }
        }

        findNavControllerSafely(R.id.splashFragment)?.navigate(
            R.id.toHome, null)
    }
}