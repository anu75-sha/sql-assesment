package jdbc.service.impl;

import jdbc.dto.StudentDTO;
import jdbc.exception.DuplicateStudentException;
import jdbc.exception.StudentNotFoundException;
import jdbc.repository.StudentRepository;
import jdbc.repository.impl.StudentRepositoryImpl;
import jdbc.service.StudentService;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private static final String STUDENT_NOT_FOUND="STUDENT NOT FOUND BY ID";
    private static final String STUDENT_ALREADY_EXITS="STUDENT ALREADY EXITS BY ID";

    public StudentServiceImpl(){
        this.studentRepository=new StudentRepositoryImpl();
    }
    @Override
    public void saveStudent(StudentDTO studentDTO) throws DuplicateStudentException {
        StudentDTO student= studentRepository.findStudent(studentDTO.getId());
        if(Objects.nonNull(student)){
            throw new DuplicateStudentException(STUDENT_ALREADY_EXITS+studentDTO.getId());
        }else{
            studentRepository.saveStudent(studentDTO);
        }
    }

    @Override
    public StudentDTO findStudent(int studentId) throws StudentNotFoundException {
        StudentDTO studentDTO= studentRepository.findStudent(studentId);
        if(Objects.isNull(studentDTO)){
            throw new StudentNotFoundException(STUDENT_NOT_FOUND+studentId);
        }else {
            return studentDTO;
        }
    }

    @Override
    public void updateCourseDetail(int studentId, String course_name) throws StudentNotFoundException {
        StudentDTO studentDTO=studentRepository.findStudent(studentId);
        if(Objects.isNull(studentDTO)){
            throw new StudentNotFoundException(STUDENT_NOT_FOUND+ studentId);
        }else {
            studentRepository.updateCourseDetail(studentId,course_name);
        }
    }

    @Override
    public void deleteStudent(int studentId) throws StudentNotFoundException {
        StudentDTO studentDTO=studentRepository.findStudent(studentId);
        if(Objects.isNull(studentDTO)){
            throw new StudentNotFoundException(STUDENT_NOT_FOUND+  studentId);
        }else {
            studentRepository.deleteStudent(studentId);
        }
    }

    @Override
    public List<StudentDTO> findAllStudents() {
        return studentRepository.findAllStudents();

    }

    @Override
    public List<StudentDTO> finStudents(String email_id, LocalDate enrollment_date) {
        return studentRepository.findStudents(email_id,enrollment_date);
    }

}