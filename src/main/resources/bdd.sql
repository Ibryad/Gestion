create table costs(
                      id serial PRIMARY KEY,
                      date date,
                      type character(6),
                      montant numeric,
                      description text
);


INSERT INTO costs (date, type, montant, description)
VALUES ('2023-06-06', 'Credit', 1440.50, 'Description de l enregistrement');




SELECT *
from costs;

delete from costs
where id=1;

