'''
*********************************************************** 
 * Discrete Structures
 * Trip Through Germany Program
 * Programmer: Mark Eatough
 * Course: CSIS 2430 
 * Created Novermber 3, 2013

 ***********************************************************
'''

from TimeDistanceMoney import*

class TrainTravel:
   def __init__(self, cityFrom, cityTo, time, dollars):
      self.cityFrom = cityFrom
      self.cityTo = cityTo
      self.time = time
      self.dollars = Dollars(dollars)
      self.euros = convertToEuros(dollars)
      self.travelBy = "Train"
      
   def displayTrainTrip(self):
      print "Leaving From: ", self.cityFrom
      print "Comming To: ", self.cityTo
      print "Total time: ", self.time
      print "Total cost in euros: ", self.euros
      print "Total cost in USD: ", self.dollars

class TaxiTravel:
      def __init__(self, cityFrom, cityTo, distance):
         self.cityFrom = cityFrom
         self.cityTo = cityTo
         self.euros = Euros(float(distance)*1.2)
         self.dollars = convertToDollars(self.euros.euros)
         self.time = Time(0,int((float(distance)/float(130))*60))
         self.travelBy = "Taxi"