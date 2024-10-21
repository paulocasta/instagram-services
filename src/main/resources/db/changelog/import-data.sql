INSERT INTO instagram_user (first_name,last_name,username,email,active,created_at) VALUES
     ('labrador','scott','labrador_ok','labra@email.com',true,'2024-09-23 11:13:05.285'),
     ('collie','border','bcollie','bcollie@email.com',true,'2024-09-23 11:13:37.714'),
     ('doberman','black','dobermanb','doberman@email.com',true,'2024-09-23 11:13:37.714'),
     ('shiba','inu','shiba','shibainu@email.com',true,'2024-09-23 11:13:37.714'),
     ('stray','simona','simonalomas','simona@email.com',true,'2024-09-23 11:13:37.714'),
     ('sherman','shepherd','osass','osa@email.com',true,'2024-09-23 11:13:37.714');

INSERT INTO instagram_post (user_id,image_url,likes,active,created_at) VALUES
     (1,'https://t3.ftcdn.net/jpg/01/02/85/78/360_F_102857871_vJs4AnThry3AUb2Va5VMTfRUUKiVwsgh.jpg',1,true,'2024-09-23 11:14:56.123'),
     (2,'https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Border_collie_canon.jpg/640px-Border_collie_canon.jpg',1,true,'2024-09-23 11:15:27.921'),
     (3,'https://content.elmueble.com/medio/2023/10/13/perro-de-raza-doberman_d76a132d_231013233105_1000x1515.jpg',1,true,'2024-09-23 11:14:56.123'),
     (4,'https://www.purina.es/sites/default/files/2021-02/BREED%20Hero_0075_japanese_shiba_inu.jpg',1,true,'2024-09-23 11:15:27.921'),
     (5,'https://news.orvis.com/wp-content/uploads/2019/08/stray.jpg',1,true,'2024-09-23 11:14:56.123'),
     (6,'https://cdn.britannica.com/79/232779-050-6B0411D7/German-Shepherd-dog-Alsatian.jpg',1,true,'2024-09-23 11:15:27.921');

INSERT INTO instagram_comment (post_id, from_user_id,"comment",active,created_at) VALUES
    (1,2,'You look adorable',true,'2024-09-23 11:23:07.643'),
    (2,1,'I love that face',true,'2024-09-23 11:23:29.333'),
    (3,1,'Why the long face',true,'2024-09-23 11:23:29.333'),
    (3,2,'Why son angry bro',true,'2024-09-23 11:23:29.333'),
    (4,3,'Nice pose',true,'2024-09-23 11:23:29.333'),
    (4,1,'Love the look',true,'2024-09-23 11:23:29.333'),
    (5,1,'Beautiful!!!',true,'2024-09-23 11:23:29.333'),
    (5,2,'Don''t give up',true,'2024-09-23 11:23:29.333'),
    (5,3,'Stay strong my friend',true,'2024-09-23 11:23:29.333'),
    (5,4,'Smile! Better things will come',true,'2024-09-23 11:23:29.333'),
    (5,6,'Let''s be friends!!!',true,'2024-09-23 11:23:29.333'),
    (6,3,'I''m better than you',true,'2024-09-23 11:23:29.333');

INSERT INTO instagram_follow (user_id,follow_by,active,created_at) VALUES
    (1,2,true,'2024-09-23 11:23:29.333'),
    (1,3,true,'2024-09-23 11:23:29.333'),
    (1,4,true,'2024-09-23 11:23:29.333'),
    (1,5,true,'2024-09-23 11:23:29.333'),
    (1,6,true,'2024-09-23 11:23:29.333'),
    (2,1,true,'2024-09-23 11:23:29.333'),
    (2,3,true,'2024-09-23 11:23:29.333'),
    (2,4,true,'2024-09-23 11:23:29.333'),
    (2,5,true,'2024-09-23 11:23:29.333'),
    (2,6,true,'2024-09-23 11:23:29.333'),
    (3,1,true,'2024-09-23 11:23:29.333'),
    (3,2,true,'2024-09-23 11:23:29.333'),
    (3,4,true,'2024-09-23 11:23:29.333'),
    (3,5,true,'2024-09-23 11:23:29.333'),
    (4,1,true,'2024-09-23 11:23:29.333'),
    (4,2,true,'2024-09-23 11:23:29.333'),
    (4,5,true,'2024-09-23 11:23:29.333'),
    (5,1,true,'2024-09-23 11:23:29.333'),
    (5,2,true,'2024-09-23 11:23:29.333'),
    (5,3,true,'2024-09-23 11:23:29.333'),
    (5,4,true,'2024-09-23 11:23:29.333'),
    (5,6,true,'2024-09-23 11:23:29.333'),
    (6,2,true,'2024-09-23 11:23:29.333'),
    (6,5,true,'2024-09-23 11:23:29.333');