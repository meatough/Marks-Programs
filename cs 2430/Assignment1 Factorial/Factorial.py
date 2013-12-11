'''
*********************************************************** 
 * Discrete Structures
 * Factorial Program
 * Programmer: Mark Eatough
 * Course: CSIS 2430 
 * Created August 25, 2013
 
 *This program Prompts the user to enter an integer, and
 *then outputs the factorial of that integer.  The program
 *will continuously promt the user and output the factorial
 *until a negative number is entered
 ***********************************************************
'''

#condition tested for exiting loop
exit = False
#tell the user what the program will do
print "This program finds the factorial of integer you will enter\n\n"

#Beginning of what is effectively a do while loop
while exit == False:
   #prompt user to enter a number
   num =  input("Please enter a positive integer(enter negative number to exit program): ")
   #check to see of number is negative
   if num < 0:
      #change exit variable to true if number is negative
      exit = True
      print "\n\n\nGoodbye"
   #if number is positive find factorial
   else:
      #factorial function
      def factorial(n):
         temp = n-1
         while temp > 0:
            n *= temp
            temp-=1 
         return n
        #end factorial function
      #print statement to output user number and factorial of that number
      print "\nThe factorial of ", num, " is ", factorial(num), "\n\n"
#End of "do while" loop