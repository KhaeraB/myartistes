package com.example.etudiant.myartistes;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.etudiant.myartistes.interfaces.WsListener;

import java.util.List;


public class RecipeActivity extends AppCompatActivity implements WsListener, ExtractorDataJson.RequestListener {
    private ListView recipeListView;
    private List<Recipe> allRecipe;
    private AdapterRecipe adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listrecipe);

        recipeListView = (ListView) findViewById(R.id.listView);

        ExtractorDataJson extractorData = new ExtractorDataJson(this);
        extractorData.extraDataRecipes();


    }

    @Override
    public void onReceiveRecipe(List<Recipe> recipes) {
        adapter = new AdapterRecipe(RecipeActivity.this, recipes);
        recipeListView.setAdapter(adapter);
        allRecipe = recipes;
    }

    @Override
    public void errorRequest(int idRequest) {

    }

    @Override
    public void successRequest(int idRequest, String data) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
