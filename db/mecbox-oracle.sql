BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE mb_user_roles';
EXCEPTION
    WHEN OTHERS THEN NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE mb_users';
EXCEPTION
    WHEN OTHERS THEN NULL;
END;
/
CREATE TABLE mb_users (
  userid NUMBER(20) NOT NULL,
  email varchar2(255) NOT NULL,
  name varchar2(100) DEFAULT NULL,
  surname varchar2(100) DEFAULT NULL,
  password varchar2(255) DEFAULT NULL,
  CONSTRAINT pk_mb_users PRIMARY KEY (userid)
);
INSERT INTO mb_users VALUES (1,'admin@mecbox.it','Admin','Mecbox','$2a$10$9rKQEP7mbFoCN82iNx16wuoVQ56WqQBGxbwU2HmDWI0G1BSucJqGW');
INSERT INTO mb_users VALUES (2,'guest@mecbox.it','Guest','Mecbox','$2a$10$QZWKAPfnG2F0MIpANjKVvOzfu8VTvEgoPKEoASh93nO/ysRmnJaVC');


CREATE TABLE mb_user_roles (
  user_role_id NUMBER(20) NOT NULL,
  role varchar2(255) DEFAULT NULL,
  userid number(20) DEFAULT NULL,
  CONSTRAINT pk_mb_user_roles PRIMARY KEY (user_role_id),
  CONSTRAINT fk_user_roles FOREIGN KEY (userid) REFERENCES mb_users (userid)
  );
  
INSERT INTO mb_user_roles VALUES (1,'ADMIN',1);
INSERT INTO mb_user_roles VALUES (2,'USER',2);

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE mb_household';
EXCEPTION
    WHEN OTHERS THEN NULL;
END;
/
CREATE TABLE mb_household (
  region varchar2(17) DEFAULT NULL,
  zone number(2) DEFAULT NULL,
  woreda number(2) DEFAULT NULL,
  city number(1) DEFAULT NULL,
  subcity number(2) DEFAULT NULL,
  psa number(2) DEFAULT NULL,
  sa number(2) DEFAULT NULL,
  kebele number(3) DEFAULT NULL,
  ea number(2) DEFAULT NULL,
  household number(21) DEFAULT '0'
);

