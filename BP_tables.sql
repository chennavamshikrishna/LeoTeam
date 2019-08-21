script for creation of REGISTRATION table

create table registration(
    -> name varchar(50),
    -> phoneno varchar(10),
    -> dob date,
    -> address varchar(125),
    -> aadhar varchar(15),
    -> username varchar(15),
    -> password varchar(15),
    -> email varchar(25),
    -> accountno varchar(10));
	
alter table registration add constraint account_pk primary key (accountno);

===========================================================================================

script for creation of CREDIT SCORE table

 create table creditscore(
    -> name varchar(50),
    -> dob date,
    -> email varchar(25),
    -> creditscore int unsigned);
	
 alter table creditscore add constraint email_pk primary key (email);
 
 ============================================================================================
 
 script for creation of TRANSACTION table
 
 create table transaction(
    -> transId int unsigned primary key auto_increment,
    -> accountno1 varchar(10),
    -> deborcredit int unsigned,
    -> accountno2 varchar(10),
    -> datestamp date,
    -> amount int unsigned);
	
================================================================================================

script for creation of ACCOUNT table

create table account(
    -> accountno varchar(10) primary key,
    -> amount int unsigned);
	
===========================================================================================