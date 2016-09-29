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

insert into user_role(user_id,role_id) value(1,1);





