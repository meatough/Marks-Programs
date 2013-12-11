'''
*********************************************************** 
 * Discrete Structures
 * Trip Through Germany Program
 * Programmer: Mark Eatough
 * Course: CSIS 2430 
 * Created Novermber 3, 2013

 ***********************************************************
'''

#class to create and manage dollars object
class Dollars: 
   def __init__(self, dollars):
      self.dollars = dollars
  #toString method equivalent
   def __str__(self):
      return("${0:.2f}".format(self.dollars))
   #method to add dollars
   def __add__(self, other):
      myMoney = self.dollars+other.dollars
      myDollars = Dollars(myMoney)
      return myDollars
   #Method to multiply dollars
   def __mul__(self, mult):
      myMoney = self.dollars*mult
      myDollars = Dollars(myMoney)
      return myDollars

#class to create and manage euros object
class Euros:
   def __init__(self, euros):
      self.euros = euros
   #toString method equivalent
   def __str__(self):
      return("{0:.2f} Euros".format(self.euros))
   #method to add Euros
   def __add__(self, other):
      myMoney = self.euros+other.euros
      myEuros = Euros(myMoney)
      return myEuros
   #method to subtract Euros
   def __sub__(self, other):
      myMoney = self.euros-other.euros
      myEuros = Euros(myMoney)
      return myEuros
   #Method to multiply dollars
   def __mul__(self, mult):
      myMoney = self.Euros*mult
      myEuros = Euros(myEuros)
      return myEuros

#class to create and manage time object
class Time:
   def __init__(self, hours, minutes):
      self.hours = hours
      self.minutes = minutes
      while(self.minutes >= 60):
         self.hours += 1
         self.minutes -= 60
   #convert time to minutes for database, convert back to time in graph
   def timeToMinutes(self):
      self.minutes += (self.hours*60)
      return self.minutes
   def __lt__(self, other):
      return (Time.timeToMinutes(self)<Time.timeToMinutes(other))
   #toString method equivalent
   def __str__(self):
      return("{0} Hours {1} Miniutes".format(self.hours,self.minutes)) 
   #overload '+' operator
   def __add__(self, other):
      myHours = self.hours+other.hours
      myMinutes = self.minutes+other.minutes
      while(myMinutes >= 60):
         myMinutes -= 60
         myHours += 1
      myTime = Time(myHours, myMinutes)
      return myTime
   #overload '-' operator
   def __sub__(self, other):
      bigMinutes = (self.hours*60)+self.minutes
      littleMinutes = (other.hours*60)+other.minutes
      newTime = bigMinutes-littleMinutes
      myTime = Time(0, newTime)
      return myTime
   #overload '*' operator   
   def __mul__(self, mult):
      myMinutes = (self.hours*60) + self.minutes
      myMinutes *=mult
      myHours = 0;
      while(myMinutes >= 60):
         myMinutes -= 60
         myHours += 1
      myTime = Time(myHours, myMinutes)
      return myTime
   #overload '/' operator
   def __div__(self, div):
      myMinutes = (self.hours*60) + self.minutes
      myMinutes /=div
      myHours = 0;
      while(myMinutes >= 60):
         myMinutes -= 60
         myHours += 1
      myTime = Time(myHours, myMinutes)
      return myTime
      
#CONVERSTIONS

#conversion rate found on xrates.com, rounded to the nearest cent
def convertToEuros(dollars):
   euros = dollars * 0.74
   return Euros(euros)
#conversion rate found on xrates.com, rounded to the nearest cent
def convertToDollars(euros):
   dollars = euros * 1.35
   return Dollars(dollars)
#Converstion from miles to kilometers
def convertToKilometers(miles):
   miles = kilometers * 0.62
   return miles
#Conversion from kilometers to miles
def convertToMiles(kilometers):
   kilometers = miles * 1.6
   return kilometers
#1.96 multiplier figured by adding all times on flights and train trips
#and then dividing by all sum of all costs on flights and train trips 
#number then rounded to 1.96
class Weight:
   def __init__(self, euros, time, Transport):
      self.euroTimeWeight = (float(euros)*1.96)+float(time)
      self.euros = Euros(euros)
      self.time = Time(0,time)
      self.Transport = Transport
      #toString method equivalent
      def __str__(self):
         return("{0:.2f} Euros".format(self.euros), " Time: ", self.time, " Weight: 0", self.weight, "by: ", transport)
   #method to add two wieghts together
   def __add__(self, other):
      self.euros+=other.euros
      self.time+=other.time
      self.euroTimeWeight+=other.euroTimeWeight
      self.Transport = "severalModes"
      return self
   def __sub__(self, other):
      self.euros-=other.euros
      self.time-=other.time
      self.euroTimeWeight-=other.euroTimeWeight
      self.Transport = "severalModes"
      return self
   def __lt__(self, other):
      return (self.euros<other.euros)
      
class PathData:
   def __init__(self, start, end, euros, time, flight):
      self.start = start
      self.end = end
      self.weight = Weight(euros, time, flight)
      
class PathStats:
   def __init__(self, list, weight):
      self.list = list
      self.weight = weight
   