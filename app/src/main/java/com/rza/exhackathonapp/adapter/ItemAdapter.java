package com.rza.exhackathonapp.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.rza.exhackathonapp.R;
import com.rza.exhackathonapp.model.Item;

import java.util.List;

/**
 * Created by Rza on 22-May-17.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public SimpleDraweeView simpleDraweeView;
        public TextView textViewName;
        public TextView textViewDesc;
        public TextView textViewDate;
        public TextView textViewPrice;
        public CardView cardView;
        public TextView textViewUser;

        public ViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView)itemView.findViewById(R.id.cardView);
            simpleDraweeView = (SimpleDraweeView)itemView.findViewById(R.id.imageView);
            textViewDate = (TextView) itemView.findViewById(R.id.date);
            textViewDesc = (TextView) itemView.findViewById(R.id.desc);
            textViewName = (TextView) itemView.findViewById(R.id.name);
            textViewPrice = (TextView) itemView.findViewById(R.id.price);
            textViewUser = (TextView) itemView.findViewById(R.id.user);
        }
    }

    private List<Item> mItems;
    private Context mContext;

    public ItemAdapter(Context context, List<Item> items){
        mItems = items;
        mContext = context;
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = inflater.inflate(R.layout.item_items, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder viewHolder, int position) {
        Item item = mItems.get(position);

        CardView cardView = (CardView) viewHolder.cardView;
        SimpleDraweeView simpleDraweeView = viewHolder.simpleDraweeView;
        TextView textViewName = viewHolder.textViewName;
        TextView textViewDesc = viewHolder.textViewDesc;
        TextView textViewDate = viewHolder.textViewDate;
        TextView textViewPrice = viewHolder.textViewPrice;
        TextView textViewUser = viewHolder.textViewUser;

        simpleDraweeView.setImageURI(item.getPhotoUrl());
        textViewDate.setText("Published at: " + item.getCurrentDateTimeString());
        textViewName.setText(item.getItemName());
        textViewDesc.setText(item.getItemDesc());
        textViewPrice.setText("Price: " +String.valueOf(item.getItemPrice() + "$"));

    }



    @Override
    public int getItemCount(){
        return mItems.size();
    }
}
