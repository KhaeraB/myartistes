package com.example.etudiant.myartistes;

import android.media.Image;
import android.widget.ImageView;

public class Recipe {

        private int id;
        private String image;
        private String itemTitle;

        public Recipe(int id, String itemTitle, String itemImage){
            this.id = id;
            this.itemTitle = itemTitle;
            this.image = itemImage;
        }

        public int getId() {
            return id;
        }

        public String getImage() {
            return image;
        }

        public String getItemTitle() {
            return itemTitle;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setImage(String image) {
            this.image = image;
        }
        public void setItemTitle(String itemName) {
            this.itemTitle = itemName;
        }

}
