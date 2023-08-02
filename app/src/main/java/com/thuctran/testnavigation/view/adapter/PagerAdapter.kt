package com.thuctran.testnavigation.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.thuctran.testnavigation.R
import com.thuctran.testnavigation.model.Photo

class PagerAdapter(private var context: Context, private var list:MutableList<Photo>)  : PagerAdapter() {

    //xác định số lượng item cần đúc
    override fun getCount(): Int {
        return list.size
    }

    //ánh xạ item_view vào code và đổ dữ liệu từ data vào
    override fun instantiateItem(viewPager: ViewGroup, position: Int): Any {
        val view:View = LayoutInflater.from(context).inflate(R.layout.activity_home,viewPager,false)
        var data: Photo = list[position]       //lấy data thuộc Model<Any> ở vị trí position
        //ánh xạ từng đối tượng View của layout kia ra và set dữ liệu data cho nó

        viewPager.addView(view)     //set xong dữ liệu rồi thì nhét cái view vừa ánh xạ kia vào viewPager
        return view
    }

    //so sánh 2 view cũ và mới, nếu view mới chiếm tỉ lệ quá 1/2 thì view mới xuất hiện, ngược lại thì giữ nguyên view cũ
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`     //so sánh view mới và view cũ
    }

    //Hủy itemView khi nó ra khỏi màn hình
    override fun destroyItem(viewPager: ViewGroup, position: Int, `object`: Any) {
        viewPager.removeView(`object` as View)      //view out ra khỏi màn hình thì sẽ remove nó
    }

}