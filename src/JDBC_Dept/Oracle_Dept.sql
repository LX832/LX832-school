select * from Departments;
alter user hr account unlock;
alter user hr identified by hr;
select * from departments;
create table Departments(
   Department_ID number(4,0) primary key,
   Department_NAME   not null,
   Manager_ID number(6,0),
   Location_ID number(4,0)
);
-CRUD Coding : select,delete,insert,update(method call)