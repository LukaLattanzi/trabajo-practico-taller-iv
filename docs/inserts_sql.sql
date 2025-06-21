CREATE DATABASE IF NOT EXISTS taller_iv_db;
USE taller_iv_db;

INSERT INTO hospitals (id, name, address_street, address_city, address_state, address_postal_code, address_country, phone_country_code, phone_number, phone_extension)
VALUES 
(1, 'Hospital Central', 'Av. Siempre Viva 123', 'Springfield', 'SP', '1000', 'Argentina', '+54', '123456789', NULL),
(2, 'Clínica del Sol', 'Av. Libertad 456', 'Buenos Aires', 'BA', '2000', 'Argentina', '+54', '987654321', '123');

INSERT INTO persons (id, title, first_name, last_name, birth_date, gender, home_street, home_city, home_state, home_postal_code, home_country, phone)
VALUES 
(1, 'Dr.', 'Juan', 'Pérez', '1980-05-10', 'MALE', 'Calle 1', 'Springfield', 'SP', '1000', 'Argentina', '111111111'),
(2, 'Sra.', 'Ana', 'García', '1990-08-22', 'FEMALE', 'Calle 2', 'Springfield', 'SP', '1000', 'Argentina', '222222222'),
(3, 'Sr.', 'Carlos', 'López', '1975-12-01', 'MALE', 'Calle 3', 'Springfield', 'SP', '1000', 'Argentina', '333333333'),
(4, 'Dra.', 'María', 'Rodríguez', '1985-03-15', 'FEMALE', 'Av. Colón 101', 'Buenos Aires', 'BA', '2000', 'Argentina', '444444444');

INSERT INTO departments (id, name, hospital_id)
VALUES 
(1, 'Cardiología', 1),
(2, 'Pediatría', 1),
(3, 'Neurología', 2);

INSERT INTO staff (person_id, joined, department_id)
VALUES 
(1, '2010-03-15', 1), -- Juan Pérez, Cardiología
(2, '2015-07-01', 2), -- Ana García, Pediatría
(4, '2012-09-10', 3); -- María Rodríguez, Neurología

INSERT INTO patients (person_id, age, accepted, hospital_id)
VALUES 
(3, 48, '2024-06-01', 1); -- Carlos López, Hospital Central

-- staff_education
INSERT INTO staff_education (staff_id, education)
VALUES 
(1, 'Médico UBA'),
(2, 'Pediatra UNC'),
(4, 'Especialista en Neurología UBA');

-- staff_certification
INSERT INTO staff_certification (staff_id, certification)
VALUES 
(1, 'Certificado Cardiología'),
(2, 'Certificado Pediatría'),
(4, 'Certificado Neurología');

-- staff_languages
INSERT INTO staff_languages (staff_id, language)
VALUES 
(1, 'Español'),
(1, 'Inglés'),
(2, 'Español'),
(4, 'Español');

-- patient_prescriptions
INSERT INTO patient_prescriptions (patient_id, prescription)
VALUES 
(3, 'Aspirina 100mg'),
(3, 'Paracetamol 500mg');

-- patient_allergies
INSERT INTO patient_allergies (patient_id, allergy)
VALUES 
(3, 'Penicilina');

-- patient_special_reqs
INSERT INTO patient_special_reqs (patient_id, special_req)
VALUES 
(3, 'Dieta baja en sal');