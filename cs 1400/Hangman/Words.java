/***********************************************
create object of type animal, state, etc.
use arrays to store those types,
check to see that array is full, then say have tried all words of that type
keep track of words won and words lost
************************************************/

public class Words
{
	//variables to keep track of array sizes
	int numStates = 50;
	int creatures = 30;
	int school = 20;
	
	//animal array, and array to keep track of words played
	String [] animals = new String [creatures];
	String [] animalsPlayed = new String[creatures];
	//school array, and array to keep track of words played
	String [] schoolSubjects = new String [school];
	String [] schoolPlayed = new String [school];
	//capitals array, and array to keep track of words played
	String [] stateCapitals = new String [numStates];
	String [] capitalsPlayed = new String [numStates];
	//states array, and array to keep track of words played
	String [] usStates = new String[numStates];
	String [] statesPlayed = new String[numStates];
	//nations array, and array to keep track of words played
	String [] nations = new String [numStates];
	String [] nationsPlayed = new String [numStates];
	//all array, and array to keep track of words played
	String [] all = new String[creatures + school + (numStates*3)];
	int [] allPlayed = new int[creatures + school + (numStates*3)];
	
	//method to populate animal array
	public void populateAnimalsArray()
	{
		animals[0] = "elephant";
		animals[1] = "giraffe";
		animals[2] = "gorilla";
		animals[3] = "oragutan";
		animals[4] = "lemur";
		animals[5] = "siberian tiger";
		animals[6] = "polar bear";
		animals[7] = "zebra";
		animals[8] = "buffalo";
		animals[9] = "panther";
		animals[10] = "king cobra";
		animals[11] = "alligator";
		animals[12] = "crocodile";
		animals[13] = "sea lion";
		animals[14] = "komodo dragon";
		animals[15] = "turtle";
		animals[16] = "leopord";
		animals[17] = "jaguar";
		animals[18] = "butterfly";
		animals[19] = "river otter";
		animals[20] = "hippopotamus";
		animals[21] = "rhinoceros";
		animals[22] = "orangutan";
		animals[23] = "chimpanzee";
		animals[24] = "porcupine";
		animals[25] = "armadillo";
		animals[26] = "ostrich";
		animals[27] = "flamingo";
		animals[28] = "woodpecker";
		animals[29] = "salamander";
	}
	
	//method to populate school array
	public void populateSchoolArray()
	{
		schoolSubjects[0] = "mathematics";
		schoolSubjects[1] = "chemistry";
		schoolSubjects[2] = "physics";
		schoolSubjects[3] = "biology";
		schoolSubjects[4] = "algebra";
		schoolSubjects[5] = "geometry";
		schoolSubjects[6] = "calculus";
		schoolSubjects[7] = "differential equations";
		schoolSubjects[8] = "literature";
		schoolSubjects[9] = "linguistics";
		schoolSubjects[10] = "political science";
		schoolSubjects[11] = "humanities";
		schoolSubjects[12] = "culinary arts";
		schoolSubjects[13] = "arcitecture";
		schoolSubjects[14] = "history";
		schoolSubjects[15] = "physical education";
		schoolSubjects[16] = "econimics";
		schoolSubjects[17] = "psycology";
		schoolSubjects[18] = "sociology";
		schoolSubjects[19] = "astronomy";
	}
	
	//method to populate capitals array
	public void populateCapitalsArray()
	{
		stateCapitals[0] = "montgomery";
		stateCapitals[1] = "juneau";
		stateCapitals[2] = "phoenix";
		stateCapitals[3] = "little rock";
		stateCapitals[4] = "sacramento";
		stateCapitals[5] = "denver";
		stateCapitals[6] = "hartford";
		stateCapitals[7] = "dover";
		stateCapitals[8] = "tallahassee";
		stateCapitals[9] = "atlanta";
		stateCapitals[10] = "honolulu";
		stateCapitals[11] = "boise";
		stateCapitals[12] = "springfield";
		stateCapitals[13] = "indianapolis";
		stateCapitals[14] = "des moines";
		stateCapitals[15] = "topeka";
		stateCapitals[16] = "frankfort";
		stateCapitals[17] = "baton rouge";
		stateCapitals[18] = "augusta";
		stateCapitals[19] = "annapolis";
		stateCapitals[20] = "boston";
		stateCapitals[21] = "lansing";
		stateCapitals[22] = "saint paul";
		stateCapitals[23] = "jackson";
		stateCapitals[24] = "jefferson city";
		stateCapitals[25] = "helena";
		stateCapitals[26] = "lincoln";
		stateCapitals[27] = "carson city";
		stateCapitals[28] = "concord";
		stateCapitals[29] = "trenton";
		stateCapitals[30] = "santa fe";
		stateCapitals[31] = "albany";
		stateCapitals[32] = "raliegh";
		stateCapitals[33] = "bismarck";
		stateCapitals[34] = "columbus";
		stateCapitals[35] = "oklahoma city";
		stateCapitals[36] = "salem";
		stateCapitals[37] = "harrisburg";
		stateCapitals[38] = "providence";
		stateCapitals[39] = "columbia";
		stateCapitals[40] = "pierre";
		stateCapitals[41] = "nashville";
		stateCapitals[42] = "austin";
		stateCapitals[43] = "salt lake city";
		stateCapitals[44] = "montpelier";
		stateCapitals[45] = "richmond";
		stateCapitals[46] = "olympia";
		stateCapitals[47] = "charleston";
		stateCapitals[48] = "madison";
		stateCapitals[49] = "cheyenne";
	}
	
