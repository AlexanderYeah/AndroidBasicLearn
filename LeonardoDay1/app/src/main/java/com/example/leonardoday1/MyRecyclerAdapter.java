package com.example.leonardoday1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {


    private List<Bean> datas;
    private Context context;

    public MyRecyclerAdapter(List<Bean> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @NonNull
    @Override
    public MyRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = View.inflate(context,R.layout.recyclerview_item,null);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerAdapter.MyViewHolder holder, int position) {
        // 绑定数据方法设置值
        holder.tv.setText(datas.get(position).name);

    }

    @Override
    public int getItemCount() {
        // 这个方式显示多少item
        return datas == null ?  0 :  datas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//             Google废弃了getAdapterPosition()方法，但是却又提供了getBindingAdapterPosition()和
//             getAbsoluteAdapterPosition()这两个方法。从方法名可以看出来，一个是用于获取元素位于当前绑定Adapter的位置
//             一个是用于获取元素位于Adapter中的绝对位置（一般常用的就是这个）。
                    // 调用自己的监听方法
                    mItemClickListener.onReceiveItemClick(getBindingAdapterPosition());
                }
            });

        }
    }
    private  OnRecyclerItemClickListener mItemClickListener;
    public void setRecyclerItemClickListener(OnRecyclerItemClickListener listener){
        mItemClickListener = listener;
    }
    // 创建一个接口 回调点击事件
    public interface OnRecyclerItemClickListener{
        void onReceiveItemClick(int position);
    }
}
