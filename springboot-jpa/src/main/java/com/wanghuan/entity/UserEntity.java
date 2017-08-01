package com.wanghuan.entity;

import com.wanghuan.base.BaseEntity;
import org.hibernate.loader.entity.plan.AbstractLoadPlanBasedEntityLoader;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 54416 on 2017/8/1.
 */
@Entity
@Table(name = "t_user")
public class UserEntity extends BaseEntity  implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "t_id")
    private Long id;

    @Column(name = "t_name")
    private String name;

    @Column(name = "t_age")
    private int age;

    @Column(name = "t_address")
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
