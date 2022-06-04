CREATE TABLE client_types (
  id TINYINT(1) UNSIGNED NOT NULL,
  name VARCHAR(50) NOT NULL,
  created_at DATETIME NOT NULL,
  created_by BINARY(16) NULL,
  updated_at DATETIME NULL,
  updated_by BINARY(16) NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX UQ_clients_types_name(name)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE client_states (
  id TINYINT(1) UNSIGNED NOT NULL,
  name VARCHAR(50) NOT NULL,
  created_at DATETIME NOT NULL,
  created_by BINARY(16) NULL,
  updated_at DATETIME NULL,
  updated_by BINARY(16) NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX UQ_clients_states_name(name)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE clients (
  id BINARY(16) NOT NULL,
  address VARCHAR(150) NOT NULL,
  email VARCHAR(150) NOT NULL,
  phone VARCHAR(50) NOT NULL,
  client_type_id TINYINT(1) UNSIGNED NOT NULL,
  client_state_id TINYINT(1) UNSIGNED NOT NULL,
  dni CHAR(8) NULL,
  first_name VARCHAR(75) NULL,
  last_name VARCHAR(75) NULL,
  ruc CHAR(11) NULL,
  company_name VARCHAR(150) NULL,
  created_at DATETIME NOT NULL,
  created_by BINARY(16) NULL,
  updated_at DATETIME NULL,
  updated_by BINARY(16) NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX UQ_clients_dni(dni),
  UNIQUE INDEX UQ_clients_ruc(ruc),
  INDEX IX_clients_first_last_name(first_name, last_name),
  INDEX IX_clients_client_type_id(client_type_id),
  INDEX IX_clients_client_state_id(client_state_id),
  CONSTRAINT FK_clients_client_type_id FOREIGN KEY(client_type_id) REFERENCES client_types(id),
  CONSTRAINT FK_clients_client_state_id FOREIGN KEY(client_state_id) REFERENCES client_states(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;