INSERT INTO mb_household VALUES ('Addis Ababa',1,1,1,10,1,1,5,4,130);
INSERT INTO mb_household VALUES ('Addis Ababa',1,1,1,4,1,2,6,4,145);
INSERT INTO mb_household VALUES ('Addis Ababa',1,1,1,10,1,1,5,3,119);
INSERT INTO mb_household VALUES ('Addis Ababa',1,1,1,4,1,1,6,3,130);
INSERT INTO mb_household VALUES ('Addis Ababa',1,1,1,7,1,1,6,1,122);
INSERT INTO mb_household VALUES ('Addis Ababa',1,1,1,7,1,1,6,5,97);
INSERT INTO mb_household VALUES ('Addis Ababa',1,1,1,2,1,1,1,2,69);
INSERT INTO mb_household VALUES ('Addis Ababa',1,1,1,4,1,1,6,2,120);
INSERT INTO mb_household VALUES ('Addis Ababa',1,1,1,2,1,1,1,3,158);
INSERT INTO mb_household VALUES ('Addis Ababa',1,1,1,2,1,1,1,1,59);
INSERT INTO mb_household VALUES ('Addis Ababa',1,1,1,7,1,1,6,2,147);
INSERT INTO mb_household VALUES ('Addis Ababa',1,1,1,4,1,2,6,6,141);
INSERT INTO mb_household VALUES ('Addis Ababa',1,1,1,10,1,1,5,1,112);
INSERT INTO mb_household VALUES ('Addis Ababa',1,1,1,10,1,1,5,2,129);
INSERT INTO mb_household VALUES ('Addis Ababa',1,1,1,2,1,1,1,4,99);
INSERT INTO mb_household VALUES ('Addis Ababa',1,1,1,7,1,1,6,3,151);
INSERT INTO mb_household VALUES ('Addis Ababa',1,1,1,7,1,1,6,4,131);
INSERT INTO mb_household VALUES ('Addis Ababa',1,1,1,4,1,1,6,1,190);
INSERT INTO mb_household VALUES ('Addis Ababa',1,1,1,7,1,1,6,6,113);
INSERT INTO mb_household VALUES ('Addis Ababa',1,1,1,4,1,2,6,5,130);
INSERT INTO mb_household VALUES ('Afar',4,1,8,88,1,3,1,1,122);
INSERT INTO mb_household VALUES ('Afar',2,4,8,88,1,1,1,3,222);
INSERT INTO mb_household VALUES ('Afar',2,4,8,88,1,1,1,1,158);
INSERT INTO mb_household VALUES ('Afar',4,1,8,88,1,1,2,3,12);
INSERT INTO mb_household VALUES ('Afar',4,1,8,88,1,2,2,5,73);
INSERT INTO mb_household VALUES ('Afar',4,1,8,88,1,2,2,6,53);
INSERT INTO mb_household VALUES ('Afar',4,1,8,88,1,2,2,4,85);
INSERT INTO mb_household VALUES ('Afar',2,4,8,88,1,1,1,5,135);
INSERT INTO mb_household VALUES ('Afar',4,1,8,88,1,3,1,3,144);
INSERT INTO mb_household VALUES ('Afar',2,4,8,88,1,1,1,4,141);
INSERT INTO mb_household VALUES ('Afar',4,1,8,88,1,1,2,1,9);
INSERT INTO mb_household VALUES ('Afar',2,4,8,88,1,1,1,2,130);
INSERT INTO mb_household VALUES ('Afar',4,1,8,88,1,3,1,2,158);
INSERT INTO mb_household VALUES ('Afar',4,1,8,88,1,1,2,2,70);
INSERT INTO mb_household VALUES ('Amhara',4,5,4,1,1,1,1,2,180);
INSERT INTO mb_household VALUES ('Amhara',5,10,8,88,1,1,18,2,156);
INSERT INTO mb_household VALUES ('Amhara',5,10,8,88,1,2,18,5,146);
INSERT INTO mb_household VALUES ('Amhara',5,10,8,88,1,1,18,1,129);
INSERT INTO mb_household VALUES ('Amhara',9,1,1,1,1,2,8,6,117);
INSERT INTO mb_household VALUES ('Amhara',4,5,8,88,1,1,5,5,109);
INSERT INTO mb_household VALUES ('Amhara',5,11,8,88,1,1,13,4,114);
INSERT INTO mb_household VALUES ('Amhara',4,5,8,88,1,1,5,2,158);
INSERT INTO mb_household VALUES ('Amhara',5,10,8,88,1,2,18,4,160);
INSERT INTO mb_household VALUES ('Amhara',9,1,1,1,1,2,8,7,181);
INSERT INTO mb_household VALUES ('Amhara',5,11,8,88,1,1,13,3,117);
INSERT INTO mb_household VALUES ('Amhara',4,5,4,1,1,1,1,1,149);
INSERT INTO mb_household VALUES ('Amhara',5,11,8,88,1,3,13,5,120);
INSERT INTO mb_household VALUES ('Amhara',4,5,4,1,1,1,1,4,213);
INSERT INTO mb_household VALUES ('Amhara',9,1,1,1,1,1,8,1,33);
INSERT INTO mb_household VALUES ('Amhara',5,11,8,88,1,1,13,1,104);
INSERT INTO mb_household VALUES ('Amhara',4,5,4,1,1,1,1,5,152);
INSERT INTO mb_household VALUES ('Amhara',5,10,8,88,1,1,18,3,143);
INSERT INTO mb_household VALUES ('Amhara',4,5,4,1,1,1,1,3,160);
INSERT INTO mb_household VALUES ('Amhara',5,11,8,88,1,1,13,2,153);
INSERT INTO mb_household VALUES ('Amhara',9,1,1,1,1,1,8,4,39);
INSERT INTO mb_household VALUES ('Amhara',4,5,8,88,1,1,5,3,114);
INSERT INTO mb_household VALUES ('Amhara',9,1,1,1,1,1,8,3,36);
INSERT INTO mb_household VALUES ('Amhara',9,1,1,1,1,2,8,5,181);
INSERT INTO mb_household VALUES ('Amhara',4,5,8,88,1,1,5,1,135);
INSERT INTO mb_household VALUES ('Amhara',4,5,8,88,1,1,5,4,118);
INSERT INTO mb_household VALUES ('Amhara',5,10,8,88,1,2,18,7,4);
INSERT INTO mb_household VALUES ('Amhara',5,10,8,88,1,2,18,6,5);
INSERT INTO mb_household VALUES ('Diredawa',1,1,1,1,1,1,10,5,180);
INSERT INTO mb_household VALUES ('Diredawa',1,1,8,88,1,1,1,3,75);
INSERT INTO mb_household VALUES ('Diredawa',1,1,8,88,1,3,2,4,153);
INSERT INTO mb_household VALUES ('Diredawa',1,1,8,88,1,1,1,2,119);
INSERT INTO mb_household VALUES ('Diredawa',1,1,1,1,1,1,10,2,150);
INSERT INTO mb_household VALUES ('Diredawa',1,1,8,88,1,1,1,1,143);
INSERT INTO mb_household VALUES ('Diredawa',1,1,1,1,1,1,10,3,190);
INSERT INTO mb_household VALUES ('Diredawa',1,1,8,88,1,2,2,2,119);
INSERT INTO mb_household VALUES ('Diredawa',1,1,8,88,1,2,2,3,140);
INSERT INTO mb_household VALUES ('Diredawa',1,1,1,1,1,1,10,4,110);
INSERT INTO mb_household VALUES ('Diredawa',1,1,1,1,1,1,10,1,150);
INSERT INTO mb_household VALUES ('Diredawa',1,1,8,88,1,3,2,5,119);
INSERT INTO mb_household VALUES ('Diredawa',1,1,8,88,1,2,2,1,167);
INSERT INTO mb_household VALUES ('Gambella',1,2,8,88,1,1,2,3,234);
INSERT INTO mb_household VALUES ('Gambella',1,2,8,88,1,1,1,2,257);
INSERT INTO mb_household VALUES ('Gambella',1,2,8,88,1,1,2,2,168);
INSERT INTO mb_household VALUES ('Gambella',1,2,8,88,1,1,2,1,264);
INSERT INTO mb_household VALUES ('Gambella',1,2,8,88,1,1,1,1,278);
INSERT INTO mb_household VALUES ('Harari',1,1,1,1,1,1,2,2,91);
INSERT INTO mb_household VALUES ('Harari',1,1,1,1,1,2,2,5,56);
INSERT INTO mb_household VALUES ('Harari',1,1,8,88,1,1,1,4,100);
INSERT INTO mb_household VALUES ('Harari',1,1,8,88,1,1,1,3,133);
INSERT INTO mb_household VALUES ('Harari',1,1,1,1,1,1,2,3,109);
INSERT INTO mb_household VALUES ('Harari',1,1,8,88,1,1,1,1,131);
INSERT INTO mb_household VALUES ('Harari',1,1,1,1,1,1,2,4,103);
INSERT INTO mb_household VALUES ('Harari',1,1,1,1,1,2,2,7,14);
INSERT INTO mb_household VALUES ('Harari',1,1,1,1,1,1,2,1,107);
INSERT INTO mb_household VALUES ('Harari',1,1,8,88,1,1,1,2,70);
INSERT INTO mb_household VALUES ('Harari',1,1,8,88,1,1,1,5,34);
INSERT INTO mb_household VALUES ('Oromia',5,4,8,88,1,1,1,4,161);
INSERT INTO mb_household VALUES ('Oromia',2,2,8,88,1,1,3,4,96);
INSERT INTO mb_household VALUES ('Oromia',5,4,8,88,1,1,1,1,172);
INSERT INTO mb_household VALUES ('Oromia',5,4,8,88,1,1,1,2,126);
INSERT INTO mb_household VALUES ('Oromia',2,2,8,88,1,1,3,3,108);
INSERT INTO mb_household VALUES ('Oromia',5,7,2,1,1,1,1,2,192);
INSERT INTO mb_household VALUES ('Oromia',5,4,8,88,1,1,1,5,116);
INSERT INTO mb_household VALUES ('Oromia',5,7,2,1,1,1,1,1,247);
INSERT INTO mb_household VALUES ('Oromia',5,4,8,88,1,1,1,3,162);
INSERT INTO mb_household VALUES ('Oromia',2,2,8,88,1,1,3,1,132);
INSERT INTO mb_household VALUES ('SNNP',11,10,8,88,1,2,12,2,165);
INSERT INTO mb_household VALUES ('SNNP',1,2,8,88,1,1,1,3,176);
INSERT INTO mb_household VALUES ('SNNP',11,10,8,88,1,2,12,1,175);
INSERT INTO mb_household VALUES ('SNNP',11,10,8,88,1,1,2,5,121);
INSERT INTO mb_household VALUES ('SNNP',11,10,8,88,1,1,2,4,143);
INSERT INTO mb_household VALUES ('SNNP',11,10,2,1,1,1,11,4,189);
INSERT INTO mb_household VALUES ('SNNP',4,4,1,1,1,1,1,5,185);
INSERT INTO mb_household VALUES ('SNNP',10,9,8,88,1,1,1,1,232);
INSERT INTO mb_household VALUES ('SNNP',11,10,2,1,1,1,11,5,177);
INSERT INTO mb_household VALUES ('SNNP',11,10,8,88,1,1,2,1,167);
INSERT INTO mb_household VALUES ('SNNP',4,4,1,1,1,1,1,3,135);
INSERT INTO mb_household VALUES ('SNNP',4,4,1,1,1,1,1,4,152);
INSERT INTO mb_household VALUES ('SNNP',11,10,8,88,1,2,12,4,166);
INSERT INTO mb_household VALUES ('SNNP',1,2,8,88,1,1,1,2,189);
INSERT INTO mb_household VALUES ('SNNP',11,10,2,1,1,1,11,3,224);
INSERT INTO mb_household VALUES ('SNNP',11,10,8,88,1,1,2,3,168);
INSERT INTO mb_household VALUES ('SNNP',1,2,8,88,1,1,1,5,141);
INSERT INTO mb_household VALUES ('SNNP',10,9,8,88,1,1,1,4,134);
INSERT INTO mb_household VALUES ('SNNP',1,2,8,88,1,1,1,4,163);
INSERT INTO mb_household VALUES ('SNNP',1,2,8,88,1,1,1,1,267);
INSERT INTO mb_household VALUES ('SNNP',11,10,2,1,1,1,11,1,249);
INSERT INTO mb_household VALUES ('SNNP',11,10,8,88,1,1,2,2,144);
INSERT INTO mb_household VALUES ('SNNP',10,9,8,88,1,1,1,3,182);
INSERT INTO mb_household VALUES ('SNNP',4,4,1,1,1,1,1,2,190);
INSERT INTO mb_household VALUES ('SNNP',11,10,2,1,1,1,11,2,158);
INSERT INTO mb_household VALUES ('SNNP',4,4,1,1,1,1,1,1,130);
INSERT INTO mb_household VALUES ('SNNP',11,10,8,88,1,2,12,3,103);
INSERT INTO mb_household VALUES ('SNNP',10,9,8,88,1,1,1,2,126);
INSERT INTO mb_household VALUES ('Somalie',1,2,1,1,1,6,1,2,64);
INSERT INTO mb_household VALUES ('Somalie',2,7,8,88,1,1,1,1,61);
INSERT INTO mb_household VALUES ('Somalie',2,7,8,88,1,2,1,4,36);
INSERT INTO mb_household VALUES ('Somalie',1,1,8,88,1,5,9,1,184);
INSERT INTO mb_household VALUES ('Somalie',2,7,8,88,1,1,1,2,60);
INSERT INTO mb_household VALUES ('Somalie',1,1,8,88,1,1,1,1,81);
INSERT INTO mb_household VALUES ('Somalie',1,2,8,88,1,2,2,1,82);
INSERT INTO mb_household VALUES ('Somalie',1,2,8,88,1,6,19,1,58);
INSERT INTO mb_household VALUES ('Somalie',1,1,8,88,1,1,1,5,1);
INSERT INTO mb_household VALUES ('Somalie',1,1,8,88,1,1,1,2,103);
INSERT INTO mb_household VALUES ('Somalie',1,1,8,88,1,1,1,3,45);
INSERT INTO mb_household VALUES ('Somalie',1,1,8,88,1,5,9,2,161);
INSERT INTO mb_household VALUES ('Somalie',2,7,8,88,1,2,1,5,55);
INSERT INTO mb_household VALUES ('Somalie',1,2,1,1,1,6,1,1,8);
INSERT INTO mb_household VALUES ('Somalie',2,7,8,88,1,2,1,3,32);
INSERT INTO mb_household VALUES ('Tigray',4,6,8,88,1,1,5,2,102);
INSERT INTO mb_household VALUES ('Tigray',4,6,8,88,1,1,5,1,119);
INSERT INTO mb_household VALUES ('Tigray',4,4,1,1,1,1,5,3,142);
INSERT INTO mb_household VALUES ('Tigray',4,6,8,88,1,1,5,3,122);
INSERT INTO mb_household VALUES ('Tigray',4,5,8,88,1,1,2,4,142);
INSERT INTO mb_household VALUES ('Tigray',4,5,8,88,1,1,2,5,37);
INSERT INTO mb_household VALUES ('Tigray',4,4,1,1,1,1,5,2,116);
INSERT INTO mb_household VALUES ('Tigray',4,6,8,88,1,1,5,4,109);
INSERT INTO mb_household VALUES ('Tigray',4,6,8,88,1,1,5,5,165);
INSERT INTO mb_household VALUES ('Tigray',4,4,1,1,1,1,5,5,92);
INSERT INTO mb_household VALUES ('Tigray',4,4,1,1,1,1,5,6,111);
INSERT INTO mb_household VALUES ('Tigray',4,5,8,88,1,1,2,1,91);
INSERT INTO mb_household VALUES ('Tigray',4,4,1,1,1,1,5,1,158);


BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE mb_religion';
EXCEPTION
    WHEN OTHERS THEN NULL;
END;
/
CREATE TABLE mb_religion (
  ID number(21) NOT NULL,
  RELIGION varchar2(14) DEFAULT NULL,
  INDIVIDUALS number(21) DEFAULT '0',
  CONSTRAINT pk_mb_religion PRIMARY KEY (id)
); 

INSERT INTO mb_religion VALUES (1,'Bahai',1);
INSERT INTO mb_religion VALUES (2,'Catholic',1048);
INSERT INTO mb_religion VALUES (3,'Jew',1);
INSERT INTO mb_religion VALUES (4,'Jova',16);
INSERT INTO mb_religion VALUES (5,'Muslim',25971);
INSERT INTO mb_religion VALUES (6,'No religion',43);
INSERT INTO mb_religion VALUES (7,'Orthodox',26155);
INSERT INTO mb_religion VALUES (8,'Others',35);
INSERT INTO mb_religion VALUES (9,'Protestant',23971);
INSERT INTO mb_religion VALUES (10,'Traditionalist',441);
INSERT INTO mb_religion VALUES (11,'Wakefena',162);


BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE mb_sex_distribution';
EXCEPTION
    WHEN OTHERS THEN NULL;
END;
/
CREATE TABLE mb_sex_distribution (
  ID number(21) NOT NULL,
  range varchar2(8) DEFAULT '',
  male number(21) DEFAULT '0',
  female number(21) DEFAULT '0',
  CONSTRAINT pk_mb_sex_distribution PRIMARY KEY (id)
);


