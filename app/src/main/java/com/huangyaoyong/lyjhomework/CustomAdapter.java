package com.huangyaoyong.lyjhomework;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private Context context;
    private List<String> list;

    private static final String TAG = "CustomAdapter";

    public CustomAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv, parent, false);
        Log.e(TAG, "onCreateViewHolder: " + getItemCount());
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.tv.setText("Item "+ list.get(position));
        holder.tv2.setText("SubItem "+list.get(position));
        holder.itemView.setOnClickListener(view -> Toast.makeText(context, "Item "+ list.get(position), Toast.LENGTH_SHORT).show());
        Log.e(TAG, "onBindViewHolder: " + position);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public List<String> getList() {
        return list;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        private TextView tv2;

        public CustomViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }

}
