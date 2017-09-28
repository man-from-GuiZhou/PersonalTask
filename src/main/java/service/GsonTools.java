package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonTools {

    public void testGson(){
        Gson gson = new GsonBuilder().create();
        gson.toJson("Hello",System.out);
    }

}
