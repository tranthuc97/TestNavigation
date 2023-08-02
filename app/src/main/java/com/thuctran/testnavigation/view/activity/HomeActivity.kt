package com.thuctran.testnavigation.view.activity

import android.util.Log
import com.thuctran.sampleprojectforall.viewmodel.CommonVM
import com.thuctran.testnavigation.databinding.ActivityHomeBinding
import com.thuctran.testnavigation.view.fragment.SplashFragment
import com.thuctran.testnavigation.view.activity.BaseAct
import com.thuctran.testnavigation.view.fragment.HomeFragment
import com.thuctran.testnavigation.viewmodel.MainVewModel

class HomeActivity : BaseAct<ActivityHomeBinding, MainVewModel>() {
    private val TAG: String = HomeActivity::class.java.name

    override fun getClassVM(): MainVewModel {
        return MainVewModel()
    }

    override fun initViewBinding(): ActivityHomeBinding {
        return ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        //showFragment(SplashFragment().TAG,null,false)       //show splash lên trước

        //viewModel?.loadBannerEvent?.observe(this){
        //            Log.i(TAG,"load banner: ... $it")
        //        }


    }

    override fun callBack(key: String, data: Any?) {
        //do something
    }

    override fun closeApp() {
        //do something
    }
}