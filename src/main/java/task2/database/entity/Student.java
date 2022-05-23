package task2.database.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Student {
    private Integer id;
    private String name;
    private String secondName;
    private String surname;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private Integer group;

    public Student() {
    }
    public Student(Integer id, String name, String secondName, String surname, LocalDate birthDate, Integer group) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.surname = surname;
        this.birthDate = birthDate;
        this.group = group;
    }

    public Student(String name, String secondName, String surname, LocalDate birthDate, Integer group) {
        this.name = name;
        this.secondName = secondName;
        this.surname = surname;
        this.birthDate = birthDate;
        this.group = group;
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", secondName='" + secondName + '\'' +
               ", surname='" + surname + '\'' +
               ", birthDate=" + birthDate +
               ", group=" + group +
               '}';
    }
}
