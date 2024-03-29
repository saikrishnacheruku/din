

-- Create chef table
CREATE TABLE chef (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    firstname TEXT,
    lastname TEXT,
    expertise TEXT,
    experienceyears INTEGER,
    restaurantid INTEGER,
    FOREIGN KEY (restaurantId) REFERENCES restaurant(id)
);

-- Create restaurant table
CREATE TABLE restaurant (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name TEXT,
    address TEXT,
    cuisinetype TEXT,
    rating INTEGER
);
