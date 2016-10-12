insert into role(id,name, description) value(1, 'ROLE_SUPER_ADMIN','Super Admin');
insert into role(id,name, description) value(2, 'ROLE_ADMIN','Admin');
insert into role(id,name,description) value(3, 'ROLE_SUPPLIER','Supplier');
insert into role(id,name, description) value(4, 'ROLE_CUSTOMER','Customer');
insert into role(id,name, description) value(5, 'ROLE_STAFF','Staff');
insert into role(id,name, description) value(6, 'ROLE_DELIVERY','Delivery');
insert into user(id,created_at, updated_at,accountNonExpired,accountNonLocked,credentialsNonExpired, enabled,
  name, username, email, password, password_type)
   value(1, '2015-06-26 12:40:55', '2015-06-26 12:40:55',1,1,1,1, 'Ashif Qureshi','ashifqureshi15@gmail.com','ashifqureshi15@gmail.com',
'8e5d3299950d242bd51ea91c68ac08f9a79852b83a84822e3cc33ae51c3bea4208800afba20c6637c0c1d102bffbdf9cd3ddeb30658992c5553ab6d8ba0363f5',0);
insert into user_address(id, address, street, city, state, country, zipCode, user_id) value(1,'4th B cross, 9th Main', 'New Thippasandra', 'Bangalore', 'Karnataka', 'India', '566075',1);
insert into user_role(user_id,role_id) value(1,1);

insert into service_charge(id, name, value, is_percent) value(1,'VAT',14, 1);
insert into service_charge(id, name, value, is_percent) value(2,'CST',5, 1);
insert into service_charge(id, name, value, is_percent) value(3,'SBAT',0.5, 1);
insert into service_charge(id, name, value, is_percent) value(4,'KKT',0.5, 1);
insert into service_charge(id, name, value, is_percent) value(5,'Min Delivery Value',299.00, 0);
insert into service_charge(id, name, value, is_percent) value(6,'delivery charge',50.00, 0);

insert into category(id, name, description, level, parent_category_id) value(1, 'Alcohol', 'Alcohol', 0, null);
insert into category(id, name, description, level, parent_category_id) value(2, 'Whisky', 'Whisky', 0, 1);
insert into category(id, name, description, level, parent_category_id) value(3, 'Wine', 'Wine', 1, 1);
insert into category(id, name, description, level, parent_category_id) value(4, 'Rum', 'Indoor', 1, 1);
insert into category(id, name, description, level, parent_category_id) value(5, 'Beer', 'Beer', 1, 1);
insert into category(id, name, description, level, parent_category_id) value(6, 'Vodka', 'Vodka', 1, 1);
insert into category(id, name, description, level, parent_category_id) value(7, 'Scotch', 'Scotch', 1, 1);

