
1.  Second largest employee

176. Second Highest Salary
Medium
3K
866
Companies
SQL Schema

Pandans Schema

Table: Employee
+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| salary      | int  |
+-------------+------+
In SQL, id is the primary key column for this table.
Each row of this table contains information about the salary of an employee.
 
Find the second highest salary from the Employee table. If there is no second highest salary, return null (return None in Pandas).
The result format is in the following example.
 
Example 1:
Input: 
Employee table:
+----+--------+
| id | salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
Output: 
+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+


  1 	# Write your MySQL query statement below
    2 	select MAX(salary) SecondHighestSalary FROM Employee
    3 	WHERE salary<(SELECT MAX(salary) FROM Employee);


2.  SQL join query: SQL Joins
SQL Join statement is used to combine data or rows from two or more tables based on a common field between them. Different types of Joins are as follows: 
• INNER JOIN
• LEFT JOIN
• RIGHT JOIN
• FULL JOIN
• NATURAL JOIN 
Consider the two tables below as follows: 
Student

 
StudentCourse 

The simplest Join is INNER JOIN. 





  
A. INNER JOIN
The INNER JOIN keyword selects all rows from both the tables as long as the condition is satisfied. This keyword will create the result-set by combining all rows from both the tables where the condition satisfies i.e value of the common field will be the same. 
Syntax: 
SELECT table1.column1,table1.column2,table2.column1,....
FROM table1 
INNER JOIN table2
ON table1.matching_column = table2.matching_column;
table1: First table.
table2: Second table
matching_column: Column common to both the tables.
Note: We can also write JOIN instead of INNER JOIN. JOIN is same as INNER JOIN. 

Example Queries(INNER JOIN)
This query will show the names and age of students enrolled in different courses.  
SELECT StudentCourse.COURSE_ID, Student.NAME, Student.AGE FROM Student
INNER JOIN StudentCourse
ON Student.ROLL_NO = StudentCourse.ROLL_NO;
Output:  


B. LEFT JOIN
This join returns all the rows of the table on the left side of the join and matches rows for the table on the right side of the join. For the rows for which there is no matching row on the right side, the result-set will contain null. LEFT JOIN is also known as LEFT OUTER JOIN.
Syntax: 
SELECT table1.column1,table1.column2,table2.column1,....
FROM table1 
LEFT JOIN table2
ON table1.matching_column = table2.matching_column;
table1: First table.
table2: Second table
matching_column: Column common to both the tables.
Note: We can also use LEFT OUTER JOIN instead of LEFT JOIN, both are the same.

Example Queries(LEFT JOIN): 
SELECT Student.NAME,StudentCourse.COURSE_ID 
FROM Student
LEFT JOIN StudentCourse 
ON StudentCourse.ROLL_NO = Student.ROLL_NO;
Output: 

C. RIGHT JOIN
RIGHT JOIN is similar to LEFT JOIN. This join returns all the rows of the table on the right side of the join and matching rows for the table on the left side of the join. For the rows for which there is no matching row on the left side, the result-set will contain null. RIGHT JOIN is also known as RIGHT OUTER JOIN. 
Syntax: 
SELECT table1.column1,table1.column2,table2.column1,....
FROM table1 
RIGHT JOIN table2
ON table1.matching_column = table2.matching_column;
table1: First table.
table2: Second table
matching_column: Column common to both the tables.
Note: We can also use RIGHT OUTER JOIN instead of RIGHT JOIN, both are the same. 

 
Example Queries(RIGHT JOIN):
SELECT Student.NAME,StudentCourse.COURSE_ID 
FROM Student
RIGHT JOIN StudentCourse 
ON StudentCourse.ROLL_NO = Student.ROLL_NO;
Output: 

D. FULL JOIN
FULL JOIN creates the result-set by combining results of both LEFT JOIN and RIGHT JOIN. The result-set will contain all the rows from both tables. For the rows for which there is no matching, the result-set will contain NULL values.

