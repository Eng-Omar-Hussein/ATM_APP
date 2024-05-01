use BANKSYSDB
GO
Create table Person
(
SSN           varchar(14)        not NULL ,
ContactNumber varchar(11) not NULL,
FirstName     varchar(15) not NULL,
MidName       varchar(15) not NULL,
LastName      varchar(15) not NULL,
E_Mail        varchar(60) not NULL,
Address       varchar(60) not NULL,
DateOfBirth   date        not NULL
);
alter table Person
add constraint Person_PK Primary KEY (SSN);
alter table Person
add constraint ContactNUmber_Unique Unique (ContactNumber);

Create table Loan
(
LoanID    int identity(5326,1)         not NULL,
Amount   numeric(9,2) not NULL,
StartDate date        not NULL,
EndDate   date        not NULL,
Status    varchar(15) not NULL,
Avail    numeric(9,2) not NULL
);

alter table Loan
add constraint Loan_PK primary key (LoanID)

Create table Customer 
(
Customer_ID    int Identity(1000,1) not NULL,
Income         numeric(9,2)                 ,
SSN            varchar(14)                          ,
LoanID         int       ,
Password       varchar(4)   
);
alter table Customer
add constraint Customer_PK Primary Key (Customer_ID);
alter table Customer
add constraint Person_Customer_FK Foreign KEy (SSN)
REFERENCES Person(SSN);
alter table Customer
add constraint Customer_Loan_FK Foreign KEy (LoanID)
REFERENCES Loan(LoanID);

Create Table Bank
(
Bank_NO   int         not NULL,
BankName  varchar(50) not NULL,
);
Alter table Bank
add constraint Bank_PK primary KEY(Bank_NO);
alter table Bank
add constraint BankName_UNIque UNIQUE (BankName);

Create Table Branch
(
Branch_ID    int         not NULL,
BranchName   varchar(30) not NUll,
Address      varchar(50) not NULL,
City         varchar(15) not NULL,
State        varchar(10) not NULL,
ContactNumber numeric(7)         ,
Bank_NO       int                
);
alter table Branch 
add Constraint Branch_PK Primary key (Branch_ID);
alter table Branch
add constraint BranchName_Unique Unique (BranchName);
alter table Branch 
add constraint Bank_Branch_FK Foreign Key(Bank_NO)
References Bank(Bank_NO);



Create table Empolyee
(
Empolyee_ID  int Identity (5000,1)        not NULL,
Position     varchar(30)                  not NULL,
Salary       numeric(7,2)                 not NULL,
Hiredate     date                         not NULL,
SSN          varchar(14)                  not NULL,
Branch_ID    int                                  ,
Password     varchar(4)
);
alter table Empolyee
add constraint Empolyee_PK primary key (Empolyee_ID)
alter table Empolyee
add constraint Person_Empolyee_FK Foreign key (SSN)
References Person(SSN);
alter table Empolyee
add constraint Branch_Empolyee_FK Foreign key (Branch_ID)
References Branch(Branch_ID);

Create TAble ATM 
(
ATM_ID    int         not NULL,
Location  varchar(30) not NULL,
Status    varchar(15) not NULL,
Branch_ID int                 
);
alter table ATM
add constraint ATM_PK primary key(ATM_ID);
alter table ATM
add constraint Branch_ATM_FK FOREIGN KEY (Branch_ID)
REferences Branch(Branch_ID);

Create Table Account
(
Account_NO      int         not NULL,
Account_Type    varchar(10) not NULL,
Balance        numeric(19,2)not NULL,
DateOpened     date         not NULL,
Status         varchar(6)   not NULL,
OverDraftLimit numeric(19,0) not NULL,
Customer_ID    int           not NULL,
Bank_NO        int           not NULL
);


alter table Account 
add constraint Account_PK primary key (Account_NO);
alter table Account 
add constraint Customer_Account_FK Foreign Key(Customer_ID)
References Customer(Customer_ID);
alter table Account 
add constraint Bank_Account_FK Foreign Key(Bank_NO)
References Bank(Bank_NO);

Create table Transactionn
(
Transaction_ID    int identity (1,1) not NULL,
ContactNumber     varchar(11)      not NULL,
AmountOfTransaction numeric(7,0)     not NULL,
Date                date             not NULL,
Transaction_Type    varchar(30)      not NULL,
ATM_ID              int						 ,
Account_NO          int              not NULL,
Loan_ID             int                      ,
Empolyee_ID         int                        
);
alter table Transactionn 
add constraint Transaction_PK primary key (Transaction_ID);
alter table Transactionn
add constraint ATM_Transactionn_FK Foreign key(ATM_ID)
REFERENCES ATM(ATM_ID);
alter table Transactionn
add constraint Account_Transaction_FK Foreign key(Account_NO)
REFERENCES Account(Account_NO);
alter table Transactionn
add constraint Loan_Transaction_FK Foreign key(Loan_ID)
REFERENCES Loan(LoanID);
alter table Transactionn
add constraint Empolyee_Transaction_FK Foreign key(Empolyee_ID)
REFERENCES Empolyee(Empolyee_ID);



