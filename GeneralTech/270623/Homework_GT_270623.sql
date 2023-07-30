--Вывести телефоны всех поставщиков, кроме тех, что из Germany и France.
SELECT SupplierName, Phone
FROM Suppliers
WHERE Country NOT IN ('Germany', 'France');

--Добавить два произвольных товара.
INSERT INTO Products (ProductName, Price, CategoryID)
VALUES ('Product A', 10.99, 1), (‘Product B', 25, 2);

--Удалить поставщиков из USA и Germany.
DELETE FROM Suppliers
WHERE Country IN ('USA', 'Germany');

--Вывести все товары до 20 EUR из категорий 3 и 6 по убыванию цены.
SELECT ProductName, Price
FROM Products
WHERE Price <= 20 AND CategoryID IN (3, 6)
ORDER BY Price DESC;

--Вывести номера трех последних заказов.
SELECT OrderID
FROM Orders
ORDER BY OrderDate DESC
LIMIT 3;
