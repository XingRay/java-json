package com.xingray.java.json.jackson.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xingray.java.json.jackson.JacksonJsonConverter;
import com.xingray.java.json.test.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JacksonTest {

    private TestCase testCase;

    @BeforeEach
    public void beforeEach() {
        testCase = new TestCase(new JacksonJsonConverter(new ObjectMapper()));
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
