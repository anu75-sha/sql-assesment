package jdbc.dto;

import jdbc.enums.CourseType;
import jdbc.enums.Gender;
import jdbc.enums.Grade;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;


@Getter
@Setter
@ToString
public class StudentDTO {
    private int id;
    private String first_name;
    private String last_name;
    private Gender gender;
    private String city;
    private String state;
    private String mobile_number;
    private String email_id;
    private int course_id;
    private String course_name;
    private LocalDate enrollment_date;
    private CourseType course_type;
    private Grade grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public LocalDate getEnrollment_date() {
        return enrollment_date;
    }

    public void setEnrollment_date(LocalDate enrollment_date) {
        this.enrollment_date = enrollment_date;
    }

    public CourseType getCourse_type() {
        return course_type;
    }

    public void setCourse_type(CourseType course_type) {
        this.course_type = course_type;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
