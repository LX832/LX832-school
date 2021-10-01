create sequence seq_address
increment by 1
start with 1
minvalue 1
maxvalue 99999;




create table address(
    seq number(7), 
    userid varchar2(30) not null,
    username varchar2(30) not null,
    address varchar2(60) not null,
    telphone varchar2(20) not null,
    primary key(userid)
);


insert into address values(seq_address.nextval,'111' ,'이조영','서울시 성동구 성수동','010-5019-9452');

commit;

select * from address;