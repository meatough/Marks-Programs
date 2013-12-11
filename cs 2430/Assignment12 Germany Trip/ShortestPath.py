from WieghtedGraphADT import*
from TimeDistanceMoney import*
#method to convert city string to vertex
def toVertex(graph, city):
   for v in graph:
      if(v.getId() == city):
         city = v
   return city
#method to get next city for stack
def addNextCity(currentCity, endCity, stack, weight, graph, check):
   while(currentCity!=endCity):
      if endCity in currentCity.connectionList:
         weight+=currentCity.getWeight(endCity)
         stack.append(endCity)
         return endCity    
      for i in currentCity.connectionList:
         if i not in stack and i not in check:
            weight+=currentCity.getWeight(i)
            stack.append(i)
            return i
      removedCity = stack.pop()
      check.append(removedCity)
      weight-=stack[len(stack)-1].getWeight(removedCity)
      currentCity = stack[len(stack)-1]
      print len(check)
   #return removeCity(currentCity, stack)
#method to remove a city from stack
def removeCity(currentCity, stack):
   stack.pop()
   return stack[len(stack)-1]                      
#method to return a path         
def getPath(graph, cityStart, cityEnd):
   stack = []
   check = []
   currentWeight = Weight(0,0,0)
   cityStart = toVertex(graph, cityStart)
   cityEnd = toVertex(graph, cityEnd)
   tempCity = cityStart
   stack.append(cityStart)
   while cityEnd not in stack:
      tempCity = addNextCity(tempCity, cityEnd, stack, currentWeight, graph, check)
   
   print "A valid path from",cityStart, "to", cityEnd, "is:"
   for i in stack:
      print i
      
   print "total time = ", currentWeight.time
   print "total money = ", currentWeight.euros
   
   
