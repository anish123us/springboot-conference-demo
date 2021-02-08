package com.pluralsight.conferencedemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "speakers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long speaker_id;

    String first_name;
    String last_name;
    String title;
    String company;
    String speaker_bio;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    byte[] speaker_photo;

    @ManyToMany(mappedBy = "speakers")
    @JsonIgnore
    List<Session> sessions;
}
