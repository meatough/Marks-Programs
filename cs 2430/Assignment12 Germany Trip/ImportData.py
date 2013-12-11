'''
*********************************************************** 
 * Discrete Structures
 * Trip Through Germany Program
 * Programmer: Mark Eatough
 * Course: CSIS 2430 
 * Created Novermber 3, 2013

 ***********************************************************
'''

import MySQLdb as mdb 
import sys



connection = mdb.connect('localhost', 'Mark', 'test623', 'GermanyDB');

with connection:
   cur = connection.cursor() 
   cur.execute("SELECT * FROM Train") 
   rows = cur.fetchall() 
   desc = cur.description 
   print "%s %12s %12s %20s %9s %13s" % (desc[0][0], desc[1][0], desc[2][0], desc[3][0], desc[4][0], desc[5][0]) 
   for row in rows: 
      print "%2s %12s %12s %20s %9s %13s" % row 
