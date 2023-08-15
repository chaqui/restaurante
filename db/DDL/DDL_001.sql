CREATE TABLE IF NOT EXISTS comanda (
  id integer PRIMARY KEY,
  id_mesa integer,
  total numeric(8,2),
  estado integer
);

CREATE TABLE IF NOT EXISTS cuenta (
  id integer PRIMARY KEY,
  id_comanda integer,
  total numeric(8,2)
);

CREATE TABLE IF NOT EXISTS cuenta_producto (
  id integer PRIMARY KEY,
  id_producto integer,
  id_cuenta integer,
  Comentario varchar
);

CREATE TABLE IF NOT EXISTS producto (
  id SERIAL PRIMARY KEY,
  total numeric(6,2),
  nombre varchar,
  comentario varchar,
  urlImagen varchar,
  id_tipo integer
);

CREATE TABLE IF NOT EXISTS tipo (
  id integer PRIMARY KEY,
  Nombre varchar,
  descriminador varchar,
  anotacion varchar
);

ALTER TABLE producto ADD CONSTRAINT fk_tipo_producto FOREIGN KEY (id_tipo) REFERENCES tipo (id);

ALTER TABLE cuenta ADD CONSTRAINT fk_comanada_cuenta FOREIGN KEY (id_comanda) REFERENCES comanda (id);

ALTER TABLE cuenta_producto ADD CONSTRAINT fk_cuenta_producto FOREIGN KEY (id_cuenta) REFERENCES cuenta (id);

ALTER TABLE cuenta_producto ADD CONSTRAINT fk_producto_cuenta FOREIGN KEY (id_producto) REFERENCES producto (id);

ALTER TABLE comanda ADD CONSTRAINT fk_mesa_comanda FOREIGN KEY (id_mesa) REFERENCES tipo (id);

ALTER TABLE comanda ADD CONSTRAINT fk_mesa_estado FOREIGN KEY (estado) REFERENCES tipo (id);

commit;
