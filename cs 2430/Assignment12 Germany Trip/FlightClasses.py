from TimeDistanceMoney import*

#class to manage flights, has many objects within it.     
class Flight:
   def __init__(self, home, vacaTo, timeTo, timeFrom, dollars, vacaBack):
      self.home = home
      self.vacaTo = vacaTo
      if(vacaBack is None):
         self.vacaBack =  vacaTo
      else:
         self.vacaBack =  vacaBack
      self.timeTo = timeTo
      self.timeFrom = timeFrom
      self.totalTime = timeTo + timeFrom
      self.dollars = Dollars(dollars)
      self.euros = convertToEuros(dollars)
   
   def displayFlight(self):
      print "Flying From: ", self.home
      print "Flying To: ", self.vacaTo
      print "Flying Back From: ", self.vacaBack 
      print "Total Time: ", self.totalTime
      print "total cost in USD:", self.dollars 
      print "total cost in Euros:", self.euros 
      
#class to manage concecated flights, has many objects within it.     
class ConcecateFlight:
   def __init__(self, vacaTo, vacaBack, dollars, avgTime):
      self.vacaTo = vacaTo
      self.vacaBack =  vacaBack
      self.avgTime = avgTime
      self.dollars = dollars
      self.euros = convertToEuros(dollars.dollars)
   
   def displayConcateFlight(self):
      print "Flying To: ", self.vacaTo
      print "Flying Back From: ", self.vacaBack 
      print "Average Time: ", self.avgTime
      print "total cost in USD:", self.dollars 
      print "total cost in Euros:", self.euros
      
def flightConcation(flight1, numf1, flight2, numf2, flight3, numf3):
   if(flight1.vacaTo != flight2.vacaTo or flight1.vacaBack != flight2.vacaBack or 
     flight1.vacaTo != flight3.vacaTo or flight1.vacaBack != flight3.vacaBack):
      print "Your destination cities do not match"  
   else:
      cityTo = flight1.vacaTo
      cityFrom = flight1.vacaBack
      totCost = (flight1.dollars*numf1) + (flight2.dollars*numf2) + (flight3.dollars*numf3)
      avgTime = ((flight1.totalTime*numf1) + (flight2.totalTime*numf2) + (flight3.totalTime*numf3))/(numf1+numf2+numf3)
      combinedFlight = ConcecateFlight(cityTo, cityFrom, totCost, avgTime)
      return combinedFlight