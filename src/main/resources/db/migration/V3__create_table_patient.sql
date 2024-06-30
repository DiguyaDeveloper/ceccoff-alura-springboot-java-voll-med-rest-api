CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE patient (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name varchar(100) not null,
    email varchar(100) not null unique,
    document varchar(15) not null unique,
    phone varchar(20) not null,
    street varchar(100) not null,
    neighborhood varchar(100) not null,
    zip_code varchar(100) not null,
    city varchar(100) not null,
    state char(2) not null,
    number varchar(28),
    additional_info varchar(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);