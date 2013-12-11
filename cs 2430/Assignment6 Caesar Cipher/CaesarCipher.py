'''
*********************************************************** 
 * Discrete Structures
 * Caesar Cipher Program
 * Programmer: Mark Eatough
 * Course: CSIS 2430 
 * Created October 6, 2013

 *This program takes user input for an offset, and user
 *input for a phrase, and then changes each letter in 
 *the phrase to as many letters in the alphabet as is
 *necessary.  The output is the Caesar Ciphered phrase 
 ***********************************************************
'''

#Create list of characters
characters = []
#populate list of characters
a = ord('a')
z = ord('z')
for letter in range(a, z+1):
   characters.append(chr(letter))
#method to convert the characters into their associated values
#ie a = 0, b = 1 etc.
def charToIntVal(c):
   for i in range(len(characters)):
      if(c.lower() == characters[i]):
         index = i
         return index   
   return c
#method that parses out the string, converts the letters to numbers,
#increments those numbers by the given offset, and then returns the
#corresponding letter
def caesarCipher(multiplier, offset, phrase):
   tempString = ""
   for i in range(len(phrase)):
      if(isinstance(charToIntVal(phrase[i]), (int))):
         tempInt = offset + charToIntVal(phrase[i])*multiplier
         tempString += characters[tempInt%26]
      else:
         tempString += charToIntVal(phrase[i])
   return tempString

#prompt user to enter muliplier
multiplier = input("Please enter your multiplier: ")
#prompt user to enter offset
offset = input("Please enter your offset: ")
#prompt user to enter phrase
phrase = raw_input("Please enter your phrase you would like to be caesar ciphered:\n")

#print out users original phrase
print "\n\n\nYour original phrase is: \n\n", phrase
#print out users phrase after going through the cipher
print "\n\n\nYour caesar ciphered phrase is: \n\n", caesarCipher(multiplier, offset, phrase)