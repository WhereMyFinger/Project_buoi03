package com.example.springboot.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class CompanyCard {

    @Id
    private String id;
    private boolean using_flg;
    private boolean is_del_flg;
    private int created_id;
    private Date created_at;
    private int modified_id;
    private Date modified_at;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isUsing_flg() {
        return using_flg;
    }

    public void setUsing_flg(boolean using_flg) {
        this.using_flg = using_flg;
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
