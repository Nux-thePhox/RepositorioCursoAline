/*1. CREA LAS SIGUIENTES TABLAS*/
/* 1.1.-Tabla cliente -> ID_CLIENTE, NOMBRE, CIUDAD*/
CREATE TABLE CLIENTE (
    ID_CLIENTE NUMBER, 
    NOMBRE NVARCHAR2(100), 
    CIUDAD NVARCHAR2(100),
    CONSTRAINT CLIENTE_PK PRIMARY KEY (ID_CLIENTE)
);

/* 1.2.- Tabla producto -> ID_PRODUCTO, NOMBRE, PRECIO*/
DROP TABLE PRODUCTO;
CREATE TABLE PRODUCTO (
    ID_PRODUCTO NUMBER, 
    NOMBRE NVARCHAR2(100), 
    PRECIO NUMBER,
    CONSTRAINT PRODUCTO_PK PRIMARY KEY (ID_PRODUCTO) 
);

/* 1.3.- Tabla venta -> ID_VENTA, CLIENTE_ID, PRODUCTO_ID, FECHA_VENTA, CANTIDAD*/
-- se cambio el nombre porque ya contaba con una tabla VENTA
DROP TABLE VENTA_PRODUCTO;
CREATE TABLE VENTA_PRODUCTO(
    ID_VENTA NUMBER, 
    CLIENTE_ID NUMBER, 
    PRODUCTO_ID NUMBER, 
    FECHA_VENTA DATE, 
    CANTIDAD NUMBER,
    CONSTRAINT VENTA_PRODUCTO_PK PRIMARY KEY (ID_VENTA),
    CONSTRAINT PRODUCTO_FK FOREIGN KEY (PRODUCTO_ID) 
        REFERENCES PRODUCTO (ID_PRODUCTO),
    CONSTRAINT CLIENTE_FK FOREIGN KEY (CLIENTE_ID) 
        REFERENCES CLIENTE (ID_CLIENTE)
);

/* 2.- INSERTA REGISTROS EN CADA UNA DE LAS TABLAS*/
--CLIENTE
INSERT INTO CLIENTE VALUES (1, 'JUAN', 'CDMX');
INSERT INTO CLIENTE VALUES (2, 'MARIA', 'GUADALAJARA');
INSERT INTO CLIENTE VALUES (3, 'PEDRO', 'MONTERREY');
INSERT INTO CLIENTE VALUES (4, 'ANITA', 'PUEBLA');
INSERT INTO CLIENTE VALUES (5, 'LUIS', 'CANCUN');
select * from cliente;

-- producto
INSERT INTO PRODUCTO VALUES (101, 'LAPTOP', 1500.50);
INSERT INTO PRODUCTO VALUES (102, 'MOUSE INALAMBRICO', 25.00);
INSERT INTO PRODUCTO VALUES (103, 'TECLADO LED', 75.25);
INSERT INTO PRODUCTO VALUES (104, 'MONITOR', 300.00);
INSERT INTO PRODUCTO VALUES (105, 'AUDIFONOS', 50.75);
select * from producto;

--venta
INSERT INTO VENTA_PRODUCTO VALUES (1, 1, 101, 
    TO_DATE('2025-10-22', 'YYYY-MM-DD'), 1);
INSERT INTO VENTA_PRODUCTO VALUES (2, 5, 101, 
    TO_DATE('2025-10-22', 'YYYY-MM-DD'), 2);
INSERT INTO VENTA_PRODUCTO VALUES (3, 3, 103, 
    TO_DATE('2025-10-21', 'YYYY-MM-DD'), 1);
INSERT INTO VENTA_PRODUCTO VALUES (4, 1, 104, 
    TO_DATE('2025-10-21', 'YYYY-MM-DD'), 1);
INSERT INTO VENTA_PRODUCTO VALUES (5, 5, 103, 
    TO_DATE('2025-10-20', 'YYYY-MM-DD'), 3);
