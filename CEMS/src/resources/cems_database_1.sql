CREATE USER IF NOT EXISTS 'CEMSAdmin'@'localhost' IDENTIFIED BY 'CEMS321';
GRANT ALL PRIVILEGES ON *.* TO 'CEMSAdmin'@'localhost';
-- DROP DATABASE IF EXISTS CEMSDatabase; -- drop database for testing when duplicates created

CREATE DATABASE IF NOT EXISTS CEMSDatabase ;
USE CEMSDatabase ;


CREATE TABLE IF NOT EXISTS User (
  student_id INT NOT NULL,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  email_address VARCHAR(45) NOT NULL,
  password_ VARCHAR(100) NULL,
  phone_number VARCHAR(45) NOT NULL,
  permissions VARCHAR(45) NOT NULL DEFAULT 'admin',
  salt VARCHAR(45)  NULL,
  security_question VARCHAR(45)  NULL,
  security_answer VARCHAR(45)  NULL,
  PRIMARY KEY (student_id));




-- Table Club
CREATE TABLE IF NOT EXISTS Club (
  club_id INT NOT NULL AUTO_INCREMENT,
  club_name VARCHAR(45) NOT NULL,
  club_description MEDIUMTEXT NOT NULL,
  PRIMARY KEY (club_id));
  

-- Table Event
CREATE TABLE IF NOT EXISTS ClubEvent (
  event_id INT NOT NULL,
  event_name VARCHAR(45) NULL,
  event_description VARCHAR(45) NULL,
  event_date DATE NULL,
  event_location VARCHAR(45) NULL,
  email_group VARCHAR(45) NULL,
  event_attendance INT null,
  club_id INT NULL,
  PRIMARY KEY (event_id),
  INDEX (club_id ASC) VISIBLE,
    FOREIGN KEY (club_id)
    REFERENCES CEMSDatabase.Club (club_id)
    ON DELETE NO ACTION
    ON UPDATE CASCADE );


-- Table EventBudget 
CREATE TABLE IF NOT EXISTS ClubEventBudget (
  event_budget_id INT NOT NULL,
  event_id INT NULL,
  venue_entertainment DECIMAL(13,2) DEFAULT 0,
  venue_location_rental DECIMAL(13,2) DEFAULT 0,
  venue_equipment_rental DECIMAL(13,2) DEFAULT 0,
  venue_furniture_rental DECIMAL(13,2) DEFAULT 0,
  venue_other DECIMAL(13,2) DEFAULT 0,
  venue_subtotal DECIMAL(13,2) DEFAULT 0,
  services_venue_staff DECIMAL(13,2) DEFAULT 0,
  service_security DECIMAL(13,2) DEFAULT 0,
  services_AVTechStaff DECIMAL(13,2) DEFAULT 0,
  services_catering_staff DECIMAL(13,2) DEFAULT 0,
  services_bar_staff DECIMAL(13,2) DEFAULT 0,
  services_volunteers DECIMAL(13,2) DEFAULT 0,
  services_advertising DECIMAL(13,2) DEFAULT 0,
  services_social_media DECIMAL(13,2) DEFAULT 0,
  services_photo_videography DECIMAL(13,2) DEFAULT 0,
  services_travel DECIMAL(13,2) DEFAULT 0,
  services_gratuities DECIMAL(13,2) DEFAULT 0,
  services_other DECIMAL(13,2) DEFAULT 0,
  services_subtotal DECIMAL(13,2) DEFAULT 0,
  refreshments_food DECIMAL(13,2) DEFAULT 0,
  refreshments_beverages DECIMAL(13,2) DEFAULT 0,
  refreshments_bar_costs DECIMAL(13,2) DEFAULT 0,
  refreshments_other DECIMAL(13,2) DEFAULT 0,
  refreshments_subtotal DECIMAL(13,2) DEFAULT 0,
  misc_prizes_awards DECIMAL(13,2) DEFAULT 0,
  misc_giftbags DECIMAL(13,2) DEFAULT 0,
  misc_participant_materials DECIMAL(13,2) DEFAULT 0,
  misc_decorations DECIMAL(13,2) DEFAULT 0,
  misc_signage DECIMAL(13,2) DEFAULT 0,
  misc_permits DECIMAL(13,2) DEFAULT 0,
  misc_fees DECIMAL(13,2) DEFAULT 0,
  misc_other DECIMAL(13,2) DEFAULT 0,
  misc_subtotal DECIMAL(13,2) DEFAULT 0,
  event_budget_subtotal DECIMAL(13,2) DEFAULT 0,
  event_budget_taxes DECIMAL(13,2) DEFAULT 0,
  event_budget_total DECIMAL(13,2) DEFAULT 0,
  INDEX (event_id ASC) ,
  PRIMARY KEY (event_budget_id),
    FOREIGN KEY (event_id)
    REFERENCES CEMSDatabase.ClubEvent  (event_id)
    ON DELETE NO ACTION
    ON UPDATE CASCADE );
    
    -- Table ClubBudget 
