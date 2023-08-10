CREATE DATABASE SR; 
CREATE USER SR WITH PASSWORD 'u!zEV2NY!k22tWk5';

CREATE SCHEMA "SR";

CREATE TABLE "SR"."Comanda" (
  "id" integer PRIMARY KEY,
  "id_mesa" integer,
  "total" numeric(8,2),
  "estado" integer
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
  "Anotacion" varchar
);

ALTER TABLE "SR"."Producto"  ADD CONSTRAINT "fk_tipo_producto" FOREIGN KEY ("id_tipo") REFERENCES "SR"."Tipo" ("id");

ALTER TABLE "SR"."Cuenta" ADD CONSTRAINT "fk_comanada_cuenta" FOREIGN KEY ("id_comanda") REFERENCES "SR"."Comanda" ("id");

ALTER TABLE "SR"."CuentaProducto" ADD CONSTRAINT "fk_cuenta_producto" FOREIGN KEY ("id_cuenta") REFERENCES "SR"."Cuenta" ("id");

ALTER TABLE "SR"."CuentaProducto" ADD CONSTRAINT "fk_producto_cuenta" FOREIGN KEY ("id_producto") REFERENCES "SR"."Producto" ("id");

ALTER TABLE "SR"."Comanda" ADD CONSTRAINT "fk_mesa_comanda" FOREIGN KEY ("id_mesa") REFERENCES "SR"."Tipo" ("id");

ALTER TABLE "SR"."Comanda" ADD CONSTRAINT "fk_mesa_estado" FOREIGN KEY ("estado") REFERENCES "SR"."Tipo" ("id");