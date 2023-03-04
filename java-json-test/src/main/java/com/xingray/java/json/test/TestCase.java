package com.xingray.java.json.test;

import com.xingray.java.json.ClassNode;
import com.xingray.java.json.JsonConverter;
import com.xingray.java.json.test.model.Student;

import java.util.Arrays;
import java.util.List;

public class TestCase {

    private final JsonConverter jsonConverter;

    public TestCase(JsonConverter jsonConverter) {
        this.jsonConverter = jsonConverter;
    }

    public boolean objectToJson() {
        Student student = new Student(1, "aa");
        String json = jsonConverter.toJson(student);
        System.out.println(json);
        assert json.equals("{\"id\":1,\"name\":\"aa\"}");
        return true;
    }

    public boolean jsonToObject() {
        String json = "{\"id\":1,\"name\":\"aa\"}";
        Student student = jsonConverter.toObject(json, Student.class);
        System.out.println(student);
        assert student != null && student.getId() == 1 && student.getName().equals("aa");
        return true;
    }

    public boolean listToJson() {
        List<Student> students = Arrays.asList(new Student(1, "aa"), new Student(2, "bb"));
        String json = jsonConverter.toJson(students);
        System.out.println(json);
        assert json.equals("[{\"id\":1,\"name\":\"aa\"},{\"id\":2,\"name\":\"bb\"}]");
        return true;
    }

    public boolean jsonToList() {
        String json = "[{\"id\":1,\"name\":\"aa\"},{\"id\":2,\"name\":\"bb\"}]";
        List<Student> students = jsonConverter.toObject(json, new ClassNode<>(List.class, Student.class));
        assert students != null && students.size() == 2;
        assert students.get(0).equals(new Student(1, "aa"));
        assert students.get(1).equals(new Student(2, "bb"));

        System.out.println(students);
        return true;
    }
}
