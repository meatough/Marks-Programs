# data segment
.data 
  iprompt:  	.asciiz "\n\n-- You will have 5 chances to guess the correct number --\n"
  guess: 	.asciiz "\nPlease enter the number you would like to guess: "
  outguess:	.asciiz "\nYou guessed: "	
  equal:	.asciiz "\nYour guessed the number!!! Congratulations you win!!!!"
  greater:	.asciiz "\nYour guess is too high"
  less:		.asciiz "\nYour guess is too low"
  loose:	.asciiz "\nSorry, you've had your 5 guesses, you loose. "
  correct:	.asciiz "\nThe correct number was: "
  eprompt:  	.asciiz "\n\nThank you for playing, Goodbye."   
  here:	.asciiz "\ndo i get here? "     

# text segment
.text
	.globl main   # global label - where the program begins
	
# main program
main:
#set the variable that keeps track if number as right or wrong to 0
	move $t0, $zero
#set our counter initially to zero
	move $t1, $zero	    #set counter to zero initially
#set our number to guess, this will not change throughout program
	addi $t2, $zero, 37	#number user needs to try to guess
#print begining message
	li   $v0, 4         # load print_string code
  	la   $a0, iprompt   # load start message
  	syscall             # print the string
  	
# prompt for number
	li   $v0, 4         # load print_string code
  	la   $a0, guess	    # load string to print
  	syscall             # print the string

  	li   $v0, 5         # load read_int code
  	syscall             # read value from kb until 'Enter' key pressed
  	move $t3, $v0       # move value read to temp register

jal guess_number
#check to see if exit condition is reached
	beq	$t0,1,exit	#exit program if answer was correct, meaning $t0 will equal 1
  	beq	$t1,5,exit 	# exit program if counter == 5, and print loose message
# prompt for number
	li   $v0, 4         # load print_string code
  	la   $a0, guess	    # load string to print
  	syscall             # print the string

  	li   $v0, 5         # load read_int code
  	syscall             # read value from kb until 'Enter' key pressed
  	move $t3, $v0       # move value read to temp register

guess_number:
# Output the guess
	li   $v0, 4         # load print_string code
  	la   $a0, outguess   # load string to print
  	syscall             # print the string 
  	
  	li   $v0, 1         # load print_int code
  	move $a0,$t3        # load value to print - $t3 is current guess
  	syscall             # print the value
  	
#check to see of numbers are equal
	beq $t2, $t3,else1	#check to see if entered number is equal to number to guess
	
		slt $t4, $t3, $t2	#check if entered number is less than 100, if it is set t3 to 0, otherwise to 1
	
			beq $t4, 1, else2	#check if value of t3 is 1
	
			li   $v0, 4         # load print_string code
  			la   $a0, greater   # load greater message
  			syscall             # print the string	
  	
  		j next
  	
  			else2:		    #if t3 is equal to 1 we jump to here.
  				li   $v0, 4         # load print_string code
  				la   $a0, less      # load less message
  				syscall             # print the string	
  	
  		next:
  			addi $t1, $t1, 1
  			beq	$t1,5,lost 	# exit program if counter == 5, and print loose message
  			
  			jr $ra
  			
  			lost:
  			# hold the screen
  				li   $v0, 4         # load print_string code
  				la   $a0, loose   # load loose message
  				syscall             # print the string	
  	
			# Output the correct number
				li   $v0, 4         # load print_string code
  				la   $a0, correct   # load string to print
  				syscall             # print the string 
  	
  				li   $v0, 1         # load print_int code
  				move $a0,$t2        # load value to print - $t2 correct number
  				syscall             # print the value 
  		jr $ra
  	
  		else1:		   #if number is equal to 100 we jump to here.
  			li   $v0, 4         # load print_string code
  			la   $a0, equal   # load equal message
  			syscall             # print the string	
  			addi $t0, $t0, 1
  		jr $ra	
exit:
# hold the screen
  	li   $v0, 4         # load print_string code
  	la   $a0, eprompt   # load end message
  	syscall             # print the string

# exit to the operating system.
  	li   $v0, 10        # load exit code
  	syscall             # terminate program