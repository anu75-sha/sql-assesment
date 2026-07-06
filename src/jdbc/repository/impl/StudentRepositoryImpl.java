package jdbc.repository.impl;

import jdbc.connection.DBConnectionUtil;
import jdbc.dto.StudentDTO;
import jdbc.exception.InternalServiceException;
import jdbc.repository.StudentRepository;
import jdbc.util.InputUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    @Override
    public void saveStudent(StudentDTO student) {
        String sql="INSERT INTO STUDENT (id,first_name,last_name,gender,city,state,mobile_number,email_id,course_id," +
                "course_name,enrollment_date,course_type,grade)VALUES \n" +
                "(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try(Connection con= DBConnectionUtil.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setInt(1, student.getId());
            ps.setString(2,student.getFirst_name());
            ps.setString(3,student.getLast_name());
            ps.setString(4, String.valueOf(student.getGender()));
            ps.setString(5,student.getCity());
            ps.setString(6,student.getState());
            ps.setString(7,student.getMobile_number());
            ps.setString(8,student.getEmail_id());
            ps.setInt(9,student.getCourse_id());
            ps.setString(10,student.getCourse_name());
            ps.setDate(11, Date.valueOf(student.getEnrollment_date()));
            ps.setString(12,student.getCourse_type().toString());
            ps.setString(13,student.getGrade().toString());
            ps.executeUpdate();
        }catch (SQLException e){
            throw new InternalServiceException(e.getMessage());
        }
    }

    @Override
    public StudentDTO findStudent(int studentId) {
        String sql="SELECT * FROM STUDENT where ID=?";
        StudentDTO studentDTO=null;
        try (Connection con=DBConnectionUtil.getConnection();
             PreparedStatement ps=con.prepareStatement(sql)){
            ps.setInt(1,studentId);
            try (ResultSet rs=ps.executeQuery()){
                while (rs.next()){
                    studentDTO= InputUtil.convertStudentResultSetToDto(rs);
                }
            }
        }catch (SQLException e){
            throw new InternalServiceException(e.getMessage());
        }
        return studentDTO;
    }



    @Override
    public void updateCourseDetail(int studentId, String course_name) {
        String sql="UPDATE STUDENT SET course_name = ? WHERE id = ?";
        try(Connection con=DBConnectionUtil.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,course_name);
            ps.setInt(2,studentId);

            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteStudent(int studentId) {
        String sql="DELETE FROM STUDENT WHERE id = ?";
        try(Connection con=DBConnectionUtil.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){
            ps.setInt(1,studentId);
            ps.executeUpdate();
        }catch (SQLException e){
            throw new InternalServiceException(e.getMessage());
        }
    }

    @Override
    public List<StudentDTO> findAllStudents() {
        String sql="SELECT * FROM STUDENT";
        List<StudentDTO> StudentList = new ArrayList<>();
        try(Connection con=DBConnectionUtil.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                StudentList.add(InputUtil.convertStudentResultSetToDto(rs));
            }
        }catch (SQLException e){
            throw new InternalServiceException(e.getMessage());
        }
        return StudentList;
    }

    @Override
    public List<StudentDTO> findStudents(String email_id, LocalDate enrollment_date) {
        String sql="SELECT * FROM STUDENT WHERE email_id = ? AND enrollment_date = ?";
        List<StudentDTO> StudentList = new ArrayList<>();
        try(Connection con=DBConnectionUtil.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,email_id);
            ps.setDate(2,Date.valueOf(enrollment_date));
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                StudentList.add(InputUtil.convertStudentResultSetToDto(rs));
            }
            System.out.println("STUDENT DETAIL FIND SUCCESSFULLY");
        }catch (SQLException e){
            throw new InternalServiceException(e.getMessage());
        }
        return StudentList;
    }

}
