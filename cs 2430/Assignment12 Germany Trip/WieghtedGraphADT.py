#maybe add a list of vertex's as well, so that I can index add, remove

#Vertex class
class Vertex:
    def __init__(self,key):
        self.id = key
        self.connectedTo = {}
        self.connectionList = []
   #add connection with weight to a vertex
    def addConnection(self,nbr,weight=0):
        self.connectedTo[nbr] = weight
        if nbr not in self.connectionList:
           self.connectionList.append(nbr)
   #toString method to return 
    def __str__(self):
        return self.id# + ' connectedTo: ' + str([x.id for x in self.connectedTo])
   #returns all connections
    def getConnections(self):
        return self.connectedTo.keys()
   #returns Id
    def getId(self):
        return self.id
   #return weight
    def getWeight(self,nbr):
        return self.connectedTo[nbr]   

#Wieghted Graph class
class WieghtedGraph:
    def __init__(self):
        self.vertList = {}
        self.numVertices = 0
   #add a new vertex to the graph
    def addVertex(self,key):
      if key not in self.vertList:
         self.numVertices = self.numVertices + 1
         newVertex = Vertex(key)
         self.vertList[key] = newVertex
         return newVertex
   #return vertex of graph
    def getVertex(self,n):
        if n in self.vertList:
            return self.vertList[n]
        else:
            return None
   #check to see if graph contains vertex
    def __contains__(self,n):
        return n in self.vertList
   #add a new edge to the graph
    def addEdge(self,f,t,cost=0):
        if f not in self.vertList:
            nv = self.addVertex(f)
        if t not in self.vertList:
            nv = self.addVertex(t)
        self.vertList[f].addConnection(self.vertList[t], cost)#1, cost2, cost3)
   #get vertices of graph
    def getVertices(self):
        return self.vertList.keys()
   
    def __iter__(self):
        return iter(self.vertList.values())
