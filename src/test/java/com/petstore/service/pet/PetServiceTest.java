package com.petstore.service.pet;

import com.petstore.models.Pet;
import com.petstore.repository.PetRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PetServiceTest {

    @Mock
    PetRepository petRepository;

    @InjectMocks
    PetService petService;

    Pet testPet;


    @BeforeEach
    void setUp() {
        petService = new PetServiceImpl();


        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save(){
        when(petService.save(testPet)).thenReturn (testPet);
        petService.save(testPet);

        verify(petRepository, times(1)).save(testPet);
    }


    @Test
    void findById(){
        when(petService.findById(11)).thenReturn(Optional.of(testPet));
        petService.findById(11);

        verify(petRepository, times(1)).save(testPet);
    }



    @Test
    void update(){
    when(petService.update(testPet)).thenReturn(testPet);
    petService.update(testPet);

    verify(petRepository, times(1)).save(testPet);
    }

    @Test
    void delete(){
    doNothing().when(petService).delete(11);
    petService.delete(11);

    }

    @Test
    void findAll(){
    List<Pet> petList = new ArrayList<>();
    when(petService.findAll()).thenReturn(petList);
    petService.findAll();

    verify(petRepository, times(1)).findAll();

    }

    @AfterEach
    void tearDown() {
    }



}