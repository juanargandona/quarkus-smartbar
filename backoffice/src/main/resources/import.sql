-- Categories
insert into categories values (1000, 'Coffee', 'Coffee');
insert into categories values (1001, 'Food', 'Food');
insert into categories values (1002, 'Soft drinks', 'Soft drinks');

-- Articles
-- Coffee
insert into articles values (2.50, 1000, 2000, 'Espresso', 'Espresso', 'ABC');
insert into articles values (3.50, 1000, 2001, 'Latte', 'Latte', 'ABC');
insert into articles values (4.00, 1000, 2002, 'Iced coffee', 'Iced coffee', 'ABC');

-- Food
insert into articles values (3.00, 1001, 2003, 'Donuts', 'Donuts', 'ABC');
insert into articles values (3.80, 1001, 2004, 'Croissant', 'Croissant', 'ABC');
insert into articles values (4.00, 1001, 2005, 'Breakfast Sandwich', 'Breakfast Sandwich', 'ABC');
insert into articles values (6.00, 1001, 2006, 'pizza', 'pizza', 'ABC');

-- Softdrinks
insert into articles values (2.80, 1002, 2007, 'Coca-Cola Classic', 'Coca-Cola Classic', 'ABC');
insert into articles values (3.20, 1002, 2008, 'Mountain Dew', 'Mountain Dew', 'ABC');
insert into article values (2.00, 1002, 2009, 'Water', 'Water', 'ABC');

-- Tables
insert into tables values (true, 4, 3000, 'Oslo');
insert into tables values (true, 8, 3001, 'Stockholm');
insert into tables values (true, 12, 3002, 'New York');
insert into tables values (false, 4, 3003, 'Munich');
insert into tables values (true, 6, 3004, 'Barcelona');