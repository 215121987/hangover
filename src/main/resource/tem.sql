with(id, category, parent_category_id, level, hierarchy) as
(select a.id, a.category, a.parent_category_id, b.level+1,b.hierarchy+' -> '+ a.category from category a inner join tree b on a.parent_category_id = b.id)
select id, category, parent_category_id, level, hierarchy from tree order by category;


 DELIMITER $$

CREATE PROCEDURE `GetItem`(int_catId varchar(20))
BEGIN
 with tree(id, Name, parent_category_id, level, hierarchy) as
(
 select id, Name, parent_category_id, 0, cast(Name as varchar(max))
   from category
   where id is 0
 union all
 select a.id, a.Name, a.parent_category_id, b.level+1,
   b.hierarchy+' -> '+a.category
  from category a
  inner join tree b on a.parent_category_id=b.id
)
select id,  Name, parent_category_id, level, hierarchy
 from tree
 order by hierarchy;

 END $$
 DELIMITER;


  with tree(StaffID, Manager, Name, JobTitle, Level, Hierarchy) as
(
 select StaffID, null, Name, JobTitle, 0, cast(Name as varchar(max))
   from tblStaff
   where Manager is null
 union all
 select a.StaffID, a.Manager, a.Name, a.JobTitle, b.Level+1,
   b.Hierarchy+' -> '+a.Name
  from tblStaff a
  inner join tree b on a.Manager=b.StaffID
)
select StaffID, Manager, Name, JobTitle, Level, Hierarchy
 from tree
 order by Hierarchy

 insert into category(id, name, description, level, parent_category_id) value(1, 'Sports', 'Sports', 0, null);
 insert into category(id, name, description, level, parent_category_id) value(2, 'Football', 'Football', 1, 1);
 insert into category(id, name, description, level, parent_category_id) value(3, 'Indoor', 'Indoor', 1, 1);
 insert into category(id, name, description, level, parent_category_id) value(4, 'TT', 'Table tennis', 2, 3);
 insert into category(id, name, description, level, parent_category_id) value(5, 'Night', 'Night Game', 2, 3);
 insert into category(id, name, description, level, parent_category_id) value(6, 'Batminton', 'Batminton', 3, 5);


  insert into brand(id, code, name,displayName, description) value(1,'kf22', 'Kingfisher', 'Kingfisher', 'Alcohol');

  insert into supplier(id, code, companyName) value(1,'As22', 'Hangover');

  insert into supplier_location(id, street, city,state, country, zipCode,supplier_id , mainBranch) value(1,'New Thippasandra', 'Bangalore', 'Karnataka', 'India','560075', 1, 1);

   insert into item(id, name, description,count, supplier_location_id, category_id, brand_id) value(1,'Vodka', 'http://livedemo00.template-help.com/woocommerce_53953/wp-content/uploads/2013/09/Antica-Formula-Carpano-Vermouth-1L-4-300x300.png',10, 1,3, 1);


   insert into item_detail(id, size, quantity, modelNumber,  sellingPrice,item_id) value(1,'300', '20','AXYZ', '89', 1);
   insert into item_detail(id, size, quantity, modelNumber,  sellingPrice,item_id) value(2,'600', '20','AXYZ', '189', 1);

   insert into item(id, name, description,count, supplier_location_id, category_id, brand_id) value(2,'Beer', 'http://livedemo00.template-help.com/woocommerce_53953/wp-content/uploads/2013/09/Antica-Formula-Carpano-Vermouth-1L-4-300x300.png',10, 1,2, 1);
   insert into item_detail(id, size, quantity, modelNumber,  sellingPrice,item_id) value(3,'300', '20','AXYZ', '79', 2);
   insert into item_detail(id, size, quantity, modelNumber,  sellingPrice,item_id) value(4,'600', '20','AXYZ', '179', 2);

   insert into item(id, name, description,count, supplier_location_id, category_id, brand_id) value(3,'Wine', 'http://livedemo00.template-help.com/woocommerce_53953/wp-content/uploads/2013/09/Antica-Formula-Carpano-Vermouth-1L-4-300x300.png',10, 1,5, 1);
   insert into item_detail(id, size, quantity, modelNumber,  sellingPrice,item_id) value(5,'300', '20','AXYZ', '99', 3);
   insert into item_detail(id, size, quantity, modelNumber,  sellingPrice,item_id) value(6,'600', '20','AXYZ', '199', 3);

   insert into user_address(id, address, street, city, state, country, zipCode, user_id) value(1,'4th B cross, 9th Main', 'New Thippasandra', 'Bangalore', 'Karnataka', 'India', '566075',1);
   insert into user_address(id, address, street, city, state, country, zipCode, user_id) value(2,'2nd cross, 6th Main', 'Indira Nagar', 'Bangalore', 'Karnataka', 'India', '566036',1);

  insert into item(id, name, description,count, supplier_location_id, category_id, brand_id) value(4,'Wine', 'http://livedemo00.template-help.com/woocommerce_53953/wp-content/uploads/2013/09/Antica-Formula-Carpano-Vermouth-1L-4-300x300.png',10, 1,5, 1);
   insert into item_detail(id, size, quantity, modelNumber,  sellingPrice,item_id) value(7,'300', '20','AXYZ', '99', 4);
   insert into item_detail(id, size, quantity, modelNumber,  sellingPrice,item_id) value(8,'600', '30','AXYZ', '199', 4);

   insert into item(id, name, description,count, supplier_location_id, category_id, brand_id) value(5,'Wine', 'http://livedemo00.template-help.com/woocommerce_53953/wp-content/uploads/2013/09/Antica-Formula-Carpano-Vermouth-1L-4-300x300.png',10, 1,5, 1);
   insert into item_detail(id, size, quantity, modelNumber,  sellingPrice,item_id) value(9,'300', '40','AXYZ', '99', 5);
   insert into item_detail(id, size, quantity, modelNumber,  sellingPrice,item_id) value(10,'600', '30','AXYZ', '199', 5);


   insert into order_entity(id, orderId, customer_id, totalAmount,  order_from,shipping_address_id) value(1,'12345678', 1, 1299, '0', 1);
   insert into order_entity(id, orderId, customer_id, totalAmount,  order_from,shipping_address_id) value(2,'12345679', 1, 1399, '0', 1);
   insert into order_item(id, item_id, itemSize, price,  quantity,order_id, order_item_state, deliverBy) value(1,1,'300', 199, 5, 1, 0, null);
   insert into order_item(id, item_id, itemSize, price,  quantity,order_id, order_item_state, deliverBy) value(2,1,'600', 299, 5, 1, 0, null);

   insert into order_item(id, item_id, itemSize, price,  quantity,order_id, order_item_state, deliverBy) value(3,1,'600', 399, 5, 2, 0, null);

   insert into service_charge(id, name, value, is_percent) value(1,'VAT',14, 1);
   insert into service_charge(id, name, value, is_percent) value(2,'CST',5, 1);
   insert into service_charge(id, name, value, is_percent) value(3,'SBAT',0.5, 1);
   insert into service_charge(id, name, value, is_percent) value(4,'KKT',0.5, 1);
   insert into service_charge(id, name, value, is_percent) value(5,'Min Delivery Value',200, 0);
   insert into service_charge(id, name, value, is_percent) value(6,'delivery charge',100, 0);


   insert into user(id,created_at, updated_at,accountNonExpired,accountNonLocked,credentialsNonExpired, enabled,
  name, username, email, password, password_type, numberVerified)
   value(2, '2015-06-26 12:40:55', '2015-06-26 12:40:55',1,1,1,1, 'Lokesh Sharma','lokesh.sharma@gmail.com','lokesh.sharma@gmail.com',
'8e5d3299950d242bd51ea91c68ac08f9a79852b83a84822e3cc33ae51c3bea4208800afba20c6637c0c1d102bffbdf9cd3ddeb30658992c5553ab6d8ba0363f5',0,1);

