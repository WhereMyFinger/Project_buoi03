package com.example.springboot.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Internship {

    @Id
    private int user_id;
    private Date birthday;
    /*@ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private University university;*/
    private int university_id;
    private int  scholastic;
    private String identity_card;
    private int mentor_id;
    private String company_card_id;
    private int position_id;
    private int status;
    private int level;
    private String memo;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /*public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }*/

    public int getUniversity_id() {
        return university_id;
    }

    public void setUniversity_id(int university_id) {
        this.university_id = university_id;
    }

    public int getScholastic() {
        return scholastic;
    }

    public void setScholastic(int scholastic) {
        this.scholastic = scholastic;
    }

    public String getIdentity_card() {
        return identity_card;
    }

    public void setIdentity_card(String identity_card) {
        this.identity_card = identity_card;
    }

    public int getMentor_id() {
        return mentor_id;
    }

    public void setMentor_id(int mentor_id) {
        this.mentor_id = mentor_id;
    }

    public String getCompany_card_id() {
        return company_card_id;
    }

    public void setCompany_card_id(String company_card_id) {
        this.company_card_id = company_card_id;
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
