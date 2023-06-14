package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectTest {

    @Test
    void testCheckIfTeacher_WhenUserIsTeacher() {
        boolean result = DatabaseConnect.checkIfTeacher("teacher");
        assertTrue(result);
    }

    @Test
    void testCheckIfTeacher_WhenUserIsNotTeacher() {
        boolean result = DatabaseConnect.checkIfTeacher("Anna");
        assertFalse(result);
    }

    @Test
    void testCheckIfTeacher_WhenUserDoesNotExist() {
        boolean result = DatabaseConnect.checkIfTeacher("nonexistent");
        assertFalse(result);
    }

    @Test
    void testCheckUser_WhenUsernameAndPasswordMatch() {
        int expectedProblemNum = 3;
        int actualProblemNum = DatabaseConnect.checkUser("Anna", "password");
        assertEquals(expectedProblemNum, actualProblemNum);
    }

    @Test
    void testCheckUser_WhenUsernameAndPasswordDoNotMatch() {
        int expected = -1;
        int actualProblemNum = DatabaseConnect.checkUser("Anna", "wrongpassword");
        assertEquals(expected, actualProblemNum);
    }

    @Test
    void testCheckUser_WhenUsernameDoesNotExist() {
        int expected = -2;
        int actualProblemNum = DatabaseConnect.checkUser("nonexistent", "nonexistent");
        assertEquals(expected, actualProblemNum);
    }

    


}
