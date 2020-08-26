SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE pet_animal;

INSERT INTO pet_animal(`id`,`name`, breed,Types,sex,age)
VALUES (200,'booby','german sherpard','DOG','MALE',15),
(100,'booby','german sherpard','DOG','MALE',15),
(300,'booby','german sherpard','DOG','MALE',15),
(1200,'booby','german sherpard','DOG','MALE',15),
(80,'booby','german sherpard','DOG','MALE',15),
(60,'booby','german sherpard','DOG','MALE',15),
(50,'booby','german sherpard','DOG','MALE',15);

SET FOREIGN_KEY_CHECKS = 1;