Syntax:  
SELECT table1.column1,table1.column2,table2.column1,....
FROM table1 
FULL JOIN table2
ON table1.matching_column = table2.matching_column;
table1: First table.
table2: Second table
matching_column: Column common to both the tables. 
Example Queries(FULL JOIN): 
SELECT Student.NAME,StudentCourse.COURSE_ID 
FROM Student
FULL JOIN StudentCourse 
ON StudentCourse.ROLL_NO = Student.ROLL_NO;
Output:  
NAME	COURSE_ID
HARSH	1
PRATIK	2
RIYANKA	2
DEEP	3
SAPTARHI	1
DHANRAJ	NULL
ROHIT	NULL
NIRAJ	NULL
NULL	4
NULL	5
NULL	4
Left JOIN (Video) 
Right JOIN (Video) 
Full JOIN (Video) 
SQL | JOIN (Cartesian Join, Self Join) 
E. Natural join (⋈)
Natural join can join tables based on the common columns in the tables being joined. A natural join returns all rows by matching values in common columns having same name and data type of columns and that column should be present in both tables.
Both table must have at list one common column with same column name and same data type.
The two table are joined using Cross join.
DBMS will look for a common column with same name and data type Tuples having exactly same values in common columns are kept in result.
Example:
Employee 		
Emp_id	Emp_name	Dept_id
1	Ram 	10
2	Jon 	30
3	Bob	50
Department 	
Dept_id	Dept_name
10	IT
30	HR
40	TIS
Query: Find all Employees and their respective departments.
Solution: (Employee) ⋈ (Department)
Emp_id	Emp_name	Dept_id	Dept_id	Dept_name
1	Ram 	10	10	IT 
2	Jon	30	30	HR
Employee data 			Department data 	

3.  What is indexing in SQL: SQL - Indexes

Index is a table that helps in faster query results and quick data retrieval from the database. Index tables use indexing, a technique that uses data structures to optimize the searching time of a database query. Indexing makes database performance better. It also consumes lesser space in the main memory.
What is an INDEX?
Index usually consists of two columns which are a key-value pair. The two columns of the index table (i.e., the key-value pair) contain copies of selected columns of the tabular data of the database.
Generally, we store the selected Primary or Candidate keys in a sorted manner so that we can reduce the overall query time or search time (from linear search to binary search).
Data Reference contains a set of pointers that holds the address of the disk block. The pointed disk block contains the actual data referred to by the Search Key. Data Reference is also called Block Pointer because it uses block-based addressing.
Indexing is used to quickly retrieve particular data from the database. Indexing reduces the number of disks required to access a particular data by internally creating an index table. Indexing is achieved by creating Index-table or Index.
How to create An Index?
The index can be created very easily using SQL commands.
Syntax:

CREATE INDEX index_name 
ON table_name(column-name_1, column-name_2, ...);
Suppose we have a database of students. The student table has 44 columns: student ID, Name, Physics (marks in Physics), and Chemistry (marks in Chemistry).
Student table:
ID	Name	Physics	Chemistry
1	Aman	86	92
2	Sushant	91	91
3	Saumya	98	98
4	Aditya	93	88
5	Nilesh	87	83
Let us create an index on the student table using the ID column.

CREATE INDEX ID_index ON student (ID);
Let us learn some of the advantages of using indexing on the tables of the database.
Advantages of Creating Index Table or Indexing:
	• Indexing helps in faster query results or quick data retrieval.
	• Indexing helps in faster sorting and grouping of records
	• Some Indexing uses sorted and unique keys, which helps to retrieve sorted queries even faster.
	• Index tables are smaller in size, so they require lesser memory.
	• As Index tables are smaller in size, they are stored in the main memory.
	• Since CPU speed and secondary memory speed have a large difference, the CPU uses this main memory index table to bridge the gap of speeds.
	• Indexing helps in better CPU utilization and better performance.
Refer to the image below to see how index works in SQL and how indexing divides the large database into smaller sub-contents.
How does Index Work?
Now that we know index and its advantages, let us now know how index works in SQL. Generally, the database takes the column provided with the CREATE INDEX command and sorts the column values using a special data structure called B-trees.
B-tree is a type of tree data structure that contains 2 things: Index Key and its corresponding disk address. Index Key refers to a certain disk address, and that disk further contains rows or tuples of data. Using B-tree, we can achieve fast searches and fast retrievals. Also, the disk space used is low.
Since the data structure, B_tree, is sorted in order, it makes our search more efficient. So, this is how the index works in SQL. Now let us take a few examples to visualize how index works in SQL.
Example - We want to store the below three-column table in the database.
Name	Marks	Age
Jone	5	28
Alex	32	45
Tom	37	23
Ron	87	13
Mark	20	48
Bob	89	32
The B-tree representation will be like this:
In the index table, the left column contains the index key, which holds the reference to a particular table row.
Let us take an example to understand how the index works in SQL. Suppose we have the database of a college which stores the details of students. We will store the name, age, CGPA, roll number, and section of students.
The student table is shown below:
Student table
Roll_No	CGPA	Name	Section
1	9.21	Aman	A
2	8.86	Aditya	A
13	9.92	Sushant	C
24	9.71	Mohit	-
5	8.56	Saumya	C
Suppose the index of the above table is roll_index. Now, a search using the index field can increase performance. The index uses B-tree, so this allows SQL for a binary search of the index with an average of log(n) accesses.
:::{.highlight} Note: We should use indexing when the table contains numerous entries. For a smaller table, the time taken by indexing is somewhat similar to a query without an index table.

 SQL like query:  SQL LIKE Operator

