package jdbc.main;

import jdbc.dto.StudentDTO;
import jdbc.service.StudentService;
import jdbc.service.impl.StudentServiceImpl;
import jdbc.util.InputUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        App app=new App();
        app.start();
    }

    public void start(){
        StudentService studentService =new StudentServiceImpl();
        System.out.println("WELCOME TO STUDENT DATABASE");
        try (Scanner sc=new Scanner(System.in)){
            do{
                int choice=InputUtil.acceptMenuOption(sc);
                switch (choice){
                    case 1:
                        System.out.println("Enter student details");
                        StudentDTO studentDTO=InputUtil.acceptStudentDetailsToSave(sc);
                        studentService.saveStudent(studentDTO);
                        System.out.println("Student details saved successfully...!!!");
                        break;
                    case 2:
                        int studentid=InputUtil.acceptIdToOperate(sc);
                        studentDTO=studentService.findStudent(studentid);
                        System.out.println(studentDTO);
                        break;
                    case 3:
                        studentid=InputUtil.acceptIdToOperate(sc);
                        String course_name=InputUtil.acceptStudentDetailsToUpdate(sc);

                        studentService.updateCourseDetail(studentid,course_name);
                        System.out.println("Student COURSE NAME updated successfully...");
                        break;
                    case 4:
                        studentid=InputUtil.acceptIdToOperate(sc);
                        studentService.deleteStudent(studentid);
                        System.out.println("STUDENT details deleted successfully");
                        break;
                    case 5:
                        studentService.findAllStudents();
                        List<StudentDTO> StudentList = studentService.findAllStudents();
                        StudentList.forEach(System.out::println);
                        System.out.println("THIS ARE OUR STUDENT DETAILS");
                        break;
                    case 6:
                        String EmailId=InputUtil.acceptStudentEmailIdToOperate(sc);
                        LocalDate enrollment_Data=InputUtil.acceptDateToOperate(sc);
                        StudentList=studentService.finStudents(EmailId,enrollment_Data);
                        StudentList.forEach(System.out::println);
                        break;
                    default:
                        System.out.println("Invalid choice...!!!");
                        break;
                }
            }while (InputUtil.wantToContinue(sc));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
