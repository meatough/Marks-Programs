'''
*********************************************************** 
 * Discrete Structures
 * Bayes Theorem Program
 * Programmer: Mark Eatough
 * Course: CSIS 2430 
 * Created October 13, 2013
 ***********************************************************
'''

#Disease statistics
diseased=.01
diseasedNot = 1-diseased
truePositive =	.9
falsePositive = .15
falseNegative = 1-truePositive
trueNegative =	1-falsePositive
   
#stock vs economy statistics
g = .7
s = .3
uGIVENg = .8
dGIVENg = 1-uGIVENg
uGIVENs = .3
dGIVENs = 1-uGIVENs
   
def dependantProbability(probA, probBgivenA, probC, probDgivenC):
   return float((probA*probBgivenA)+(probC*probDgivenC))

#French student statistics
france = 2
uK = 3
canada = 4
b = 1
   
def pCountry(country):
   return float(country)/9
      
def pBoyCountry(boyCountry, country):
   return  float(boyCountry)/country
      
def bayesTheorem(probA, probB, probBgivenA):
   return (probA*probB)/probBgivenA
   
def percent(dec):
   dec *= 100
   print round(dec,2), "%"
   

#Probabliltiy that someone who tests positive for disease has disease
print "The probability that someone who test positive for the desease has the disease is: "
percent(bayesTheorem(diseased, truePositive, dependantProbability(diseased,truePositive,diseasedNot,falsePositive)))   
#probablility that economy goes up given stock goes up
print "\n\n\nThe probability that the economy goes up given that our stock goes up is: "
percent(bayesTheorem(uGIVENg, g, dependantProbability(uGIVENg, g, s, uGIVENs)))

#probablitity that student is from france given that he is a box
print "\n\n\nThe probability that a student is from france if we know he is a boy is: "
percent(bayesTheorem(pCountry(france), pBoyCountry(b, france), 
   pCountry(france)*pBoyCountry(b,france)+pCountry(uK)*pBoyCountry(b, uK)+pCountry(canada)*pBoyCountry(b, canada)))