Sometimes we may require tuples from the database which match certain patterns. For example, we want to retrieve all columns where the tuples start with the letter ‘y’, or start with ‘b’ and end with ‘l’, or even more complicated and restrictive string patterns. This is where the SQL LIKE Clause comes to the rescue, often coupled with the WHERE Clause in SQL.
In SQL, the LIKE operator is mainly used in the WHERE clause to search for a enumerate pattern in a column.
Two barriers are often used in conjunction with the LIKE :
1. %: Used to match zero or more characters. (Variable Length)
2. _: Used to match exactly one character. (Fixed Length)
SQL Like Syntax:
SELECT column1, column2, ...
FROM table_name
WHERE columnN LIKE pattern;
The following are the rules for pattern matching with the LIKE Clause :
Pattern	Meaning
‘a%’	Match strings that start with ‘a’
‘%a’	Match strings with end with ‘a’
‘a%t’	Match strings that contain the start with ‘a’ and end with ‘t’.
‘%wow%’	Match strings that contain the substring ‘wow’ in them at any position.
‘_wow%’	Match strings that contain the substring ‘wow’ in them at the second position.
‘_a%’	Match strings that contain ‘a’ at the second position.
‘a_ _%’	Match strings that start with ‘a and contain at least 2 more characters.
Example: Say we have a relation, Supplier. We want to test various patterns using the LIKE clause:
Supplier Table
SupplierID	Name	Address
S1	Paragon Suppliers	21-3, Okhla, Delhi
S2	Mango Nation	21, Faridabad, Haryana
S3	Canadian Biz	6/7, Okhla Phase II, Delhi
S4	Caravan Traders	2-A, Pitampura, Delhi
S5	Harish and Sons	Gurgaon, NCR
S6	Om Suppliers	2/1, Faridabad, Haryana
SQL LIKE – Sample Queries and Outputs
Query 1:
SELECT SupplierID, Name, Address
FROM Suppliers
WHERE Name LIKE 'Ca%';
Output:
S3	Canadian Biz	6/7, Okhla Phase II, Delhi
S4	Caravan Traders	2-A, Pitampura, Delhi
Query 2:
SELECT *
FROM Suppliers
WHERE Address LIKE '%Okhla%';
Output:
S1	Paragon Suppliers	21-3, Okhla, Delhi
S3	Canadian Biz	6/7, Okhla Phase II, Delhi
Query 3:
SELECT SupplierID, Name, Address
FROM Suppliers
WHERE Name LIKE '_ango%';
Output:
S2	Mango Nation	21, Faridabad, Haryana
SQL LIKE Application
The LIKE operator is extremely resourceful in situations such as address filtering wherein we know only a segment or a portion of the entire address (such as locality or city) and would like to retrieve results based on that. The wildcards can be resourcefully exploited to yield even better and more filtered tuples based on the requirement. 
Important to know about SQL LIKE 
One important thing to note about the LIKE operator is that it is case-insensitive by default in most database systems. This means that if you search for “apple” using the LIKE operator, it will return results that include “Apple”, “APPLE”, “aPpLe”, and so on.
For making the LIKE operator case-sensitive, you can use the “BINARY” keyword in MySQL or the “COLLATE” keyword in other database systems. 
For example:
• XML

SELECT * FROM products WHERE name LIKE BINARY 'apple%'

SQL- what is primary key and unique key

SQL PRIMARY KEY Constraint
The PRIMARY KEY constraint uniquely identifies each record in a table.
Primary keys must contain UNIQUE values, and cannot contain NULL values.
A table can have only ONE primary key; and in the table, this primary key can consist of single or multiple columns (fields).


CREATE TABLE Persons (
    ID int NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int,
    PRIMARY KEY (ID)
);

SQL-  what is foreign key

SQL FOREIGN KEY Constraint
The FOREIGN KEY constraint is used to prevent actions that would destroy links between tables.
A FOREIGN KEY is a field (or collection of fields) in one table, that refers to the PRIMARY KEY in another table.
The table with the foreign key is called the child table, and the table with the primary key is called the referenced or parent table.

Persons Table
PersonID	LastName	FirstName	Age
1	Hansen	Ola	30
2	Svendson	Tove	23
3	Pettersen	Kari	20
Orders Table
OrderID	OrderNumber	PersonID
1	77895	3
2	44678	3
3	22456	2
4	24562	1
Notice that the "PersonID" column in the "Orders" table points to the "PersonID" column in the "Persons" table.
The "PersonID" column in the "Persons" table is the PRIMARY KEY in the "Persons" table.
The "PersonID" column in the "Orders" table is a FOREIGN KEY in the "Orders" table.
The FOREIGN KEY constraint prevents invalid data from being inserted into the foreign key column, because it has to be one of the values contained in the parent table.



