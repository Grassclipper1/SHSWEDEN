package com.example.SHSWEDEN.Entities;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class ZipCode {
    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 10)
    @Column(name = "ZipCode", length = 10)
    private String zipCode;

    //    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "CityId")
    @Column(name = "CityId")
    private String city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}