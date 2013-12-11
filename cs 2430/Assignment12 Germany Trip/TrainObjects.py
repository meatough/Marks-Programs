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

#create all needed train objects
#all flights found via http://www.raileurope.com/train-faq/european-trains/ice/how-to-book.h... 
#with october 18 as travel date in economy class, prices appeared to be given in dollars

from TrainClasses import*
import MySQLdb as mdb 
import sys

trainList = []

rostockToHamburg = TrainTravel("Rostock", "Hamburg", Time(1,47), 82)
print "\n\nTrain trip from Rostock to Hamburg\n"
rostockToHamburg.displayTrainTrip()
trainList.append(rostockToHamburg)

rostockToLubeck = TrainTravel("Rostock", "Lubeck", Time(2,32), 108)
print "\n\nTrain trip from Rostock to Hamburg\n"
rostockToLubeck.displayTrainTrip()
trainList.append(rostockToLubeck)

hamburgToLubeck = TrainTravel("Hamburg", "Lubeck", Time(0,45), 26)
print "\n\nTrain trip from Hamburg to Lubeck\n"
hamburgToLubeck.displayTrainTrip()
trainList.append(hamburgToLubeck)

wiesbadenToKassel = TrainTravel("Wiesbaden", "Kassel", Time(1,18), 104)
print "\n\n Train trip from Munich to Nuremburg\n"
#munichToNuremburg.displayTrainTrip()
trainList.append(wiesbadenToKassel)

# hannoverToRostock = TrainTravel("Hannover", "Rostock", Time(2,05), 104)
# print "\n\n Train trip from Munich to Nuremburg\n"
# #munichToNuremburg.displayTrainTrip()
# trainList.append(hannoverToRostock)

hamburgToBerlin = TrainTravel("Hamburg", "Berlin", Time(1,51), 109)
print "\n\nTrain trip from Hamburg to Berlin\n"
hamburgToBerlin.displayTrainTrip()
trainList.append(hamburgToBerlin)

# rostockToBerlin = TrainTravel("Rostock", "Berlin", Time(4,47), 234)
# print "\n\nTrain trip from Hamburg to Berlin\n"
# hamburgToBerlin.displayTrainTrip()
# trainList.append(rostockToBerlin)
# 
# lubeckToBerlin = TrainTravel("Lubeck", "Berlin", Time(2,17), 154)
# print "\n\nTrain trip from Hamburg to Berlin\n"
# hamburgToBerlin.displayTrainTrip()
# trainList.append(lubeckToBerlin)
# 
# bremenToBerlin = TrainTravel("Bremen", "Berlin", Time(3,0), 152)
# print "\n\nTrain trip from Hamburg to Berlin\n"
# hamburgToBerlin.displayTrainTrip()
# trainList.append(bremenToBerlin)
# 
# hannoverToBerlin = TrainTravel("Hannover", "Berlin", Time(2,11), 183)
# print "\n\nTrain trip from Hamburg to Berlin\n"
# hamburgToBerlin.displayTrainTrip()
# trainList.append(hannoverToBerlin)

hamburgToBremen = TrainTravel("Hamburg", "Bremen", Time(1,9), 43)
print "\n\nTrain trip from Hamburg to Bremen\n"
hamburgToBremen.displayTrainTrip()
trainList.append(hamburgToBremen)

rostockToBremen = TrainTravel("Rostock", "Bremen", Time(2,56), 125)
trainList.append(rostockToBremen)

bremenToLubeck = TrainTravel("Bremen", "Lubeck", Time(1,54), 69)
print "\n\nTrain trip from Rostock to Hamburg\n"
bremenToLubeck.displayTrainTrip()
trainList.append(bremenToLubeck)

hamburgToHannover = TrainTravel("Hamburg", "Hannover", Time(1,20), 78)
print "\n\nTrain trip from Hamburg to Hannover\n"
hamburgToHannover.displayTrainTrip()
trainList.append(hamburgToHannover)

hannoverToKassel = TrainTravel("Hannover", "Kassel", Time(0,55), 65)
print "\n\nTrain trip from Hannover to Kassel\n"
hannoverToKassel.displayTrainTrip()
trainList.append(hannoverToKassel)

hannoverToDusseldorf = TrainTravel("Hannover", "Dusseldorf", Time(2,26), 101)
print "\n\nTrain trip from Hannover to Kassel\n"
hannoverToDusseldorf.displayTrainTrip()
trainList.append(hannoverToDusseldorf)

