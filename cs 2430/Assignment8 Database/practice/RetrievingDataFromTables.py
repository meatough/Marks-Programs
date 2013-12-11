import MySQLdb as mdb 
import sys

con = mdb.connect('localhost', 'Mark', 'test623', 'testdb');

with con:
   cur = con.cursor() 
   cur.execute("SELECT * FROM Writers") 
   #can be printed this way, probably best way
   rows = cur.fetchall() 
   desc = cur.description 
   print "%s %3s" % (desc[0][0], desc[1][0]) 
   for row in rows: 
      print "%2s %3s" % row 
   #can be printed like this
   #for row in rows: 
      #print row 

   #or this way
   #for i in range(cur.rowcount): 
      #row = cur.fetchone(0)  
      #print row[0], row[1] 
