CREATE TABLE line(
  id INT AUTO_INCREMENT PRIMARY KEY ,
  lineKey VARCHAR(256) NOT NULL ,
  lineContent LONGTEXT NOT NULL ,
  uin VARCHAR(16) NOT NULL ,
  model VARCHAR(16) NULL ,
  qua VARCHAR(32) NULL
) DEFAULT CHAR SET utf8;

CREATE TABLE lineNode(
  id INT AUTO_INCREMENT PRIMARY KEY ,
  lineId INT NOT NULL ,
  lineKey VARCHAR(256) NOT NULL ,
  nodeId VARCHAR(12) NOT NULL ,
  level INT NOT NULL DEFAULT 0,
  fromMethod VARCHAR(128) NOT NULL ,
  lineNumber INT,
  toMethod VARCHAR(128) NOT NULL ,
  costTime INT
) DEFAULT CHAR SET utf8;

CREATE TABLE zz_upload(
  f_id INT AUTO_INCREMENT PRIMARY KEY ,
  f_url VARCHAR(256) NOT NULL ,
  f_qq VARCHAR(64) NOT NULL ,
  p_id INT,
  f_uploadtime TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP
) DEFAULT CHAR SET utf8;

INSERT INTO zz_upload(f_url,f_qq,p_id)
    VALUES ('http://127.0.0.1/data.zip','23432443',8),
      ('localhost/data.zip','43543543',8),
      ('localhost/data.zip','43543543',3);