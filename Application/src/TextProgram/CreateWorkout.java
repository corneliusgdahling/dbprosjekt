package TextProgram;

import TextProgram.AddElements.*;

public class CreateWorkout {

    public CreateWorkout() {
        insertWorkoutIntoDB();
    }


    public void insertWorkoutIntoDB() {
    	DetermineWhere determineWhere = new DetermineWhere();
        AddTreningsøkt addTreningsøkt = new AddTreningsøkt();
        DetermineType determineType = new DetermineType();
        AddForhold addForhold = new AddForhold();
        
    }

}
