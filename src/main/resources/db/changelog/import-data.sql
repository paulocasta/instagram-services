INSERT INTO instgram_user (first_name,last_name,username,email,active,created_at,updated_at) VALUES
     ('labrador','qt','labrador_ok','labra@email.com',true,'2024-09-23 11:13:05.285','2024-09-23 11:13:05.285'),
     ('collie','border','bcollie','bcollie@email.com',true,'2024-09-23 11:13:37.714','2024-09-23 11:13:37.714');

INSERT INTO instgram_post (user_id,image_url,likes,active,created_at) VALUES
     (1,'https://t3.ftcdn.net/jpg/01/02/85/78/360_F_102857871_vJs4AnThry3AUb2Va5VMTfRUUKiVwsgh.jpg',1,true,'2024-09-23 11:14:56.123'),
     (2,'https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Border_collie_canon.jpg/640px-Border_collie_canon.jpg',1,true,'2024-09-23 11:15:27.921');

INSERT INTO instgram_comment (post_id,from_user_id,"comment",active,created_at) VALUES
    (1,2,'You look adorable',true,'2024-09-23 11:23:07.643'),
    (2,1,'I love that face',true,'2024-09-23 11:23:29.333');

