CREATE DATABASE privateSchool;
USE privateSchool;

CREATE TABLE student (
id INT PRIMARY KEY auto_increment NOT NULL,
fname VARCHAR (225) NOT NULL,
lname VARCHAR (225),
dob DATE,
tuitionFees INT
);

CREATE TABLE course (
id INT PRIMARY KEY auto_increment NOT NULL,
title VARCHAR (225) NOT NULL,
Stream VARCHAR (225),
type VARCHAR (225),
startDate DATE,
endDate DATE
);

CREATE TABLE assignment (
id INT PRIMARY KEY auto_increment NOT NULL,
title VARCHAR (225) NOT NULL,
description VARCHAR (225),
subdate DATE,
oralmark INT,
totalmark INT
);

CREATE TABLE trainer (
id INT PRIMARY KEY auto_increment NOT NULL,
name VARCHAR (225) NOT NULL,
lname VARCHAR (225),
subject VARCHAR (225)
);

CREATE TABLE studentPerCourse(
id INT PRIMARY KEY auto_increment NOT NULL,
sid INT ,
cid INT,
FOREIGN KEY (sId) REFERENCES student(Id) ON DELETE CASCADE,
FOREIGN KEY (cId) REFERENCES course(Id) ON DELETE CASCADE
);



CREATE TABLE assignmentPerCourse(
id INT PRIMARY KEY  auto_increment NOT NULL ,
aid INT ,
cid INT,
FOREIGN KEY (aID) REFERENCES assignment
(Id) ON DELETE CASCADE,
FOREIGN KEY (cId) REFERENCES course(Id) ON DELETE CASCADE
);


CREATE TABLE trainerPerCourse(
id INT PRIMARY KEY auto_increment NOT NULL,
tid INT ,
cid INT,
FOREIGN KEY (tId) REFERENCES trainer(Id) ON DELETE CASCADE,
FOREIGN KEY (cId) REFERENCES course(Id) ON DELETE CASCADE
);

create view CoursePerStudent as
select  s.fname, s.lname, s.dob, s.tuitionFees, c.Title
from student s, studentpercourse spc , course c , assignmentpercourse apc, assignment ass
where spc.sid = s.id
and c.id = spc.cid
and apc.cid = spc.cid
and apc.aid = ass.id;

create view numberOfCoursesPerStudent as
select fname, lname, dob, tuitionfees, count(*) as number_of_courses
from CoursePerStudent
group by fname, lname, dob, tuitionfees;


-- inserting values

INSERT INTO student VALUES(1 ,'Mike','Mantouvalos','1990-05-26', 50);
INSERT INTO student VALUES(2 ,'manolis','Stratoudakis','1990-09-13', 150);
INSERT INTO student VALUES(3 ,'ksenofon', 'Karidis', '1989-02-24', 250);
INSERT INTO student VALUES(4 ,'Giorgos', 'xristodoulakis','1988-03-04', 40);
INSERT INTO student VALUES(5 ,'Dora', 'Zormpa', '1988-10-18', 140);
INSERT INTO student VALUES(6 ,'Alexandros', 'Euxtixiou', '1990-07-20', 400);


INSERT INTO course VALUES(1 ,'Mathimatika','science','thetikesEpistimes', '2019-09-20', '2020-01-23');
INSERT INTO course VALUES(2 ,'fisiki','science','thetikesEpistimes', '2019-09-20', '2020-01-24');
INSERT INTO course VALUES(3 ,'ximeia','science','thetikesEpistimes', '2019-09-21', '2020-01-25');
INSERT INTO course VALUES(4 ,'coding','tech','texnologikesEpistimes', '2019-09-23', '2020-01-26');
INSERT INTO course VALUES(5 ,'glwssa','science','theoritikesEpistimes', '2019-09-25', '2020-01-30');

INSERT INTO  assignment VALUES (1 ,'ergasiaMath1','descMath','2019-11-15', 80 , 100 );
INSERT INTO  assignment VALUES (2 ,'ergasiaMATH2','descMath2','2020-01-20', 70 , 100 );
INSERT INTO  assignment VALUES (3 ,'ergasiaFisiki1','descFisiki1','2019-11-10', 85 , 100 );
INSERT INTO  assignment VALUES (4 ,'ergasiaFisiki2','descFisiki2','2020-02-03', 85 , 100 );
INSERT INTO  assignment VALUES (5 ,'ergasiaXimeia','descXimeia','2020-01-18', 90 , 100 );
INSERT INTO  assignment VALUES (6 ,'ergasiaCoding','descCoding','2020-01-17', 50 , 100 );
INSERT INTO  assignment VALUES (7 ,'ergasiaGlwssa','descGlwssa','2020-01-21', 60 , 100 );


INSERT INTO  trainer VALUES (1, 'tasos', 'lelakis', 'coding' );
INSERT INTO  trainer VALUES (2, 'lampros', 'fisfis', 'math' );
INSERT INTO  trainer VALUES (3, 'despoina', 'kalifatidou', 'ximeia' );
INSERT INTO  trainer VALUES (4, 'Nikiforos', 'kapetanakis', 'fisiki' );
INSERT INTO  trainer VALUES (5, 'Anna', 'Vasilaki', 'glwssa' );


INSERT INTO studentPerCourse values (1,1,1);
INSERT INTO studentPerCourse values (2,1,2);
INSERT INTO studentPerCourse values (3,1,3);
INSERT INTO studentPerCourse values (4,2,1);
INSERT INTO studentPerCourse values (5,2,2);
INSERT INTO studentPerCourse values (6,2,4);
INSERT INTO studentPerCourse values (7,3,5);
INSERT INTO studentPerCourse values (8,3,2);
INSERT INTO studentPerCourse values (9,3,1);
INSERT INTO studentPerCourse values (10,4,5);
INSERT INTO studentPerCourse values (11,4,3);
INSERT INTO studentPerCourse values (12,5,5);
INSERT INTO studentPerCourse values (13,6,3);
INSERT INTO studentPerCourse values (14,6,5);


INSERT INTO trainerpercourse values (1,1,4); -- lelakis/coding
INSERT INTO trainerpercourse values (2,2,1); -- fisfis/math
INSERT INTO trainerpercourse values (3,3,3); -- kalifatidou/ximeia
INSERT INTO trainerpercourse values (4,4,2); -- kapetanakis/fisiki
INSERT INTO trainerpercourse values (5,5,5); -- vasilaki// glwssa




INSERT INTO assignmentPerCourse values (1,1,1); -- mathimatika1 / mathimatika1
INSERT INTO assignmentPerCourse values (2,2,1); -- mathimatika2 / mathimatika1
INSERT INTO assignmentPerCourse values (3,3,2); -- fisiki1 / fisiki
INSERT INTO assignmentPerCourse values (4,4,2); -- fisiki2 / fisiki
INSERT INTO assignmentPerCourse values (5,5,3); -- ximeia / ximeia
INSERT INTO assignmentPerCourse values (6,6,4); -- coding / coding
INSERT INTO assignmentPerCourse values (7,7,5); -- glwssa / glwssa
