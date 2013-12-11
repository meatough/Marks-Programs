from ShortestPath import*
import os
import time

#method to get next city for stack
def addCity(currentCity, endCity, stack, weight, i, pathSize):
   while(i < len(currentCity.connectionList)):
      if(len(stack) == 0):
         return
      if len(stack) == pathSize-1 and endCity in currentCity.connectionList:
         weight+=currentCity.getWeight(endCity)
         stack.append(endCity)
         return endCity
      if currentCity.connectionList[i] not in stack and currentCity.connectionList[i] != endCity:
         currentCity.connectionList[i]
         stack.append(currentCity.connectionList[i])
         weight+=currentCity.getWeight(currentCity.connectionList[i]) 
         return currentCity.connectionList[i]  
      i+=1
   removeCurrentCity(stack, endCity, weight, pathSize)
   
def removeCurrentCity(stack, startCity, weight, pathSize):
   previousCity = stack.pop()
   if(len(stack) == 0):
         return
   currentCity = stack[len(stack)-1]
   i = currentCity.connectionList.index(previousCity)+1
   weight-=currentCity.getWeight(previousCity)
   addCity(currentCity, startCity, stack, weight, i, pathSize)  

def hamiltonCirciut(graph, startCity, endCity, weight):   
   stack = []
   startCity = toVertex(graph, startCity)
   endCity = toVertex(graph, endCity)
   stack.append(startCity)
   currentWeight = weight
   if(startCity == endCity):
      pathSize = len(graph.vertList)+1
   else:
      pathSize = len(graph.vertList)

   while(len(stack)<pathSize):
      i=0
      if(len(stack) == 0):
         break
      currentCity = stack[len(stack)-1]
      addCity(currentCity, endCity, stack, currentWeight, i, pathSize)
      
   if(len(stack) == 0):
      currentWeight = Weight(0,0,0)
   
   return PathStats(stack, currentWeight)