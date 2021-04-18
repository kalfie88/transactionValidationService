CREATE TABLE failed_validations {
    reference BIGINT NOT NULL,
    description  VARCHAR(300),
    PRIMARY KEY (reference),
    FOREIGN KEY (transactions_id) REFERENCES transactions(id)
};

CREATE TABLE transactions {
    id INTEGER NOT NULL auto_increment,
    reference BIGINT,
    PRIMARY KEY (id)
}