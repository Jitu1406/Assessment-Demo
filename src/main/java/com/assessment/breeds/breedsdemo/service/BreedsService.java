package com.assessment.breeds.breedsdemo.service;

import java.util.List;


import com.assessment.breeds.breedsdemo.constant.dto.BreedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.breeds.breedsdemo.entity.Breeds;
import com.assessment.breeds.breedsdemo.repository.BreedsRepository;

/*
* Breeds Service
*/

@Service
public class BreedsService {

    @Autowired
    private BreedsRepository breedsRepository;
 
    /*
     * save the breeds object
     */
    public Breeds saveCat(Breeds breed) {
        return breedsRepository.save(breed);
    }

    /*
     * view all breeds
     */
    public List<Breeds> findAllBreeds() {
        return breedsRepository.findAll();
    }

    /*
     * delete specific breeds
     */
    public void deleteCat(Breeds breedId) {
        breedsRepository.delete(breedId);
    }

    /* find by specific cat by id  */
    public List<Breeds> findCat(String employeeId) {
        return breedsRepository.findCatById(employeeId);
    }

}
