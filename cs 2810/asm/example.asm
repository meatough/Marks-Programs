# data segment
.data         
  eprompt:  	.asciiz "\n\nPress any key to exit..."

# text segment
.text
	.globl main   # global label - where the program begins
	
# main program
main:
#store our values
	addi $a0, $zero, 6	#store the first value
	addi $a1, $zero, 5	#store the second value
	addi $a2, $zero, 4	#store the third value
	addi $a3, $zero, 3	#store the fourth value

jal leaf_example

#print the answer here

  	move $a0,$v0        # load value to print - $v6 contains answer
  	li   $v0, 1         # load print_int code
  	syscall             # print the value
  	
#now exit the program
	j exit

leaf_example:
#move some values around... A little fuzzy on what we are accomplishing here....
	addi $sp, $sp, -12	#adjust stack to make room for 3 more items
	sw $t1, 8($sp)		#save register t1 for use afterwords
	sw $t0, 4($sp)		#save register t0 for use afterwords
	sw $s0, 0($sp)		#save register s0 for use afterwords
	
#now we do some simple arithmatic
	add $t0, $a0, $a1   #add the first two values together (g+h)
	add $t1, $a2, $a3   #add the last two values together (i+j)
	sub $s0, $t0, $t1   #Subtract the sum of the last two from the sum of the first two  (g+h)-(i+j)
	
#to return the answer, we copy it to the return value register
	add $v0, $s0, $zero	#returns answer($v0 = $s0 + 0)
	
#before returning we restore the theree old vaalues of the registers we saved by popping them from the stack
	lw $s0, 0($sp)		#restore register $s0 for caller
	lw $t0, 4($sp)		#restore register $s0 for caller
	lw $t1, 8($sp)		#restore register $s0 for caller
	addi $sp, $sp, 12	#adjust stack to make room for 3 more items
	
#jump back to the calling routine
	jr $ra
	
exit:
# hold the screen
  	li   $v0, 4         # load print_string code
  	la   $a0, eprompt   # load end message
  	syscall             # print the string

# exit to the operating system.
  	li   $v0, 10        # load exit code
  	syscall             # terminate program
