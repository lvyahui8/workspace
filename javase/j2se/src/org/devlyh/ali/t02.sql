CREATE TABLE users(
  id INT AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(24) NOT NULL COMMENT '用户名',
  created_at TIMESTAMP NOT NULL DEFAULT current_timestamp,
  updated_at TIMESTAMP
);

CREATE TABLE users_invest(
  id INT AUTO_INCREMENT PRIMARY KEY ,
  user_id INT NOT NULL ,
  money INT NOT NULL ,
  created_at TIMESTAMP NOT NULL DEFAULT current_timestamp,
  updated_at TIMESTAMP
);

CREATE TABLE product(
  id INT AUTO_INCREMENT PRIMARY KEY ,
  name  VARCHAR(255) NOT NULL ,
  money BIGINT not NULL ,
  min_invest INT not NULL DEFAULT 1000,
  max_invest INT ,
  rate INT NOT NULL DEFAULT 0,
  created_at TIMESTAMP NOT NULL DEFAULT current_timestamp,
  updated_at TIMESTAMP
);

INSERT INTO product (name,money,min_invest,max_invest,rate) VALUES ("万能险",2000000,1000,20000,18);

