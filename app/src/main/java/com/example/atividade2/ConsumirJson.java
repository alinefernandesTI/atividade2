package com.example.atividade2;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ConsumirJson {

    public static List<Lavagens> jsonDados(String conteudo){
        try{
            List<Lavagens> lavagensList = new ArrayList<>();
            JSONArray jsonArray = null;
            JSONObject jsonObject = null;

            jsonArray = new JSONArray(conteudo);

            for (int i =0; i< jsonArray.length(); i++){
                jsonObject = jsonArray.getJSONObject(i);

                Lavagens lavagens = new Lavagens();

                lavagens.setNome(jsonObject.getString("nome"));
                lavagens.setValor(jsonObject.getString("valor"));

                lavagensList.add(lavagens);



            }
            return lavagensList;
        }catch (Exception e){
            e.printStackTrace();
            return null;

        }

    }
}
