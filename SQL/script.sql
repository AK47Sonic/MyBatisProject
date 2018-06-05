CREATE DATABASE mybatis CHARACTER SET UTF8;

CREATE TABLE tbl_employee (
id INT(11) PRIMARY KEY AUTO_INCREMENT,
last_name VARCHAR(255),
gender CHAR(1),
email VARCHAR(255)
)

CREATE TABLE tbl_dept(
 id INT(11) PRIMARY KEY AUTO_INCREMENT,
 dept_name VARCHAR(255)
)

ALTER TABLE tbl_employee ADD COLUMN d_id INT(11)

ALTER TABLE tbl_employee ADD CONSTRAINT fk_emp_dept
FOREIGN KEY(d_id) REFERENCES tbl_dept(id)

