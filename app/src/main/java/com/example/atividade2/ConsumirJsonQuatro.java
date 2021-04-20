package com.example.atividade2;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ConsumirJsonQuatro {
    public static List<Contatos> jsonDados(String conteudo){
        try{
            List<Contatos> contatosList = new ArrayList<>();
            JSONArray jsonArray = null;
            JSONObject jsonObject = null;

            jsonArray = new JSONArray(conteudo);

            for (int i =0; i< jsonArray.length(); i++){
                jsonObject = jsonArray.getJSONObject(i);

                Contatos contatos = new Contatos();

                contatos.setUnidade(jsonObject.getString("Unidade"));
                contatos.setEndereco(jsonObject.getString("Endereço"));
                contatos.setEmail(jsonObject.getString("Email"));
                contatos.setNumero(jsonObject.getString("Numero"));

                contatosList.add(contatos);



            }
            return contatosList;
        }catch (Exception e){
            e.printStackTrace();
            return null;

        }

    }
}
