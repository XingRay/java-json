package com.xingray.java.json.gson.test;

import com.google.gson.Gson;
import com.xingray.java.json.gson.GsonJsonConverter;
import com.xingray.java.json.test.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GsonTest {

    private TestCase testCase;

    @BeforeEach
    public void beforeEach() {
        testCase = new TestCase(new GsonJsonConverter(new Gson()));
    }

    @Test
    public void test01() {
        assert testCase.objectToJson();
    }

    @Test
    public void test02() {
        assert testCase.jsonToObject();
    }

    @Test
    public void test03() {
        assert testCase.listToJson();
    }

    @Test
    public void test04() {
        assert testCase.jsonToList();
    }

}
