package com.example.recyclview.adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclview.CharacterModel;
import com.example.recyclview.R;
import com.example.recyclview.fragments.CharacterDescriptionFragment;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.MyViewHolder> {

    List<CharacterModel> dataSet;

    public CharacterAdapter(List<CharacterModel> dataSet) {
        this.dataSet = dataSet;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView name;
        TextView desc;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardViewCardPage);
            name = itemView.findViewById(R.id.firstTextCard);
            desc = itemView.findViewById(R.id.secondTextCard);
            image = itemView.findViewById(R.id.imageViewCard);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TextView name = holder.name;
        TextView desc = holder.desc;
        ImageView image = holder.image;
        CardView card = holder.cardView;

        name.setText(dataSet.get(position).getName());
        desc.setText(dataSet.get(position).getDescription());
        image.setImageResource(dataSet.get(position).getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                bundle.putInt("id", dataSet.get(holder.getAdapterPosition()).getId());
                CharacterDescriptionFragment characterDescriptionFragment = new CharacterDescriptionFragment();

                characterDescriptionFragment.setArguments(bundle);

                Navigation.findNavController(view).navigate(R.id.action_characterListFragment_to_characterDescriptionFragment, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
