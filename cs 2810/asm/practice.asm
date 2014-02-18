# data segment
.data         
  iprompt:  	.asciiz "-- Enter any integer --\n"
  nprompt: 	.asciiz "\nInput number "
  equal:	.asciiz "\nYour number is equal to 100"
  greater:	.asciiz "\nYour number is greater than 100"
  less:		.asciiz "\nYour number is less than 100"
  notEqual:	.asciiz "\nYour number is NOT equal to 100"
  eprompt:  	.asciiz "\n\nPress any key to exit..."

# text segment
.text
	.globl main   # global label - where the program begins
	
# main program
main:
#store our check value
	move $s0, $zero
	addi $s0, $s0, 100
	move $t1, $s0	    #store the value we are checking against which is 100

# display initial prompt
	li   $v0, 4         # load print_string code (pg. A-49)
	la   $a0, iprompt   # load string to print
	syscall             # print the string

# prompt for number
	li   $v0, 4         # load print_string code
  	la   $a0, nprompt   # load string to print
  	syscall             # print the string

  	li   $v0, 5         # load read_int code
  	syscall             # read value from kb until 'Enter' key pressed
  	move $t2, $v0       # move value read to temp register
	
#check to see of numbers are equal
	beq $t1, $t2,else1	#check to see if entered number is equal to 100	
	
		slt $t3, $t2, $t1	#check if entered number is less than 100, if it is set t3 to 0, otherwise to 1
	
			beq $t3, 1, else2	#check if value of t3 is 1
	
			li   $v0, 4         # load print_string code
  			la   $a0, greater   # load greater message
  			syscall             # print the string	
  	
  		j exit
  	
  			else2:		    #if t3 is equal to 1 we jump to here.
  				li   $v0, 4         # load print_string code
  				la   $a0, less      # load less message
  				syscall             # print the string	
  	
  		j exit
  	
  		else1:		   #if number is equal to 100 we jump to here.
  			li   $v0, 4         # load print_string code
  			la   $a0, equal   # load equal message
  			syscall             # print the string	
	
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