INSERT INTO mb_sex_distribution VALUES (1,'0 to 4',4699,4541);
INSERT INTO mb_sex_distribution VALUES (2,'5 to 10',7143,6879);
INSERT INTO mb_sex_distribution VALUES (3,'11 to 16',5858,5679);
INSERT INTO mb_sex_distribution VALUES (4,'17 to 25',6688,7810);
INSERT INTO mb_sex_distribution VALUES (5,'26 to 34',4879,5218);
INSERT INTO mb_sex_distribution VALUES (6,'35 to 45',5213,4700);
INSERT INTO mb_sex_distribution VALUES (7,'46 to 55',1803,1964);
INSERT INTO mb_sex_distribution VALUES (8,'56 to 65',1400,1296);
INSERT INTO mb_sex_distribution VALUES (9,'66 to 78',879,732);
INSERT INTO mb_sex_distribution VALUES (10,'79 to 99',361,337);


drop sequence SEQ_MB_USER_ROLES;
create sequence SEQ_MB_USER_ROLES 
minvalue 1
maxvalue 99999999999999999999
start with 3
increment by 1
cache 20;

drop sequence SEQ_MB_USERS;
create sequence SEQ_MB_USERS
minvalue 1
maxvalue 99999999999999999999
start with 3
increment by 1
cache 20;

-- Done!

commit;

-- Committed
