
alter table TRANSACTION (
    add column HASH_ACCOUNT varchar(60),
    add CONSTRAINT fk_account
        FOREIGN KEY (HASH_ACCOUNT)
        REFERENCES ACCOUNT(HASH);
);
