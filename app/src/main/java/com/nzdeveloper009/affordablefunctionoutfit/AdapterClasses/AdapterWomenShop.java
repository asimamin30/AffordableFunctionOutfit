package com.nzdeveloper009.affordablefunctionoutfit.AdapterClasses;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nzdeveloper009.affordablefunctionoutfit.Buyer.RentProducts.Shops.BuyerWomenShopDetails;
import com.nzdeveloper009.affordablefunctionoutfit.HelperClasses.ModelShop;
import com.nzdeveloper009.affordablefunctionoutfit.R;

import java.util.ArrayList;

public class AdapterWomenShop extends RecyclerView.Adapter<AdapterWomenShop.HolderWomenShop> {
    private Context context;
    public ArrayList<ModelShop> shopList;

    public AdapterWomenShop(Context context, ArrayList<ModelShop> shopList) {
        this.context = context;
        this.shopList = shopList;
    }

    @NonNull
    @Override
    public HolderWomenShop onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate layout row_shop.xml
        View view = LayoutInflater.from(context).inflate(R.layout.row_shop,parent,false);


        return new HolderWomenShop(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderWomenShop holder, int position) {
        //get data
        ModelShop modelShop = shopList.get(position);
        final String name = modelShop.getUsername();
        final String email = modelShop.getEmail();
        final String phone = modelShop.getPhoneNo();

        //set data
        holder.username.setText(name);
        holder.email.setText(email);
        holder.phone.setText(phone);
        holder.shopIv.setImageResource(R.drawable.ic_shop);

        //handle click listener, show shop details
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BuyerWomenShopDetails.class);
                intent.putExtra("name",name);
                intent.putExtra("email",email);
                intent.putExtra("phone",phone);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return shopList.size();
    }

    class HolderWomenShop extends RecyclerView.ViewHolder{
        private TextView username,email,phone;
        private ImageView shopIv;
        public HolderWomenShop(@NonNull View itemView) {
            super(itemView);

            //init ui views
            username = itemView.findViewById(R.id.seller_username);
            email = itemView.findViewById(R.id.seller_email);
            phone = itemView.findViewById(R.id.seller_phoneNo);
            shopIv = itemView.findViewById(R.id.shopIv);

        }
    }
}