-- Inserting data into the Person table
INSERT INTO Person(SSN, ContactNumber, FirstName, MidName, LastName, E_Mail, Address, DateOfBirth)
VALUES 
    ('123456789', '1234567890', 'John', 'Doe', 'Smith', 'apdosophi123@example.com', '123 Main St', '1990-05-15'),
    ('234567890', '2345678901', 'Jane', 'Mary', 'Doe', 'jane@example.com', '456 Elm St', '1985-08-21'),
    ('345678901', '3456789012', 'Michael', 'James', 'Johnson', 'michael@example.com', '789 Oak St', '1978-11-30'),
    ('456789012', '4567890123', 'Emily', 'Grace', 'Williams', 'emily@example.com', '321 Maple Ave', '1995-03-10'),
    ('567890123', '5678901234', 'David', 'Lee', 'Brown', 'david@example.com', '654 Pine St', '1982-07-18'),
    ('678901234', '6789012345', 'Sarah', 'Anne', 'Taylor', 'sarah@example.com', '987 Cedar St', '1992-09-25'),
    ('789012345', '7890123456', 'Christopher', 'Joseph', 'Clark', 'chris@example.com', '210 Walnut St', '1980-12-05'),
    ('890123456', '8901234567', 'Jessica', 'Marie', 'Martinez', 'jessica@example.com', '543 Birch St', '1987-04-14'),
    ('901234567', '9012345678', 'Matthew', 'Robert', 'Young', 'matthew@example.com', '876 Cherry St', '1976-06-28'),
    ('012345678', '0123456789', 'Amanda', 'Nicole', 'Anderson', 'amanda@example.com', '109 Pineapple St', '1998-01-20');


-- Inserting data into the Loan table
INSERT INTO Loan ( Amount, StartDate, EndDate, Status, Avail)
VALUES 
    ( 5000, '2024-04-01', '2024-10-01', 'Active', 20),
    ( 8000, '2024-03-15', '2024-09-15', 'Active', 18.75),
    ( 10000, '2024-02-20', '2024-08-20', 'Active', 25),
    ( 3000, '2024-01-10', '2024-07-10', 'Active', 16.75),
    ( 7000, '2024-05-05', '2024-11-05', 'Active', 17.15),
    ( 6000, '2024-04-08', '2024-10-08', 'Active', 18.35),
    ( 4000, '2024-03-01', '2024-09-01', 'Active', 20.15),
    ( 9000, '2024-02-15', '2024-08-15', 'Active', 17.79),
    ( 12000, '2024-01-20', '2024-07-20', 'Active', 20.84),
    ( 2000, '2024-06-10', '2024-12-10', 'Active', 20.01);

	-- Inserting data into the Customer table with example passwords
INSERT INTO Customer ( Income,SSN, LoanID,Password)
VALUES 
    ( 50000, '123456789', 5326,'1111'),
    ( 60000,  '234567890', 5327,'2222'),
    ( 55000,  '345678901', 5328,'3333'),
    ( 70000, '456789012', 5329,'4444'),
    ( 48000,  '567890123', 5330,'5555'),
    ( 62000,  '678901234', 5331,'6666'),
    ( 58000,  '789012345', 5332,'7777'),
    ( 75000,  '890123456', 5333,'8888'),
    ( 53000, '901234567', 5334,'9999'),
    ( 67000,  '012345678', 5335,'1010');

	-- Inserting data into the Bank table
INSERT INTO Bank (Bank_NO, BankName)
VALUES 
    (1234, 'Bank of America'),
    (5678, 'Wells Fargo'),
    (9012, 'JPMorgan Chase'),
    (3456, 'Citibank'),
    (7890, 'U.S. Bank'),
    (2345, 'PNC Bank'),
    (6789, 'TD Bank'),
    (1235, 'Capital One'),
    (5679, 'HSBC Bank'),
    (9013, 'Bank of New York Mellon');

	-- Inserting data into the Branch table
INSERT INTO Branch (Branch_ID, BranchName, Address, City, State, ContactNumber, Bank_NO)
VALUES 
    (10001, 'Main Branch', '123 Main St', 'New York', 'NY', '1234567', 1234),
    (10002, 'Downtown Branch', '456 Elm St', 'Los Angeles', 'CA', '2345678', 5678),
    (10003, 'Uptown Branch', '789 Oak St', 'Chicago', 'IL', '3456789', 9012),
    (10004, 'Westside Branch', '321 Pine St', 'Houston', 'TX', '4567890', 3456),
    (10005, 'Eastside Branch', '654 Maple St', 'Miami', 'FL', '5678901', 7890),
    (10006, 'Southside Branch', '987 Cedar St', 'Atlanta', 'GA', '6789012', 2345),
    (10007, 'Northside Branch', '210 Birch St', 'Seattle', 'WA', '7890123', 6789),
    (10008, 'Central Branch', '543 Walnut St', 'Denver', 'CO', '8901234', 1235),
    (10009, 'Suburban Branch', '876 Cherry St', 'Dallas', 'TX', '9012345', 5679),
    (10010, 'Rural Branch', '109 Pineapple St', 'Phoenix', 'AZ', '2109876', 9013);


	-- Inserting data into the Employee table
