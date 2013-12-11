'''
*********************************************************** 
 * Discrete Structures
 * Trip Through Germany Program
 * Programmer: Mark Eatough
 * Course: CSIS 2430 
 * Created Novermber 3, 2013

 ***********************************************************
'''
#database called GermanyDB for all objects
#table called train in GermanyDB
import MySQLdb as mdb 
import sys
#create all needed flight objects
#all flights found via travelocity with June 30 2014 as departure date and August 1 2014 as return date
from FlightClasses import*

flightsList = []

#Flight from Salt Lake City to and from Frankfurt
myFrankfurt = Flight("Salt Lake City", "Frankfurt", Time(13, 4), Time(13, 15), 1727.40, None)

#Flight from Nashville to and from Frankfurt
parentsFrankfurt = Flight("Nashville", "Frankfurt", Time(10, 38), Time(14, 17), 1625.90, None)

#Flight from Boston to and from Frankfurt
grandFrankfurt = Flight("Boston", "Frankfurt", Time(9, 20), Time(10, 35), 1080.50, None)

#Flight from Salt Lake City to and from Stuttgart
myStuttgart = Flight("Salt Lake City", "Stuttgart", Time(12, 55), Time(17, 23), 1778.59, None)

#Flight from Nashville to and from Stuttgart
parentsStuttgart = Flight("Nashville", "Stuttgart", Time(11, 10), Time(13, 2), 1616.00, None)

#Flight from Boston to and from Stuttgart
grandStuttgart = Flight("Boston", "Stuttgart", Time(8, 45), Time(11, 0), 1569.90, None)

#Flight from Salt Lake City to and from Munich
myMunich = Flight("Salt Lake City", "Munich", Time(12, 59), Time(18, 21), 1768.49, None)

#Flight from Nashville to and from Munich
parentsMunich = Flight("Nashville", "Munich", Time(11, 13), Time(13, 26), 1607.80, None)

#Flight from Boston to and from Munich
grandMunich = Flight("Boston", "Munich", Time(9, 35), Time(15, 30), 1172.80, None)

#Flight from Salt Lake City to and from Berlin
myBerlin = Flight("Salt Lake City", "Berlin", Time(14, 29), Time(16, 10), 1800.10, None)

#Flight from Nashville to and from Berlin
parentsBerlin = Flight("Nashville", "Berlin", Time(19, 55), Time(12, 0), 1553.49, None)

#Flight from Boston to and from Berlin
grandBerlin = Flight("Boston", "Berlin", Time(9, 10), Time(10, 10), 1568.49, None)

frankfurtFlight = flightConcation(myFrankfurt, 1, parentsFrankfurt, 2, grandFrankfurt, 2)
ConcecateFlight.displayConcateFlight(frankfurtFlight)
flightsList.append(frankfurtFlight)

stuttgartFlight = flightConcation(myStuttgart, 1, parentsStuttgart, 2, grandStuttgart, 2)
ConcecateFlight.displayConcateFlight(stuttgartFlight)
flightsList.append(stuttgartFlight)

munichFlight = flightConcation(myMunich, 1, parentsMunich, 2, grandMunich, 2)
ConcecateFlight.displayConcateFlight(munichFlight)
flightsList.append(munichFlight)

berlinFlight = flightConcation(myBerlin, 1, parentsBerlin, 2, grandBerlin, 2)
ConcecateFlight.displayConcateFlight(berlinFlight)
flightsList.append(berlinFlight)

#Flight from Salt Lake City to Frankfurt from stuttgart
myFrankStutt = Flight("Salt Lake City", "Frankfurt", Time(13, 25), Time(15, 05), 1861.09, "Stuttgart")
#Flight from Nashville to Frankfurt from stuttgart
parentsFrankStutt = Flight("Nashville", "Frankfurt", Time(10,48),Time(14,19) , 1700.19, "Stuttgart")
#Flight from Boston to Frankfurt from stuttgart
grandFrankStutt = Flight("Boston", "Frankfurt", Time(7,0), Time(12,25), 1594.69, "Stuttgart")
frankStuttFlight = flightConcation(myFrankStutt, 1, parentsFrankStutt, 2, grandFrankStutt, 2)
flightsList.append(frankStuttFlight)

