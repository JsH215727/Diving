import java.util.Scanner;

public class DivingScore {
	public static Scanner input = new Scanner(System.in);
	public static final int JUDGE_SIZE=7;
	public static void main(String[]args){
	
			float[]diverScores = new float[JUDGE_SIZE];
			float dDif=0.0f, score=0.0f;
			System.out.println( "DiverScoring" + "\t\t" + "Program");
			
			dDif= inputValidDegreeOfDifficulty();
			diverScores = inputAllScores();
			score = calculateScore(diverScores, dDif);
			
			System.out.printf("%-25s %-25s\n", "Degree of Difficulty", dDif);
			for( int i=0; i<JUDGE_SIZE; i++){
				System.out.printf("%-25s %-25sf\n","Judge#:"+(i+1),"Score:"+diverScores[i]);
			}
			System.out.printf("%-25s %-25s\n", "Overall Score", score);
			input.close();
	}
//Method to evaluate score input and store correct value
	public static float inputValidScore(){
			float value=11f;
			while (value<0 | value>10){
				System.out.println("Please enter a valid score between 0 and 10");
				value=input.nextFloat();
				if(value<0 | value>10)
					System.out.println("Invalid entry. Please try again.");
				else;
			}
			return value;
	}
//Method to store all of the judges scores in a single array
	public static float[] inputAllScores(){
		float[] value = new float [JUDGE_SIZE];
// i = count 		
		int i= 0;
		while(i < JUDGE_SIZE){
			value[i]=inputValidScore();
			i++;
		}
	return value;
	}
	
//Method that store degree of difficulty and ensure it is in bounds
	public static float inputValidDegreeOfDifficulty(){
		float dif=0.0f;
		while(dif<1.2 || dif>3.8){
			System.out.println("Please enter a valid degree of difficulty between 1.2 and 3.8 for diver");
			dif= input.nextFloat();
			if(dif<1.2 || dif>3.8)
				System.out.println("Invaild entry");
			else
				System.out.println("Thank you");
		}
		return dif;
	}
//Two Dimensional array to calculate the score 
// jScore = Judge Score dDif= Degree of difficulty 
	public static float calculateScore(float[] jScore, float dDif){
		float score = 0.0f;
		int maxSc= 0, minSc= 0;
//Loop for finding the max so i can exclude from sum
		for (int i=0; i<JUDGE_SIZE; i++){
			if(jScore[i]>jScore[maxSc])
				maxSc=i;
		}	
//Loop for finding the min so I can exclude from sum
		for (int i=0; i<JUDGE_SIZE; i++){
			 if(jScore[i]<jScore[minSc])
				minSc=i;
		}

		for(int i=0; i< JUDGE_SIZE; i++){
			score +=jScore[i];
		}
			score -=(minSc+maxSc);
			score *=dDif*0.6;
			return score;
	}	
}