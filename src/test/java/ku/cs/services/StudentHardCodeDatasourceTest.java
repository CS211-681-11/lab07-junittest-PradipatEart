package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {

    @Test
    @DisplayName("ทดสอบการอ่านข้อมูล")
    void testReadData(){
        StudentList list = new StudentList();
        list.addNewStudent("6710400001", "First");
        list.addNewStudent("6710400002", "Second");
        list.addNewStudent("6710400003", "Third");
        list.addNewStudent("6710400004", "Fourth");

        StudentHardCodeDatasource datasource = new StudentHardCodeDatasource();
        StudentList readList = datasource.readData();

        assertEquals(list.getStudents().toString(), readList.getStudents().toString());
    }

}