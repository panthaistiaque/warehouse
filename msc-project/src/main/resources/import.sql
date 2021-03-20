INSERT INTO role (role_name) VALUES ('ROLE_SM');
INSERT INTO role (role_name) VALUES  ('ROLE_WM');
INSERT INTO role (role_name) VALUES ('ROLE_WS');
INSERT INTO role (role_name) VALUES ('ROLE_MTM');
INSERT INTO role (role_name) VALUES ('ROLE_S');

insert into users(email, first_name, last_name, password, phone) values ('pantha@gmail.com', 'Pantha', 'Istiaqe','123', '01685331016');
insert into user_role(id, role_id) values (1,1);

into suppliers(address, contact_person_name, contact_person_phone, email, name, remarks, type) values ('16 Akmol khan road, Mitford', 'Panta', '01685331016', 'panthaistiaque@gmail.com', 'IH Traders', null, 'Vendor');
into suppliers(address, contact_person_name, contact_person_phone, email, name, remarks, type) values ('39 New market, Dhaka', 'Istiaque', '01721672283', 'panthaistiaque@gmail.com', 'Thai Brothers and Co.', null, 'Vendor');