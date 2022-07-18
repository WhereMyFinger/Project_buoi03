package com.example.springboot.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class InternshipTimesheet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    /*@ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Internship internship;*/
    @Column(insertable = false, updatable = false)
    private int internship_id;
    private Date working_day;
    private String time;
    private boolean is_del_flg;
    private int created_id;
    private Date created_at;
    private int modified_id;
    private Date modified_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*public Internship getInternship() {
        return internship;
    }

    public void setInternship(Internship internship) {
        this.internship = internship;
    }*/

    public int getInternship_id() {
        return internship_id;
    }

    public void setInternship_id(int internship_id) {
        this.internship_id = internship_id;
    }

    public Date getWorking_day() {
        return working_day;
    }

    public void setWorking_day(Date working_day) {
        this.working_day = working_day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isIs_del_flg() {
        return is_del_flg;
    }

    public void setIs_del_flg(boolean is_del_flg) {
        this.is_del_flg = is_del_flg;
    }

    public int getCreated_id() {
        return created_id;
    }

    public void setCreated_id(int created_id) {
        this.created_id = created_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public int getModified_id() {
        return modified_id;
    }

    public void setModified_id(int modified_id) {
        this.modified_id = modified_id;
    }

    public Date getModified_at() {
        return modified_at;
    }

    public void setModified_at(Date modified_at) {
        this.modified_at = modified_at;
    }
}