#Flight from Salt Lake City to Frankfurt from Munich
myFrankMun = Flight("Salt Lake City", "Frankfurt", Time(12, 6), Time(14, 51), 1869.59, "Munich")
#Flight from Nashville to Frankfurt from munich
parentsFrankMun = Flight("Nashville", "Frankfurt",  Time(11, 7), Time(15, 44), 1641.59, "Munich")
#Flight from Boston to Frankfurt from munich
grandFrankMun = Flight("Boston", "Frankfurt",  Time(9, 50), Time(12, 45), 1256.96, "Munich")
frankMunFlight = flightConcation(myFrankMun, 1, parentsFrankMun, 2, grandFrankMun, 2)
flightsList.append(frankMunFlight)

#Flight from Salt Lake City to Frankfurt from Berlin
myFrankBer = Flight("Salt Lake City", "Frankfurt", Time(12, 6), Time(17, 36), 1822.39, "Berlin")
#Flight from Nashville to Frankfurt from Berlin
parentsFrankBer = Flight("Nashville", "Frankfurt",  Time(10, 48), Time(14, 14), 1709.69, "Berlin")
#Flight from Boston to Frankfurt from Berlin
grandFrankBer = Flight("Boston", "Frankfurt",  Time(9, 50), Time(12, 55), 1241.36, "Berlin")
frankBerFlight = flightConcation(myFrankBer, 1, parentsFrankBer, 2, grandFrankBer, 2)
flightsList.append(frankBerFlight)

#Flight from Salt Lake City to Stuttgart from Frankfurt
myStuttFrank = Flight("Salt Lake City", "Stuttgart", Time(12, 55), Time(14, 05), 1865.69, "Frankfurt")
#Flight from Nashville to Stuttgart from Frankfurt
parentsStuttFrank = Flight("Nashville", "Stuttgart", Time(11, 10), Time(13, 12), 1719.59, "Frankfurt")
#Flight from Boston to Stuttgart from Frankfurt
grandStuttFrank = Flight("Boston", "Stuttgart", Time(9, 15), Time(11, 0), 1664.59, "Frankfurt")
stuttFrankFlight = flightConcation(myStuttFrank, 1, parentsStuttFrank, 2, grandStuttFrank, 2)
flightsList.append(stuttFrankFlight)

#Flight from Salt Lake City to Stuttgart from Munich
myStuttMun = Flight("Salt Lake City", "Stuttgart", Time(12, 55), Time(14, 20), 1965.19, "Munich")
#Flight from Nashville to Stuttgart from Munich
parentsStuttMun = Flight("Nashville", "Stuttgart", Time(11, 10), Time(13, 37), 1700.99, "Munich")
#Flight from Boston to Stuttgart from Munich
grandStuttMun = Flight("Boston", "Stuttgart", Time(9, 15), Time(10, 55), 1654.09, "Munich")
stuttMunFlight = flightConcation(myStuttMun, 1, parentsStuttMun, 2, grandStuttMun, 2)
flightsList.append(stuttMunFlight)

#Flight from Salt Lake City to Stuttgart from Berlin
myStuttBer = Flight("Salt Lake City", "Stuttgart", Time(12, 55), Time(14, 25), 1847.69, "Berlin")
#Flight from Nashville to Stuttgart from Berlin
parentsStuttBer = Flight("Nashville", "Stuttgart", Time(11, 10), Time(15, 27), 1725.99, "Berlin")
#Flight from Boston to Stuttgart from Berlin
grandStuttBer = Flight("Boston", "Stuttgart", Time(9, 15), Time(10, 30), 1649.59, "Berlin")
stuttBerFlight = flightConcation(myStuttBer, 1, parentsStuttBer, 2, grandStuttBer, 2)
flightsList.append(stuttBerFlight)

#Flight from Salt Lake City to Munich from Frankfurt
myMunFrank = Flight("Salt Lake City", "Munich", Time(12, 59), Time(14, 55), 1839.19, "Frankfurt")
#Flight from Nashville to Munich from Frankfurt
parentsMunFrank = Flight("Nashville", "Munich", Time(11, 35), Time(13, 12), 1711.69, "Frankfurt")
#Flight from Boston to Munich from Frankfurt
grandMunFrank = Flight("Boston", "Munich", Time(9, 35), Time(10, 35), 1246.89, "Frankfurt")
munFrankFlight = flightConcation(myMunFrank, 1, parentsMunFrank, 2, grandMunFrank, 2)
flightsList.append(munFrankFlight)

