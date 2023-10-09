CREATE TABLE public.debt(
   id SERIAL PRIMARY KEY,
   debt_due_date TIMESTAMP,
   original_value NUMERIC(10, 2),
   current_balance NUMERIC(10, 2),
   type_of_debt varchar,
   debt_status varchar,
   user_id INT REFERENCES public.users(id)
  )