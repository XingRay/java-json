package com.xingray.java.json.gson;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

public class TypeTokenFactory<T> {
    private final Type type;
    public TypeTokenFactory(Type type) {
        this.type = type;
    }

    public TypeToken<T> getTypeToken() {
        try {
            Constructor<TypeToken> constructor = TypeToken.class.getDeclaredConstructor(Type.class);
            constructor.setAccessible(true);
            return constructor.newInstance(this.type);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
