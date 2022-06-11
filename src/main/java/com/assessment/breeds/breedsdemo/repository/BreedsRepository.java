package com.assessment.breeds.breedsdemo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assessment.breeds.breedsdemo.entity.Breeds;

import java.util.List;

/*
* * Breeds Repository
*/
@Repository
public interface BreedsRepository extends JpaRepository<Breeds, Long> {

    // Get the cat data by id
    // View all the data of specific cat
    @Query(value = "SELECT * FROM breeds where breed_id = :breedId", nativeQuery = true)
    List<Breeds> findCatById(String breedId);
}
