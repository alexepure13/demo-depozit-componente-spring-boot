create table T_CATEGORY(
        id INTEGER NOT NULL auto_increment,
        category_code INTEGER,
        quantity INTEGER,
        typeofcomponent VARCHAR(50),
        PRIMARY KEY(id)
);

create table T_COMPONENT(
    id INTEGER NOT NULL auto_increment,
    product_code INTEGER,
    manufacturer VARCHAR(50),
    name VARCHAR(100),
    price DOUBLE,
    quantity INTEGER,
    primary key(id),
    category_id integer,
    foreign key (category_id) references T_CATEGORY(id)
);