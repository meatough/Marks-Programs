import time
from random import randint
#create a list to store my data 
randList = []
pivot = 500

#populate my list with 50 random integers between 1 and 1000
for i in range(0, 50):
   randList.extend([randint(1, 1000)])

randList2 = randList[:]
randList3 = randList[:]
randList4 = randList[:]

firstSum = 0
secondSum = 0
thirdSum = 0

# quicksort method
def quickSort(r, pivot):
   quickStart = time.clock()
   greater = []
   less = []
   for i in range(len(r)):
      if(r[i] < pivot):
         less.append(r[i])
      if(r[i] >= pivot):
         greater.append(r[i])
         
   r = less[:] + greater[:]
   print "quickSort time: \t", (time.clock() - quickStart)
   return r
      
#bubble sort method
def bubbleSort(r):
   start = time.clock()
   k = 0
   l = 0
   for k in range(len(r)-1):
      for l in range(len(r)-1):
         if r[l] > r[l+1]:
            temp = r[l]
            r[l] = r[l+1]
            r[l+1] = temp
   print "bubbleSort time: \t", (time.clock() - start)
   
#my sort method
def mySort(r):
   myStart = time.clock()
   leftSide = 0
   rightSide = len(r)-1
   
   #nested while loop to sort list
   while(leftSide < len(r)/2):
      lCounter = leftSide
      rCounter = rightSide
      lowTemp = r[leftSide]
      highTemp = r[rightSide]
      lowIndex = leftSide
      highIndex = rightSide
      swap = 0;
      #inner while loop
      while(lCounter < len(r)/2):
         if(lCounter < rCounter):
            if(r[lCounter] < lowTemp):
               lowTemp = r[lCounter]
               lowIndex = lCounter
               swap+=1
            if(r[rCounter] < lowTemp):
               lowTemp = r[rCounter]
            if(r[lCounter] > highTemp):
               highTemp = r[lCounter]
            if(r[rCounter] > highTemp):
               highTemp = r[rCounter]
            lCounter+=1
            rCounter-=1
      if(leftSide >= rightSide-1):
         if(r[leftSide] > r[rightSide]):
            lowTemp = r[rightSide]
            r[rightSide] = r[leftSide]
            r[leftSide] = lowTemp
      else:
         lowIndex = r.index(lowTemp) 
         r[lowIndex] = r[leftSide]
         r[leftSide] = lowTemp
         highIndex =  r.index(highTemp)
         r[highIndex] = r[rightSide]
         r[rightSide] = highTemp
           
      leftSide+=1
      rightSide-=1   
   print "mySort time: \t\t", (time.clock() - myStart)         
      
      
mySort(randList2)
bubbleSort(randList)
randList3 = quickSort(randList3, pivot)

print "\n\n\tBubble Sort\tMy Sort\t\tQuick Sort\tUnsorted list"
for j in range(len(randList2)):
   print j+1, ".\t", randList[j], "\t\t", randList2[j], "\t\t", randList3[j], "\t\t", randList4[j]
   secondSum += randList2[j]
   firstSum += randList[j] 
   thirdSum += randList3[j]




print "\n\n\n first sum = ", firstSum, "\n second sum = ", secondSum, "\n third sum = ", thirdSum