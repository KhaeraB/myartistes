package com.example.etudiant.myartistes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterRecipe extends ArrayAdapter<Recipe>{
        private List<Recipe> allRecipe = new ArrayList<>();

        public AdapterRecipe(Context context, List<Recipe> users) {

            super(context, 0, users);

        }
        @Nullable
        @Override
        public Recipe getItem(int position) {
            if(allRecipe.isEmpty()){
                return super.getItem(position);
            }else{
                return allRecipe.get(position);
            }
        }
        @Nullable
        public String getImage(int position) {
            if(allRecipe.isEmpty()){
                return super.getItem(position).getImage();
            }else{
                return allRecipe.get(position).getImage();
            }
        }

        @Nullable
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if(convertView == null){
                //Nous récupérons notre row_tweet via un LayoutInflater,
                //qui va charger un layout xml dans un objet View
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.recipeitem,parent, false);
            }

            RecipeViewHolder viewHolder = (RecipeViewHolder) convertView.getTag();
            if(viewHolder == null){
                viewHolder = new RecipeViewHolder();
                viewHolder.itemTitle =  convertView.findViewById(R.id.ItemTitle);
                viewHolder.image = convertView.findViewById(R.id.image);
                convertView.setTag(viewHolder);
            }
            viewHolder.itemTitle.setText(getItem(position ).getItemTitle());
            Picasso.get().load(getImage(position)).into(viewHolder.image);

            //nous renvoyons notre vue à l'adapter, afin qu'il l'affiche
            //et qu'il puisse la mettre à recycler lorsqu'elle sera sortie de l'écran
            return convertView;
        }


    private class RecipeViewHolder{
        public ImageView image;
        public TextView itemTitle;
    }
}
