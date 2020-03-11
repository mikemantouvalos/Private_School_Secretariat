-- A list of all the students
SELECT * FROM student;



-- A list of all the trainers
SELECT * FROM trainer;



-- A list of all the assignments
SELECT * FROM assignment;



-- A list of all the courses
SELECT * FROM course;



-- All the students per course 
SELECT c.title, c.type, c.startDate, c.endDate, s.fname, s.lname 
FROM studentpercourse spc, course c, student s
WHERE spc.cid = c.id 
AND spc.sid = s.id;

 
 
-- All the trainers per course
SELECT c.title, c.type, c.startDate, c.endDate, t.name, t.lname 
FROM trainerpercourse tpc, course c, trainer t
WHERE tpc.cid = c.id 
and tpc.tid = t.id;


-- All the assignments per course
select c.title, c.type, c.startDate, c.endDate, assi.title, assi.description, assi.subdate, assi.oralmark, assi.totalmark 
FROM assignmentpercourse apc, course c, assignment assi
WHERE apc.cid = c.id 
AND apc.aid = assi.id
ORDER BY c.title;



-- All the assignments per course per student
SELECT s.fname, s.lname, c.title, assi.title, assi.description, assi.subdate, assi.oralmark, assi.totalmark
FROM studentpercourse spc, assignmentpercourse apc, student s, course c, assignment assi
WHERE spc.cid = apc.cid
AND spc.cid = c.id
AND apc.aid = assi.id
AND spc.sid = s.id
ORDER BY s.fname;
           
           

-- A list of students that belong to more than one courses
SELECT * FROM numberOfCoursesPerStudent where number_of_courses>1;
