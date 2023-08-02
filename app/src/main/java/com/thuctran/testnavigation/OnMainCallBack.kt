package com.thuctran.testnavigation

interface OnMainCallBack {
    fun callBack(key:String,data:Any?)
    fun showFragment(tag:String,data: Any?,isBacked:Boolean)
    fun closeApp()
}