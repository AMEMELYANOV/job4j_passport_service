create table passports (
   id serial primary key not null,
   name varchar(255),
   surname varchar(255),
   seria int,
   number int,
   issue_date timestamp,
   expired_date timestamp,
   registration_place varchar(2000)
);