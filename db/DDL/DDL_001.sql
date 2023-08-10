CREATE SCHEMA "SR";

CREATE TABLE "SR"."Comanda" (
  "id" integer PRIMARY KEY,
  "total" numeric(8,2)
);

CREATE TABLE "SR"."Cuenta" (
  "id" integer PRIMARY KEY,
  "id_producto" integer,
  "id_comanda" integer,
  "total" numeric(8,2)
);

CREATE TABLE "SR"."CuentaProducto" (
  "id" integer PRIMARY KEY,
  "id_producto" integer,
  "id_cuenta" integer,
  "Comentario" varchar
);

CREATE TABLE "SR"."Producto" (
  "id" integer PRIMARY KEY,
  "total" numeric(6,2),
  "Nombre" varchar,
  "Comentario" varchar,
  "urlImagen" varchar,
  "id_tipo" integer
);

CREATE TABLE "SR"."Tipo" (
  "id" integer PRIMARY KEY,
  "Nombre" varchar,
  "Descriminador" varchar,
  "anotacion" varchar
);

ALTER TABLE "SR"."Producto" ADD FOREIGN KEY ("id_tipo") REFERENCES "SR"."Tipo" ("id");

ALTER TABLE "SR"."Cuenta" ADD FOREIGN KEY ("id_comanda") REFERENCES "SR"."Comanda" ("id");

ALTER TABLE "SR"."CuentaProducto" ADD FOREIGN KEY ("id_cuenta") REFERENCES "SR"."Cuenta" ("id");

ALTER TABLE "SR"."CuentaProducto" ADD FOREIGN KEY ("id_producto") REFERENCES "SR"."Producto" ("id");
