package com.example.leonardoday1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private List<Bean> datas;

    public MyAdapter(Context context, List<Bean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        // Tag从本质上来讲是就是相关联的view的额外的信息。它们经常用来存储一些view的数据，这样做非常方便而不用存入另外的单独结构。
        // 用View中的setTag(Onbect)给View添加1个格外的数据，再用getTag()获得到对应的View。
        if (view == null){
            view =  LayoutInflater.from(context).inflate(R.layout.list_item,viewGroup,false);
            viewHolder = new ViewHolder();
            viewHolder.textView =  view.findViewById(R.id.tv);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
//        TextView tv = view.findViewById(R.id.tv);
        String name = datas.get(i).name;
//        tv.setText(name);
        viewHolder.textView.setText(name);
        return view;
    }


    private  final  class ViewHolder{
        TextView textView;
    }


}
