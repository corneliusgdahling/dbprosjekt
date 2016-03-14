package TextProgram;

import TextProgram.AddElements.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CreateWorkout {

    public CreateWorkout() {
        insertWorkoutIntoDB();
    }


    public void insertWorkoutIntoDB() {
        AddTreningsøkt addTreningsøkt = new AddTreningsøkt();
        AddØvelse addØvelse = new AddØvelse();
        DetermineType determineType = new DetermineType();
        AddForhold addForhold = new AddForhold();
        DetermineWhere determineWhere = new DetermineWhere();

    }

}
