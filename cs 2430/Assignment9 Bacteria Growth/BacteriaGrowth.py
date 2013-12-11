'''
*********************************************************** 
 * Discrete Structures
 * Bacteria Growth Program
 * Programmer: Mark Eatough
 * Course: CSIS 2430 
 * Created October 27, 2013

 ***********************************************************
'''

import math

#class to create and manage time object
class Time:
   def __init__(self, hours, miniutes):
      self.hours = hours
      self.miniutes = miniutes
      while(self.miniutes >= 60):
         self.hours += 1
         self.miniutes -= 60
   #toString method equivalent
   def __str__(self):
      return("{0} Hours {1} Miniutes".format(self.hours,self.miniutes))       
   #method to add two times together
   def addTime(self, otherTime):
      myHours = self.hours+otherTime.hours
      myMiniutes = self.miniutes+otherTime.miniutes
      while(myMiniutes >= 60):
         myMiniutes -= 60
         myHours += 1
      myTime = Time(myHours, myMiniutes)
      return myTime
      
   def subTime(self, otherTime):
      myHours = 0
      otherTime.miniutes += (otherTime.hours*60)
      myMinutes = self.miniutes + (self.hours*60) - otherTime.miniutes
      while(myMinutes > 60):
         myMinutes -= 60
         myHours += 1
      myTime = (int(math.fabs(myHours)), int(math.fabs(myMinutes)))
      return myTime
#end time class

def squareBacteria(n):
   bacteria = 2
   while(n>0):
      bacteria*=bacteria
      n-=1
   return bacteria

def doubleBacteria(n):
   bacteria = 2
   while(n>0):
      bacteria*=2
      n-=1
   return bacteria
      
def doubleToMillion(timeToDouble):
   minsToDouble = Time(0,timeToDouble)
   minsPassed = Time(0,0)
   bacteria = 0
   n = 0
   while(bacteria<1000000):
      bacteria = doubleBacteria(n)
      if(bacteria > 1000000):
         bacteria= doubleBacteria(n-1)
         bacteriaToGo = 1000000-bacteria
         increasePerMin = bacteria/20
         timeLeft = bacteriaToGo/increasePerMin
         timeAdded = Time(0,timeLeft)
         minsPassed = Time.addTime(minsPassed, timeAdded)
         bacteria = 1000000
      else:
         minsPassed = Time.addTime(minsPassed, minsToDouble)
         n+=1
   return minsPassed
   
def squareToMillion(timeToDouble):
   minsToDouble = Time(0,timeToDouble)
   minsPassed = Time(0,0)
   bacteria = 0
   n = 0
   while(bacteria<1000000):
      bacteria = squareBacteria(n)
      if(bacteria > 1000000):
         bacteria = squareBacteria(n-1)
         bacteriaToGo = 1000000-bacteria
         while(bacteria < 1000000):
            increasePerMin = bacteria*2
            bacteria+=increasePerMin
            minsPassed = Time.addTime(minsPassed, Time(0,1))
      else:
         minsPassed = Time.addTime(minsPassed, minsToDouble)
         n+=1
   return minsPassed
   
   
   
double = doubleToMillion(20)  
diff1 = Time.subTime(double, Time(2,0))
print "If the bacteria doubles every 20 minutes, an untreated patient will die in\n", double
print "So we need to get the treatement in to the patient ", diff1, "after they are\ninfected"

square = squareToMillion(20)
diff2 = Time.subTime(square, Time(2,0))
print "\n\n\nIf the bacteria squares every 20 minutes, an untreated patient will die in\n", square
print "So we need to get the treatement in to the patient ", diff2, " minutes before theyare infected"