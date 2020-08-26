package com.petstore.repository;


import com.petstore.models.Pet;
import com.petstore.models.PetSex;
import com.petstore.models.PetType;
import com.petstore.models.Store;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Properties;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = {"classpath:db\\insert_store.sql"})
class StoreRepositoryTest {
    Logger log = Logger.getLogger(getClass().getName());

    @Autowired
    StoreRepository storeRepository;

    Store testStore;

    @BeforeEach
    void setUp() {
        testStore = storeRepository.findById(500).orElse(null);
        assertThat(testStore).isNotNull();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createNewStoreTest() {
        Store londonStore = new Store();
        londonStore.setStoreName("londonStore");
        londonStore.setState("lagos");
        londonStore.setCity("Yaba");
        londonStore.setStoreNumber(1451);
        londonStore.setAddress("12,london street");
        londonStore.setCountry("Nigeria");

        assertThat(londonStore.getId()).isNull();

        londonStore = storeRepository.save(londonStore);

        log.info("store object after saving --->" + londonStore);
        assertThat(londonStore.getId()).isNotNull();

    }

    @Test
    void whenAddPetToStore_thensaveToDbTest(){

            Pet pet = new Pet();
            pet.setName("Jack");
            pet.setBreed("Bull Dog");
            pet.setTypes(PetType.DOG);
            pet.setSex(PetSex.MALE);
            pet.setAge(5);
            pet.setPetStore(testStore);
            testStore.addPet(pet);


        testStore = storeRepository.save(testStore);

        log.info("store object after saving --->" + testStore);




    }

    @Test
    void whenStoreisretrieved_theRetrievedStorePetsTest() {


        Pet pet1 = new Pet();
        pet1.setName("Jack");
        pet1.setBreed("Bull Dog");
        pet1.setTypes(PetType.DOG);
        pet1.setSex(PetSex.MALE);
        pet1.setAge(5);
        pet1.setPetStore(testStore);
        testStore.addPet(pet1);


        Pet pet2 = new Pet();
        pet2.setName("Jack");
        pet2.setBreed("Bull Dog");
        pet2.setTypes(PetType.DOG);
        pet2.setSex(PetSex.MALE);
        pet2.setAge(5);
        pet2.setPetStore(testStore);
        testStore.addPet(pet2);


        //add pets to store
        testStore.addPet(pet1);
        testStore.addPet(pet2);

        //save store
        testStore =storeRepository.save(testStore);
        log.info("stor object saved to the db --->" + testStore);

        Store savedStore = storeRepository.findById(testStore.getId()).orElse(null);
        assertThat(savedStore.getPets()).isNotNull();
        assertThat(savedStore.getPets()).hasSize(2);
    }

    }
