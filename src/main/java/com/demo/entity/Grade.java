package com.demo.entity;

import java.io.Serializable;

/**
 * (Grade)实体类
 *
 * @author makejava
 * @since 2021-07-03 17:09:15
 */
public class Grade implements Serializable {
    private static final long serialVersionUID = -66711974614896257L;
    /**
     * 班级id
     */
    private Integer classId;
    /**
     * 班主任
     */
    private String teaName;
    /**
     * 年龄
     */
    private Integer teaAge;
    /**
     * 性别
     */
    private String teaSex;


    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public Integer getTeaAge() {
        return teaAge;
    }

    public void setTeaAge(Integer teaAge) {
        this.teaAge = teaAge;
    }

    public String getTeaSex() {
        return teaSex;
    }

    public void setTeaSex(String teaSex) {
        this.teaSex = teaSex;
    }

}
