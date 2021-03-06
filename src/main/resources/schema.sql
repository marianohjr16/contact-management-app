CREATE TABLE IDENTIFICATION(
  IDENTIFICATION_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  FIRST_NAME VARCHAR(50) NOT NULL,
  LAST_NAME VARCHAR(50) NOT NULL,
  DOB DATE,
  GENDER VARCHAR(1) NOT NULL,
  TITLE VARCHAR(12) NOT NULL
);

CREATE TABLE ADDRESS(
  ADDRESS_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  IDENTIFICATION_ID BIGINT,
  TYPE VARCHAR(16) NOT NULL,
  NUMBER VARCHAR(10),
  STREET VARCHAR(64),
  UNIT VARCHAR(64),
  CITY VARCHAR(64),
  STATE VARCHAR(64),
  ZIPCODE VARCHAR(5)
);

CREATE TABLE COMMUNICATION(
  COMMUNICATION_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  IDENTIFICATION_ID BIGINT,
  TYPE VARCHAR(16) NOT NULL,
  VALUE VARCHAR(64) NOT NULL,
  PREFERRED VARCHAR(16) NOT NULL
);

--ALTER TABLE ADDRESS ADD FOREIGN KEY (IDENTIFICATION_ID) REFERENCES IDENTIFICATION(IDENTIFICATION_ID);
--ALTER TABLE COMMUNICATION ADD FOREIGN KEY (IDENTIFICATION_ID) REFERENCES IDENTIFICATION(IDENTIFICATION_ID);
