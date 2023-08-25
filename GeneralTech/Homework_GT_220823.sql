
-- 1) Remove all customers from China and Brazil

DELETE FROM Customers
WHERE Country IN ('China', 'Brazil');


-- 2) Display the name of the category with the highest average cost of products

SELECT Categories.CategoryName
FROM Categories
JOIN Products ON Categories.CategoryID = Products.CategoryID
GROUP BY Categories.CategoryName
ORDER BY AVG(Products.Price) DESC
LIMIT 1;


-- 3) Display the names of the three products that sell the worst

SELECT Products.ProductName
FROM Products
JOIN OrderDetails ON Products.ProductID = OrderDetails.ProductID
GROUP BY Products.ProductName
ORDER BY SUM(OrderDetails.Quantity) ASC
LIMIT 3;

-- 4) Display the name of shipper that has the fewest orders

SELECT Shippers.ShipperName
FROM Shippers
LEFT JOIN Orders ON Shippers.ShipperID = Orders.ShipperID
GROUP BY Shippers.ShipperName
ORDER BY COUNT(Orders.OrderID) ASC
LIMIT 1;


-- 5) Display products by adding the field "discount price" to 15.5%

SELECT ProductName, Price, Price * 0.845 AS DiscountedPrice
FROM Products;


