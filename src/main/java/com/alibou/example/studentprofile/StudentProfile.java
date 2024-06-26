package com.alibou.example.studentprofile;


import com.alibou.example.student.Student;
import jakarta.persistence.*;

@Entity
public class StudentProfile {


    @Id
    @GeneratedValue
    private Integer id;

    private String bio;
    @OneToOne
    @JoinColumn(name = "students_id")
    private Student student;




    public StudentProfile() {
    }

    public StudentProfile(String bio) {
        this.bio = bio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