CREATE TABLE Orders (
    OrderID int NOT NULL,
    OrderNumber int NOT NULL,
    PersonID int,
    PRIMARY KEY (OrderID),
    FOREIGN KEY (PersonID) REFERENCES Persons(PersonID)
);

SQL- what is average query

A column in the SQL table is the vertical catalog structure. In this article, we will be using the Microsoft SQL Server as our database.
For the purpose of example, we will be creating a sample table and performing the same operations on it.
Table Definition:
We have the following car table in our database :
CREATE TABLE car (
companyid integer ,
companyname varchar(20) ,
totalmodels integer )



What is JDBC

JDBC stands for Java Database Connectivity. JDBC is a Java API to connect and execute the query with the database. It is a part of JavaSE (Java Standard Edition). JDBC API uses JDBC drivers to connect with the database. There are four types of JDBC drivers:

We can use JDBC API to access tabular data stored in any relational database. By the help of JDBC API, we can save, update, delete and fetch data from the database. It is like Open Database Connectivity (ODBC) provided by Microsoft.

We can use JDBC API to handle database using Java program and can perform the following activities:
	1. Connect to the database
	2. Execute queries and update statements to the database
	3. Retrieve the result received from the database.

Group by clause

The GROUP BY Statement in SQL is used to arrange identical data into groups with the help of some functions. i.e. if a particular column has the same values in different rows then it will arrange these rows in a group. 
Features
• GROUP BY clause is used with the SELECT statement.
• In the query, the GROUP BY clause is placed after the WHERE clause.
• In the query, the GROUP BY clause is placed before the ORDER BY clause if used.
• In the query, the Group BY clause is placed before the Having clause.
• Place condition in the having clause.
Syntax:
SELECT column1, function_name(column2)
FROM table_name
WHERE condition
GROUP BY column1, column2
ORDER BY column1, column2;
Explanation:
1. function_name: Name of the function used for example, SUM() , AVG().
2. table_name: Name of the table.
3. condition: Condition used.
Let’s assume that we have two tables Employee and Student Sample Table is as follows after adding two tables we will do some specific operations to learn about GROUP BY.
Employee Table:
CREATE TABLE emp (
  emp_no INT PRIMARY KEY,
  name VARCHAR(50),
  sal DECIMAL(10,2),
  age INT
);
Insert some random data into a table and then we will perform some operations in GROUP BY.
Query:
INSERT INTO emp (emp_no, name, sal, age) VALUES
(1, 'Aarav', 50000.00, 25),
(2, 'Aditi', 60000.50, 30),
(3, 'Amit', 75000.75, 35),
(4, 'Anjali', 45000.25, 28),
(5, 'Chetan', 80000.00, 32),
(6, 'Divya', 65000.00, 27),
(7, 'Gaurav', 55000.50, 29),
(8, 'Isha', 72000.75, 31),
(9, 'Kavita', 48000.25, 26),
(10, 'Mohan', 83000.00, 33);
Output:

 
 
Student Table:
Query:
CREATE TABLE student (
  name VARCHAR(50),
  year INT,
  subject VARCHAR(50)
);
INSERT INTO student (name, year, subject) VALUES
('Alice', 1, 'Mathematics'),
('Bob', 2, 'English'),
('Charlie', 3, 'Science'),
('David', 1, 'History'),
('Emily', 2, 'Art'),
('Frank', 3, 'Computer Science');
Output:

 
Group By single column
Group By single column means, placing all the rows with the same value of only that particular column in one group. Consider the query as shown below:
Query:
SELECT NAME, SUM(SALARY) FROM emp 
GROUP BY NAME;
The above query will produce the below output: 

 
As you can see in the above output, the rows with duplicate NAMEs are grouped under the same NAME and their corresponding SALARY is the sum of the SALARY of duplicate rows. The SUM() function of SQL is used here to calculate the sum.
Group By Multiple Columns
 Group by multiple columns is say, for example, GROUP BY column1, column2. This means placing all the rows with the same values of columns column 1 and column 2 in one group. Consider the below query:
