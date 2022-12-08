create table if not exists public.account
(
    id          bigserial primary key,
    name        text   not null,
    description text,
    user_id     bigint not null,
    balance     bigint not null,
    foreign key (user_id) references public.user (id),
    constraint uniq_account_per_user unique (name, user_id)
);
