package com.assessment.breeds.breedsdemo.controller;

import java.util.Arrays;
import java.util.List;


import com.assessment.breeds.breedsdemo.constant.dto.BreedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.assessment.breeds.breedsdemo.entity.Breeds;
import com.assessment.breeds.breedsdemo.service.BreedsService;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.assessment.breeds.breedsdemo.constant.API.MAIN_URL;

/* 
 * Breeds Controller
*/
@Controller
public class BreedsController {

    @Autowired
    private BreedsService breedsService;


    // Get the all cat breeds
    @GetMapping("/")
    public String listCats(Model model) {
        getAllCatBreeds();
        model.addAttribute("breeds",breedsService.findAllBreeds());
        return "breeds_data";
    }

    // From to add the new cat
    @GetMapping("/add-new-cat")
    public String createCatForm(Model model) {

        Breeds breeds = new Breeds();
        model.addAttribute("breed", breeds);
        return "add_new_cat";
    }

    // Saving the cat data to database
    @PostMapping("/save/new-cat")
    public String saveCat(Breeds breed) {
        breedsService.saveCat(breed);
        return "redirect:/";
    }

    // Delete the cat by id
    @GetMapping("/deleteCat")
    public String deleteCat( Breeds breedId) {
        breedsService.deleteCat(breedId);
        return "redirect:/";
    }

    // Get the cat by id
    @GetMapping("/getCat")
    public String getCat( String breedId,Model model) {
        model.addAttribute("breeds",breedsService.findCat(breedId));
        return "view_cat";
    }

    /* Fetching cat breeds data from URL */
    private void getAllCatBreeds(){
        RestTemplate restTemplate = new RestTemplate();
        BreedResponse[] result = restTemplate.getForObject(MAIN_URL, BreedResponse[].class);
        for (int i=0;i<result.length;i++){
            Breeds breed = new Breeds();
            breed.setBreedId(result[i].getId());
            breed.setBreedName(result[i].getName());
            breedsService.saveCat(breed);
        }
    }

    
}