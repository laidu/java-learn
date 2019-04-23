CREATE TABLE druid_demo.app_user (
	id BIGINT NOT NULL AUTO_INCREMENT,
	username varchar(100) NULL,
	id_card varchar(100) NULL,
	CONSTRAINT app_user_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;
