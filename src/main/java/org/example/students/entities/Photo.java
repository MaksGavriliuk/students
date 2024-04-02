package org.example.students.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.experimental.Accessors;


@Entity
@Table(name = "photos")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "photo", columnDefinition = "BYTEA")
    private byte[] photo;

    @Column(name = "format")
    private String format;

}