kasselToFrankfurt = TrainTravel("Kassel", "Frankfurt", Time(1,32), 75)
print "\n\nTrain trip from Kassel to Frankfurt\n"
kasselToFrankfurt.displayTrainTrip()
trainList.append(kasselToFrankfurt)

dusseldorfToKoln = TrainTravel("Dusseldorf", "Koln", Time(0,24), 26)
print "\n\nTrain trip from Dusseldorf to Koln\n"
dusseldorfToKoln.displayTrainTrip()
trainList.append(dusseldorfToKoln)

dusseldorfToBonn = TrainTravel("Dusseldorf", "Bonn", Time(0,47), 48)
print "\n\nTrain trip from Dusseldorf to Bonn\n"
dusseldorfToBonn.displayTrainTrip()
trainList.append(dusseldorfToBonn)

wiesbadenToMannhiem = TrainTravel("Wiesbaden", "Mannhiem", Time(1,27), 83)
print "\n\nTrain trip from Wiesbaden to Mannhiem\n"
wiesbadenToMannhiem.displayTrainTrip()
trainList.append(wiesbadenToMannhiem)

kolnToBonn = TrainTravel("Koln", "Bonn", Time(0, 23), 22)
print "\n\nTrain trip from Koln to Bonn\n"
kolnToBonn.displayTrainTrip()
trainList.append(kolnToBonn)

kolnToFrankfurt = TrainTravel("Koln", "Frankfurt", Time(1,05), 112)
print "\n\n Train trip from Koln to Frankfurt\n"
kolnToFrankfurt.displayTrainTrip()
trainList.append(kolnToFrankfurt)

bonnToFrankfurt = TrainTravel("Bonn", "Frankfurt", Time(1,58), 72)
print "\n\n Train trip from Bonn to Frankfurt\n"
bonnToFrankfurt.displayTrainTrip()
trainList.append(bonnToFrankfurt)

frankfurtToWiesbaden = TrainTravel("Frankfurt", "Wiesbaden", Time(0,49), 29)
print "\n\n Train trip from Frankfurt to Wiesbaden\n"
frankfurtToWiesbaden.displayTrainTrip()
trainList.append(frankfurtToWiesbaden)

# wiesbadenToStuttgart = TrainTravel("Wiesbaden", "Stuttgart", Time(2,23), 130)
# print "\n\n Train trip from Frankfurt to Stuggart\n"
# #frankfurtToStuttgart.displayTrainTrip()
# trainList.append(wiesbadenToStuttgart)

frankfurtToMannhiem = TrainTravel("Frankfurt", "Mannhiem", Time(0,38), 54)
print "\n\n Train trip from Frankfurt to Mannhiem\n"
frankfurtToMannhiem.displayTrainTrip()
trainList.append(frankfurtToMannhiem)

frankfurtToKarlsruhe = TrainTravel("Frankfurt", "Karlsruhe", Time(1,3), 69)
print "\n\n Train trip from Frankfurt to Karlsruhe\n"
frankfurtToKarlsruhe.displayTrainTrip()
trainList.append(frankfurtToKarlsruhe)

# badenbadenToStuttgart = TrainTravel("Baden Baden", "Stuttgart", Time(2,53), 179)
# print "\n\n Train trip from Frankfurt to Stuggart\n"
# #frankfurtToStuttgart.displayTrainTrip()
# trainList.append(badenbadenToStuttgart)

frankfurtToBadenBaden = TrainTravel("Frankfurt", "Baden Baden", Time(1,19), 78)
print "\n\n Train trip from Frankfurt to Baden Baden\n"
frankfurtToBadenBaden.displayTrainTrip()
trainList.append(frankfurtToBadenBaden)

frankfurtToStuttgart = TrainTravel("Frankfurt", "Stuttgart", Time(1,34), 101)
print "\n\n Train trip from Frankfurt to Stuggart\n"
frankfurtToStuttgart.displayTrainTrip()
trainList.append(frankfurtToStuttgart)

frankfurtToNuremburg = TrainTravel("Frankfurt", "Nurnberg", Time(2,06), 89)
print "\n\n Train trip from Frankfurt to Nuremburg\n"
frankfurtToNuremburg.displayTrainTrip()
trainList.append(frankfurtToNuremburg)

