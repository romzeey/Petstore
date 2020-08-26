SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE store;
TRUNCATE TABLE pet_animal;

INSERT INTO store(`id`,`store_name`, `store_number`,`address`,`city`,`state`,`country`)
VALUES (200,'Good sherpard','125','12 good street','Yaba','Lagos','Nigeria'),
    (500,'Pet store','124','13 pet street','VI','Lagos','Nigeria'),
    (502,'Puppy lovers','245','17 puppy street','Lekki','Lagos','Nigeria');


SET FOREIGN_KEY_CHECKS = 1;