Query:
SELECT SUBJECT, YEAR, Count(*)
FROM Student
GROUP BY SUBJECT, YEAR;
Output:

 
Output: As you can see in the above output the students with both the same SUBJECT and YEAR are placed in the same group. And those whose only SUBJECT is the same but not YEAR belong to different groups. So here we have grouped the table according to two columns or more than one column.
HAVING Clause in GROUP BY Clause
We know that the WHERE clause is used to place conditions on columns but what if we want to place conditions on groups? This is where the HAVING clause comes into use. We can use the HAVING clause to place conditions to decide which group will be part of the final result set. Also, we can not use aggregate functions like SUM(), COUNT(), etc. with the WHERE clause. So we have to use the HAVING clause if we want to use any of these functions in the conditions. 
Syntax:
SELECT column1, function_name(column2)
FROM table_name
WHERE condition
GROUP BY column1, column2
HAVING condition
ORDER BY column1, column2;
Explanation:
4. function_name: Name of the function used for example, SUM() , AVG().
5. table_name: Name of the table.
6. condition: Condition used.
Example:
SELECT NAME, SUM(sal) FROM Emp
GROUP BY name
HAVING SUM(sal)>3000; 
Output:






What is MYsql
MySQL is a relational database management system based on the Structured Query Language, which is the popular language for accessing and managing the records in the database. MySQL is open-source and free software under the GNU license. It is supported by Oracle Company.



Diff between Unique key and primary key

Primary Key
A primary key is a column of a table that uniquely identifies each tuple (row) in that table. The primary key enforces integrity constraints to the table. Only one primary key is allowed to use in a table. The primary key does not accept any duplicate and NULL values. The primary key value in a table changes very rarely so it is chosen with care where the changes can occur in a seldom manner. A primary key of one table can be referenced by the foreign key of another table. 
For a better understanding of the primary key, we take a table named Student table, having attributes such as Roll_number, Name, Batch, Phone_number, and Citizen_ID. 
Primary Key
The roll number attribute can never have an identical and NULL value, because every student enrolled in a university can have a unique roll number, therefore two students cannot have the same roll number, and each row in a table is uniquely identified with the student’s roll number. So, we can make Roll_number attribute as a primary key in this case.
Features of Primary Key
Some of the essential features of Primary Keys are discussed below.
• There will be no duplicate row in case of a Primary Key.
• Only a single primary key exists for a table.
• Primary Key contains NOT NULL constraints.
• The primary Key can be made from one or more table fields.
Unique Key
Unique Key constraints also identify an individual tuple uniquely in a relation or table. A table can have more than one unique key, unlike a primary key. Unique key constraints can accept only one NULL value for the column. Unique constraints are also referenced by the foreign key of another table. It can be used when someone wants to enforce unique constraints on a column and a group of columns which is not a primary key. 
For a better understanding of the unique key, we take the Student table with Roll_number, Name, Batch, Phone_number, and Citizen_ID attributes. 
Unique Key
Roll number attribute is already assigned with the primary key and Citizen_ID can have unique constraints where each entry in a Citizen_ID column should be unique because each citizen of a country must have his or her Unique identification number like an Aadhaar Number. But if the student is migrated to another country in that case, he or she would not have any Citizen_ID and the entry could have a NULL value as only one NULL is allowed in the unique constraint. 
Features of Unique Key
Some of the essential features of Unique Keys are discussed below.
• There can be more than one unique key for a table.
• Unique Keys have the liberty of having NULL values in the column.
• Unique Keys can be formed from one or more tables.
• Foreign Keys can refer to Unique Keys for referencing.
Differences between Primary Key and Unique Key
Parameters	PRIMARY KEY	UNIQUE KEY
Basic	Used to serve as a unique identifier for each row in a table.	Uniquely determines a row that isn’t the primary key.
NULL value acceptance	Cannot accept NULL values.	Can accept NULL values.
Number of keys that can be defined in the table	Only one primary key	More than one unique key
Index	Creates clustered index	Creates non-clustered index
Auto Increment	A Primary key supports auto-increment value.	A unique key does not support auto-increment value.
Modification	We cannot change or delete values stored in primary keys.	We can change unique key values.
Uses	The primary Key is used for indicating the rows uniquely.	The Unique Key is used for preventing duplicate entries.
Syntax	CREATE TABLE Student	CREATE TABLE House
	(	(
	Student_Id INT PRIMARY KEY, 	House_Number INT UNIQUE, 
	Student_name VARCHAR(150), 	House_Name VARCHAR(150), 
	roll_number INT(10)	House_Address VARCHAR(250)
	)	)
Conclusion
• The primary key will not accept NULL values whereas the Unique key can accept NULL values.
• A table can have only one primary key whereas there can be multiple unique keys on a table.
• A Clustered index is automatically created when a primary key is defined whereas a Unique key generates the non-clustered index.
• A Primary Key can be a Unique Key, but a Unique Key cannot be a primary key.




 what is indexing required

Indexing is the way to get an unordered table into an order that will maximize the query's efficiency while searching. When a table is unindexed, the order of the rows will likely not be discernible by the query as optimized in any way, and your query will therefore have to search through the rows linearly.



