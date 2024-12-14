DROP DATABASE IF EXISTS TileShop;

 DROP DATABASE IF EXISTS socialmedia;

CREATE DATABASE IF NOT EXISTS socialmedia;

 use socialmedia;

 create table user(
     castID varchar(6) PRIMARY KEY,
     castName varchar (30),
     castBirthDay DATE,
     castAddress varchar(30),
     caslogin varchar(20),
     caspassword varchar(20)
 );

 CREATE TABLE post (
     postID INT AUTO_INCREMENT PRIMARY KEY,
     castID varchar(6),
     postContent TEXT,
     postDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     FOREIGN KEY (castID) REFERENCES user(castID)
 );


CREATE TABLE subscription (
    subscriber_id VARCHAR(6),
    subscribed_id VARCHAR(6),
    PRIMARY KEY (subscriber_id, subscribed_id),
    FOREIGN KEY (subscriber_id) REFERENCES user(castID),
    FOREIGN KEY (subscribed_id) REFERENCES user(castID)
);