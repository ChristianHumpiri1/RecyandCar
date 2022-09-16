package com.example.myappre;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdaptador extends RecyclerView.Adapter<ListAdaptador.ViewHolder> {
    private List<ListElement> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdaptador(List<ListElement> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }
    @Override
    public int getItemCount() {return mData.size(); }

    @Override
    public ListAdaptador.ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType){
        View view = mInflater.inflate(R.layout.list_element, null);
        return new ListAdaptador.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final ListAdaptador.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }
    public void setItems (List<ListElement> items ) { mData = items;}

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImage;
        TextView name, city, status;

        ViewHolder(View itemView){
            super(itemView);
            iconImage = itemView.findViewById(R.id.iconImageView);
            name = itemView.findViewById(R.id.nametextView);
            city = itemView.findViewById(R.id.citytextView);
            status = itemView.findViewById(R.id.statustextView);
        }

        void bindData(final ListElement item){
            iconImage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            name.setText(item.getName());
            city.setText(item.getCiudad());
            status.setText(item.getStatus());
        }

    }

}
