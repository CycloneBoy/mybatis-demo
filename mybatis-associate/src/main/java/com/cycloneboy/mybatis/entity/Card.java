package com.cycloneboy.mybatis.entity;

/**
 * Created by CycloneBoy on 2017/7/21.
 */
public class Card {
    private int id;
    private String code;

    public Card() {
    }

    public Card(int id, String code) {
        this.id = id;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}