insert into brand(id, code, name,displayName, description, category_id) value(1,'KK', 'Kingfisher', 'Kingfisher', 'Kingfisher',5);
insert into brand(id, code, name,displayName, description, category_id) value(2,'cb', 'Carlsberg', 'Carlsberg', 'Carlsberg',5);
insert into brand(id, code, name,displayName, description, category_id) value(3,'bws', 'Budweiser', 'Budweiser', 'Budweiser',5);
insert into brand(id, code, name,displayName, description, category_id) value(4,'Heineken', 'Heineken', 'Heineken', 'Heineken',5);
insert into brand(id, code, name,displayName, description, category_id) value(5,'crn', 'Corona', 'Corona', 'Corona',5);
insert into brand(id, code, name,displayName, description, category_id) value(6,'fl', 'Foster Lager', 'Foster Lager', ' Foster Lager',5);
insert into brand(id, code, name,displayName, description, category_id) value(7,'ds', 'Director’s Special', 'Director’s Special', 'Director’s Special',2);
insert into brand(id, code, name,displayName, description, category_id) value(8,'8pm', '8 PM Royale', '8 PM Royale', '8 PM Royale',2);
insert into brand(id, code, name,displayName, description, category_id) value(9,'ib', 'Imperial Blue', 'Imperial Blue', 'Imperial Blue',2);
insert into brand(id, code, name,displayName, description, category_id) value(10,'bpp', 'Bagpiper', 'Bagpiper', 'Bagpiper',2);
insert into brand(id, code, name,displayName, description, category_id) value(11,'rs', 'Royal Stag', 'Royal Stag', 'Royal Stag',2);
insert into brand(id, code, name,displayName, description, category_id) value(12,'oc', 'Officers Choice', 'Officers Choice', 'Officers Choice',2);
insert into brand(id, code, name,displayName, description, category_id) value(13,'mcd', 'McDowell’s No 1', 'McDowell’s No 1', 'McDowell’s No 1',2);
insert into brand(id, code, name,displayName, description, category_id) value(14,'snf', 'Smirnoff', 'Smirnoff', 'Smirnoff',6);
insert into brand(id, code, name,displayName, description, category_id) value(15,'esf', 'Eristoff', 'Eristoff', 'Eristoff',6);
insert into brand(id, code, name,displayName, description, category_id) value(16,'wm', 'White Mischief', 'White Mischief', 'White Mischief',6);
insert into brand(id, code, name,displayName, description, category_id) value(17,'wm', 'Romanov', 'Romanov', 'Romanov',6);
insert into brand(id, code, name,displayName, description, category_id) value(18,'mm', 'Magic Moments', 'Magic Moments', 'Magic Moments',6);
insert into brand(id, code, name,displayName, description, category_id) value(19,'abs', 'Absolut', 'Absolut', 'Absolut',6);

insert into supplier(id, code, companyName) value(1,'lad', 'Liquor At Door');
insert into supplier_store(id, street, city,state, country, zipCode,supplier_id , mainBranch) value(1,'New Thippasandra', 'Bangalore', 'Karnataka', 'India','560075', 1, 1);

insert into offers(title, subTitle, offer_type, offer_for, image_url, priority, description)
value('<h3>Get up to<br> 10% off</h3><h4>on Vodka</h4><h5>more than 50 items</h5>', '<h3>Free shipping</h3><h5>on orders over Rs299</h5>', 3, 0, 'http://liquoratdoor.com/hangover/images/banner/item-banner-3.jpg',1,'');

insert into offers(title, subTitle, offer_type, offer_for, image_url, priority, description)
value('<h3>Get up to<br> 10% off</h3><h4>on Beer</h4><h5>more than 50 items</h5>', '<h3>Free shipping</h3><h5>on orders over Rs299</h5>', 3, 0, 'http://liquoratdoor.com/hangover/images/banner/item-banner-2.jpg',1,'');

insert into offers(title, subTitle, offer_type, offer_for, image_url, priority, description)
value('<h3>Get up to<br> 10% off</h3><h4>on Whisky</h4><h5>more than 50 items</h5>', '<h3>Free shipping</h3><h5>on orders over Rs299</h5>', 3, 0, 'http://liquoratdoor.com/hangover/images/banner/item-banner-1.jpg',1,'');

insert into offers(title, subTitle, offer_type, offer_for, image_url, priority, description)
value('<h5>Pure organic grapes</h5>', '<h3>100%</h3><h4>Great tasting wine with a splash of fruit. Wines for momentous encounters.</h4>', 2, 0,'',1,'buy today for Rs399');


insert into offers(title, subTitle, offer_type, offer_for, image_url, priority, description)
value('<h4>Big sale<br/> of the year!</h4><h3>save up to 10%</h3>', '<h5>buy a 1l bottle for the 750ml price and</h5><p>get 30%<br/> off</p>', 0, 0,'http://liquoratdoor.com/hangover/images/banner/banner-2.jpg',1,'');

insert into banner(large_image_url, banner_type) value('http://liquoratdoor.com/hangover/images/banner/banner-1.jpg',0);






