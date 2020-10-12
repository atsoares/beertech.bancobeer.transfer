
create table ACCOUNT (
    ID numeric not null PRIMARY KEY,
    HASH varchar(60) UNIQUE,
    BALANCE numeric null
);
