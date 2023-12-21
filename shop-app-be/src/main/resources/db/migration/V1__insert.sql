INSERT INTO product_categories(description, name)
VALUES ('new kitchen supplies', 'kitchen');

INSERT INTO products
(price, weight, category_id, description, imageurl, name)
VALUES (5, 2, (select id from product_categories where name ='kitchen' limit 1), 'blabla', 'URL', 'spoon');