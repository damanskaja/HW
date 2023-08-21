-- 1) Find the min/cost of items for each category

SELECT 
CategoryName,
MIN(Products.Price) AS MinPrice,
MAX(Products.Price) AS MaxPrice
FROM 
Categories
JOIN 
Products ON Categories.CategoryID = Products.CategoryID
GROUP BY 
Categories.CategoryName;


-- 2) Display the TOP 3 countries by the number of delivered orders

SELECT 
Customers.Country,
COUNT(Orders.OrderID) AS DeliveredOrders
FROM 
Customers
JOIN 
Orders ON Customers.CustomerID = Orders.CustomerID
WHERE 
Orders.OrderDate IS NOT NULL
GROUP BY 
Customers.Country
ORDER BY 
DeliveredOrders DESC
LIMIT 3;

-- 3) Display the names of categories in which there are more than 10 products

SELECT 
Categories.CategoryName,
COUNT(Products.ProductID) AS ProductCount
FROM 
Categories 
JOIN 
Products  ON Categories.CategoryID = Products.CategoryID
GROUP BY 
Categories.CategoryName
HAVING 
ProductCount > 10;


-- 4)Clear phone/number for suppliers from USA

UPDATE Suppliers
SET Phone = NULL
WHERE Country = 'USA';


-- 5) Display the names and surnames (and number of orders) of managers who have a number of orders less than 15

SELECT 
Employees.FirstName,
Employees.LastName,
COUNT(Orders.EmployeeID) AS OrderCount
FROM 
Employees 
JOIN 
Orders ON Employees.EmployeeID = Orders.EmployeeID
GROUP BY 
Employees.FirstName, Employees.LastName
HAVING 
OrderCount < 15;


-- 6) Display the product that is in second place in the number of orders

SELECT 
Products.ProductName,
COUNT(OrderDetails.ProductID) AS OrderCount
FROM 
Products 
JOIN 
OrderDetails ON Products.ProductID = OrderDetails.ProductID
GROUP BY 
Products.ProductName
ORDER BY 
OrderCount DESC
LIMIT 1 OFFSET 1;
