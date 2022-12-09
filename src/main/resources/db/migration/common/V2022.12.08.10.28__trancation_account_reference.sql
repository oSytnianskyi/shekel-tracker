alter table if exists public.transaction
    add column if not exists account_id bigint references public.account (id);
