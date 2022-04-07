use CEMSDatabase ;
INSERT INTO Club (club_id,club_name,club_description)
VALUES (1, 'All Clubs', ' This is a club with all clubs'),

(2,'Algoma U Business Society','The Algoma University Business Society (AUBS) is a student run club that
represents the interests of students pursuing their Bachelor of Business Administration degree at Algoma University.'),

 (3,'Bike Share Club','To provide an opportunity for students to go on bike
rides and trails. And to support the well-being of students.'),

(4,'Dance Club','Engage students with different stlyes of dance and cultures.'),

 (5,'Tech Environment Club', 'We are a club dedicated to technology initiatives at Algomau');

INSERT INTO User  (student_id,first_name,last_name,email_address,password_,phone_number,permissions,
salt,security_question,security_answer,club_club_id)
VALUES (999999999, 'Master', 'User','master@email.com',
    'ff0120461cdb27bc43d56335dcc9634b30891ceaebb150837a01ec41ac84d4e3',
    '555-123-4567', 'SuperAdmin', '[B@4bcdcfa',
    'What course is this project for?', 'COSC3506',1),
(111111111, 'System', 'Testing', 'test@email.com',
    '3c519bff0ca6e159c872bbd4d496223a60d3be4de7aabb0319475b05ea9a9e26',
    '555-123-4567', 'Admin+', '[B@e99d198',
    'What course is this project for?', 'COSC3506',1),
(111111122, 'Sara', 'Joe', 'Sara@email.com',
    '3c519bff0ca6e159c872bbd4d496223a60d3be4de7aabb0319471455ea9a9e26',
    '555-156-4567', 'Admin', '[B@e99d188',
    'What course is this project for?', 'COSC3506',5),
(158111122, 'John', 'Jacob', 'John@email.com',
    '3c519bff0ca6e159c859bbd4d496223a60d3be4de7aabb0319471455ea9a9e26',
    '555-966-4567', 'Admin', '[B@e99d189',
    'What course is this project for?', 'COSC3506',4),
(158111123, 'Liz', 'Henry', 'Liz@email.com',
    '3c519bff0ca8e159c859bbd4d496223a60d3be4de7aabb0319471455ea9a9e26',
    '555-966-4507', 'Admin', '[B@e89d189',
    'What course is this project for?', 'COSC3506',4
);
INSERT INTO ClubEvent ( event_id ,event_name ,event_description ,event_date ,event_location ,email_group ,
  event_attendance ,club_id )
VALUES (20,"Dance event", "Come hear see us dance",'2022-04-08  15:30:00',"RM103","None",55,4),
       (21,"Swing Dance Event", "Lets Swing Dance Toegther!",'2022-04-03 15:00:00',"RM103","None",30,4),
       (22,"Tech Event", "Come learn more about tech",'2022-04-15 13:00:00',"RM555","None",20,5),
       (23,"Business Networking Event", "Network with local businesses",'2022-04-15 17:30:00',"Business Lounge","None",96,2),
       (24,"LinkedIn Event", "Learn how to netowkr online",'2022-04-03 17:30:00',"Business Lounge","None",32,2),
       (25,"Clubs Day", "Come learn about all the school clubs",'2022-04-03 15:00:00',"Student Center","None",200,1),
       (26,"Make a Club Event", "Learn how to form a club",'2022-04-22 20:30:00',"Student Center","None",25,1),
       (27,"All Clubs Day", "All Clubs Hangout",'2022-05-28 16:30:00',"Student Center","None",2150,1);
