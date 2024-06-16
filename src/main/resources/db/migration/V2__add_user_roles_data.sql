insert into roles (name, description) values ('ADMIN', 'Admin role');
insert into roles (name, description) values ('VIEW', 'View role');

insert into users (username, password, email) values ('admin', 'admin', 'admin@localhost');
insert into users (username, password, email) values ('user', 'user', 'user@localhost');

insert into users_roles (user_id, role_id) values (1, 1);
insert into users_roles (user_id, role_id) values (1, 2);
insert into users_roles (user_id, role_id) values (2, 2);
