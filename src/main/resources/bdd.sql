create table costs(
                      id serial PRIMARY KEY,
                      date date,
                      type character(6),
                      montant numeric,
                      description text
);