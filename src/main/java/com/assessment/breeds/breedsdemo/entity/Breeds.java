package com.assessment.breeds.breedsdemo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* Breeds Table
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Breeds {

    @Id
    private String breedId;

    private String breedName;
    
    private String breedGroup;
    
    private Long weight;

}