//Login Table
create Table userstore (
USERNAME varchar2(30) not null,
PASSWORD varchar2(30) not null
);

insert into userstore(USERNAME, PASSWORD) values ('admin123','Admin@1230');
Select *from userstore;

ALTER TABLE userstore ADD Logged_At Timestamp(2);


//CustomerAccount Table
create Table CustomerAccount_RBM(
Customer_ID NUMBER(11) not null,
SSN_ID NUMBER(11) PRIMARY KEY,
Customer_Name varchar2(30),
Customer_Age varchar2(30),
Customer_Address varchar2(30),
State varchar2(30),
City varchar2(30),
Account_ID NUMBER(11) ,
Account_Type varchar2(30) ,

Status varchar2(30) ,
Message varchar2(30),
Last_updated varchar2(50)
);

create sequence custIdSeq
MINVALUE 100000000
MAXVALUE 10000000000
START WITH 100000000
INCREMENT BY 1;

select * from CustomerAccount_RBM;

create sequence accseq
MINVALUE 100000100
MAXVALUE 10000000000
START WITH 100000100
INCREMENT BY 1;

ALTER TABLE CustomerAccount_RBM ADD Acc_Status varchar2(30);
ALTER TABLE CustomerAccount_RBM ADD Balance Number(8);

Update CustomerAccount_RBM SET Account_ID=accseq.nextval,Account_Type=?,Balance=?,Acc_Status='Active', Message='Account created successfully'  where Customer_ID=? ;

ALTER TABLE CustomerAccount_RBM DROP primary key;

ALTER TABLE CustomerAccount_RBM ADD primary key(Customer_ID);
select * from CustomerAccount_RBM;

drop sequence custIdSeq;

drop sequence accseq;

drop table userstore;

drop table CustomerAccount_RBM;

insert into CustomerAccount_RBM(Customer_ID,SSN_ID,Customer_Name,Customer_Age,Customer_Address,State,City,Account_ID,Account_Type,Amount,Status,Message,Last_updated) values(100000,100,'Garima','22','sector 10','haryana','gurgaon',101,'Saving Account',1000,'Active','hello','today');
insert into CustomerAccount_RBM(Customer_ID,SSN_ID,Customer_Name,Customer_Age,Customer_Address,State,City,Account_ID,Account_Type,Amount,Status,Message,Last_updated) values(100000,102,'Garima','22','sector 10','haryana','gurgaon',102,'Current Account',1000,'Active','hello','today');