select * from VENTA_PRODUCTO;

/*3.- REALIZA LAS SIGUIENTES CONSULTAS*/
/*3.a.- muestra todas las ventas con nombre del cliente y producto*/
SELECT V.ID_VENTA, C.NOMBRE, p.nombre AS PRODUCTO 
FROM CLIENTE C 
INNER JOIN VENTA_PRODUCTO V ON v.cliente_id = c.id_cliente
INNER JOIN PRODUCTO P ON v.producto_id = p.id_producto
ORDER BY V.ID_VENTA;

/*3.b.- Muestra el total de productos vendidos*/
SELECT SUM(CANTIDAD) AS TOTAL_PRODUCTOS_VENDIDOS FROM VENTA_PRODUCTO;

/*3.c.- Muestra el resumen de ventas por cliente (usa una vista)*/
CREATE OR REPLACE VIEW V_VENTAS_POR_CLIENTE AS
SELECT C.NOMBRE AS CLIENTE, SUM(v.cantidad) PRODUCTOS_VENDIDOS 
FROM CLIENTE C 
INNER JOIN VENTA_PRODUCTO V ON v.cliente_id = c.id_cliente
GROUP BY C.NOMBRE;

SELECT * FROM V_VENTAS_POR_CLIENTE;

/*3.d.- Crea un procedimiento almacenado que muestre las compras realizadas por
un cliente*/
CREATE OR REPLACE PROCEDURE PK_VENTAS_DE_CLIENTE (P_CLIENTE_ID IN NUMBER)
IS
    CURSOR c_compras IS
        SELECT V.ID_VENTA, C.NOMBRE AS NOMBRE_CLIENTE, P.NOMBRE AS PRODUCTO, 
            p.precio, CANTIDAD, (v.cantidad * p.precio) AS SUBTOTAL
        FROM VENTA_PRODUCTO V
        INNER JOIN CLIENTE C ON c.id_cliente = v.cliente_id
        INNER JOIN PRODUCTO P ON p.id_producto = v.producto_id
        WHERE V.CLIENTE_ID = P_CLIENTE_ID;
    -- Define una variable de tipo ROWTYPE para manejar las filas del cursor
    v_compra c_compras%ROWTYPE;
    LV_GANANCIA_VENTA NUMBER;
BEGIN
    OPEN c_compras; -- Abrir el cursor explícitamente
    FETCH c_compras INTO v_compra; -- Intentar obtener la primera fila
    LV_GANANCIA_VENTA := 0;
    -- Manejar el caso en que no se encuentren compras
    IF c_compras%NOTFOUND THEN
        DBMS_OUTPUT.PUT_LINE('No se encontraron compras para el cliente con ID ' || P_CLIENTE_ID);
    ELSE
        DBMS_OUTPUT.PUT_LINE('Estas son las compras del cliente '
            ||v_compra.nombre_cliente);
        -- Si se encontró una fila, procesarla y continuar con el bucle
        LOOP
            DBMS_OUTPUT.PUT_LINE(
                ', Producto: ' || v_compra.producto ||
                ', Precio: ' || v_compra.precio ||
                ', Cantidad: ' || v_compra.cantidad ||
                ', Subtotal: ' || v_compra.subtotal
            );
            LV_GANANCIA_VENTA := LV_GANANCIA_VENTA + v_compra.subtotal;
            FETCH c_compras INTO v_compra; -- Extraer la siguiente fila
            EXIT WHEN c_compras%NOTFOUND; -- Salir cuando no haya más filas
        END LOOP;
        DBMS_OUTPUT.PUT_LINE('La ganancia total es de: '
            ||LV_GANANCIA_VENTA);
    END IF;
    close c_compras; --cerrar el cursor
END;
/

EXECUTE PK_VENTAS_DE_CLIENTE(5);

/*
    6. CREA UN TRIGGER DE AUDITORIA PARA REGISTRAR CUANDO SE REALICE 
    UNA NUEVA VENTA
*/