	//method to populate states array
	public void populateStatesArray()
	{
		usStates[0] = "oregon";
		usStates[1] = "washington";
		usStates[2] = "california";
		usStates[3] = "arizona";
		usStates[4] = "utah";
		usStates[5] = "new mexico";
		usStates[6] = "idaho";
		usStates[7] = "montana";
		usStates[8] = "wyoming";
		usStates[9] = "nevada";
		usStates[10] = "colorado";
		usStates[11] = "north dakota";
		usStates[12] = "south dakota";
		usStates[13] = "nebraska";
		usStates[14] = "kansas";
		usStates[15] = "oklahoma";
		usStates[16] = "texas";
		usStates[17] = "louisiana";
		usStates[18] = "mississippi";
		usStates[19] = "arkansas";
		usStates[20] = "missouri";
		usStates[21] = "iowa";
		usStates[22] = "minnesota";
		usStates[23] = "wisconsin";
		usStates[24] = "illinois";
		usStates[25] = "michigan";
		usStates[26] = "indiana";
		usStates[27] = "ohio";
		usStates[28] = "kentucky";
		usStates[29] = "tennessee";
		usStates[30] = "alabama";
		usStates[31] = "florida";
		usStates[32] = "georgia";
		usStates[33] = "south carolina";
		usStates[34] = "north carolina";
		usStates[35] = "virginia";
		usStates[36] = "west virginia";
		usStates[37] = "maryland";
		usStates[38] = "deleware";
		usStates[39] = "new jersey";
		usStates[40] = "connecticut";
		usStates[41] = "pennsylvania";
		usStates[42] = "new york";
		usStates[43] = "vermont";
		usStates[44] = "massechusetts";
		usStates[45] = "new hampshire";
		usStates[46] = "maine";
		usStates[47] = "rhode island";
		usStates[48] = "hawaii";
		usStates[49] = "alaska";
	}
	
	//method to populate nations array
	public void populateNationsArray()
	{
		nations[0] = "united states";
		nations[1] = "canada";
		nations[2] = "mexico";
		nations[3] = "brazil";
		nations[4] = "great britian";
		nations[5] = "germany";
		nations[6] = "russia";
		nations[7] = "china";
		nations[8] = "australia";
		nations[9] = "new zealand";
		nations[10] = "argentina";
		nations[11] = "romainia";
		nations[12] = "nigeria";
		nations[13] = "egypt";
		nations[14] = "india";
		nations[15] = "saudi arabia";
		nations[16] = "thailand";
		nations[17] = "japan";
		nations[18] = "peru";
		nations[19] = "chile";
		nations[20] = "costa rica";
		nations[21] = "france";
		nations[22] = "spain";
		nations[23] = "italy";
		nations[24] = "portugal";
		nations[25] = "belgium";
		nations[26] = "norway";
		nations[27] = "switzerland";
		nations[28] = "sweden";
		nations[29] = "finland";
		nations[30] = "denmark";
		nations[31] = "ukraine";
		nations[32] = "hungary";
		nations[33] = "turkey";
		nations[34] = "indonesia";
		nations[35] = "uraguay";
		nations[36] = "paraguay";
		nations[37] = "afghanistan";
		nations[38] = "czech republic";
		nations[39] = "austria";
		nations[40] = "cambodia";
		nations[41] = "ghana";
		nations[42] = "greece";
		nations[43] = "israel";
		nations[44] = "jamaica";
		nations[45] = "kuwait";
		nations[46] = "papua new ginea";
		nations[47] = "sri lanka";
		nations[48] = "zimbabwe";
		nations[49] = "ireland";
	}
	
	//method to populate all array
	public void populateAllArray()
	{
		int i;
		//add animals to all array
		for(i = 0; i < animals.length; i++)
		{
			all[i] = animals[i];
		}
		//add school subjecst to all array
		for(int j = 0; j < schoolSubjects.length; j++)
		{
			all[i] = schoolSubjects[j];
			i++;
		}
		//add state capitals to all array
		for(int k = 0; k < stateCapitals.length; k++)
		{
			all[i] = stateCapitals[k];
			i++;
		}
		//add states to all array
		for(int l = 0; l < usStates.length; l++)
		{
			all[i] = usStates[l];
			i++;
		}
		//add nations to all array
		for(int m = 0; m < nations.length; m++)
		{
			all[i] = nations[m];
			i++;
		}
	}//end populate all array method
	
	public void populateAllPlayedArray()
	{
		for(int i = 0; i < allPlayed.length; i++)
		{
			allPlayed[i] = -1;
		}
	}
	
	public boolean contains(String [] arr, String w)
	{
		boolean contain = false;
		
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] == w)
			{
				contain = true;
			}
		}
		return contain;
	}//end contains method
	
}//end words class