package pl.akademia.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="class_teacher")
public class ClassTeacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="class_Name")
    private String className;

    @OneToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;
}
