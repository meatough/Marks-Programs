from WieghtedGraphADT import*
from TimeDistanceMoney import*
#show all connections and weights
def allConnections1(graph):
   i = 1
   for v in graph: 
      print i, ".", v.getId()
      i+=1
      for w in v.connectionList:
         print "\t%s" % (w.getId())
def allConnections2(graph):
   i = 1
   for v in graph: 
      print i, ".", v.getId()
      i+=1
      for w in v.getConnections():
         print "\t%s" % (w.getId())