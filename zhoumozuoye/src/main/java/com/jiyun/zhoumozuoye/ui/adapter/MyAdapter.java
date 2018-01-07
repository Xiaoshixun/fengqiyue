package com.jiyun.zhoumozuoye.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jiyun.zhoumozuoye.R;
import com.jiyun.zhoumozuoye.ui.Bean.ShiTi;

import java.util.List;

/**
 * Created by papi酱 on 2018/1/6.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
   private List<ShiTi.ResultBean.ListBean> mlist;
   private Context context;

       public MyAdapter(List<ShiTi.ResultBean.ListBean> mlist, Context context) {
       this.mlist = mlist;
       this.context = context;
   }

   @Override
   public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       RecyclerView.ViewHolder holder = null;
       switch (viewType){
           case 0:
               View inflate = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
               holder = new ViewHolder(inflate);
               holder.itemView.setOnClickListener(this);
               break;
           case 1:
               View view = LayoutInflater.from(context).inflate(R.layout.item2, parent, false);
               holder = new ViewHolder1(view);
               holder.itemView.setOnClickListener(this);
               break;
       }
       return holder;

   }

   @Override
   public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
       if (holder instanceof  ViewHolder){
           ((ViewHolder) holder).textView1.setText(mlist.get(position).getTitle()+"\n"+mlist.get(position).getSource());

           Glide.with(context).load(mlist.get(position).getFirstImg()).into(((ViewHolder) holder).imageView);
           holder.itemView.setTag(position);
       }
       if (holder instanceof ViewHolder1){
           ((ViewHolder1) holder).textView2.setText(mlist.get(position).getTitle2());
           Glide.with(context).load(mlist.get(position).getFirstImg()).into(((ViewHolder1) holder).imageView1);

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
       private ImageView imageView;
       private TextView textView1;


       public ViewHolder(View itemView) {
           super(itemView);

           imageView = itemView.findViewById(R.id.imageView);
           textView1 = itemView.findViewById(R.id.textView1);

       }
   }
   public class ViewHolder1 extends RecyclerView.ViewHolder {
       private ImageView imageView1;
       private TextView textView2;


       public ViewHolder1(View itemView) {
           super(itemView);
           imageView1 = itemView.findViewById(R.id.imageView1);
           textView2 = itemView.findViewById(R.id.textView2);

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
