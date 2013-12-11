'''
*********************************************************** 
 * Discrete Structures
 * Recursion Iteration Contrast Program
 * Programmer: Mark Eatough
 * Course: CSIS 2430 
 * Created September 29, 2013

 ***********************************************************
'''
import time

#algorithm 1 from chapter 4 in book, used to find binary representation of my exponents
def makeBinary(number):
   q = number
   b = 2
   binary = ""
   while(q > 0):
      a = q%b
      q = q/b
      binary = str(a) + binary
   return binary

#algorithm 5 from chapter 4 in book, iterative modular exponentiation algorithm
#this one is partially wrong?
def iterativeModularExponentation(number, exponent, modulus):
   x = 1
   binary = makeBinary(exponent)
   i = len(binary)-1
   if(binary[i] == '1'):
      x = x*number
      x = x% modulus
   while (i > 0):
      number*=number
      number = number % modulus
      if(binary[i-1] == '1'):
         x*=number
         x = x % modulus
      i-=1
   return x
   
#method to square something, used in recursive modular exponentation
def squared(x):
   return x*x
    

#algorithm 4 from chapter 5 in book, recursive modular exponentiation equation
#this one is all right?
def recursiveModularExponentation(number, exponent, modulus):
   if(exponent == 0):
      return 1
   elif(exponent % 2 == 0):
      return squared(recursiveModularExponentation(number, exponent/2, modulus)) % modulus
   else:            
      return (squared(recursiveModularExponentation(number, exponent/2, modulus))%modulus*number%modulus) % modulus
#algorithm 7 from chapter 5 in book, recursive fibonacci algorithm
def recursiveFibonacci(number):
   if(number  <= 1):
      return number
   else:
      return recursiveFibonacci(number - 1) + recursiveFibonacci(number - 2)
#algorithm 8 from chapter 5 in book, iterative fibonacci algorithm
def iterativeFibonacci(number):
   if(number == 0): 
      return number
   else:
      x = 0
      y = 1
      for i in range(1, number):
         z = x + y
         x = y
         y = z
      return y

def timeIterativeMod():
   itModStart = time.clock()
   itMod1 = iterativeModularExponentation(7,644, 645)
   itMod2 = iterativeModularExponentation(11,644, 645)
   itMod3 = iterativeModularExponentation(3,2003, 99)
   itMod4 = iterativeModularExponentation(123,1001, 101)
   #calculate time
   itModTime = time.clock() - itModStart
   #print modulus
   print "\nModulus using algorithm 5 from chapter 4:\n"
   print "7^644 mod 645 = \t", itMod1
   print "11^644 mod 645 = \t", itMod2
   print "3^2003 mod 99 = \t", itMod3
   print "123^1001 mod 101 = \t", itMod4
   #print time it took
   print "Iterative Modular Exponentation method time: \t", itModTime
   return float(itModTime)
   
def timeRecursiveMod():
   recModStart = time.clock()
   recMod1 = recursiveModularExponentation(7,644, 645)
   recMod2 = recursiveModularExponentation(11,644, 645)
   recMod3 = recursiveModularExponentation(3,2003, 99)
   recMod4 = recursiveModularExponentation(123,1001, 101)
   #calculate time
   recModTime = time.clock() - recModStart
   #print modulus
   print "\n\nModulus using algorithm 4 from chapter 5:\n"
   print "7^644 mod 645 = \t", recMod1
   print "11^644 mod 645 = \t", recMod2
   print "3^2003 mod 99 = \t", recMod3
   print "123^1001 mod 101 = \t", recMod4
   #print time it took
   print "Recursive Modular Exponentation method time: \t", recModTime
   return float(recModTime)
   
def timeIterativeFib():
   itFibStart = time.clock()
   itFib1 = iterativeFibonacci(5)
   itFib2 = iterativeFibonacci(10)
   itFib3 = iterativeFibonacci(15)
   itFib4 = iterativeFibonacci(20)
   #calculate time
   itFibTime = time.clock() - itFibStart
   #print fibinacci
   print "\n\nFibonacci using algorithm 8 from chapter 5:\n"
   print "Fibonacci of 5 = \t", itFib1
   print "Fibonacci of 10 = \t", itFib2
   print "Fibonacci of 15 = \t", itFib3
   print "Fibonacci of 20 = \t", itFib4
   #print time it took
   print "Iterative Fibonacci method time: \t", itFibTime
   return float(itFibTime)
   
def timeRecursiveFib():
   recFibStart = time.clock()
   recFib1 = recursiveFibonacci(5)
   recFib2 = recursiveFibonacci(10)
   recFib3 = recursiveFibonacci(15)
   recFib4 = recursiveFibonacci(20)
   #calculate timne
   recFibTime = time.clock() - recFibStart
   #print fibinacci
   print "\n\nFibonacci using algorithm 7 from chapter 5:\n"
   print "Fibonacci of 5 = \t", recFib1
   print "Fibonacci of 10 = \t", recFib2
   print "Fibonacci of 15 = \t", recFib3
   print "Fibonacci of 20 = \t", recFib4
   #print time it took
   print "Recursive Fibonacci method time: \t", recFibTime
   return float(recFibTime)

def timeCompare(it, rec):
   if it < rec:
      print "The iterative method is about", rec/it, "times faster than the recursive method"
   else:
      print "The recursive method is about", it/rec, "times faster than the iterative method"

itMod = timeIterativeMod()
recMod = timeRecursiveMod()
itFib = timeIterativeFib()
recFib = timeRecursiveFib()

print "\n\n\nModular Exponentation method comparison:\n"
timeCompare(itMod, recMod)
print "\n\nFibinocci method comparison:\n"
timeCompare(itFib, recFib)