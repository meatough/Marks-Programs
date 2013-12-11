'''
*********************************************************** 
 * Discrete Structures
 * 8 Queens Program
 * Programmer: Mark Eatough
 * Course: CSIS 2430 
 * Created Novermber 4, 2013
 
 *This program solves the 8 queens problem, which is the 
 *problem of placing 8 queens on a chess board so that none
 *none of them attack eachother.
 ***********************************************************
'''
from random import randint
import os
import time
#my s number ends in an odd number, so I will implement the 8 queens 
class ChessCoord:
   def __init__(self, row, col):
      self.row = row
      self.col = col

queenStack = []
matrix = [[0 for x in xrange(8)] for x in xrange(8)] 

#method to track horizontal attacks of queens
def verticleAttack(m,n):
   for i in range(m+1,len(matrix)):
      if(matrix[i][n] != 1):
         matrix[i][n] += 1
   for j in range(0,m):
      if(matrix[j][n] != 1):
         matrix[j][n] += 1
#method to track horizontal attacks of queens
def horizontalAttack(m,n):
   for i in range(n+1,len(matrix)):
      if(matrix[m][i] != 1):
         matrix[m][i] += 1
   for j in range(0,n):
      if(matrix[m][j] != 1):
         matrix[m][j] += 1
#method to track left diagonal attacks of queens
def leftDiagonal(m,n):
   #check diagonal starting from origin to bottom right corner
   i = m+1
   j = n+1
   while(i<len(matrix) and j<len(matrix)):
      if(matrix[i][j]!=1):
         matrix[i][j]+=1
      i+=1
      j+=1
   #check diagonal starting from origin to top left corner
   k = m-1
   l = n-1
   while(k>=0 and l>=0):
      if(matrix[k][l]!=1):
         matrix[k][l]+=1
      k-=1
      l-=1
#method to track right diagonal attacks of queens
def rightDiagonal(m,n):
   #check diagonal starting from origin to bottom left corner
   i = m-1
   j = n+1
   while(i>=0 and j<len(matrix)):
      if(matrix[i][j]!=1):
         matrix[i][j]+=1
      i-=1
      j+=1
   #check diagonal starting from origin to top right corner   
   k = m+1
   l = n-1
   while(k<len(matrix) and l>=0):
      if(matrix[k][l]!=1):
         matrix[k][l]+=1
      k+=1
      l-=1  
#calls all directional attacks
def attackRange(m,n):
   horizontalAttack(m,n)
   verticleAttack(m,n)   
   rightDiagonal(m,n)
   leftDiagonal(m,n)
#method to make the mid portion of individual chess square
def makeMidChessSquare(n):
   if(n < 2):
      middle = "|   |"
   else:
      middle = "| Q |"
   return middle
#method to make the bottom portion of individual chess square   
def makeBotChessSquare(n):
   if(n == 0 or n == 2):
      bottom = "|___|"
   else:
      bottom = "|_A_|"
   return bottom
#method to display entire chess board
def displayChessBoard(twoD):
   os.system('cls')
   print "Queen noted with a Q"
   print "Attack range noted with an A"
   print "Number of Queens:\t", len(queenStack), "\n\n\n"
   tab = " "
   num = 8
   a=ord('a')
   h=ord('h')
   columns = tab
   for letter in range(a, h+1):
      columns+="  "+chr(letter)+"  "
   top = " ___ "
   middle = "|   |"
   bottom = "|___|" 
   print columns 
   for i in range(8):
      num = 8-i
      middle = tab + makeMidChessSquare(twoD[i][0])
      gTop = tab + top
      gBottom = str(num) + makeBotChessSquare(twoD[i][0]) 
      for j in range(1,8): 
         gTop+=top
         middle+= makeMidChessSquare(twoD[i][j])
         gBottom+=makeBotChessSquare(twoD[i][j])      
      print gTop
      print middle
      print gBottom+str(num)
   print columns
#method to add a queen
def addQueen(m,n):
   matrix[m][n]+=2
   attackRange(m,n)
   queenStack.append(ChessCoord(m,n))   
#method to remove a queen
def removeQueen():
   rq = queenStack.pop()
   for i in range(len(matrix)):
      for j in range(len(matrix)):
         matrix[i][j] = 0
   for k in range(len(queenStack)):
      tempQueen = queenStack[k]
      matrix[tempQueen.row][tempQueen.col] += 2
      attackRange(tempQueen.row,tempQueen.col)
   displayChessBoard(matrix)
   print "Queen removed"
   time.sleep(.5)
   replaceQueen(rq)

#method to replace removed queen
def replaceQueen(rq):
   myCol = rq.col+1
   myRow = rq.row
   while(myCol < 8):
      if(matrix[myRow][myCol]==0):
         addQueen(myRow, myCol)
         displayChessBoard(matrix)
         print "Queen replaced in different column in same row"
         time.sleep(.5)
         return
      myCol+=1
   print "No more valid spaced for queens, call remove queen method again"
   time.sleep(.5)
   removeQueen()
#method to check if a row has a problem
def checkProblemRows():
   for i in range(len(matrix)):
      for j in range(len(matrix)):
         k = matrix[i][j]
         if(k==0 or k==2):
            break
      if(k!=0 and k!=2):
         return i
   return -1
#randomly select a position for first queen
def firstQueen():
   m = randint(0,7)
   n = randint(0,7)
   addQueen(m,n)
   displayChessBoard(matrix)
#method to place the next queen
def placeNext():
   for i in range(len(matrix)):
      for j in range(len(matrix)):
         if(matrix[i][j] == 0):
            addQueen(i,j)
            displayChessBoard(matrix)
            print "added by placeNext method"
            time.sleep(.5)  
            return
#use algorithm to select position for queens without any attacking eachother
def placeQueens():
   while(len(queenStack) < 8):    
      placeNext()  
      while(checkProblemRows()>-1):
         removeQueen()
   print "8 queens problem solved, above is a solution"
displayChessBoard(matrix)   
firstQueen()
placeQueens()