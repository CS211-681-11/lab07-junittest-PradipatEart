package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {

    StudentList studentList;
    @BeforeEach
    void init(){
        studentList = new StudentList();
    }


    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียน / เพิ่มพร้อมคะแนน")
    void testAddNewStudent(){
        studentList.addNewStudent("6700000001", "One");
        assertFalse(studentList.getStudents().isEmpty());
        studentList = new StudentList();
        studentList.addNewStudent("6700000001", "One", 50);
        assertEquals(studentList.getStudents().get(0).getScore(), 50);
    }

    @Test
    @DisplayName("ทดสอบการหานักเรียนด้วยชื่อ")
    void testFindStudentById(){
        studentList.addNewStudent("6700000001", "One");

        Student s = new Student("6700000001", "One");
        Student findStudent = studentList.findStudentById("6700000001");
        assertEquals(findStudent.getId(), s.getId());
        assertEquals(findStudent.getName(), s.getName());
    }

    @Test
    @DisplayName("ทดสอบการค้นหาตามชื่อ")
    void testFilterByName(){
        studentList.addNewStudent("6700000001", "Prasit");
        studentList.addNewStudent("6700000002", "Prasert");
        studentList.addNewStudent("6700000003", "Prayut");
        studentList.addNewStudent("6700000004", "Name");
        StudentList filterStudents = studentList.filterByName("Pra");

        StudentList correctFilterStudent = new StudentList();
        correctFilterStudent.addNewStudent("6700000001", "Prasit");
        correctFilterStudent.addNewStudent("6700000002", "Prasert");
        correctFilterStudent.addNewStudent("6700000003", "Prayut");

        assertEquals(filterStudents.getStudents().toString(), correctFilterStudent.getStudents().toString());
    }

    @Test
    @DisplayName("ทดสอบการให้คะแนนตาม ID")
    void testGiveScoreToId(){
        studentList.addNewStudent("6700000001", "Prasit");
        studentList.giveScoreToId("6700000001", 50);
        assertEquals(studentList.findStudentById("6700000001").getScore(), 50);
    }

    @Test
    @DisplayName("ทดสอบการดูเกรดด้วย ID")
    void testViewGradeOfId(){
        studentList.addNewStudent("6700000001", "Test", 25);
        assertEquals(studentList.getStudents().get(0).getScore(), 25);
    }

}