# kasselToStuttgart = TrainTravel("Kassel", "Stuttgart", Time(2,06), 176)
# print "\n\n Train trip from Frankfurt to Stuggart\n"
# frankfurtToStuttgart.displayTrainTrip()
# trainList.append(kasselToStuttgart)
# 
# kolnToStuttgart = TrainTravel("Koln", "Stuttgart", Time(2,39), 213)
# print "\n\n Train trip from Frankfurt to Stuggart\n"
# frankfurtToStuttgart.displayTrainTrip()
# trainList.append(kolnToStuttgart)
# 
# bonnToStuttgart = TrainTravel("Bonn", "Stuttgart", Time(3,32), 173)
# print "\n\n Train trip from Frankfurt to Stuggart\n"
# frankfurtToStuttgart.displayTrainTrip()
# trainList.append(bonnToStuttgart)
# 
# mannhiemToStuttgart = TrainTravel("Mannhiem", "Stuttgart", Time(0,38), 55)
# print "\n\n Train trip from Mannhiem to Stuttgart\n"
# mannhiemToStuttgart.displayTrainTrip()
# trainList.append(mannhiemToStuttgart)

mannhiemToKarlsruhe = TrainTravel("Mannhiem", "Karlsruhe", Time(1,07), 32)
print "\n\n Train trip from Mannhiem to Karlsruhe\n"
mannhiemToKarlsruhe.displayTrainTrip()
trainList.append(mannhiemToKarlsruhe)

mannhiemToBadenBaden = TrainTravel("Mannhiem", "Baden Baden", Time(0,39), 54)
print "\n\n Train trip from Mannhiem to Baden Baden\n"
mannhiemToBadenBaden.displayTrainTrip()
trainList.append(mannhiemToBadenBaden)

karlsruheToBadenBaden = TrainTravel("Karlsruhe", "Baden Baden", Time(0,20), 23)
print "\n\n Train trip from Karlsruhe to Baden Baden\n"
karlsruheToBadenBaden.displayTrainTrip()
trainList.append(karlsruheToBadenBaden)

karlsruheToStuttgart = TrainTravel("Karlsruhe", "Stuttgart", Time(0,55), 36)
print "\n\n Train trip from Karlsruhe to Stuttgart\n"
karlsruheToStuttgart.displayTrainTrip()
trainList.append(karlsruheToStuttgart)

basilToKarlsruhe = TrainTravel("Basil", "Karlsruhe", Time(1,48), 100)
print "\n\nTrain trip from Dusseldorf to Koln\n"
dusseldorfToKoln.displayTrainTrip()
trainList.append(basilToKarlsruhe)

basilToMannhiem = TrainTravel("Basil", "Mannhiem", Time(2,7), 131)
print "\n\nTrain trip from Dusseldorf to Koln\n"
dusseldorfToKoln.displayTrainTrip()
trainList.append(basilToMannhiem)

badenBadenToBasil = TrainTravel("Baden Baden", "Basil", Time(1,28), 77)
print "\n\n Train trip from Baden Baden to basil\n"
badenBadenToBasil.displayTrainTrip()
trainList.append(badenBadenToBasil)

stuttgartToNuremburg = TrainTravel("Stuttgart", "Nurnberg", Time(2,11), 59)
print "\n\n Train trip from Stuttgart to Nuremburg\n"
stuttgartToNuremburg.displayTrainTrip()
trainList.append(stuttgartToNuremburg)

stuttgartToMunich = TrainTravel("Stuttgart", "Munich", Time(2,15), 92)
print "\n\n Train trip from Stuttgart to Munich\n"
stuttgartToMunich.displayTrainTrip()
trainList.append(stuttgartToMunich)

munichToNuremburg = TrainTravel("Munich", "Nurnberg", Time(1,14), 91)
print "\n\n Train trip from Munich to Nuremburg\n"
munichToNuremburg.displayTrainTrip()
trainList.append(munichToNuremburg)

# munichToDresden = TrainTravel("Munich", "Dresden", Time(5,28), 204)
# print "\n\n Train trip from Munich to Nuremburg\n"
# munichToNuremburg.displayTrainTrip()
# trainList.append(munichToDresden)

munichToFrankfurt = TrainTravel("Munich", "Frankfurt", Time(3,49), 192)
print "\n\n Train trip from Munich to Nuremburg\n"
munichToNuremburg.displayTrainTrip()
trainList.append(munichToFrankfurt)

