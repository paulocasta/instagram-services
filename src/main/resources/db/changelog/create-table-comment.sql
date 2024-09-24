CREATE TABLE IF NOT EXISTS instgram_comment (
        id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
        post_id BIGINT NOT NULL,
        from_user_id BIGINT NOT NULL,
        comment varchar(200) NOT NULL,
        active BOOLEAN NOT NULL DEFAULT TRUE,
        created_at  TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL
);

ALTER TABLE instgram_comment
    ADD FOREIGN KEY (post_id) REFERENCES instgram_post(id);

ALTER TABLE instgram_comment
    ADD FOREIGN KEY (from_user_id) REFERENCES instgram_user(id);