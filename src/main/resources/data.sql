-- Insert data into Restaurant table
INSERT INTO restaurant (name, address, cuisinetype, rating) VALUES
('Fine Dining', '123 Main St', 'European', 5),
('Taco Bell', '456 Elm St', 'Fast Food', 3),
('Sushi Place', '789 Oak St', 'Japanese', 4);

-- Insert data into Chef table
INSERT INTO chef (firstname, lastname, expertise, experienceyears, restaurantid) VALUES
('John', 'Doe', 'Sous Chef', 5, 1),
('Jane', 'Doe', 'Pastry Chef', 7, 1),
('Mike', 'Smith', 'Head Chef', 10, 2),
('Emily', 'Johnson', 'Sushi Chef', 8, 3),
('Anna', 'Williams', 'Pastry Chef', 6, 3),
('Mark', 'Brown', 'Sous Chef', 4, 2);
