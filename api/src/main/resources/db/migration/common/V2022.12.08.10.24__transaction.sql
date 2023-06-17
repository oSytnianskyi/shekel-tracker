create table if not exists public.transaction
(
    id          bigserial primary key,
    description text,
    amount      bigint not null,
    type        text   not null,
    user_id     bigint not null,
    category_id bigint not null,
    foreign key (user_id) references public.user (id),
    foreign key (category_id) references public.category (id)
);
