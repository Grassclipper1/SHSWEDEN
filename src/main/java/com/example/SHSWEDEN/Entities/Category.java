package com.example.SHSWEDEN.Entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Category {
    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "CategoryName", nullable = false, length = 50)
    private String categoryName;

    @NotNull
    @Column(name = "CategoryId", nullable = false)
    private Integer categoryId;

    @NotNull
    @Column(name = "CategoryLevel", nullable = false)
    private Integer categoryLevel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCategoryLevel() {
        return categoryLevel;
    }

    public void setCategoryLevel(Integer categoryLevel) {
        this.categoryLevel = categoryLevel;
    }

}