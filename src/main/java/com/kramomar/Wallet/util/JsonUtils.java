package com.kramomar.Wallet.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class JsonUtils {

    public static <T> List<T> convertFromJsonToList(String json, TypeReference<List<T>> typeReference) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, typeReference);
    }

    public static <T> T convertFromJsonToObject(String json, Class<T> aClass) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, aClass);
    }

    public static String convertFromObjectToJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
    public static String removeFirstAndLast(String param) {
        StringBuilder sb = new StringBuilder(param);
        sb.delete(param.length() - 1, param.length());
        sb.delete(0, 1);
        return sb.toString();
    }

}
