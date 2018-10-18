create table lineitem
(
  id integer not null GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
  quantity integer not null,
  description varchar(255) not null,
  unitprice DECIMAL(20, 2) not null,
  primary key(id)
);

create table invoice
(
  id integer not null GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
  client varchar(255) not null,
  vatrate integer not null,
  invoicedate date not null,
  primary key(id)
);
