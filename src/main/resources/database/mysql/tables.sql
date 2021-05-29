CREATE TABLE categories(
	code BINARY(16) NOT NULL,
	name VARCHAR(100) NOT NULL,
	description VARCHAR(255),
	created_at DATETIME NOT NULL,
	updated_at DATETIME DEFAULT NULL,
	deleted_at DATETIME DEFAULT NULL,
	is_active BOOLEAN DEFAULT FALSE,
	PRIMARY KEY (code)
);
