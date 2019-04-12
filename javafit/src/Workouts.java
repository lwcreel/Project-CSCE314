import java.util.ArrayList; // We choose ArrayList over Vector because...? 
/**
* Use the provided enumerations and code framework to create our workouts class.
* This class should contain all the functionality we need to interact with our workout list.
* Minimize duplication of code by writing helper functions as needed.
* 
* Do not change any of the provided code, although you can, and should, add to it as needed. 
* (E.G. Do not make private attributes public, or change the parameters of a function.)
*/

public class Workouts {

	// Use the Refactor functionality in Eclipse to rename "muscle" to "Muscle" to match our naming convention. Done
	public enum Muscle {ABS, BACK, BICEPS, CHEST, FOREARM, GLUTES, LOWERLEG, SHOULDER, TRICEPS, UPPERLEG, NONE} // Why didn't I have to declare this static?
  	public enum Equipment {BARBELL, BODYWEIGHT, DUMBBELL, CABLE, HAMMERSTRENGTH}
	private final ArrayList<Workout> workoutList = new ArrayList<Workout>();

	// This is a nested class, also known as an inner class. Why do we use a nested class?
	// You will need to create a number of methods for the inner class. You are not limited to 
	// only the methods listed inside this class.
	private class Workout {
		private String name;
		private Equipment equipment;
		private Muscle primaryMuscle;
		private Muscle secondaryMuscle;
		private String desc;
		private String reminders;
	
    Workout(String name, Equipment equipment, Muscle primaryMuscle, Muscle secondaryMuscle, String desc, String reminders) {
    	this.name = name;
    	this.equipment = equipment;
    	this.primaryMuscle = primaryMuscle;
    	this.secondaryMuscle = secondaryMuscle;
    	this.desc = desc;
    	this.reminders = reminders;
    }
    
    public final String getName() {return this.name;}
    	
    public final Equipment getEquipment() {return this.equipment;}
    	
    public final Muscle getPrimaryMuscle() {return this.primaryMuscle;}
    	
    public final Muscle getSecondaryMuscle() {return this.secondaryMuscle;}
    
    public final String getDesc() {return this.desc;}
    
    public final String getReminders() {return this.reminders;}

    public final String getEquipmentString() {return this.equipment.toString();}
    
    public final String getSecondaryMuscleString() {return this.secondaryMuscle.toString();}
    
    public final String getPrimaryMuscleString() {return this.primaryMuscle.toString();}
		
    // How do we get the name of an enumeration value?
	}
	
  // This function adds a new workout to the Workouts object.
  public final void addWorkout(String name, Equipment equipment, Muscle primaryMuscle, Muscle secondaryMuscle, String desc, String reminders)
  {
	  // Create new workout and add to list
	  Workout temp = new Workout(name, equipment, primaryMuscle, secondaryMuscle, desc, reminders);
	  workoutList.add(temp);
  }
  
  // This function adds a workout to the Workouts object.
  public final void addWorkout(Workout workout)
  {
	  workoutList.add(workout);
  }
  
  // This list returns a new Workouts object that contains only the workouts that contain the
  // Equipment value that is provided as an argument. The programmer has an option to get
  // Workouts that only have the Muscle in the PrimaryMuscle attribute, or to also look
  // in the secondaryMuscle category.
	public final Workouts getWorkoutsByMuscle(Muscle m, boolean includeSecondary)
	{
		Workouts retWorkouts = new Workouts();
		
		// What is short-circuit evaluation?
		if (includeSecondary) {
			for (int i = 0; i < workoutList.size(); i++) {
				
				// If passed muscle value is either a primary or secondary muscle for current workout
				if (workoutList.get(i).getPrimaryMuscle() == m || workoutList.get(i).getSecondaryMuscle() == m) {
					retWorkouts.addWorkout(workoutList.get(i));;
				}
			}
		} 
		
		else {
			for(int i = 0; i < workoutList.size(); i++) {
				
				// If passed muscle value is a primary muscle for current workout
				if (workoutList.get(i).getPrimaryMuscle() == m) {
					retWorkouts.addWorkout(workoutList.get(i));
				}
			}
		}
		return retWorkouts;
	}
	
	// This list returns a new Workouts object that contains only the workouts that contain the
	// Equipment value that is provided as an argument.
  public final Workouts getWorkoutsByEquipment(Equipment e)
  {
	  Workouts retWorkouts = new Workouts();
	  
	  // Iterate through old Workouts, checking passed value
	  for (int i = 0; i < workoutList.size(); i++) {
		  if (workoutList.get(i).getEquipment() == e) {
			  
			  // If true add current workout to new Workouts workoutList
			  retWorkouts.addWorkout(workoutList.get(i));
		  }
	  }
	  return retWorkouts;
  }
	
  // This returns a new Workouts object that contains only the workouts that contain an Equipment
  // value that is in the provided ArrayList of Equipment.
  public final Workouts getWorkoutsByEquipment(ArrayList<Equipment> e)
  {
	  Workouts retWorkouts = new Workouts();
	  
	  // Iterate through Equipment list
	  for (int i = 0; i < e.size(); i++) {
		  
		  // Iterate through workout list
		  for (int k = 0; k < workoutList.size(); k++) {
			  
			  // If current equipment value is equal to current equipment value at current workout
			  if (e.get(i) == workoutList.get(k).getEquipment()) {
				  retWorkouts.addWorkout(workoutList.get(k));
			  }
		  }
	  }
	  return retWorkouts;
  }
	
  // Returns size of workoutList
  public final int getNumWorkouts() {return workoutList.size();}
  
  // This method returns an ArrayList of Strings. Each String is a name of a workout in our Workouts list.
  public final ArrayList<String> getNames()
  {
	  ArrayList<String> workoutNames = new ArrayList<String>();
	  
	  // Iterate through workoutList
	  for(int i = 0; i < workoutList.size(); i++) {
		  
		  // Add name from workoutList to return list
		  workoutNames.add(workoutList.get(i).getName());
	  }
	  return workoutNames;
  }
 
  // This method returns all the information of the Workouts as an ArrayList of String arrays, 
  // one entry in the ArrayList per Workout. The String array should contain the workout's Name, 
  // Equipment, Primary and Secondary Muscles, Description, and Reminders. All of these should be strings.
  
  public final ArrayList<String[]> getFullInformation()
  {
	  ArrayList<String[]> retArrayList = new ArrayList<String[]>();
	  
	  // Iterate through workoutList
	  for (int i = 0; i < workoutList.size(); i++) {
		  String[] currWorkout = new String[6];
		  
		  // Build string array for current workout
		  currWorkout[0] = workoutList.get(i).getName();
		  currWorkout[1] = workoutList.get(i).getEquipmentString();
		  currWorkout[2] = workoutList.get(i).getPrimaryMuscleString();
		  currWorkout[3] = workoutList.get(i).getSecondaryMuscleString();
		  currWorkout[4] = workoutList.get(i).getDesc();
		  currWorkout[5] = workoutList.get(i).getReminders();

		  // Add to return list
		  retArrayList.add(currWorkout);
	  }
	  
	  return retArrayList;
  }
}
