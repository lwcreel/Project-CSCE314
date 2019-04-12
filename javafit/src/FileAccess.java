import java.io.*;


// Write code to load the workouts from the provided workouts.csv file. The function should return a Workouts object.

public class FileAccess {
  
  public static Workouts loadWorkouts() {
    // What is a try/catch block and why do we need one?
    // What is an exception?
	 
	  Workouts retWorkouts = new Workouts();
	  
	  try {
		  
		// Create input file stream 
		BufferedReader ifs = new BufferedReader(new FileReader(Config.WORKOUTFILE));
		String currLine;
		
		
		while ((currLine = ifs.readLine()) != null) {
			String[] workoutInfo = currLine.split(",");
			
			// Create new workout from current line
			Workouts.Equipment currValE = Workouts.Equipment.valueOf(workoutInfo[1]);	// Convert string to Equipment enum
			Workouts.Muscle currValPM   = Workouts.Muscle.valueOf(workoutInfo[2]);		// Convert string to Muscle enum
			Workouts.Muscle currValSM   = Workouts.Muscle.valueOf(workoutInfo[3]);		// Convert string to Muscle enum
			
			// Add to return Workouts
			retWorkouts.addWorkout(workoutInfo[0], currValE, currValPM, currValSM, workoutInfo[4], workoutInfo[5]);		
		}
		
		ifs.close();
		return retWorkouts;
	  } 
	  
	  catch (FileNotFoundException e) {
		System.out.println("File not found error.");
		return retWorkouts;
	  }
	  
	  catch (IOException e) {
		  System.out.println("IO stream error.");
		  return retWorkouts;
	  }
	  
  }

}
