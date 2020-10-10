DROP TABLE IF EXISTS account;

CREATE TABLE account (
                         account_number BIGINT PRIMARY KEY NOT NULL,
                         account_name   VARCHAR2 NOT NULL,
                         account_type   VARCHAR2 NOT NULL,
                         balance        DECIMAL(19,2) NOT NULL,
                         balance_date   DATE NOT NULL,
                         currency       VARCHAR2 NOT NULL,
                         version        BIGINT
);

INSERT INTO account (account_number, account_name, account_type, balance, balance_date, currency, version)
VALUES
(001, 'acct001', 'SAVINGS', 101.99, '2020-10-01', 'AUD', 0),
(002, 'acct002', 'CURRENT', 102.99, '2020-10-02', 'USD', 0),
(003, 'acct003', 'SAVINGS', 103.99, '2020-10-03', 'SGD', 0);