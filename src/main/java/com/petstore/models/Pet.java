package com.petstore.models;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pet_animal")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(nullable = false, length = 50)
    private String name;

    private String breed;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PetType types;



    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PetSex sex;


    @Column(nullable = false)
    private Integer age;



    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "store_pets")
    private Store petStore;

    public Store getPetStore() {
        return petStore;
    }

    public void setPetStore(Store petStore) {
        this.petStore = petStore;
    }

    private Date birthDate;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pet{");
        sb.append("Id=").append(Id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", breed='").append(breed).append('\'');
        sb.append(", types=").append(types);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", birthDate=").append(birthDate);
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public PetType getTypes() {
        return types;
    }

    public void setTypes(PetType types) {
        this.types = types;
    }

    public PetSex getSex() {
        return sex;
    }

    public void setSex(PetSex sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
