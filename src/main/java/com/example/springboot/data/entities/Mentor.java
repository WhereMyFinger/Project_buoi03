package com.example.springboot.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mentor {

    @Id
    private int user_id;
    private int max_internship;
    private boolean is_active;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMax_internship() {
        return max_internship;
    }

    public void setMax_internship(int max_internship) {
        this.max_internship = max_internship;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }
}
