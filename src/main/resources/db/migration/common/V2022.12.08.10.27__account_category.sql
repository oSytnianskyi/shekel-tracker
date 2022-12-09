create table if not exists public.account_category
(
    id          bigserial primary key,
    account_id  bigint not null,
    category_id bigint not null,
    foreign key (account_id) references public.account (id),
    foreign key (category_id) references public.category (id)
);