#Flight from Salt Lake City to Munich from Stuttgart
myMunStutt = Flight("Salt Lake City", "Munich", Time(12, 59), Time(15, 55), 1937.69, "Stuttgart")
#Flight from Nashville to Munich from Stuttgart
parentsMunStutt = Flight("Nashville", "Munich", Time(11, 35), Time(13, 2), 1675, "Stuttgart")
#Flight from Boston to Munich from Stuttgart
grandMunStutt = Flight("Boston", "Munich", Time(9, 25), Time(10, 30), 1564.99, "Stuttgart")
munStuttFlight = flightConcation(myMunStutt, 1, parentsMunStutt, 2, grandMunStutt, 2)
flightsList.append(munStuttFlight)

#Flight from Salt Lake City to Munich from Berlin
myMunBer = Flight("Salt Lake City", "Munich", Time(12, 59), Time(16, 10), 1945.29, "Berlin")
#Flight from Nashville to Munich from Berlin
parentsMunBer = Flight("Nashville", "Munich", Time(11, 33), Time(14, 14), 1709.69, "Berlin")
#Flight from Boston to Munich from Berlin
grandMunBer = Flight("Boston", "Munich", Time(7, 25), Time(9, 55), 1681.29, "Berlin")
munBerFlight = flightConcation(myMunBer, 1, parentsMunBer, 2, grandMunBer, 2)
flightsList.append(munBerFlight)


#Flight from Salt Lake City to Berlin from Frankfurt
myBerFrank = Flight("Salt Lake City", "Berlin", Time(13, 5), Time(14, 5), 1858.39, "Frankfurt")
#Flight from Nashville to Berlin from Frankfurt
parentsBerFrank = Flight("Nashville", "Berlin", Time(12, 0), Time(14, 35), 1761.69, "Frankfurt")
#Flight from Boston to Berlin from Frankfurt
grandBerFrank = Flight("Boston", "Berlin", Time(10, 20), Time(13, 20), 1378.66, "Frankfurt")
berFrankFlight = flightConcation(myBerFrank, 1, parentsBerFrank, 2, grandBerFrank, 2)
flightsList.append(berFrankFlight)

#Flight from Salt Lake City to Berlin from Stuttgart
myBerStutt = Flight("Salt Lake City", "Berlin", Time(14, 45), Time(15, 5), 1844.79, "Stuttgart")
#Flight from Nashville to Berlin from Stuttgart
parentsBerStutt = Flight("Nashville", "Berlin", Time(12, 0), Time(15, 45), 1565.09, "Stuttgart")
#Flight from Boston to Berlin from Stuttgart
grandBerStutt = Flight("Boston", "Berlin", Time(9, 15), Time(12, 25), 1631.99, "Stuttgart")
berStuttFlight = flightConcation(myBerStutt, 1, parentsBerStutt, 2, grandBerStutt, 2)
flightsList.append(berStuttFlight)

#Flight from Salt Lake City to Berlin from Munich
myBerMun = Flight("Salt Lake City", "Berlin", Time(14, 29), Time(14, 51), 1883.19, "Munich")
#Flight from Nashville to Berlin from Munich
parentsBerMun = Flight("Nashville", "Berlin", Time(13, 15), Time(13, 26), 1715.49, "Munich")
#Flight from Boston to Berlin from Munich
grandBerMun = Flight("Boston", "Berlin", Time(10, 20), Time(12, 45), 1380.96, "Munich")
berMunFlight = flightConcation(myBerMun, 1, parentsBerMun, 2, grandBerMun, 2)
flightsList.append(berMunFlight)

headers = ("CREATE TABLE Flights(Id INT PRIMARY KEY AUTO_INCREMENT,"
            "StartCity VARCHAR(25), EndCity VARCHAR(25), AvgTime VARCHAR(25)," 
            "Dollars VARCHAR(25), Euros VARCHAR(25))")

connection = mdb.connect('localhost', 'Mark', 'test623', 'GermanyDB');
with connection:
   cur = connection.cursor() 
   cur.execute("DROP TABLE IF EXISTS Flights") 
   cur.execute(headers) 
   i = 1
   for f in flightsList:
      cur.execute("INSERT INTO Flights(StartCity) VALUES(%s)", f.vacaTo) 
      cur.execute("UPDATE Flights SET EndCity = %s WHERE Id = %s", 
         (f.vacaBack, i)) 
      cur.execute("UPDATE Flights SET AvgTime = %s WHERE Id = %s", 
         (Time.timeToMinutes(f.avgTime), i))
         #(f.avgTime, i))    
      cur.execute("UPDATE Flights SET Dollars = %s WHERE Id = %s", 
         (f.dollars.dollars, i)) 
      cur.execute("UPDATE Flights SET Euros = %s WHERE Id = %s", 
         (f.euros.euros, i))
      i+=1 