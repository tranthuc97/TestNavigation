package com.thuctran.sampleprojectforall.viewmodel

import androidx.lifecycle.ViewModel

class CommonVM : ViewModel() {
    /*
    private var firstName: MutableLiveData<String> = MutableLiveData("")
    private var lastName: MutableLiveData<String> = MutableLiveData("")
    private var isEN: MutableLiveData<Boolean> = MutableLiveData(false)

    //tạo PT để cất giữ liệu
    fun setInfo(firstName: String, lastName: String, isEN: Boolean) {
        this.firstName.postValue(firstName) // 1 cái KDL String, 1 cái KDL MutableLiveData nên phải để là postValue
        this.lastName.postValue(lastName)
        this.isEN.postValue(isEN)

    }

    fun fullNameLD(): MediatorLiveData<String>? {

        //tạo ra thằng MediatorLiverData để gộp chung các dữ liệu thay đổi thành 1 nguồn duy nhất
        var mediator: MediatorLiveData<String> = MediatorLiveData()
        Log.i(TAG,"mediator postValue")
        val handleName: Observer<in Any> = Observer {
            if (isEN.value == false) {
                //postValue chung thành 1 nguồn cho thằng fullNameLD để đẩy sang bên View
                mediator.postValue(firstName.value + " " + lastName.value)  //ở trên đã postValue rồi nên ở đây ta có thể lấy dữ liệu value của từng thằng ra
            } else {
                mediator.postValue(lastName.value + " " + firstName.value)
            }
        }

        //gộp chung vào thằng mediator
            mediator.addSource(firstName, handleName)
            mediator.addSource(lastName, handleName)
            mediator.addSource(isEN, handleName)
            Log.i(TAG,"mediator postValue")
        return mediator
    }*/
}