'''
*********************************************************** 
 * Discrete Structures
 * Huffman Coding Program
 * Programmer: Mark Eatough
 * Course: CSIS 2430 
 * Created Novermber 10, 2013

 *This program implements Huffman Coding, first we generate 
 *file with 4000 Characters using Ipsum Lorum. We convert the
 *file to binary and measure the size. Then, implement 
 *Huffman Coding to compress the file and then measure again. 
 *What is the delta shrinkage from the first file to the second. 
 *Now, use the frequencies found on page 771 #27 and reimplement. 
 *Measure again. Compare/contrast.
 ***********************************************************
'''
import os 

#Ipsum Lorum generated using http://www.procato.com/lipsum/
#spaces removed and text shortened to 4000 characters using 
#wordpad

#import ipusm lorm as read only 
f = open('ipsumLorum.txt', 'r') 
#assign file to variable
ipsumLorum = f.read()
#create dictionary to store letters with frequencies
frequencies = {}
#create dictionary to store letters with constant binary lengths
constant = {}
#create dictionary to store letters with book defined frequencies
book = {}
#print out ipsum lorum text
print ipsumLorum
#variables to keep track of first and last letter of alphabet
a = ord('a')
z = ord('z')
#method to increment the binary string
def incrementBinaryString(s):
   return '{:05b}'.format(1 + int(s, 2))
#method to convert frequencies to binary strings
def dictFunction(dictionary):
   #print dictionary
   myStack = []
   while(len(dictionary) > 2):
      lowValue=1
      lowKey="*"
      lowestValue = lowValue
      lowestKey = lowKey
      for key, value in dictionary.iteritems():
         if(value < lowValue):
            lowValue=value
            lowKey=key
         if(lowValue < lowestValue):
            tempValue=lowestValue
            tempKey=lowestKey
            lowestValue=lowValue
            lowestKey=lowKey
            lowValue=tempValue
            lowKey=tempKey
      newValue = lowestValue+lowValue
      newKey = lowestKey+lowKey
      myStack.append(lowKey)
      dictionary[newKey] = newValue
      del dictionary[lowKey]
      del dictionary[lowestKey]
   for key in dictionary.iterkeys():
      if(key == newKey):
         dictionary[key]="1"
      else:
         dictionary[key]="0"
   while(len(myStack)>0):
      removedKey = myStack.pop()
      for key, value in dictionary.iteritems():
         if(removedKey[0] in key): 
            tempKey = key.split(removedKey)
            dictionary[tempKey[0]]=value+"0"
            dictionary[removedKey]=value+"1"
            del dictionary[key]
            break
   print "\n\n\n", dictionary
#add all letters, and their occurances to a dictionary
#dictionary based on frequency
for character in range(a, z+1):
   i = 0
   for l in range(len(ipsumLorum)):
      if(chr(character) == ipsumLorum[l]):
         i+=1
   frequencies[chr(character)] = float(i)/float(4000)
#convert ipsum lorum to binary digits and output to file
def toBinary(dictionary, s):
   bin = ""
   for letter in ipsumLorum:
      for key, value in dictionary.iteritems():
         if(letter == key):
            bin+=value
            break
   g=open(s, "a")
   g.write(bin)
   g.close()

#add all letters, and constant binary strings to a dictionary
#dictionary based on frequency
x = '00000' 
for character in range(a,z+1):
   constant[chr(character)] = x
   x = incrementBinaryString(x)    
#constant = sorted([(value,key) for (key,value) in constant.items()], reverse=True)
print "\n\n\nConstants:\n\n\n", constant

def deltaShrinkage(c, b, f):
   d1 = c-b
   s1 = float(d1)/float(c)
   print "\nThe delta shrinkage from the constant binary numbers to the book binary number is: %0.2f"%(s1*100), "%"
   d2 = c-f
   s2 = float(d2)/float(c)
   print "\nThe delta shrinkage from the constant binary numbers to the frequency binary number is: %0.2f"%(s2*100), "%"
   d3 = b-f
   s3 = float(d3)/float(b)
   print "\nThe delta shrinkage from the book binary numbers to the frequency binary number is: %0.2f"%(s3*100), "%"
#add all letters and frequencies out of book
book['a'] = 0.0817
book['b'] = 0.0145
book['c'] = 0.0248
book['d'] = 0.0431
book['e'] = 0.1232
book['f'] = 0.0209
book['g'] = 0.0182
book['h'] = 0.0668
book['i'] = 0.0689
book['j'] = 0.0010
book['k'] = 0.0080
book['l'] = 0.0397
book['m'] = 0.0277
book['n'] = 0.0662
book['o'] = 0.0781
book['p'] = 0.0156
book['q'] = 0.0009
book['r'] = 0.0572
book['s'] = 0.0628
book['t'] = 0.0905
book['u'] = 0.0304
book['v'] = 0.0102
book['w'] = 0.0264
book['x'] = 0.0015
book['y'] = 0.0211
book['z'] = 0.0005

#book = sorted([(value,key) for (key,value) in book.items()], reverse=True)
#print "\n\n\n", book
print "\n\n\nFrequencies:"
dictFunction(frequencies)
print "\n\n\nBook:"
dictFunction(book)
toBinary(constant, "constant.txt")
toBinary(frequencies, "frequencies.txt")
toBinary(book, "book.txt")

constantSize =  os.path.getsize("constant.txt")
bookSize =  os.path.getsize("book.txt")
frequenciesSize =  os.path.getsize("frequencies.txt")

print "\n\n\nSize of text file with constant binary lengths", constantSize
print "\n\n\nSize of text file with book frequencies", bookSize
print "\n\n\nSize of text file with calculated frequencies", frequenciesSize
print"\n\n"

deltaShrinkage(constantSize, bookSize, frequenciesSize)