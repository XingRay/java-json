package com.xingray.java.json.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.xingray.java.json.ClassNode;

import java.lang.reflect.Type;

public class TypeReferenceImpl<T> extends TypeReference<T> {
    private final Type type;

    public TypeReferenceImpl(ClassNode<T> classNode) {
        this.type = classNode.toType();
    }

    @Override
    public Type getType() {
        return type;
    }
}
