#create a list of 9 numbers between 1 and 100
myList = [85, 13, 8, 97, 73, 24, 37, 62, 23]
pivot = 50
      
def quickSort(r):
   less = []
   equal = [] 
   greater = []
   if (len(r) > 1): 
      pivot = r[0] 
      for x in r:
         if x < pivot:
            less.append(x)
         if (x == pivot):
            equal.append(x)     
         if x > pivot:
             greater.append(x)
         quickSort(less) 
         quickSort(greater) 
         r = less[:] + equal[:] + greater [:]
   return r
 
      
myList = quickSort(myList) 
for j in range(len(myList)):
   print j+1, ".\t", myList[j]   
     