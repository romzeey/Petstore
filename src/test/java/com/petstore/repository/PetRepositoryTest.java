package com.petstore.repository;

import com.petstore.models.Pet;
import com.petstore.models.PetSex;
import com.petstore.models.PetType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Sql(scripts = {"classpath:db\\insert_pet.sql"})
class PetRepositoryTest {
    Logger log = Logger.getLogger(getClass().getName());
    @Autowired
    PetRepository petRepository;

    Pet testPetDate;

    @BeforeEach
    void setUp() {
        testPetDate = petRepository.findById(200).orElse(null);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createPetObject_thenSaveToDatabaseTest(){

        Pet pet =new Pet();
        pet.setAge(5);
        pet.setName("Lucky");
        pet.setSex(PetSex.MALE);
        pet.setTypes(PetType.DOG);
        pet.setBreed("bull dog");
        pet.setBirthDate(new Date());

        log.info( "created pet object --> " + pet);
        assertThat(pet.getId()).isNull();

        //save object in db
        pet = petRepository.save(pet);
        log.info("after saving pet object---->" + pet);
        assertThat(pet.getId()).isNotNull();

    }
    @Test
    void whenFindAllPetsiscalled_thenRetrievePetsListTest(){
        List<Pet> allPet = petRepository.findAll();
        assertThat(allPet.size()).isEqualTo(7);
        log.info("all parts retrieved from the database--->" + allPet);


    }
    @Test
    void whenPetDetailIsUpdated_thenUpdateDatabaseDetails() {
        assertThat(testPetDate.getName()).isEqualTo("bobby");

        testPetDate = petRepository.save(testPetDate);
        assertThat(testPetDate.getName()).isEqualTo("jiran");
    }
    @Test
    void whendeleteiscalled_thenDeletePetsListTest(){
        List<Pet> allPet = petRepository.findAll();
        assertThat(allPet).isNotNull();
        assertThat(allPet.size()).isEqualTo(7);


        Pet savedPet = petRepository.findById(100).orElse(null);
        assertThat(savedPet).isNotNull();
        petRepository.deleteById(100);

        Pet deletedPet =petRepository.findById(100).orElse(null);
        assertThat(deletedPet).isNull();

        allPet =petRepository.findAll();
        assertThat(allPet).isNotNull();
        assertThat(allPet.size()).isEqualTo(6);

    }
}