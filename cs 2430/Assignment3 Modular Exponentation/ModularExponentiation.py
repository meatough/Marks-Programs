'''
**************************************************************** 
 * Discrete Structures
 * Modular Exponentiation Program
 * Programmer: Mark Eatough
 * Course: CSIS 2430 
 * Created September 15, 2013

 *This program finds the modulus of a number raised to a 
 *large power given the number, the exponent, and the modulus
 *The algorithm 1 method converts the exponent to a binary number
 *and the algorithm 5 method calls the algorithm one method, and
 *then uses that to find the modulus of our very large number.
 *****************************************************************
'''
#algorithm 1 out of book, used to find binary representation of my exponents
def convertToBinary(n,b):
   q = n
   binary = ""
   while(q > 0):
      a = q%b
      q = q/b
      binary = str(a) + binary
   return binary

#algorithm 5 out of book, used to find modulus of very large numbers
def iterativeModularExponentation(n, b, m):
   x = 1
   binary = convertToBinary(b, 2)
   i = len(binary)-1
   if(binary[i] == '1'):
      x = x*n
      x = x% m
   while (i > 0):
      n*=n
      n = n % m
      if(binary[i-1] == '1'):
         x*=n
         x = x % m
      i-=1
   return x

#print out my modulus
print "\n\nModulus using algorithm 5:\n"
print "7^644 mod 645 = \t", iterativeModularExponentation(7,644, 645)
print "11^644 mod 645 = \t", iterativeModularExponentation(11,644, 645)
print "3^2003 mod 645 = \t", iterativeModularExponentation(3,2003, 99)
print "123^1001 mod 645 = \t", iterativeModularExponentation(123,1001, 101)