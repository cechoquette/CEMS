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

 INSERT INTO ClubBudget (club_budget_id,events_venue,eventsSubtotal,fundraising_donations,fundraising_subtotal,misc_admin_fees,misc_subtotal,club_budget_subtotal,
club_budget_taxes,club_budget_total,club_id)
VALUES(12,520.00,520.00,300.00,300.00,100.00,100.00,920.00,113.00,1033.00,1),
        (13,440.00,440.00,220.00,220.00,150.00,150.00,810.00,97.00,907.00,2),
        (14,150,150.00,230.00,230.00,80.00,80.00,460.00,46.00,506.00,3),
        (15,180.00,180.00,290.00,290.00,130.00,130.00,600.00,56.00,656.00,4),
        (16,220.00,220.00,190.00,190.00,100.00,100.00,920.00,113.00,1033.00,5);
INSERT INTO ClubBudget (club_budget_id,club_activities_other,club_activities_subtotal,fundraising_income,fundraising_subtotal,misc_banking_fees,misc_subtotal,club_budget_subtotal,
club_budget_taxes,club_budget_total,club_id)
VALUES    (17,220.00,220.00,190.00,190.00,100.00,100.00,920.00,113.00,1033.00,5),
    (18,520.00,520.00,300.00,300.00,100.00,100.00,920.00,113.00,1033.00,1),
    (19,180.00,180.00,290.00,290.00,130.00,130.00,600.00,56.00,656.00,4),
    (20,150,150.00,230.00,230.00,80.00,80.00,460.00,46.00,506.00,3),
    (21,440.00,440.00,220.00,220.00,150.00,150.00,810.00,97.00,907.00,2);

 INSERT INTO ClubEventBudget(event_budget_id,venue_entertainment,venue_subtotal,services_other,services_subtotal,refreshments_other,refreshments_subtotal,misc_other,misc_subtotal,
event_budget_subtotal,event_budget_taxes,event_budget_total,club_id,event_id)
VALUES (30,40.00,40.00,50.00,50.00,80.00,80.00,20.00,20.00,190.00,26.00,216.00,4,20),
        (31,20.00,20.00,80.00,80.00,50.00,50.00,40.00,40.00,190.00,26.00,216.00,4,21),
        (32,90.00,90.00,55.00,55.00,88.00,88.00,75.00,75.00,308.00,33.00,341.00,5,22),
        (33,55.00,55.00,90.00,90.00,75.00,75.00,88.00,88.00,308.00,33.00,341.00,1,26);
INSERT INTO ClubEventBudget(event_budget_id,venue_entertainment,venue_subtotal,services_other,services_subtotal,refreshments_other,refreshments_subtotal,misc_other,misc_subtotal,
event_budget_subtotal,event_budget_taxes,event_budget_total,club_id,event_id)
VALUES  (34,35.00,35.00,98.00,98.00,42.00,42.00,12.00,12.00,187.00,24.00,211.00,2,23),
        (35,55.00,55.00,90.00,90.00,75.00,75.00,88.00,88.00,308.00,33.00,341.00,2,24),
        (36,20.00,20.00,80.00,80.00,50.00,50.00,40.00,40.00,190.00,26.00,216.00,1,24),
        (37,40.00,40.00,50.00,50.00,80.00,80.00,20.00,20.00,190.00,26.00,216.00,1,27);

INSERT INTO ClubExpenditure(expenditure_id,description_,account_holder,amount,
payment_account,tax_amount,total,province,date_,vendor_name,
category,payment_method,club_id,clubEvent_event_id)
VALUES  (50,"Pay for pizza and drinks","Joe",50.00,"CEMS Account",7.50,57.50,"Ontario",'2022-04-03 15:00:00',"Amazon","refreshments_other",
"Visa",1,27),
(65,"Pay for student centre rental","Joe",60,"CEMS Account",6.75,66.75,"Ontario",'2022-04-06 15:00:00',"Amazon","venue_subtotal",
"Visa",1,27),
(66,"Pay for student centre rental","Joe",100,"CEMS Account",13.00,113.00,"Ontario",'2022-04-02 15:00:00',"Amazon","venue_subtotal",
"Visa",1,27);