What is SQL union

The UNION operator could be used to find the result set or combination of two or more tables. 
Terms and Conditions for using UNION 
• Each table used within UNION must have the same number of columns.
• The columns must have the same data types.
• The columns in each table must be in the same order.
Syntax: 
SELECT columnnames FROM table1
UNION
SELECT columnnames FROM table2;
UNION operator provides only unique values by default. To find duplicate values, use UNION ALL.
 Syntax:
SELECT columnnames FROM table1
UNION ALL
SELECT columnnames FROM table2;
Let’s assume we have two tables “Emp1” and “Emp2”;
Table1:
CREATE TABLE Emp1(
    EmpID INT PRIMARY KEY,
    Name VARCHAR(50),
    Country VARCHAR(50),
    Age int(2),
  mob int(10)
);
-- Insert some sample data into the Customers table
INSERT INTO Emp1 (EmpID, Name,Country, Age, mob)
VALUES (1, 'Shubham',  'India','23','738479734'),
       (2, 'Aman ',  'Australia','21','436789555'),
       (3, 'Naveen', 'Sri lanka','24','34873847'),
       (4, 'Aditya',  'Austria','21','328440934'),
       (5, 'Nishant', 'Spain','22','73248679');
       Select * from Emp1;
Output:

 
Table2
CREATE TABLE Emp2(
    EmpID INT PRIMARY KEY,
    Name VARCHAR(50),
    Country VARCHAR(50),
    Age int(2),
  mob int(10)
);
-- Insert some sample data into the Customers table
INSERT INTO Emp2 (EmpID, Name,Country, Age, mob)
VALUES (1, 'Tommy',  'England','23','738985734'),
       (2, 'Allen',  'France','21','43678055'),
       (3, 'Nancy', 'India','24','34873847'),
       (4, 'Adi',  'Ireland','21','320254934'),
       (5, 'Sandy', 'Spain','22','70248679');
       Select * from Emp2;
Output:

 
 SQL UNION Example
 The below SQL statement finds the cities (only unique values) from both the “Table1” and the “Table2” tables: 
Query: 
SELECT Country
FROM Emp1
UNION
SELECT Country
FROM Emp2
ORDER BY Country;
Output:

 
SQL UNION ALL Example 
The below SQL statement finds the cities (duplicate values also) from both the “Emp1” and the “Emp2” tables: 
Query: 
SELECT Country FROM Emp1 UNION SELECT Country FROM Emp2 ORDER BY Country;
Output: 

 
SQL UNION ALL With WHERE
The following SQL statement returns the cities (duplicate values also) from both the “Geeks1” and the “Geeks2” tables:
Query: 
SELECT Country, Name FROM Emp1
WHERE Name='Aditya'
UNION ALL
SELECT Country, Name FROM Emp2
WHERE Country='Ireland'
ORDER BY Country;
Output:


 Difference between sql and no sql

Main differences between NoSQL and SQL
Type 
SQL databases are primarily called Relational Databases (RDBMS); whereas NoSQL databases are primarily called non-relational or distributed databases. 
Language 
SQL databases define and manipulate data-based structured query language (SQL). Seeing from a side this language is extremely powerful. SQL is one of the most versatile and widely-used options available which makes it a safe choice, especially for great complex queries. But from another side, it can be restrictive. SQL requires you to use predefined schemas to determine the structure of your data before you work with it. Also, all of your data must follow the same structure. This can require significant up-front preparation which means that a change in the structure would be both difficult and disruptive to your whole system. 
 
A NoSQL database has a dynamic schema for unstructured data. Data is stored in many ways which means it can be document-oriented, column-oriented, graph-based, or organized as a key-value store. This flexibility means that documents can be created without having a defined structure first. Also, each document can have its own unique structure. The syntax varies from database to database, and you can add fields as you go. 
Scalability 
In almost all situations SQL databases are vertically scalable. This means that you can increase the load on a single server by increasing things like RAM, CPU, or SSD. But on the other hand, NoSQL databases are horizontally scalable. This means that you handle more traffic by sharding, or adding more servers in your NoSQL database. It is similar to adding more floors to the same building versus adding more buildings to the neighborhood. Thus NoSQL can ultimately become larger and more powerful, making these databases the preferred choice for large or ever-changing data sets.
Structure 
 SQL databases are table-based on the other hand NoSQL databases are either key-value pairs, document-based, graph databases, or wide-column stores. This makes relational SQL databases a better option for applications that require multi-row transactions such as an accounting system or for legacy systems that were built for a relational structure. 
