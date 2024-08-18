package com.os.opendialogonsinglelistitem;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.os.opendialogonsinglelistitem.databinding.ListItemBinding;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {
    private Context context;
    ArrayList<String> itemList;

    public ListAdapter(Context context, ArrayList<String> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemBinding binding = ListItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ListAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding.tvItemName.setText(itemList.get(position));
        holder.binding.tvItemName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Constant.clickUIFeel(holder.itemView);
                int[] location = new int[2];
                holder.itemView.getLocationInWindow(location);
                int x = location[0];
                int y = location[1];

                holder.itemPopupWindow.showAtLocation(holder.itemView, Gravity.TOP | Gravity.CENTER, 0, y + 55);
                holder.itemPopupWindow.setOutsideTouchable(true);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ListItemBinding binding;
        private PopupWindow itemPopupWindow;
        public MyViewHolder( ListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            View maleFemalePopupView = LayoutInflater.from(context).inflate(R.layout.male_female_dialog, null);
            TextView tvMale = maleFemalePopupView.findViewById(R.id.tvMale);
            TextView tvFemale = maleFemalePopupView.findViewById(R.id.tvFemale);
            itemPopupWindow = new PopupWindow(maleFemalePopupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
            itemPopupWindow.setElevation(8);

            tvMale.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemPopupWindow.dismiss();
                    Toast.makeText(context, "MALE", Toast.LENGTH_SHORT).show();
                }
            });

            tvFemale.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemPopupWindow.dismiss();
                    Toast.makeText(context, "FEMALE", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
