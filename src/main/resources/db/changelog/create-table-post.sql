CREATE TABLE IF NOT EXISTS instagram_post (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id BIGINT NOT NULL,
    image_url varchar(200) NOT NULL,
    likes BIGINT DEFAULT 0,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at  TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at  TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE instagram_post
    ADD FOREIGN KEY (user_id) REFERENCES instagram_user(id);