package com.bitinbyte.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * InstructorDetail
 */
@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

    // Annotate the class as an entity and map to db table
    // Define the fields
    // Annotate the fields with db column names
    // Create constructors
    // Generate getter/setter methods
    // Generate toString() method

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtube;

    @Column(name = "hobby")
    private String hobby;

    // Add new field for Instructor (also add getter/setters)
    // Add @OneToOne annotation
    // @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
    // Only delete this side of the relation
    @OneToOne(mappedBy = "instructorDetail", cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST,
            CascadeType.REFRESH })
    private Instructor instructor;

    public InstructorDetail() {
    }

    public InstructorDetail(String youtube, String hobby) {
        this.youtube = youtube;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "InstructorDetail [hobby=" + hobby + ", id=" + id + ", youtube=" + youtube + "]";
    }

}