nuremburgToDresden = TrainTravel("Nurnberg", "Dresden", Time(4,14), 113)
print "\n\n Train trip from Nuremburg to Dresden\n"
nuremburgToDresden.displayTrainTrip()
trainList.append(nuremburgToDresden)

nuremburgToLeipzig = TrainTravel("Nurnberg", "Leipzig", Time(3,36), 136)
print "\n\n Train trip from Nuremburg to Dresden\n"
nuremburgToLeipzig.displayTrainTrip()
trainList.append(nuremburgToLeipzig)

munichToLeipzig = TrainTravel("Munich", "Leipzig", Time(2,51), 134)
print "\n\n Train trip from Munich to Nuremburg\n"
munichToNuremburg.displayTrainTrip()
trainList.append(munichToLeipzig)

dresdenToLeipzig = TrainTravel("Dresden", "Leipzig", Time(1,37), 43)
print "\n\n Train trip from Dresden to Leipzig\n"
dresdenToLeipzig.displayTrainTrip()
trainList.append(dresdenToLeipzig)

dresdenToBerlin = TrainTravel("Dresden", "Berlin", Time(2,10), 76)
print "\n\n Train trip from Dresden to Berlin\n"
dresdenToBerlin.displayTrainTrip()
trainList.append(dresdenToBerlin)

leipzigToBerlin = TrainTravel("Leipzig", "Berlin", Time(1,8), 68)
print "\n\n Train trip from Leipzig to Berlin\n"
leipzigToBerlin.displayTrainTrip()
trainList.append(leipzigToBerlin)

kolnToStAugustin = TaxiTravel("Koln", "St. Augustin", 9.18)
trainList.append(kolnToStAugustin)
bonnToStAugustin = TaxiTravel("Bonn", "St. Augustin", 32.25)
trainList.append(bonnToStAugustin)
dusseldorfToStAugustin = TaxiTravel("Dusseldorf", "St. Augustin", 69.9)
trainList.append(dusseldorfToStAugustin)
wiesbadenToStAugustin = TaxiTravel("Wiesbaden", "St. Augustin", 135.9)
trainList.append(wiesbadenToStAugustin)

kolnToCastle = TaxiTravel("Koln", "Castle", 10.0)
#trainList.append(kolnToCastle)

headers = ("CREATE TABLE Train(Id INT PRIMARY KEY AUTO_INCREMENT,"
            "StartCity VARCHAR(25), EndCity VARCHAR(25), Time VARCHAR(25)," 
            "Dollars VARCHAR(25), Euros VARCHAR(25), Trans VARCHAR(25))")

connection = mdb.connect('localhost', 'Mark', 'test623', 'GermanyDB');
with connection:
   cur = connection.cursor() 
   cur.execute("DROP TABLE IF EXISTS Train") 
   cur.execute(headers) 
   i = 1
   for t in trainList:
      cur.execute("INSERT INTO Train(StartCity) VALUES(%s)", t.cityFrom) 
      cur.execute("UPDATE Train SET EndCity = %s WHERE Id = %s", 
         (t.cityTo, i)) 
      cur.execute("UPDATE Train SET Time = %s WHERE Id = %s", 
         (Time.timeToMinutes(t.time), i)) 
      cur.execute("UPDATE Train SET Dollars = %s WHERE Id = %s", 
         (t.dollars.dollars, i)) 
      cur.execute("UPDATE Train SET Euros = %s WHERE Id = %s", 
         (t.euros.euros, i))
      cur.execute("UPDATE Train SET Trans = %s WHERE Id = %s", 
         (t.travelBy, i))
      i+=1  
      cur.execute("INSERT INTO Train(StartCity) VALUES(%s)", t.cityTo) 
      cur.execute("UPDATE Train SET EndCity = %s WHERE Id = %s", 
         (t.cityFrom, i)) 
      cur.execute("UPDATE Train SET Time = %s WHERE Id = %s", 
         (Time.timeToMinutes(t.time), i)) 
      cur.execute("UPDATE Train SET Dollars = %s WHERE Id = %s", 
         (t.dollars.dollars, i)) 
      cur.execute("UPDATE Train SET Euros = %s WHERE Id = %s", 
         (t.euros.euros, i))
      cur.execute("UPDATE Train SET Trans = %s WHERE Id = %s", 
         (t.travelBy, i))
      i+=1 