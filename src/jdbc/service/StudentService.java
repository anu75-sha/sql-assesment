package jdbc.service;

import jdbc.dto.StudentDTO;
import jdbc.exception.DuplicateStudentException;
import jdbc.exception.StudentNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface StudentService {
    void saveStudent(StudentDTO student)throws DuplicateStudentException;
    StudentDTO findStudent(int studentId) throws StudentNotFoundException;
    void updateCourseDetail(int studentId, String course_name) throws StudentNotFoundException;
    void deleteStudent(int studentId) throws StudentNotFoundException;
    List<StudentDTO> findAllStudents();
    List<StudentDTO> finStudents(String email_id, LocalDate enrollment_date);
}
