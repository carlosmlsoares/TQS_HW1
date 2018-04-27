/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw1tqs;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Collections;
/**
 *
 * @author Carlos Soares
 */

    
@ManagedBean
@ApplicationScoped
public class ConversorBean implements Serializable {
    private APIAccess api;
    private float value;
    private final JSONObject apiInfo;
    private float convertedValue;
    private String currency1;
    private String currency2;

    public float getCoinValue(String coin){
        return apiInfo.getJSONObject("quotes").getFloat("USD"+coin);
    }
    public float convert(float v1, float v2, float value){
        setValue(value);
        float result=(value/v1)*v2;
        setConvertedValue(result);
        System.out.println("Result: "+result);
        return result;
    }  
    public List<String> getCoins(){
        List<String> coinsList= new ArrayList<>();
        JSONObject coins=(JSONObject) apiInfo.get("quotes");
        JSONArray array = coins.names();
        for (int i = 0; i < array.length(); i++  ) {coinsList.add(array.getString(i).substring(3));}
        Collections.sort(coinsList);
        return coinsList;
    }
    public ConversorBean() {
        api=new APIAccess();
        apiInfo=api.getData();        
        value=0;
        convertedValue=0;
    }
       public String submit(){
        float v1=getCoinValue(currency1);
        float v2=getCoinValue(currency2);
        System.out.println(currency1+" to "+currency2);
        convert(v1,v2,value);
        return "main.xhtml";
    }
    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getCurrency1() {
        return currency1;
    }

    public void setCurrency1(String currency1) {
        this.currency1 = currency1;
    }

    public float getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(float convertedValue) {
        this.convertedValue = convertedValue;
    }

    public String getCurrency2() {
        return currency2;
    }

    public void setCurrency2(String currency2) {
        this.currency2 = currency2;
    }
     public APIAccess getAPI() {
        return api;
    }
      public void setAPIAccess(APIAccess api) {
        this.api = api;
    }
    
    
}
