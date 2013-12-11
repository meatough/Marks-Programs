from WieghtedGraphADT import*
from TimeDistanceMoney import*
from ShortestPath import*
import MySQLdb as mdb 
import sys

#shortest path algorithms on page 712 Dijkstra's algorithm psuedocode, section 10.6
#primps, Kruskal, Floyds, Dijkstra(greedy)

germanTrainGraph = WieghtedGraph()

connection = mdb.connect('localhost', 'Mark', 'test623', 'GermanyDB');

with connection:
   cur = connection.cursor() 
   cur.execute("SELECT * FROM Train") 
   rows = cur.fetchall() 
   for row in rows:
      germanTrainGraph.addEdge(row[1], row[2], Weight(float(row[5]),int(row[3]), row[6]))
   