use CEMSDatabase ;
INSERT INTO Club (club_id,club_name,club_description)
VALUES (1, 'All Clubs', ' This is a club with all clubs');

INSERT INTO Club (club_id,club_name,club_description)
VALUES (2,'Algoma U Business Society','The Algoma University Business Society (AUBS) is a student run club that
represents the interests of students pursuing their Bachelor of Business Administration degree at Algoma University.');

INSERT INTO Club (club_id,club_name,club_description)
VALUES (3,'Bike Share Club','To provide an opportunity for students to go on bike
rides and trails. And to support the well-being of students.');

INSERT INTO Club (club_id,club_name,club_description)
VALUES (4,'Dance Club','Engage students with different stlyes of dance and cultures.');

INSERT INTO Club (club_id,club_name,club_description)
VALUES (5,'Tech Environment Club', 'We are a club dedicated to technology initiatives at Algomau');


INSERT INTO User  (student_id,first_name,last_name,email_address,password_,phone_number,permissions,
salt,security_question,security_answer,club_club_id)
VALUES (999999999, 'Master', 'User','master@email.com',
    'ff0120461cdb27bc43d56335dcc9634b30891ceaebb150837a01ec41ac84d4e3',
    '555-123-4567', 'SuperAdmin', '[B@4bcdcfa',
    'What course is this project for?', 'COSC3506', 1
);

INSERT INTO User  (student_id,first_name,last_name,email_address,password_,phone_number,permissions,
salt,security_question,security_answer,club_club_id)
VALUES (111111111, 'System', 'Testing', 'test@email.com',
    '3c519bff0ca6e159c872bbd4d496223a60d3be4de7aabb0319475b05ea9a9e26',
    '555-123-4567', 'Admin+', '[B@e99d198',
    'What course is this project for?', 'COSC3506',1
);