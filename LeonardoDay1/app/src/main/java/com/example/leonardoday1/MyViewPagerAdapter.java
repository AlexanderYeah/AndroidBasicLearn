package com.example.leonardoday1;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class MyViewPagerAdapter extends PagerAdapter {

    List<View> views;

    public MyViewPagerAdapter(List<View> views) {
        this.views = views;
    }

    // 获取viewPager 中有多少个view
    @Override
    public int getCount() {
        return views.size();
    }

    // 将给定位置的view 添加到viewGroup 中去，创建并且显示出来
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
         container.addView(views.get(position),0);
        return views.get(position);
    }
    // 判断函数返回的key 与 一个页面视图是否代表的是同一个视图（即它俩是否是对应的，对应的话表示同一个view）
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    // 移除一个给定位置的页面
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(views.get(position));
//        super.destroyItem(container, position, object);

    }
}
