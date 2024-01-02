package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ProductListAdapter extends BaseAdapter {
    private Context mContext;
    private List<Product> mProducts;

    public ProductListAdapter(Context context, List<Product> products) {
        mContext = context;
        mProducts = products;
    }

    @Override
    public int getCount() {
        return mProducts.size();
    }

    @Override
    public Object getItem(int position) {
        return mProducts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.activity_main, parent, false);
            holder = new ViewHolder();
            holder.title = convertView.findViewById(R.id.title);
            holder.price = convertView.findViewById(R.id.price);
            holder.description = convertView.findViewById(R.id.description);
            holder.image = convertView.findViewById(R.id.image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Product product = mProducts.get(position);

        holder.title.setText(product.title);
        holder.price.setText(String.valueOf(product.price));
        holder.description.setText(product.description);

        Glide.with(mContext).load(product.image).into(holder.image);

        return convertView;
    }

    static class ViewHolder {
        TextView title;
        TextView price;
        TextView description;
        ImageView image;
    }
}
