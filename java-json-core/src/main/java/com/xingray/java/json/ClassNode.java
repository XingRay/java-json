package com.xingray.java.json;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class ClassNode<T> {

    private Class cls;

    private ClassNode parent;

    private ClassNode[] children;

    public ClassNode(Class cls) {
        this.cls = cls;
    }

    public ClassNode(Class cls, ClassNode parent) {
        this.cls = cls;
        this.parent = parent;

    }

    public ClassNode(Class cls, ClassNode[] children) {
        this.cls = cls;
        this.children = children;
    }

    public ClassNode(Class cls, Class... classes) {
        this.cls = cls;
        this.children = of(classes);
    }

    public ClassNode(Class cls, ClassNode parent, ClassNode[] children) {
        this.cls = cls;
        this.parent = parent;
        this.children = children;
    }

    public Class getCls() {
        return cls;
    }

    public ClassNode getParent() {
        return parent;
    }

    public ClassNode[] getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "ClassNode{" +
                "cls=" + cls +
                ", parent=" + parent +
                ", children=" + Arrays.toString(children) +
                '}';
    }

    public static ClassNode[] of(Class... classes) {
        ClassNode[] nodes = new ClassNode[classes.length];
        for (int i = 0; i < classes.length; i++) {
            nodes[i] = new ClassNode(classes[i]);
        }

        return nodes;
    }

    public Type toType(){
        if(children==null){
            return cls;
        }
        return new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                int length = children.length;
                Type[] types = new Type[length];
                for (int i = 0; i < length; i++) {
                    types[i] = children[i].toType();
                }
                return types;
            }

            @Override
            public Type getRawType() {
                return cls;
            }

            @Override
            public Type getOwnerType() {
                return null;
            }
        };
    }
}
