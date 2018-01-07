package com.jiyun.zhoumozuoye.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.zhoumozuoye.R;
import com.jiyun.zhoumozuoye.ui.Bean.ShiTi;
import com.jiyun.zhoumozuoye.ui.Bean.ShiTi2;

import java.util.List;

/**
 * Created by papi酱 on 2018/1/6.
 */

public class MyAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
   private List<ShiTi2.ResultBean.DataBean> mlist;
   private Context context;

       public MyAdapter2(List<ShiTi2.ResultBean.DataBean> mlist, Context context) {
       this.mlist = mlist;
       this.context = context;
   }

   @Override
   public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       RecyclerView.ViewHolder holder = null;
       switch (viewType){
           case 0:
               View inflate = LayoutInflater.from(context).inflate(R.layout.item3, parent, false);
               holder = new ViewHolder(inflate);
               holder.itemView.setOnClickListener(this);
               break;
           case 1:
               View view = LayoutInflater.from(context).inflate(R.layout.item4, parent, false);
               holder = new ViewHolder1(view);
               holder.itemView.setOnClickListener(this);
               break;
       }
       return holder;

   }

   @Override
   public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
       if (holder instanceof  ViewHolder){
           ((ViewHolder) holder).textView.setText(mlist.get(position).getTitle()+"\n");
           ((ViewHolder) holder).textView3.setText(mlist.get(position).getAuthor_name()+"\n");
           ((ViewHolder) holder).textView4.setText(mlist.get(position).getDate()+"\n");

           Glide.with(context).load(mlist.get(position).getThumbnail_pic_s()).into(((ViewHolder) holder).imageView2);
           holder.itemView.setTag(position);
       }
       if (holder instanceof ViewHolder1){
           ((ViewHolder1) holder).textView5.setText(mlist.get(position).getTitle()+"\n");
           ((ViewHolder1) holder).textView6.setText(mlist.get(position).getAuthor_name()+"\n");
           ((ViewHolder1) holder).textView7.setText(mlist.get(position).getDate()+"\n");
           Glide.with(context).load(mlist.get(position).getThumbnail_pic_s02()).into(((ViewHolder1) holder).imageView3);

           holder.itemView.setTag(position);
       }
   }

   @Override
   public int getItemViewType(int position) {
       return position%2;
   }

   @Override
   public int getItemCount() {
       return mlist.size();
   }



   public class ViewHolder extends RecyclerView.ViewHolder {
       private ImageView imageView2;
       private TextView textView;
       private TextView textView3;
       private TextView textView4;


       public ViewHolder(View itemView) {
           super(itemView);

           imageView2 = itemView.findViewById(R.id.imageView2);
           textView = itemView.findViewById(R.id.textView);
           textView3 = itemView.findViewById(R.id.textView3);
           textView4 = itemView.findViewById(R.id.textView4);

       }
   }
   public class ViewHolder1 extends RecyclerView.ViewHolder {
       private ImageView imageView3;
       private TextView textView5;
       private TextView textView6;
       private TextView textView7;


       public ViewHolder1(View itemView) {
           super(itemView);
           imageView3 = itemView.findViewById(R.id.imageView3);
           textView5 = itemView.findViewById(R.id.textView5);
           textView6 = itemView.findViewById(R.id.textView6);
           textView7 = itemView.findViewById(R.id.textView7);

       }
   }
   public interface OnItemclik{
       void setOnItemClik(View view, int position);
   }
   public OnItemclik onItemclik;
   public void setOnItemclik(OnItemclik onItemclik){
       this.onItemclik  = onItemclik;
   }
   @Override

   public void onClick(View view) {
       if (onItemclik!=null){
           onItemclik.setOnItemClik(view, (Integer) view.getTag());
       }

   }
}
