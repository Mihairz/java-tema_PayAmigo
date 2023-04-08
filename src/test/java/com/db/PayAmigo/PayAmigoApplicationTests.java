package com.db.PayAmigo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class PayAmigoApplicationTests {

    static List<String> myStrings;

    @BeforeAll
    static void startingTest() {
        System.out.println("Starting test");
        myStrings = new ArrayList<>();
    }

    @Test
    void helloTest() {
        String str = "Hello";
        assert str.compareTo("Hello") == 0;
    }

    @Test
    void helloTest2() {
        String str = "Hello";
        assert str == "Hello";
    }

    @RepeatedTest(5)
    void addToList() {
        String temp = UUID.randomUUID().toString();
        myStrings.add(temp);
        assert myStrings.contains(temp);
        assert myStrings.size() == 1;
    }

    @AfterEach
    void afterEachTest() {
        myStrings.clear();
    }


}
