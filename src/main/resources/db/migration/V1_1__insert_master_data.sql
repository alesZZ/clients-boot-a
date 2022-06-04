INSERT INTO client_types(id, name, created_at, created_by, updated_at, updated_by)
VALUES
    (1, 'Person', UTC_TIMESTAMP(), NULL, NULL, NULL),
    (2, 'Company', UTC_TIMESTAMP(), NULL, NULL, NULL);

INSERT INTO client_states(id, name, created_at, created_by, updated_at, updated_by)
VALUES
    (0, 'Inactive', UTC_TIMESTAMP(), NULL, NULL, NULL),
    (1, 'Active', UTC_TIMESTAMP(), NULL, NULL, NULL);