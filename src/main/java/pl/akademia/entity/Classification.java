package pl.akademia.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="classification")
public class Classification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="subject")
    private String subject;

    @Column(name="score")
    private int score;

    @Column(name = "student_id", nullable = false)
    private Long studentId;
}
