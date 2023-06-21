
create table if not exists member(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
email char(50) NOT NULL,
passwod char(50) NOT NULL,
nick_name char(50) NOT NULL,
created_at date NOT NULL,
updated_at date NOT NULL
);

CREATE table if not exists friend(
    id int not null auto_increment primary key,
member_id int not null,
my_member_id int not null,
created_at date not null,
updated_at date not null,
FOREIGN KEY(member_id) REFERENCES member(id),
FOREIGN KEY(my_member_id) REFERENCES member(id)
);

CREATE table if not exists lol_information(
    id int not null auto_increment primary key,
member_id int not null,
lol_nick_name char(50) not null,
lol_tier char(20) not null,
created_at date not null,
updated_at date not null,
foreign key(member_id) references member(id)
);

CREATE table if not exists board(
    id int not null auto_increment primary key,
 member_id int not null,
title text not null,
content text not null,
created_at date not null,
updated_at date not null,
foreign key(member_id) references member(id)
);

CREATE table if not exists board_image(
   id int not null auto_increment primary key,
image_path text not null,
board_id int not null,
created_at date not null,
updated_at date not null,
foreign key(board_id) references board(id)
);

CREATE table if not exists room(
    id int not null auto_increment primary key,
member_id int not null,
room_title text not null,
content text not null,
created_at date not null,
updated_at date not null,
foreign key(member_id) references member(id)
);

CREATE table if not exists room_join_member(
    id int not null	auto_increment primary key,
room_id int not null,
member_id int not null,
created_at date not null,
updated_at date not null,
foreign key(room_id) references room(id),
foreign key(member_id) references member(id)
);