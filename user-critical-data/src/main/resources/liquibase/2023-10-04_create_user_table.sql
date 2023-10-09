CREATE TABLE public.users(
   id SERIAL PRIMARY KEY,
   cpf varchar(11),
   name varchar(255),
   address varchar(255),
   CONSTRAINT unique_cpf UNIQUE (cpf)
  )

