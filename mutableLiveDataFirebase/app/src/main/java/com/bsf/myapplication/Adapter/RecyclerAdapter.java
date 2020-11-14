package com.bsf.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bsf.myapplication.Model.Model;
import com.bsf.myapplication.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Model> _modelList;
    private Context _context;
    public RecyclerAdapter(Context context, List<Model> modelList) {
        _modelList = modelList;
        _context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(_context).inflate(R.layout.recycler_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.foodNameTV.setText(_modelList.get(position).getFoodName());
        holder.caloriTV.setText(_modelList.get(position).getFoodCalori());
        holder.proteinTv.setText(_modelList.get(position).getFoodProtein());
        holder.fatTV.setText(_modelList.get(position).getFoodFat());
        holder.karbonhidratTV.setText(_modelList.get(position).getFoodKardonhidrat());
        holder.foodDescriptionTV.setText(_modelList.get(position).getFoodDescription());
    }

    @Override
    public int getItemCount() {
        if (_modelList!=null){
            return _modelList.size();
        }else
            return 0;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView foodNameTV,caloriTV,proteinTv,fatTV,karbonhidratTV,foodDescriptionTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            foodNameTV = itemView.findViewById(R.id.foodNameTV);
            caloriTV = itemView.findViewById(R.id.caloriTV);
            proteinTv = itemView.findViewById(R.id.proteinTv);
            fatTV = itemView.findViewById(R.id.fatTV);
            karbonhidratTV = itemView.findViewById(R.id.karbonhidratTV);
            foodDescriptionTV = itemView.findViewById(R.id.foodDescriptionTV);
        }
    }
}
