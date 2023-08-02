package com.thuctran.testnavigation.view.activity

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.R
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.thuctran.testnavigation.OnMainCallBack
import com.thuctran.testnavigation.view.fragment.BaseFragment
import java.lang.Exception
import java.lang.reflect.Constructor

abstract class BaseAct<V : ViewBinding, M : ViewModel> : AppCompatActivity(), OnClickListener,
    OnMainCallBack {
    protected var binding: V? = null
    protected var viewModel: M? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = initViewBinding()
        setContentView(binding!!.root)
        viewModel = ViewModelProvider(this).get(getClassVM()::class.java)

        initViews()
    }

    abstract fun getClassVM(): M

    abstract fun initViewBinding(): V

    abstract fun initViews()

    final override fun onClick(v: View?) {
        v!!.startAnimation(AnimationUtils.loadAnimation(this, R.anim.abc_fade_in))
        clickView(v)
    }

    protected fun clickView(v: View) {
        //do sothing
    }

    protected fun showNotify(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    protected fun showNotify(msg: Int) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showFragment(tag: String, data: Any?, isBacked: Boolean) {
        try {
            var clazz: Class<*> = Class.forName(tag)        //trỏ vào một fragment class thông qua tag truyền vào
            var constructor: Constructor<*> = clazz.getConstructor()        //tạo Constructor
            var baseFragment: BaseFragment<*> = constructor.newInstance() as BaseFragment<*>        //Tạo 1 thực thể từ lớp Fragment

            baseFragment.CALLBACK = this
            baseFragment.DATA = data!!

            var trans: FragmentTransaction = supportFragmentManager.beginTransaction()
                .replace(com.thuctran.testnavigation.R.id.ln_mainAct, baseFragment, tag)

            if (isBacked) {
                trans.addToBackStack(null)      //trở về màn hình trước đó, true thì có cho phép back
            }
            trans.commit()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}