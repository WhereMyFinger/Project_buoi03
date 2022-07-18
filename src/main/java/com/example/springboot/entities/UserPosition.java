package com.example.springboot.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class UserPosition implements Serializable {

    @Id
    //@Column(name = "user_id", insertable = false, updatable = false)
    private int user_id;
    @Id
    //@Column(insertable = false, updatable = false)
    private int position_id;
    /*@ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Position position;
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Internship internship;
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Mentor mentor;*/
    private boolean is_del_flg;
    private int created_id;
    private Date created_at;
    private int modified_id;
    private Date modified_at;

    @Override
    public boolean equals(Object arg0) {
        if(arg0 == null) return false;
        if(!(arg0 instanceof UserPosition)) return false;
        UserPosition arg1 = (UserPosition) arg0;
        return (this.user_id == arg1.getUser_id()) &&
                (this.position_id == arg1.getPosition_id());
    }

    @Override
    public int hashCode() {
        int hsCode;
        hsCode = user_id;
        hsCode = 19 * hsCode+ position_id;
        return hsCode;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    /*public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Internship getInternship() {
        return internship;
    }

    public void setInternship(Internship internship) {
        this.internship = internship;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }*/

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
