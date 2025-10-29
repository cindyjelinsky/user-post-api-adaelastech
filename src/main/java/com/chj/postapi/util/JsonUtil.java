package com.chj.postapi.util;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;


public class JsonUtil{

       private static final ObjectMapper mapper = new ObjectMapper();


       public static <T> T  fromJsonToEntity(String json, Class<T> clazz){
              try{

                  return mapper.readValue(json,clazz);


              }catch(Exception e){
                  throw new RuntimeException("Error converting json: " + e.getMessage());
              }
       }

        public static <T> List<T> fromJsonToList(String json,String fieldName, Class<T> clazz){
           try{
               Map<String, Object> map = mapper.readValue(json, new TypeReference<Map<String, Object>>() {});

               return mapper.convertValue(map.get(fieldName), mapper.getTypeFactory().constructCollectionType(List.class,clazz));

           }catch(Exception e){
               throw new RuntimeException("Error converting json: " + e.getMessage());
           }
        }



}




