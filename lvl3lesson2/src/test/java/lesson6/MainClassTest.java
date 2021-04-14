package lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MainClassTest {
    private MainClass listik;
    @BeforeEach
    void init() {
        listik = new MainClass();

    }


    @Test
    void taskOne() {
        Assertions.assertEquals(new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9)), listik.taskOne(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9))));
        Assertions.assertEquals(new ArrayList<>(Arrays.asList(3, 2, 1)), listik.taskOne(new ArrayList<>(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1))));
        Assertions.assertEquals(new ArrayList<>(Arrays.asList(-10, 2, -55)), listik.taskOne(new ArrayList<>(Arrays.asList(-1, -2, -3, 4, 5, 4, -10, 2, -55))));
        Assertions.assertEquals(new ArrayList<>(Arrays.asList()), listik.taskOne(new ArrayList<>(Arrays.asList(44, 234, 4, 1, 4, 4, 4, 2, 4))));
        Assertions.assertThrows(RuntimeException.class, () -> {
            listik.taskOne(new ArrayList<>(Arrays.asList(44, 234, 5, 7, 1, 5)));
        });
    }

    @Test
    void taskTwo() {
        Assertions.assertTrue(listik.taskTwo(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9))));
        Assertions.assertTrue(listik.taskTwo(new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9))));
        Assertions.assertFalse(listik.taskTwo(new ArrayList<>(Arrays.asList( 2, 3, 5, 6, 7, 8, 9))));
    }
}