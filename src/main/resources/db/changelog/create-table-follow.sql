CREATE TABLE IF NOT EXISTS instagram_follow (
        user_id BIGINT NOT NULL,
        follow_by BIGINT NOT NULL,
        active BOOLEAN NOT NULL DEFAULT TRUE,
        created_at  TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
        updated_at  TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE instagram_follow
    ADD FOREIGN KEY (user_id) REFERENCES instagram_user(id);

ALTER TABLE instagram_follow
    ADD FOREIGN KEY (follow_by) REFERENCES instagram_user(id);

ALTER TABLE instagram_follow
    ADD CONSTRAINT UC_Follow UNIQUE (user_id, follow_by);