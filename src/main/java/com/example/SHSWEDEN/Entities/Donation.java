package com.example.SHSWEDEN.Entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Donation {
    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "NameOrganisation", nullable = false, length = 50)
    private String nameOrganisation;

    @Size(max = 200)
    @NotNull
    @Column(name = "Description", nullable = false, length = 200)
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOrganisation() {
        return nameOrganisation;
    }

    public void setNameOrganisation(String nameOrganisation) {
        this.nameOrganisation = nameOrganisation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}