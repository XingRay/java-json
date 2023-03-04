package com.xingray.java.json.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xingray.java.json.ClassNode;
import com.xingray.java.json.JsonConverter;

public class GsonJsonConverter implements JsonConverter {

    private final Gson gson;

    public GsonJsonConverter(Gson gson) {
        this.gson = gson;
    }

    @Override
    public String toJson(Object o) {
        return gson.toJson(o);
    }

    @Override
    public <T> T toObject(String json, Class<T> cls) {
        return gson.fromJson(json, cls);
    }

    @Override
    public <T> T toObject(String json, ClassNode<T> node) {
        TypeToken<T> typeToken = new TypeTokenFactory<T>(node.toType()).getTypeToken();
        return gson.fromJson(json, typeToken);
    }
}
