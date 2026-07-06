package jdbc.repository;

import jdbc.dto.StudentDTO;

import java.time.LocalDate;
import java.util.List;

public interface StudentRepository {
    void saveStudent(StudentDTO student) ;
    StudentDTO findStudent(int studentId) ;
    void updateCourseDetail(int studentId,String course_name);
    void deleteStudent(int studentId);
    List<StudentDTO> findAllStudents();
    List<StudentDTO> findStudents(String email_id, LocalDate enrollment_date);
}
