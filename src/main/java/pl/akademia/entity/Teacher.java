package pl.akademia.entity;



import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name="teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name = "last_Name", nullable = false)
    private String lastName;

    @Column(name = "employment_Date", nullable = false)
    private Date employmentDate;

    @Column(name = "subject")
    private String subject;

}
