package com.thuctran.testnavigation.viewmodel

import androidx.lifecycle.MutableLiveData
import java.lang.Thread.sleep

class SplashViewModel : BaseViewModel() {
    private var thread: Thread? = null
    private var x: Int = 100
    private var loadEvent: MutableLiveData<Boolean> = MutableLiveData(false)
    private var timeData: MutableLiveData<Int> = MutableLiveData(0)

    val LOADEVENT: MutableLiveData<Boolean>
        get() = loadEvent

    val TIMEDATAL: MutableLiveData<Int>
        get() = timeData

    fun startProgressBar() {
        if (thread == null || !thread!!.isAlive) {
            thread = Thread {
                var i: Int = 0
                while (i < x) {
                    sleep(100)
                    timeData.postValue(i)
                    i += 3
                }
                loadEvent.postValue(true)
            }
            thread?.isDaemon = true

            thread?.start()
        }
    }
}