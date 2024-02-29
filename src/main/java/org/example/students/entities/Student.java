package org.example.students.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "students")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "patronymic", nullable = false)
    private String patronymic;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @ManyToOne
    @MapsId("group_id")
    private Group group;

    @OneToMany(mappedBy = "student")
    private List<StudentActivity> activities;

    @OneToMany(mappedBy = "student")
    private List<ScientificPublication> publications;

}