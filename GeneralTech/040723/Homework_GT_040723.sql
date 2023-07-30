--Retrieve customers from Germany whose name has an a in it and customers from France whose name has a b in it 
SELECT *
FROM Customers
WHERE (Country = 'Germany' AND CustomerName LIKE '%a%')
   OR (Country = 'France' AND CustomerName LIKE '%b%');

--Output the two cheapest products whose names end with u.
SELECT TOP 2 *
FROM Products
WHERE ProductName LIKE '%u'
ORDER BY Price;

--Apply a permanent discount to the goods from categories 1 and 3, with:
--for category 1 - 29% discount
--for category 3 - 0.5%

UPDATE Products
SET Price = Price * 0.71
WHERE CategoryID = 1;

UPDATE Products
SET Price = Price * 0.995 
WHERE CategoryID = 3;


-—Output data on shipping companies, and hide the phone numbers of those companies from Australia (projection: company_name, phone number).

SELECT CompanyName
  CASE WHEN Country = 'Australia' THEN 'Hidden' ELSE Phone END AS Phone
FROM
  Customers
WHERE
  City = 'Shipping'
ORDER BY
  CompanyName;

—-Display cities of customers not from Germany and cities of suppliers not from USA
SELECT DISTINCT City AS CustomerCity, City AS SupplierCity
FROM Customers, Suppliers
WHERE Country != 'Germany' AND Country != 'USA';
