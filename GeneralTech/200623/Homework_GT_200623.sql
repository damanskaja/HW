--Output the name and cost of items from 20 to 200 EUR:
SELECT name, cost
FROM items
WHERE cost BETWEEN 20 AND 200;


--Display the goods from vendors 2 and 4 in descending order of price:
SELECT *
FROM items
WHERE vendor_id IN (2, 4)
ORDER BY price DESC;


--Display the items by adding a "price discount" of 12.5%:
SELECT name, cost, cost * 0.875 AS discounted_price
FROM items;


--Change the phone numbers of Vendors 3 and 5 to arbitrary values:
UPDATE vendors
SET phone_number = 'new_phone_number'
WHERE vendor_id IN (3, 5)