package com.xingray.java.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xingray.java.json.ClassNode;
import com.xingray.java.json.JsonConverter;

public class JacksonJsonConverter implements JsonConverter {

    private ObjectMapper objectMapper;

    public JacksonJsonConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public String toJson(Object o) {
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T toObject(String json, Class<T> cls) {
        try {
            return (T) objectMapper.readValue(json, cls);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T toObject(String json, ClassNode<T> node) {
        try {
            return objectMapper.readValue(json, new TypeReferenceImpl<>(node));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
