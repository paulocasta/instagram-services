create TABLE IF NOT EXISTS instagram_user (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    first_name varchar(30) NOT NULL,
    last_name varchar(30) NOT NULL,
    username varchar(50) NOT NULL,
    email varchar(100) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at  TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at  TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);
