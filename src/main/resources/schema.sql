/*DROP TABLE IF EXISTS moneda;*/

CREATE TABLE monedas (
    idtipocambio INT AUTO_INCREMENT PRIMARY KEY,
    monedaorigen VARCHAR(3),
    monedadestino VARCHAR(3),
    equivalencia NUMBER(10,3)
);