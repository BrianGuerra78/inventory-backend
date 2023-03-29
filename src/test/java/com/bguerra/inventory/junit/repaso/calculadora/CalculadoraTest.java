package com.bguerra.inventory.junit.repaso.calculadora;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    Calculadora cal;

    @BeforeAll
    public static void primero(){
        System.out.println("primero");
    }

    @AfterAll
    public static void ultimo(){
        System.out.println("ultimo");
    }

    @AfterEach
    public void ultimoPorCadaPrueba(){
        System.out.println("ultimo por cada prueba");
    }

    @BeforeEach
    public void primeroPorCadaPrueba(){
        System.out.println("primero por cada prueba");
        cal = new Calculadora();
    }

    @Test
    @DisplayName("prueba de sumar calculadora")
    public void sumarTest(){
        assertEquals(2,cal.sumar(1,1));
        assertFalse(cal.sumar(2,2) == 5);
    }

    @Test
    @Disabled("se desabilita por efectos educativos")
    public void restarTest(){
        assertEquals(4,cal.restar(5,1));
    }

    @Test
    public void multiplicarTest(){
        assertEquals(25,cal.multiplicar(5,5));
    }

    @Test
    public void dividirTest(){
        assertTrue(cal.dividir(10,2) == 5);
    }
}
