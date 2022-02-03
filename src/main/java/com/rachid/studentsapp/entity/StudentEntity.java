package com.rachid.studentsapp.entity;

import com.rachid.studentsapp.validators.ValidId;
import org.springframework.context.annotation.PropertySource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@PropertySource(value={"classpath:messages.properties"})
@Table(name = "student")
public class StudentEntity {

    @Id
    @ValidId(lower = 10 , message = "{messageId}")
    @Column(name = "ID")
    private Integer id;

    @NotBlank(message = "{messageName}")
    @Column(name = "NAME")
    private String name;

    @Column(name = "ROLL_NUMBER")
    @Pattern(regexp = "^[0-9A-Z]*$", message = "roll No accept only alphanumeric")
    private String rollNo;

    @Column(name = "ADDRESS")
    private String address;

    public StudentEntity() {
    }

    public StudentEntity(String name, String rollNo, String address) {
        this.name = name;
        this.rollNo = rollNo;
        this.address = address;
    }

    public StudentEntity(Integer id, @NotBlank(message = "please add student name. ")String name, String rollNo, String address) {
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rollNo='" + rollNo + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}