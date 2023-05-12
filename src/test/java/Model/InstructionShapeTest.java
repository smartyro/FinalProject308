package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructionShapeTest {
    InstructionShape testCase = new InstructionShape(100, 100, "testShape");

    @Test
    void contains_test1() {
        assertTrue(testCase.contains(100, 100));
    }

    @Test
    void contains_test2() {
        assertTrue(testCase.contains(150, 150));
    }

    @Test
    void contains_test3() {
        assertFalse(testCase.contains(50, 150));
    }
}