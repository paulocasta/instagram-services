CREATE TABLE IF NOT EXISTS instagram_like (
                                              user_id BIGINT NOT NULL,
                                              like_by BIGINT NOT NULL,
                                              post_id BIGINT NOT NULL,
                                              active BOOLEAN NOT NULL DEFAULT TRUE,
                                              created_at  TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
                                              updated_at  TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE instagram_like
    ADD FOREIGN KEY (user_id) REFERENCES instagram_user(id);

ALTER TABLE instagram_like
    ADD FOREIGN KEY (like_by) REFERENCES instagram_user(id);

ALTER TABLE instagram_like
    ADD FOREIGN KEY (post_id) REFERENCES instagram_post(id);

ALTER TABLE instagram_like
    ADD CONSTRAINT UC_Like UNIQUE (user_id, like_by, post_id);