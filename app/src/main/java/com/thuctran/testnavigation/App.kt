package com.thuctran.testnavigation

import android.app.Application


class App : Application() {

    private var storage: Storage? = null

    val STORAGE: Storage
        get() = storage!!


    companion object {
        private var instance: App? = null
        val INSTANCE: App
            get() = instance!!

    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        storage = Storage()
    }

    //App.INSTANCE.assets trở tới thư mục asset để sử dụng file dữ liệu
}