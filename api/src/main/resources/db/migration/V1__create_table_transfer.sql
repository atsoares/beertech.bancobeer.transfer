
create table ACCOUNT (
    ID numeric not null PRIMARY KEY,
    VALUE_TRANSACTION numeric null,
    DATA_TRANSACTION TIMESTAMP not null,
    HASH_ACCOUNT_ORIGIN varchar(60) UNIQUE,
    HASH_ACCOUNT_DESTINATION varchar(60) UNIQUE,
);
