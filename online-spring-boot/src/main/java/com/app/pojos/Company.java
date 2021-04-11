package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comp_id")
    private Integer compId;

    @Column(name = "comp_title")
    private String compTitle;

    @Column(name = "comp_description")
    private String compDescription;

    
    public Integer getCompId() {
        return this.compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getCompTitle() {
        return this.compTitle;
    }

    public void setCompTitle(String compTitle) {
        this.compTitle = compTitle;
    }

    public String getCompDescription() {
        return this.compDescription;
    }

    public void setCompDescription(String compDescription) {
        this.compDescription = compDescription;
    }
}
