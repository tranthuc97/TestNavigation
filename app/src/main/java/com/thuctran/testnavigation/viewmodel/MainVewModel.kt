package com.thuctran.testnavigation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.thuctran.testnavigation.model.Photo
import com.thuctran.testnavigation.model.Topic
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import org.w3c.dom.Document
import org.w3c.dom.Element

class MainVewModel : BaseViewModel() {

    private val TAG: String = MainVewModel::class.java.name
    private val LINK: String = "https://unsplash.com/fr/s/photos/cat"
    private var thread:Thread? = null
    private var banner:Topic? = null      //danh sách banners
     var loadBannerEvent:MutableLiveData<Boolean> = MutableLiveData(false)      //tạo ra thằng này để thông báo load ảnh xong rồi

    val BANNER:Topic?
        get() = banner

    fun parseHTTP(){
        if(thread==null || !thread!!.isAlive){
            try {
                thread = Thread {
                    var doc:org.jsoup.nodes.Document = Jsoup.connect(LINK).get()    //đọc tài liệu theo link, sử dụng thằng Jsoup
                    var items:Elements = doc.getElementsByTag("figure")     //lấy dữ liệu/yêu tố (Elements) theo tên thẻ tag "figure"
                    var photos:MutableList<Photo> = mutableListOf()      //danh sách ảnh (Photo)

                    for (item in items){
                        //lây ảnh theo thẻ tag
                        var img:String = item.getElementsByTag("img").attr("src")      //attr: Giá trị của thuộc tính từ phần tử được khớp đầu tiên có thuộc tính. Nếu không có phần tử nào được khớp (isEmpty() == true) hoặc nếu không có phần tử nào có thuộc tính, thì trả về chuỗi trống.
                        // src = link ảnh (trên web)
                        if (img.contains("profile")) continue           //trong vòng lặp, nếu img chứa "profile" thì bỏ qua vì đây là ảnh lỗi
                        Log.i(TAG, "IMG-Link: $img")
                        photos.add(Photo(img))       //add ảnh vào danh sách Photo
                    }
                    banner = Topic("Banner",photos)     //banner
                    loadBannerEvent.postValue(true)
                }
            }catch (e:Exception){
                loadBannerEvent.postValue(false)
                e.printStackTrace()         //khai báo try catch trể tránh ngoại lệ khi chơi Thread
            }
            thread?.isDaemon = true     //chương trình kết thúc thì thread kết thúc theo
            thread?.start()
        }
    }
}