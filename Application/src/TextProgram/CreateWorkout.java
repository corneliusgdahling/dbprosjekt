package TextProgram;

import TextProgram.AddElements.*;

public class CreateWorkout {

    public CreateWorkout() {
        insertWorkoutIntoDB();
    }


    public void insertWorkoutIntoDB() {
        AddTreningsøkt addTreningsøkt = new AddTreningsøkt();
        DetermineType determineType = new DetermineType();
        AddForhold addForhold = new AddForhold();
        DetermineWhere determineWhere = new DetermineWhere();
    }

}
