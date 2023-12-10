package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;


public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private Context context;
    public List<HomeData> data;

    public HomeAdapter(Context context, List<HomeData> data){
        this.context = context;
        this.data = data;
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {
        public TextView homeAddress;
        public ImageView homeImage;
        public TextView homeType;
        public TextView homeBds;
        public TextView homeBa;
        public TextView homePrice;

        public HomeViewHolder(@NonNull View itemView){
            super(itemView);
            homeAddress = itemView.findViewById(R.id.address);
            homeImage = itemView.findViewById(R.id.coverImage);
            homeType = itemView.findViewById(R.id.homeType);
            homeBds = itemView.findViewById(R.id.bedrooms);
            homeBa = itemView.findViewById(R.id.bathrooms);
            homePrice = itemView.findViewById(R.id.price);
        }
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View homeItemView = layoutInflater.inflate(R.layout.recycler_item, parent, false);
        return new HomeViewHolder(homeItemView);
    }




    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position){
        holder.homeAddress.setText(data.get(position).getFullAddress());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(data.get(position).getImgSrc())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.homeImage);

        holder.homeType.setText(data.get(position).getHomeType());
        holder.homeBds.setText(data.get(position).getBedrooms() + " bds");
        holder.homeBa.setText(data.get(position).getBathrooms() + " ba");
        holder.homePrice.setText("$" + data.get(position).getPrice());

    }

    @Override
    public int getItemCount(){return data.size();}
}
