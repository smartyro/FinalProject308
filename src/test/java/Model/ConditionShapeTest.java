package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConditionShapeTest {
    ConditionShape testCase = new ConditionShape(100, 100, "testShape");

    @Test
    void contains_test1() {
        assertTrue(testCase.contains(100, 100));
    }

    @Test
    void contains_test2() {
        assertTrue(testCase.contains(120, 120));
    }

    @Test
    void contains_test3() {
        assertFalse(testCase.contains(50, 150));
    }
}