CREATE TABLE IF NOT EXISTS ClubBudget (
  club_budget_id INT NOT NULL,
  club_id INT NOT NULL,
  events_venue DECIMAL(13,2) DEFAULT 0,
  events_services DECIMAL(13,2) DEFAULT 0,
  event_refreshments DECIMAL(13,2) DEFAULT 0,
  events_miscellaneous DECIMAL(13,2) DEFAULT 0,
  eventsSubtotal DECIMAL(13,2) DEFAULT 0,
  clubMeetings DECIMAL(13,2) DEFAULT 0,
  clubSpaceRentalOrFees DECIMAL(13,2) DEFAULT 0,
  club_equipment DECIMAL(13,2) DEFAULT 0,
  club_activities_other DECIMAL(13,2) DEFAULT 0,
  club_activities_subtotal DECIMAL(13,2) DEFAULT 0,
  fundraising_costs DECIMAL(13,2) DEFAULT 0,
  fundraising_income DECIMAL(13,2) DEFAULT 0,
  fundraising_participant_fees DECIMAL(13,2) DEFAULT 0,
  fundraising_donations DECIMAL(13,2) DEFAULT 0,
  fundraising_subtotal DECIMAL(13,2) DEFAULT 0,
  misc_admin_fees DECIMAL(13,2) DEFAULT 0,
  misc_banking_fees DECIMAL(13,2) DEFAULT 0,
  misc_banking_interest_income DECIMAL(13,2) DEFAULT 0,
  misc_utilities DECIMAL(13,2) DEFAULT 0,
  misc_other DECIMAL(13,2) DEFAULT 0,
  misc_subtotal DECIMAL(13,2) DEFAULT 0,
  club_budget_subtotal DECIMAL(13,2) DEFAULT 0,
  club_budget_taxes DECIMAL(13,2) DEFAULT 0,
  club_budget_total DECIMAL(13,2) DEFAULT 0, 
  PRIMARY KEY (club_budget_id),
    FOREIGN KEY (club_id)
    REFERENCES CEMSDatabase.Club (club_id)
    ON DELETE NO ACTION
    ON UPDATE CASCADE );



-- Table ClubExpenditure 
CREATE TABLE IF NOT EXISTS ClubExpenditure (
  expenditure_id INT NOT NULL ,
  club_id INT NOT NULL ,
  description_ MEDIUMTEXT NULL ,
  account_holder VARCHAR(45) NULL ,
  amount DECIMAL(13,2) NULL ,
  payment_account  VARCHAR(45) NULL ,
  tax_amount DECIMAL(13,2) ,
  total DECIMAL(13,2) ,
  province VARCHAR(45) ,
  date_ VARCHAR(45) ,
  vendor_name VARCHAR(45) ,
  category VARCHAR(45) ,
  payment_method VARCHAR(45) ,
  PRIMARY KEY (expenditure_id),
  INDEX (club_id ASC) VISIBLE,
    FOREIGN KEY (club_id)
    REFERENCES CEMSDatabase.Club (club_id)
    ON DELETE NO ACTION
    ON UPDATE CASCADE );



-- Table ClubMember
CREATE TABLE IF NOT EXISTS ClubMember(
  clubmember_id INT NOT Null,
  student_id INT NOT NULL,
  club_id INT NOT NULL,
  club_member_permission VARCHAR(45) NULL,
  PRIMARY KEY (student_id,club_id),
  INDEX (club_id ASC) VISIBLE,
  INDEX (student_id ASC) VISIBLE,
    FOREIGN KEY (student_id)
    REFERENCES CEMSDatabase.User (student_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT 
    FOREIGN KEY (club_id)
    REFERENCES CEMSDatabase.Club (club_id)
    ON DELETE NO ACTION
    ON UPDATE CASCADE );


ALTER TABLE club AUTO_INCREMENT=1001;
