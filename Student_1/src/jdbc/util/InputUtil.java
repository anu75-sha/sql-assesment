package jdbc.util;

import jdbc.dto.StudentDTO;
import jdbc.enums.CourseType;
import jdbc.enums.Gender;
import jdbc.enums.Grade;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InputUtil {


    public static int acceptMenuOption(Scanner sc){
        System.out.println("1. Add a new students.");
        System.out.println("2. Fetch student details.");
        System.out.println("3. Update course details.");
        System.out.println("4. Delete student records.");
        System.out.println("5. Fetch all students.");
        System.out.println("6. Fetch student details by email id and enrollment date.");
        System.out.print("ENTER THE OPTION : ");
        int menuOption = sc.nextInt();
        if (menuOption == 1 || menuOption == 2 || menuOption == 3 || menuOption == 4 || menuOption == 5 || menuOption == 6) {
            return menuOption;
        } else {
            return acceptMenuOption(sc);
        }
    }

    public static StudentDTO acceptStudentDetailsToSave(Scanner sc){

        System.out.print("Enter id of student:");
        int id=sc.nextInt();
        System.out.print("Enter first name of student:");
        String first_name=sc.next();
        System.out.print("Enter last name of student:");
        String last_name=sc.next();
        System.out.print("Enter gender of student:" + Arrays.asList(Gender.values()));
        String gender= sc.next().toUpperCase();
        System.out.print("Enter city of student:");
        String city=sc.next();
        System.out.print("Enter state of student:");
        String state=sc.next();
        System.out.print("Enter mobile number of student:");
        String mobile_number=sc.next();
        System.out.print("Enter email id of student:");
        String email_id=sc.next();
        System.out.print("Enter id of course:");
        int course_id=sc.nextInt();
        System.out.print("Enter course name of student:");
        String course_name=sc.next();
        System.out.print("Enter enrollment date of student (dd-MM-yyyy):");
        String enrollment_date=sc.next();
        System.out.print("Enter course type of student:" + Arrays.asList(CourseType.values()));
        String course_type= sc.next().toUpperCase();
        System.out.print("Enter grade of student:" + Arrays.asList(Grade.values()));
        String grade= sc.next().toUpperCase();
        try {
            StudentDTO studentDTO=new StudentDTO();
            studentDTO.setId(id);
            studentDTO.setFirst_name(first_name);
            studentDTO.setLast_name(last_name);
            studentDTO.setGender(Gender.valueOf(gender));
            studentDTO.setCity(city);
            studentDTO.setState(state);
            studentDTO.setMobile_number(mobile_number);
            studentDTO.setEmail_id(email_id);
            studentDTO.setCourse_id(course_id);
            studentDTO.setCourse_name(course_name);
            studentDTO.setEnrollment_date(convertStringToDate(enrollment_date));
            studentDTO.setCourse_type(CourseType.valueOf(course_type));
            studentDTO.setGrade(Grade.valueOf(grade));
            return studentDTO;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return acceptStudentDetailsToSave(sc);
        }

    }

    public static StudentDTO convertStudentResultSetToDto(ResultSet rs) throws SQLException {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(rs.getInt("id"));
        studentDTO.setFirst_name(rs.getString("first_name"));
        studentDTO.setLast_name(rs.getString("last_name"));
        studentDTO.setGender(Gender.valueOf(rs.getString("gender")));
        studentDTO.setCity(rs.getString("city"));
        studentDTO.setState(rs.getString("state"));
        studentDTO.setMobile_number(rs.getString("mobile_number"));
        studentDTO.setEmail_id(rs.getString("email_id"));
        studentDTO.setCourse_id(rs.getInt("course_id"));
        studentDTO.setCourse_name(rs.getString("course_name"));
        studentDTO.setEnrollment_date(rs.getDate("enrollment_date").toLocalDate());
        studentDTO.setCourse_type(CourseType.valueOf(rs.getString("course_type")));
        studentDTO.setGrade(Grade.valueOf(rs.getString("grade")));

        return studentDTO;
    }

    public static LocalDate convertStringToDate(String stringDate) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(stringDate, format);
    }

    public static boolean wantToContinue(Scanner sc) {
        System.out.print("Press Y to continue and N to exit [Y/N] : ");
        char choice = sc.next().toUpperCase().charAt(0);
        return 'Y' == choice;
    }

    public static int acceptIdToOperate(Scanner sc) {
        System.out.print("Enter id of student:");
        return sc.nextInt();
    }

    public static String acceptStudentDetailsToUpdate(Scanner sc) {
        System.out.print("Enter NEW COURSE detail:");
        return sc.next();
    }

    public static String acceptStudentEmailIdToOperate(Scanner sc) {
        System.out.print("Enter email id of student:");
        sc.nextLine();
        return sc.nextLine();
    }

    public static LocalDate acceptDateToOperate(Scanner sc) {
        System.out.print("Enter Enrollment date (dd-MM-yyyy):");
        return convertStringToDate(sc.next());
    }
}
