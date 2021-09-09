package com.technicalTask.model;

import javax.persistence.*;

@Entity
@Table
public class Mkb {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String code;
    @Column(name = "title")
    private String diagnosis;

    public Mkb() {
    }

    public Mkb(String code, String diagnosis) {
        this.code = code;
        this.diagnosis = diagnosis;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}
