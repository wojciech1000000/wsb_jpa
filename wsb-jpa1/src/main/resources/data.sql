
INSERT INTO ADDRESS (id, ADDRESS_LINE1, ADDRESS_LINE2, CITY, POSTAL_CODE) 
VALUES
    (1,'123 Main Street', 'Apt 2', 'New York', '10001'),
    (2,'456 Elm Avenue', 'Suite 3', 'Los Angeles', '90001'),
    (3,'789 Oak Road', 'Suite 100', 'Chicago', '60601'),
    (4,'101 Pine Street', 'Floor 5', 'Miami', '33101'),
    (5,'202 Maple Drive', 'Unit B', 'Houston', '77001'),
    (6,'345 Cedar Lane', 'Suite 10', 'San Francisco', '94101'),
    (7,'678 Birch Street', 'Apt 15', 'Seattle', '98101'),
    (8,'901 Walnut Avenue', 'Floor 3', 'Boston', '02101'),
    (9,'234 Oakwood Drive', 'Unit C', 'Philadelphia', '19101'),
    (10,'567 Elmwood Boulevard', 'Suite 20', 'Atlanta', '30301'),
    (11,'890 Pinecrest Drive', 'Floor 4', 'Dallas', '75201'),
    (12,'1234 Maple Avenue', 'Apt 25', 'Denver', '80201'),
    (13,'5678 Cedar Street', 'Unit D', 'Phoenix', '85001'),
    (14,'9012 Oak Lane', 'Suite 30', 'Las Vegas', '89101'),
    (15,'3456 Elm Road', 'Floor 6', 'Orlando', '32801');

INSERT INTO doctor (doctor_number, email, first_name, last_name, specialization, telephone_number, address_id) 
VALUES
    ('DR123', 'jan.kowalski@example.com', 'Jan', 'Kowalski', 'SURGEON', '123456789', 1),
    ('DR456', 'anna.nowak@example.com', 'Anna', 'Nowak', 'OCULIST', '987654321', 2),
    ('DR789', 'adam.nowicki@example.com', 'Adam', 'Nowicki', 'GP', '555123456', 3),
    ('DR1011', 'marta.lewandowska@example.com', 'Marta', 'Lewandowska', 'DERMATOLOGIST', '999987654', 4),
    ('DR1213', 'piotr.mazurek@example.com', 'Piotr', 'Mazurek', 'SURGEON', '777654321', 5);

INSERT INTO medical_treatment (id, description, type) 
VALUES
    (1,'Ultrasonography', 'USG'),
    (2, 'Electrocardiogram', 'EKG'),
    (3, 'Radiography', 'RTG');


INSERT INTO PATIENT (id, first_name, last_name, telephone_number, email, patient_Number, date_of_birth, age, address_id,)
VALUES 
    (1,'Jan', 'Kowalski', '123456789', 'jan.kowalski@example.com', 'P12345', '1990-05-15', 34,6),
    (2,'Anna', 'Nowak', '987654321', 'anna.nowak@example.com', 'A98765', '1985-10-20', 39,7),
    (3,'Michał', 'Wiśniewski', '111222333', 'michal.wisniewski@example.com', 'M54321', '1988-03-03', 32,8),
    (4,'Magdalena', 'Kwiatkowska', '555444333', 'magda.kwiatkowska@example.com', 'MK9876', '1976-12-10', 48,9),
    (5,'Adam', 'Dąbrowski', '666777888','adam.dabrowski@example.com' , 'AD4567', '1995-08-25', 29,10),
    (6,'Barbara', 'Wójcik', '111223344', 'barbara.wojcik@example.com', 'BW2345', '1987-06-18', 34,11),
    (7,'Tomasz', 'Kamiński', '222334455', 'tomasz.kaminski@example.com', 'TK3456', '1980-09-22', 41,12),
    (8,'Katarzyna', 'Lewandowska', '333445566', 'katarzyna.lewandowska@example.com', 'KL4567', '1975-04-14', 47,13),
    (9,'Piotr', 'Woźniak', '444556677', 'piotr.wozniak@example.com', 'PW5678', '1992-11-30', 29,14),
    (10,'Monika', 'Krawczyk', '555667788', 'monika.krawczyk@example.com', 'MK6789', '1983-07-07', 38,15);

INSERT INTO VISIT (id, description, time, doctor_id, medical_treatment_id, patient_id)
VALUES
    (1,'Badanie kontrolne', '2024-05-19 10:00:00', 1, 1, 1),
    (2,'Badanie okulistyczne', '2024-05-19 12:00:00', 2, 2, 2),
    (3,'Badanie serca', '2024-05-20 09:30:00', 3, 3, 3),
    (4,'Konsultacja dermatologiczna', '2024-05-20 14:00:00', 4, 1, 4),
    (5,'Badanie kontrolne', '2024-05-21 11:00:00', 5, 2, 5),
    (6,'Badanie chirurgiczne', '2024-05-21 13:30:00', 1, 1, 1),
    (7,'Badanie kontrolne', '2024-05-22 10:45:00', 2, 2, 2),
    (8,'Konsultacja dermatologiczna', '2024-05-23 14:30:00', 4, 1, 4),
    (9,'Badanie kontrolne', '2024-05-23 09:15:00', 5, 2, 5),
    (10,'Badanie serca', '2024-05-24 11:20:00', 3, 3, 3);
