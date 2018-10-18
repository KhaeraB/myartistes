package com.example.etudiant.myartistes;

import android.util.Log;

import com.github.kittinunf.fuel.Fuel;
import com.github.kittinunf.fuel.core.FuelError;
import com.github.kittinunf.fuel.core.Handler;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ExtractorDataJson {

    private List<Recipe> allRecipes = new ArrayList<>();
    private RequestListener listener;

    interface RequestListener{
        void onReceiveRecipe(List<Recipe> users);
    }



    public ExtractorDataJson(RequestListener listener){
        this.listener = listener;
    }

    public void extraDataRecipes(){
        //get
        String urlRecipes = "http://51.15.254.4:9001/ws/resto/listRecettes";
        Fuel.post(urlRecipes).responseString(new Handler<String>() {
            @Override
            public void failure(Request request, Response response, FuelError error) {
                Log.e("RECIPE LIST", "No data error" + error);
            }

            @Override
            public void success(Request request, Response response, String data) {
                if(data != null){
                    try{
                        Log.d("RECIPES LIST", "success: RECIPE "+response+ " "+data);
                        JSONArray jsonData = new JSONArray(data);
                        for(int i = 0; i<jsonData.length(); i++){
                            JSONObject obj = (JSONObject)jsonData.get(i);
                            int id  = obj.getInt("id");
                            String title = obj.getString("title");
                            String image=obj.getString("photo");
                            Log.d("ListView", " Fuel Success Loop" );
                            allRecipes.add( new Recipe(id, title, image));
                        }

                        listener.onReceiveRecipe(allRecipes);

                    }catch (final JSONException exception){
                        Log.e("RECIPES LIST", "Json parsing error" + exception);
                    }
                }
            }
        });
    }
}
