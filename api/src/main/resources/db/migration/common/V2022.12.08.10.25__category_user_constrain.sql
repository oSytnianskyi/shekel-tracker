alter table if exists public.category
    add constraint uniq_category_per_user unique (user_id, name);
