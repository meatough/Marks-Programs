import java.util.Random;

public class SurveyEvaluationLab
{
	public static void main(String[] args)
	{
		Random rand = new Random();
		//questionaire has 7 questions
		int[][] questionaire = new int [5][7];
		for(int people = 0; people < 	questionaire.length; people++)
		{
			for(int answers = 0; answers < questionaire[people].length; answers ++)
			{
				questionaire[people][answers] = 1 + rand.nextInt(9);
				double minimumF = 9;
				double minimumT = 0;
		
			for (int i = 1; i< questionaire[people][answers].length; i++)
			{
				if (questionaire[people][answers][i] < questionaire[people][answers][i -1])
				minimumT = questionaire[people][answers][i];
				else
				minimumT = questionaire[people][answers][i-1];
			
				if (minimumF < minimumT)
					minimumT = minimumF;
				else
					minimumF = minimumT;
			}
	
	
			double maximumT = 0;
			double maximumF = 0;
		
			for (int i = 1; i< questionaire[people][answers]; i++)
			{
				if (questionaire[people][answers][i] > questionaire[people][answers][i -1])
				maximumT = questionaire[people][answers][i];
				else
				maximumT = questionaire[people][answers][i-1];
			
				if (maximumF > maximumT)
					maximumT = maximumF;
				else
					maximumF = maximumT;
			}

			
				
			}
		}
		
		for(int people = 0; people < 	questionaire.length; people++)
		{
			for(int answers = 0; answers < questionaire[people].length; answers ++)
			{
				System.out.printf("%d  ", questionaire[people][answers]);
				
			}
		}	
		double minimumF = 9;
		double minimumT = 0;
		
		for (int i = 1; i< questionaire[people][answers].length; i++)
		{
			if (questionaire[people][answers][i] < questionaire[people][answers][i -1])
			minimumT = questionaire[people][answers][i];
			else
			minimumT = questionaire[people][answers][i-1];
			
			if (minimumF < minimumT)
				minimumT = minimumF;
			else
				minimumF = minimumT;
		}
		return minimumF;
	
	
		double maximumT = 0;
		double maximumF = 0;
		
		for (int i = 1; i< questionaire[people][answers]; i++)
		{
			if (questionaire[people][answers][i] > questionaire[people][answers][i -1])
			maximumT = questionaire[people][answers][i];
			else
			maximumT = questionaire[people][answers][i-1];
			
			if (maximumF > maximumT)
				maximumT = maximumF;
			else
				maximumF = maximumT;
		}

		return maximumF;

			
			
		
		
		//each question has to be rated from 1 to 9(1 not at all, 9 very much)
		//each question has to be answered in order to complete the questionaire
		//5 people complete the questionaire
		//display the results, the hightest and the lowest value
	}
}