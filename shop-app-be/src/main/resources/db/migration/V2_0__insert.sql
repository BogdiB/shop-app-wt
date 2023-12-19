INSERT INTO product_categories
(description,
name)
VALUES ( 'new kitchen supplies',
'kitchen'
);

INSERT INTO products
(price, weight,
category_id,
description,
imageurl,
name)
VALUES (5, 2, (select id from product_categories where name ='kitchen' limit 1), 'blabla', 'ahsdvkahvd', 'spoon');

INSERT INTO products
(price, weight,
category_id,
description,
imageurl,
name)
VALUES (5, 2, (select id from product_categories where name ='kitchen' limit 1), 'blabla', 'ahsdvkahvd', 'fork');


INSERT INTO products
(price, weight,
category_id,
description,
imageurl,
name)
VALUES (5, 2, (select id from product_categories where name ='kitchen' limit 1), 'blabla', 'ahsdvkahvd', 'knife');

INSERT INTO products
(price, weight,
category_id,
description,
imageurl,
name)
VALUES (5, 2, (select id from product_categories where name ='kitchen' limit 1), 'blabla', 'ahsdvkahvd', 'glass');

INSERT INTO products
(price, weight,
category_id,
description,
imageurl,
name)
VALUES (5, 2, (select id from product_categories where name ='kitchen' limit 1), 'blabla', 'ahsdvkahvd', 'bowl');

INSERT INTO locations
(country,
city,
county,
street,
name)
VALUES ('Romania','Timisoara','Timis','Aleea Studentilor', 'Depozit1');

INSERT INTO locations
(country,
city,
county,
street,
name)
VALUES ('Romania','Timisoara','Timis','Aleea Studentilor', 'Depozit2');

INSERT INTO customers
(first_name,
last_name,
username,
password,
email_address)
VALUES ('John','Doe','JohnDoe','password', 'john_doe@joe.com');

INSERT INTO stock
(product_id,
location_id,
quantity)
VALUES ((select id from products where name ='fork' limit 1), (select id from locations where name ='Depozit1' limit 1), 15);

INSERT INTO stock
(product_id,
location_id,
quantity)
VALUES ((select id from products where name ='spoon' limit 1), (select id from locations where name ='Depozit1' limit 1), 10);


INSERT INTO stock
(product_id,
location_id,
quantity)
VALUES ((select id from products where name ='knife' limit 1), (select id from locations where name ='Depozit1' limit 1), 7);

INSERT INTO stock
(product_id,
location_id,
quantity)
VALUES ((select id from products where name ='fork' limit 1), (select id from locations where name ='Depozit2' limit 1), 4);

INSERT INTO stock
(product_id,
location_id,
quantity)
VALUES ((select id from products where name ='glass' limit 1), (select id from locations where name ='Depozit2' limit 1), 9);

INSERT INTO stock
(product_id,
location_id,
quantity)
VALUES ((select id from products where name ='bowl' limit 1), (select id from locations where name ='Depozit2' limit 1), 6);