# data segment
.data         
  iprompt:  	.asciiz "\n\n-- Please Enter 3 Integers --\n"
  n1prompt: 	.asciiz "\nInput First Number: "
  n2prompt: 	.asciiz "\nInput Second Number: "
  n3prompt: 	.asciiz "\nInput Third Number: "
  sum:  	.asciiz "\nSum = "
  min:  	.asciiz "\nMin = "
  max:  	.asciiz "\nMax = "
  continue:	.asciiz "\nWould you like to continue? (enter 0 to exit, anything else to run again): "
  eprompt:  	.asciiz "\n\nThank you for using the program, Press any key to exit..."

# text segment
.text
	.globl main   # global label - where the program begins
	
# main program
main:
loop:
# display initial prompt
	li   $v0, 4         # load print_string code (pg. A-49)
	la   $a0, iprompt   # load string to print
	syscall             # print the string

# prompt for and input first integer
	li   $v0, 4         # load print_string code
  	la   $a0, n1prompt  # load string to print
  	syscall             # print the string

  	li   $v0, 5         # load read_int code
  	syscall             # read value from kb until 'Enter' key pressed
  	move $t1, $v0       # move value read to temp register

# prompt for and input second integer
  	li   $v0, 4         # load print_string code
  	la   $a0,n2prompt   # load string to print
  	syscall             # print the string

  	li   $v0, 5         # load read_int code
  	syscall             # read value from kb
  	move $t2, $v0       # move value to temp register
  	
# prompt for and input third integer
  	li   $v0, 4         # load print_string code
  	la   $a0,n3prompt   # load string to print
  	syscall             # print the string

  	li   $v0, 5         # load read_int code
  	syscall             # read value from kb
  	move $t3, $v0       # move value to temp register
  	
# Calculate the sum
  	add  $t4, $t1, $t2  # n1 + n2
  	add  $t4, $t4, $t3  #n3 + above sum
  	
# find the min			
	slt $t7, $t1, $t2	#check if first number is less than second, if it is set t7 to 0, otherwise to 1
	beq $t7, 1, else1	#check if value of t7 is 1	
		add $t5, $zero, $t2	#set t5 to t2 if t2 < t1
	j exit1				#skip past next line of code if above code executes
  	else1:	add $t5, $zero, $t1	#set t5 to t1 if t1 < t2
  	
  	exit1:			#jump to this point if necessary
  	slt $t7, $t5, $t3	#check if third number is less than smaller of first two numbers, if it is set t7 to 0, otherwise to 1
  	beq $t7, 1, else2	#check if value of t7 is 1
  	add $t5, $zero, $t3	#set t5 to t3 if t3 is smallest of all numbers
  	else2:			#skip above code if t3 is not the smallest integer
  	
#find the max			
	sgt $t7, $t1, $t2	#check if first number is less than second, if it is set t7 to 0, otherwise to 1
	beq $t7, 1, else3	#check if value of t7 is 1	
		add $t6, $zero, $t2	#set t5 to t2 if t2 > t1
	j exit2				#skip past next line of code if above code executes
  	else3:	add $t6, $zero, $t1	#set t5 to t1 if t1 > t2
  	
  	exit2:				#jump to this point if necessary
  	sgt $t7, $t6, $t3		#check if third number is greater than larger of first two numbers, if it is set t7 to 0, otherwise to 1
  	beq $t7, 1, else4	#check if value of t7 is 1
  	add $t6, $zero, $t3	#set t5 to t3 if t3 is largest of all numbers
  	else4:			#skip above code if t3 is not the largerst integer

# output the prompt and the sum
 	li   $v0, 4         # load print_string code
  	la   $a0, sum   # load string to print
  	syscall             # print the string

  	li   $v0, 1         # load print_int code
  	move $a0,$t4        # load value to print - $t4 contains sum
  	syscall             # print the value
  	
# output the prompt and the min
 	li   $v0, 4         # load print_string code
  	la   $a0, min       # load string to print
  	syscall             # print the string

  	li   $v0, 1         # load print_int code
  	move $a0,$t5        # load value to print - $t5 contains min
  	syscall             # print the value
  	
# output the prompt and the max
 	li   $v0, 4         # load print_string code
  	la   $a0, max       # load string to print
  	syscall             # print the string

  	li   $v0, 1         # load print_int code
  	move $a0,$t6        # load value to print - $t6 contains max
  	syscall             # print the value
  	
#check to see if user wants to continue or exit
	li   $v0, 4         # load print_string code
  	la   $a0, continue  # load string to print
  	syscall             # print the string

  	li   $v0, 5         # load read_int code
  	syscall             # read value from kb until 'Enter' key pressed
  	beq	$v0,$zero,exit # quit loop if integer == 0
j loop

exit:
# hold the screen
  	li   $v0, 4         # load print_string code
  	la   $a0, eprompt   # load end message
  	syscall             # print the string
  	li   $v0, 12        # load read_int code
  	syscall             # read from kb until 'Enter' key pressed

# exit to the operating system.
  	li   $v0, 10        # load exit code
  	syscall             # terminate program
