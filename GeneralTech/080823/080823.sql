-- 1) Display the number of suppliers not from the UK and not from China:

-- SELECT COUNT(*) AS SupplierCount
-- FROM Suppliers
-- WHERE Country NOT IN ('UK', 'China');

-- 2) Display average/MAX/MIN cost and number of products from categories 3 and 5:

-- SELECT
-- COUNT(*) As total_products,
-- Max(Price) AS MaxPrice,
-- Min(Price) AS MinPrice,
-- AVG(Price) AS AVGPrice
-- FROM Products
-- WHERE CategoryID IN (3, 5);

-- 3) Display the total amount of Products which sold:

-- SELECT SUM(OrderDetails.Quantity * Products.Price) AS TotalSales
-- FROM OrderDetails 
-- JOIN Products ON OrderDetails.ProductID = Products.ProductID
-- JOIN Orders ON OrderDetails.OrderID = Orders.OrderID;

-- 4) Display the number of countries that supply drinks:

-- SELECT COUNT(DISTINCT Suppliers.Country) AS NumberOfCountries
-- FROM Suppliers 
-- JOIN Products ON Suppliers.SupplierID = Products.SupplierID
-- JOIN Categories ON Products.CategoryID = Categories.CategoryID
-- WHERE Categories.CategoryName = 'Beverages';

-- 5) Display the amount for which Products were sent to customers in the USA:

-- SELECT SUM(OrderDetails.Quantity * Products.Price) AS TotalAmountSentToUSA
-- FROM OrderDetails 
-- JOIN Orders ON OrderDetails.OrderID = Orders.OrderID
-- JOIN Customers ON Orders.CustomerID = Customers.CustomerID
-- JOIN Products ON OrderDetails.ProductID = Products.ProductID
-- WHERE Customers.Country = 'USA';




