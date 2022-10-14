package com.ltp.gradesubmission.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "grade", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"student_id","course_id"})
})
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "score")
    private String score;

    @NonNull
//    @JsonIgnore
    @ManyToOne(optional = false)// nambah cascade di Onenya cara 1
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

//    @JsonIgnore
    @ManyToOne(optional = false)// nambah cascade di Onenya cara 1
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Grade grade = (Grade) o;
        return id != null && Objects.equals(id, grade.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
