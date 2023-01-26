package com.example.SHSWEDEN.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class City {
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "CityName", length = 50)
    private String cityName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

}