INSERT INTO Empolyee ( Position, Salary, Hiredate, SSN, Branch_ID,Password)
VALUES 
    ( 'Manager', 70000, '2023-01-15', '123456789', 10001,1111),
    ( 'Assistant Manager', 55000, '2023-03-20', '234567890', 10002,2222),
    ( 'Accountant', 60000, '2023-05-10', '345678901', 10003,3333),
    ( 'Sales Representative', 45000, '2023-07-25', '456789012', 10004,4444),
    ( 'Customer Service ', 40000, '2023-09-30', '567890123', 10005,5555),
    ( 'IT Specialist', 65000, '2023-11-05', '678901234', 10006,6666),
    ( 'Human Resources Manager', 60000, '2024-01-10', '789012345', 10007,7777),
    ( 'Marketing Coordinator', 50000, '2024-03-15', '890123456', 10008,8888),
    ( 'Operations Supervisor', 58000, '2024-05-20', '901234567', 10009,9999),
    ( 'Financial Analyst', 62000, '2024-07-25', '012345678', 10010,1010);

	-- Inserting data into the ATM table
INSERT INTO ATM (ATM_ID, Location, Status, Branch_ID)
VALUES 
    (1001, '123 Main St', 'Active', 10001),
    (2002, '456 Elm St', 'Active', 10002),
    (3003, '789 Oak St', 'Out of Service', 10003),
    (4004, '321 Pine St', 'Active', 10004),
    (5005, '654 Maple St', 'Active', 10005),
    (6006, '987 Cedar St', 'Out of Service', 10006),
    (7007, '210 Birch St', 'Active', 10007),
    (8008, '543 Walnut St', 'Active', 10008),
    (9009, '876 Cherry St', 'Out of Service', 10009),
    (1010, '109 Pineapple St', 'Active', 10010);

	-- Inserting data into the Account table
INSERT INTO Account (Account_NO, Account_Type, Balance, DateOpened, Status, OverDraftLimit, Customer_ID, Bank_NO)
VALUES 
    (1001, 'Savings', 5000, '2023-01-15', 'Active', 1000, 1000, 1234),
    (1002, 'Checking', 2500, '2023-03-20', 'Active', 500, 1001, 5678),
    (1003, 'Savings', 7500, '2023-05-10', 'Active', 1500, 1002, 9012),
    (1004, 'Checking', 3000, '2023-07-25', 'Active', 600, 1003, 3456),
    (1005, 'Savings', 6000, '2023-09-30', 'Active', 1200, 1004, 7890),
    (1006, 'Checking', 3500, '2023-11-05', 'Active', 700, 1005, 2345),
    (1007, 'Savings', 8000, '2024-01-10', 'Active', 1600, 1006, 6789),
    (1008, 'Checking', 4000, '2024-03-15', 'Active', 800, 1007, 1235),
    (1009, 'Savings', 9000, '2024-05-20', 'Active', 1800, 1008, 5679),
    (1010, 'Checking', 4500, '2024-07-25', 'Active', 900, 1009, 9013);
	


	-- Inserting data into the Transactionn table
INSERT INTO Transactionn ( ContactNumber, AmountOfTransaction, Date, Transaction_Type, ATM_ID, Account_NO, Loan_ID, Empolyee_ID)
VALUES 
    ( '1234567', 1000, '2024-01-01', 'Deposit', 1001, 1001, NULL, 5001),
    ( '2345678', 1500, '2024-02-02', 'Withdrawal', NULL, 1002, NULL, 5006),
    ( '3456789', 2000, '2024-03-03', 'Transfer', 2002, 1003, NULL, 5007),
    ( '4567890', 2500, '2024-04-04', 'Payment', NULL, 1004, NULL, 5008),
    ( '5678901', 3000, '2024-05-05', 'Withdrawal', 3003, 1005, NULL,5009),
    ( '6789012', 3500, '2024-06-06', 'Deposit', NULL, 1006, NULL, 5002),
    ( '7890123', 4000, '2024-07-07', 'Withdrawal', 4004, 1007, NULL, 5003),
    ( '8901234', 4500, '2024-08-08', 'Payment', NULL, 1008, NULL, 5004),
    ( '9012345', 5000, '2024-09-09', 'Deposit', 5005, 1009, NULL, 5005),
    ( '0123456', 5500, '2024-10-10', 'Transfer', NULL, 1010, NULL, 5000);


	
	
	--Drop table Transactionn ;
	--Drop table Account;
	--drop table ATM;
	--drop table Empolyee;
	--drop table Branch;
	--drop table Bank;
	--drop table Customer;
	--drop table Loan;
	--drop table Person;
	































