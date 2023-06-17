create table if not exists public.category
(
    id          bigserial primary key,
    name        text   not null,
    description text,
    user_id     bigint not null,
    foreign key (user_id) references public.user (id)
);