Property followed 
SQL databases follow ACID properties (Atomicity, Consistency, Isolation, and Durability) whereas the NoSQL database follows the Brewers CAP theorem (Consistency, Availability, and Partition tolerance). 
Support 
Great support is available for all SQL databases from their vendors. Also, a lot of independent consultants are there who can help you with SQL databases for very large-scale deployments but for some NoSQL databases you still have to rely on community support and only limited outside experts are available for setting up and deploying your large-scale NoSQL deploy. 
When To Use: SQL vs NoSQL 
SQL is a good choice when working with related data. Relational databases are efficient, flexible, and easily accessed by any application. A benefit of a relational database is that when one user updates a specific record, every instance of the database automatically refreshes, and that information is provided in real-time.
SQL and a relational database make it easy to handle a great deal of information, scale as necessary and allow flexible access to data only needing to update data once instead of changing multiple files, for instance. It’s also best for assessing data integrity. Since each piece of information is stored in a single place, there’s no problem with former versions confusing the picture.
 
While NoSQL is good when the availability of big data is more crucial, SQL is valued for ensuring data validity. It’s also a wise decision when a business needs to expand in response to shifting customer demands. NoSQL offers high performance, flexibility, and ease of use.
NoSQL is also a wise choice when dealing with large or constantly changing data sets, flexible data models, or requirements that don’t fit into a relational model. Document databases, like CouchDB, MongoDB, and Amazon DocumentDB, are useful for handling large amounts of unstructured data.
Key Highlights on SQL vs NoSQL
SQL	NoSQL
RELATIONAL DATABASE MANAGEMENT SYSTEM (RDBMS)	Non-relational or distributed database system.
These databases have fixed or static or predefined schema	They have a dynamic schema
These databases are not suited for hierarchical data storage.	These databases are best suited for hierarchical data storage.
These databases are best suited for complex queries	These databases are not so good for complex queries
Vertically Scalable	Horizontally scalable
Follows ACID property	Follows CAP(consistency, availability, partition tolerance)
Examples: MySQL, PostgreSQL, Oracle, MS-SQL Server, etc	Examples: MongoDB, GraphQL, HBase, Neo4j, Cassandra, etc



write SQL query to add one more column into it

Let’s perform an SQL add column to table action. We’ll add a fourth column to an existing table, our “employees” table:
ALTERTABLEemployees ADDprobation BOOLEAN;
Now our table appears as follows:
Column Name	Data Type	Constraints
Name	VARCHAR(50)	NOT NULL
Title	VARCHAR(75)	NOT NULL
Branch	VARCHAR(25)	NOT NULL
Probation	BOOLEAN	


normalization and it's types explain

What is Normalization?
	• Normalization is the process of organizing the data in the database.
	• Normalization is used to minimize the redundancy from a relation or set of relations. It is also used to eliminate undesirable characteristics like Insertion, Update, and Deletion Anomalies.
	• Normalization divides the larger table into smaller and links them using relationships.
	• The normal form is used to reduce redundancy from the database table.
Types of Normal Forms:
Normalization works through a series of stages called Normal forms. The normal forms apply to individual relations. The relation is said to be in particular normal form if it satisfies constraints.
Following are the various types of Normal forms:

Normal Form	Description
1NF	A relation is in 1NF if it contains an atomic value.
2NF	A relation will be in 2NF if it is in 1NF and all non-key attributes are fully functional dependent on the primary key.
3NF	A relation will be in 3NF if it is in 2NF and no transition dependency exists.
BCNF	A stronger definition of 3NF is known as Boyce Codd's normal form.
4NF	A relation will be in 4NF if it is in Boyce Codd's normal form and has no multi-valued dependency.
5NF	A relation is in 5NF. If it is in 4NF and does not contain any join dependency, joining should be lossless.
First Normal Form (1NF)
	• A relation will be 1NF if it contains an atomic value.
	• It states that an attribute of a table cannot hold multiple values. It must hold only single-valued attribute.
	• First normal form disallows the multi-valued attribute, composite attribute, and their combinations.
Example: Relation EMPLOYEE is not in 1NF because of multi-valued attribute EMP_PHONE.
EMPLOYEE table:
EMP_ID	EMP_NAME	EMP_PHONE	EMP_STATE
14	John	7272826385,	UP
		9064738238
20	Harry	8574783832	Bihar
12	Sam	7390372389,	Punjab
		8589830302
The decomposition of the EMPLOYEE table into 1NF has been shown below:
EMP_ID	EMP_NAME	EMP_PHONE	EMP_STATE
14	John	7272826385	UP
14	John	9064738238	UP
20	Harry	8574783832	Bihar
12	Sam	7390372389	Punjab
12	Sam	8589830302	Punjab

Second Normal Form (2NF)
	• In the 2NF, relational must be in 1NF.
	• In the second normal form, all non-key attributes are fully functional dependent on the primary key
