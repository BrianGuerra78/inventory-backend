package com.bguerra.inventory.junit.repaso;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertTrueFalseTest {

    @Test
    public void test1(){
        assertTrue(true);
        assertFalse(false);
    }

    @Test
    public void test2(){
        boolean expresoon1 = (4 ==4);
        boolean expresion2 = (4 == 2);
        assertTrue(expresoon1);
        assertFalse(expresion2);
    }
}
