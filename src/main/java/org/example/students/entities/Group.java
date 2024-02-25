package org.example.students.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;


@Entity
@Table(name = "groups")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_number")
    private String groupNumber;

    @ManyToOne
    @JoinColumn(name = "specialization_id")
    private Specialty specialization;

    @OneToMany(mappedBy = "group")
    private List<Student> students;

}