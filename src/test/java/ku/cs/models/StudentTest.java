package ku.cs.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student s;
    @BeforeEach
    void init(){
        s = new Student("6700000000", "Tester");
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 40.1")
    void testAddScore(){
        s.addScore(40.1);
        assertEquals(40.1, s.getScore());
    }

    @Test
    @DisplayName("ทดสอบการคำนวณเกรด")
    void testCalculateGrade(){
        s.addScore(90);
        assertEquals("A", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการเช็ค ID")
    void testIsID(){
        assertTrue(s.isId("6700000000"));
    }

    @Test
    @DisplayName("ทดสอบว่าในชื่อมี String ดังกล่าว")
    void testIsNameContains(){
        assertTrue(s.isNameContains("Test"));
    }

}