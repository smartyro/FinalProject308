package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputOutputShapeTest {
    InputOutputShape testCase = new InputOutputShape(100, 100, "testShape");

    //testCase.draw();

    @Test
    void contains_test1() {
    //    assertTrue(testCase.contains(105, 105));
    }

    @Test
    void contains_test2() {
    //    assertTrue(testCase.contains(110, 110));
    }

    @Test
    void contains_test3() {
    //    assertFalse(testCase.contains(50, 150));
    }
}