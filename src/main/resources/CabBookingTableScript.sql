drop schema if exists cab_booking_database;
create database cab_booking_database;
use cab_booking_database;

DROP TABLE IF EXISTS ride_locations;
DROP TABLE IF EXISTS payments;
DROP TABLE IF EXISTS bookings;
DROP TABLE IF EXISTS cabs;
DROP TABLE IF EXISTS users;

create table users(
    user_id int primary key auto_increment,
    name varchar(100) not null,
    email varchar(100) unique not null,
    password varchar(255) not null,
    role enum('CUSTOMER','DRIVER','ADMIN') not null,
    phone_number varchar(15) unique not null,
    is_active boolean default true,
    created_at timestamp default current_timestamp
);

create table cabs(
    cab_id int auto_increment primary key,
    driver_id int unique,
    cab_number varchar(20) unique not null,
    cab_type enum('STANDARD', 'PREMIUM') not null,
    is_available boolean default true,
    created_at timestamp default current_timestamp,
    foreign key(driver_id) references users(user_id)
);

create table bookings(
    booking_id int primary key auto_increment,
    customer_id int,
    cab_id int,
    pickup_location varchar(255) not null,
    dropoff_location varchar(255) not null,
    fare decimal(10,2) not null,
    status enum('PENDING', 'IN_PROGRESS','COMPLETED', 'CANCELLED') default 'PENDING',
    booking_time timestamp default current_timestamp,
    foreign key (customer_id) references users(user_id),
    foreign key (cab_id) references cabs(cab_id)
);

create table payments(
    payment_id int primary key auto_increment,
    booking_id int not null,
    customer_id int not null,
    payment_method enum('CASH', 'CARD', 'UPI') not null,
    payment_status enum('PENDING', 'COMPLETED', 'FAILED') DEFAULT 'PENDING',
    amount decimal(10,2) not null,
    transaction_id varchar(20) unique,
    payment_time timestamp default current_timestamp,
    foreign key (booking_id) references bookings(booking_id),
    foreign key (customer_id) references users(user_id)
);

create table ride_locations(
    location_id int primary key auto_increment,
    booking_id int,
    latitude decimal(9,6) not null,
    longitude decimal(9,6) not null,
    timestamp timestamp default current_timestamp,
    foreign key (booking_id) references bookings(booking_id)
);