insert into user_role(user_id,role_id) value(2,3);

insert into user(id,created_at, updated_at,accountNonExpired,accountNonLocked,credentialsNonExpired, enabled,
  name, username, email, password, password_type, numberVerified)
   value(3, '2015-06-26 12:40:55', '2015-06-26 12:40:55',1,1,1,1, 'Uday Kumar','uday.kumar@gmail.com','uday.kumar@gmail.com',
'8e5d3299950d242bd51ea91c68ac08f9a79852b83a84822e3cc33ae51c3bea4208800afba20c6637c0c1d102bffbdf9cd3ddeb30658992c5553ab6d8ba0363f5',0,1);

insert into user_role(user_id,role_id) value(3,5);

insert into user(id,created_at, updated_at,accountNonExpired,accountNonLocked,credentialsNonExpired, enabled,
  name, username, email, password, password_type,numberVerified)
   value(4, '2015-06-26 12:40:55', '2015-06-26 12:40:55',1,1,1,1, 'Rahul Kundra','rahul.kundra@gmail.com','rahul.kundra@gmail.com',
'8e5d3299950d242bd51ea91c68ac08f9a79852b83a84822e3cc33ae51c3bea4208800afba20c6637c0c1d102bffbdf9cd3ddeb30658992c5553ab6d8ba0363f5',0,1);

insert into user_role(user_id,role_id) value(4,6);

insert into user(id,created_at, updated_at,accountNonExpired,accountNonLocked,credentialsNonExpired, enabled,
  name, username, email, password, password_type,numberVerified)
   value(5, '2015-06-26 12:40:55', '2015-06-26 12:40:55',1,1,1,1, 'Arvind Kumar','Arvind.Kumar@gmail.com','Arvind.Kumar@gmail.com',
'8e5d3299950d242bd51ea91c68ac08f9a79852b83a84822e3cc33ae51c3bea4208800afba20c6637c0c1d102bffbdf9cd3ddeb30658992c5553ab6d8ba0363f5',0,1);

insert into user_role(user_id,role_id) value(5,4);















 SELECT t1.id, t1.name, t1.parent_category_id FROM
category AS t1 LEFT JOIN category as t2
ON t1.id = t2.parent_category_id
WHERE t2.id IS NULL;


select @pv:=id as category_id, name, parent_category_id from category join (select @pv:=1)tmp where parent_category_id=@pv;


select  id,  name,parent_category_id from    (select * from category order by parent_category_id, id) base, (select @pv := '2') tmp where   find_in_set(parent_category_id, @pv) > 0 and     @pv := concat(@pv, ',', id);



select  id,  name,parent_category_id from    (select * from category) base, (select @pv := '1,3,5,6') tmp where find_in_set(parent_category_id, @pv)>0 or find_in_set(id, @pv) and     @pv := concat(@pv, ',', id);