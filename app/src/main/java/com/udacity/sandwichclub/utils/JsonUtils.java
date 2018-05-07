package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json)  {
        String nainName = "";
        List<String> alsoKnownAs= new ArrayList<>();
        String placeOfOrigin = "";
        String description ="";
        String image= "";
        List<String> ingredients = new ArrayList();
        JSONArray nameArray = null;
        JSONArray ingredientsArray = null;
        try {
            JSONObject sandwichString = new JSONObject(json);
            nainName = sandwichString.getJSONObject("name").getString("mainName");
            nameArray = sandwichString.getJSONObject("name").getJSONArray("alsoKnownAs");
            for( int i = 0 ; i < nameArray.length(); i++){
                alsoKnownAs.add(nameArray.getString(i));
            }
            placeOfOrigin = sandwichString.getString("placeOfOrigin");
            description = sandwichString.getString("description");
            image = sandwichString.getString("image");
            ingredientsArray = sandwichString.getJSONArray("ingredients");
            for( int i = 0 ; i < ingredientsArray.length(); i++){
                ingredients.add(ingredientsArray.getString(i));
            }
        }
        catch (Exception e){
            return null;
        }

        return new Sandwich(nainName,alsoKnownAs,placeOfOrigin,description,image,ingredients);
    }
}
