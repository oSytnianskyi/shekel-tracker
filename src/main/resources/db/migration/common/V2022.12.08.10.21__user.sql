create table if not exists public.user
(
    id         bigserial primary key,
    email      varchar(25) not null,
    first_name varchar(25),
    last_name   varchar(25)
);
