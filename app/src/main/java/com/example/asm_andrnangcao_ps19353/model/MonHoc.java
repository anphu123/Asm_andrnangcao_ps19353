package com.example.asm_andrnangcao_ps19353.model;

import java.io.Serializable;

public class MonHoc implements Serializable {
    private String code;
    private String name;
    private String teacher;
    private int isRegister;


    public MonHoc(String code, String name, String teacher) {
        this.code = code;
        this.name = name;
        this.teacher = teacher;
    }

    public MonHoc(String code, String name, String teacher, int isRegister) {
        this.code = code;
        this.name = name;
        this.teacher = teacher;
        this.isRegister = isRegister;
    }

    public int getIsRehidter() {
        return isRegister;
    }

    public void setIsRehidter(int isRehidter) {
        this.isRegister = isRegister;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