Example: Let's assume, a school can store the data of teachers and the subjects they teach. In a school, a teacher can teach more than one subject.
TEACHER table
TEACHER_ID	SUBJECT	TEACHER_AGE
25	Chemistry	30
25	Biology	30
47	English	35
83	Math	38
83	Computer	38
In the given table, non-prime attribute TEACHER_AGE is dependent on TEACHER_ID which is a proper subset of a candidate key. That's why it violates the rule for 2NF.
To convert the given table into 2NF, we decompose it into two tables:
TEACHER_DETAIL table:
TEACHER_ID	TEACHER_AGE
25	30
47	35
83	38
TEACHER_SUBJECT table:
TEACHER_ID	SUBJECT
25	Chemistry
25	Biology
47	English
83	Math
83	Computer

Third Normal Form (3NF)
	• A relation will be in 3NF if it is in 2NF and not contain any transitive partial dependency.
	• 3NF is used to reduce the data duplication. It is also used to achieve the data integrity.
	• If there is no transitive dependency for non-prime attributes, then the relation must be in third normal form.
A relation is in third normal form if it holds atleast one of the following conditions for every non-trivial function dependency X → Y.
	1. X is a super key.
	2. Y is a prime attribute, i.e., each element of Y is part of some candidate key.
	Example:
	EMPLOYEE_DETAIL table:
	EMP_ID	EMP_NAME	EMP_ZIP	EMP_STATE	EMP_CITY
	222	Harry	201010	UP	Noida
	333	Stephan	02228	US	Boston
	444	Lan	60007	US	Chicago
	555	Katharine	06389	UK	Norwich
	666	John	462007	MP	Bhopal
	Super key in the table above:
	1. {EMP_ID}, {EMP_ID, EMP_NAME}, {EMP_ID, EMP_NAME, EMP_ZIP}....so on  
	Candidate key: {EMP_ID}
	Non-prime attributes: In the given table, all attributes except EMP_ID are non-prime.
	Here, EMP_STATE & EMP_CITY dependent on EMP_ZIP and EMP_ZIP dependent on EMP_ID. The non-prime attributes (EMP_STATE, EMP_CITY) transitively dependent on super key(EMP_ID). It violates the rule of third normal form.
	That's why we need to move the EMP_CITY and EMP_STATE to the new <EMPLOYEE_ZIP> table, with EMP_ZIP as a Primary key.
	EMPLOYEE table:
	EMP_ID	EMP_NAME	EMP_ZIP
	222	Harry	201010
	333	Stephan	02228
	444	Lan	60007
	555	Katharine	06389
	666	John	462007
	EMPLOYEE_ZIP table:
	EMP_ZIP	EMP_STATE	EMP_CITY
	201010	UP	Noida
	02228	US	Boston
	60007	US	Chicago
	06389	UK	Norwich
	462007	MP	Bhopal
Boyce Codd normal form (BCNF)
	• BCNF is the advance version of 3NF. It is stricter than 3NF.
	• A table is in BCNF if every functional dependency X → Y, X is the super key of the table.
	• For BCNF, the table should be in 3NF, and for every FD, LHS is super key.
Example: Let's assume there is a company where employees work in more than one department.
EMPLOYEE table:
EMP_ID	EMP_COUNTRY	EMP_DEPT	DEPT_TYPE	EMP_DEPT_NO
264	India	Designing	D394	283
264	India	Testing	D394	300
364	UK	Stores	D283	232
364	UK	Developing	D283	549
In the above table Functional dependencies are as follows:
1. EMP_ID  →  EMP_COUNTRY  
2. EMP_DEPT  →   {DEPT_TYPE, EMP_DEPT_NO}  
Candidate key: {EMP-ID, EMP-DEPT}
The table is not in BCNF because neither EMP_DEPT nor EMP_ID alone are keys.
To convert the given table into BCNF, we decompose it into three tables:
EMP_COUNTRY table:
EMP_ID	EMP_COUNTRY
264	India
264	India
EMP_DEPT table:
EMP_DEPT	DEPT_TYPE	EMP_DEPT_NO
Designing	D394	283
Testing	D394	300
Stores	D283	232
Developing	D283	549
EMP_DEPT_MAPPING table:
EMP_ID	EMP_DEPT
D394	283
D394	300
D283	232
D283	549
Functional dependencies:
3. EMP_ID   →    EMP_COUNTRY  
4. EMP_DEPT   →   {DEPT_TYPE, EMP_DEPT_NO}  
Candidate keys:
For the first table: EMP_ID
For the second table: EMP_DEPT
For the third table: {EMP_ID, EMP_DEPT}
Now, this is in BCNF because left side part of both the functional dependencies is a key.
