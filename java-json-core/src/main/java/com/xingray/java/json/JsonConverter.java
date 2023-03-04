package com.xingray.java.json;

public interface JsonConverter {
    String toJson(Object o);

    <T> T toObject(String json, Class<T> cls);

    <T> T toObject(String json, ClassNode<T> node);
}
