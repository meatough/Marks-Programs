import MySQLdb as mdb 
import sys

con = mdb.connect('localhost', 'Mark', 'test623', 'testdb');

with con:
   cur = con.cursor() 
   cur.execute("DROP TABLE IF EXISTS Writers") 
   cur.execute("CREATE TABLE Writers(Id INT PRIMARY KEY AUTO_INCREMENT, Name VARCHAR(25))") 
   cur.execute("INSERT INTO Writers(Name) VALUES('Jack London')") 
   cur.execute("INSERT INTO Writers(Name) VALUES('Honore de Balzac')") 
   cur.execute("INSERT INTO Writers(Name) VALUES('Lion Feuchtwanger')") 
   cur.execute("INSERT INTO Writers(Name) VALUES('Emile Zola')") 
   cur.execute("INSERT INTO Writers(Name) VALUES('Truman Capote')") 