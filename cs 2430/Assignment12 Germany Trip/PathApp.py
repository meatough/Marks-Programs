from WieghtedGraphADT import*
from TimeDistanceMoney import*
from ShortestPath import*
from CreateGraph import*
from GraphTests import*
from HamiltonCircuit import*

castle = 20
river = 10

flightList = []

connection = mdb.connect('localhost', 'Mark', 'test623', 'GermanyDB');

with connection:
   cur = connection.cursor() 
   cur.execute("SELECT * FROM Flights") 
   rows = cur.fetchall() 
   for row in rows:
      flightList.append(PathData(row[1], row[2], float(row[5]), int(row[3]), "flight"))
      
   #for f in flightList:
    #  print f.start, f.end

#allConnections1(germanTrainGraph)        
#getPath(germanTrainGraph, "Koln", "Dresden")
shortestStack = []
shortestWeight = Weight(0,0,0)
shortestTimeStack = []
shortestTimeWeight = Weight(0,0,0)
shortestMoneyStack = []
shortestMoneyWeight = Weight(0,0,0)


for f in flightList:
   temp = hamiltonCirciut(germanTrainGraph, f.start, f.end, f.weight)
   if(shortestWeight.euroTimeWeight == 0 or temp.weight.euroTimeWeight<shortestWeight.euroTimeWeight and temp.weight.euroTimeWeight!=0):
      shortestStack = temp.list
      shortestWeight = temp.weight
      #print "Shortest weight = ", shortestWeight.euroTimeWeight
   if(shortestTimeWeight.time.hours == 0 or temp.weight.time.hours<shortestTimeWeight.time.hours and temp.weight.time.hours!=0):
      shortestTimeStack = temp.list
      shortestTimeWeight = temp.weight
      #print "Shortest Time = ", shortestTimeWeight.time
   if(shortestMoneyWeight.euros.euros == 0 or temp.weight.euros.euros<shortestMoneyWeight.euros.euros and temp.weight.euros.euros!=0):
      shortestMoneyStack = temp.list
      shortestMoneyWeight = temp.weight
      #print "Shortest money = ", shortestMoneyWeight.euros

print "The shortest path optomizing for both is: "
j = 0
for i in shortestStack:
   message = ""
   if(i == toVertex(germanTrainGraph,"Hannover")):
      message = "Buy 5 new iPads at 180 euros each"
   if(i == toVertex(germanTrainGraph,"Basil")):
      message = "Buy 2 new watches at 6,000 euros each"
   if(i == toVertex(germanTrainGraph,"Koln")):
      message = "Take a taxi 20 km round trip to see the casle"
   if(i == toVertex(germanTrainGraph,"Hamburg")):
      message = "Take a taxi under the river"
   if(i == toVertex(germanTrainGraph,"Baden Baden")):
      message = "Spend the day at the spa"
   j+=1
   print j,".",i, "\t", message

shortestWeight.euros.euros+=(2100)
shortestWeight+=Weight(float(castle)*1.2, int(float(castle)/float(130)*60), "taxi")
shortestWeight+=Weight(float(river)*1.2, int(float(river)/float(130)*60), "taxi")
print "total time = ", shortestWeight.time
print "total euros = ", shortestWeight.euros
print "total weight = ", shortestWeight.euroTimeWeight
print "cost in dollars = ", convertToDollars(shortestWeight.euros.euros)

print "\n\n\nThe shortest path optomizing for time is: "
j = 0
for i in shortestTimeStack:
   message = ""
   if(i == toVertex(germanTrainGraph,"Hannover")):
      message = "Buy 5 new iPads at 180 euros each"
   if(i == toVertex(germanTrainGraph,"Basil")):
      message = "Buy 2 new watches at 6,000 euros each"
   if(i == toVertex(germanTrainGraph,"Koln")):
      message = "Take a taxi 20 km round trip to see the casle"
   if(i == toVertex(germanTrainGraph,"Hamburg")):
      message = "Take a taxi under the river"
   j+=1
   print j,".",i, "\t", message
shortestTimeWeight.euros.euros+=(2100)
shortestTimeWeight+=Weight(float(castle)*1.2, int(float(castle)/float(130)*60), "taxi")
shortestTimeWeight+=Weight(float(river)*1.2, int(float(river)/float(130)*60), "taxi")
print "total time = ", shortestTimeWeight.time
print "total euros = ", shortestTimeWeight.euros
print "total weight = ", shortestTimeWeight.euroTimeWeight
print "cost in dollars = ", convertToDollars(shortestTimeWeight.euros.euros)

print "\n\n\nThe shortest path optomizing for money is: "
j = 0
for i in shortestMoneyStack:
   message = ""
   if(i == toVertex(germanTrainGraph,"Hannover")):
      message = "Buy 5 new iPads at 180 euros each"
   if(i == toVertex(germanTrainGraph, "Basil")):
      message = "Buy 2 new watches at 6,000 euros each"
   if(i == toVertex(germanTrainGraph,"Koln")):
      message = "Take a taxi 20 km round trip to see the casle"
   if(i == toVertex(germanTrainGraph,"Hamburg")):
      message = "Take a taxi under the river"
   j+=1
   print j,".",i, "\t", message
print "total time = ", shortestMoneyWeight.time
print "total euros = ", shortestMoneyWeight.euros
print "total weight = ", shortestMoneyWeight.euroTimeWeight
print "cost in dollars = ", convertToDollars(shortestMoneyWeight.euros.euros)