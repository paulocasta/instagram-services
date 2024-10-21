CREATE TABLE IF NOT EXISTS instagram_comment (
        id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
        post_id BIGINT NOT NULL,
        from_user_id BIGINT NOT NULL,
        comment varchar(200) NOT NULL,
        active BOOLEAN NOT NULL DEFAULT TRUE,
        created_at  TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
        updated_at  TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE instagram_comment
    ADD FOREIGN KEY (post_id) REFERENCES instagram_post(id);

ALTER TABLE instagram_comment
    ADD FOREIGN KEY (from_user_id) REFERENCES instagram_user(id);