/************************************************************************
 * Final Project
 * NewEventPane.java
 * CS 225 Spring 2021
 * Written by: Maegan Lucas
 * Date: 04/08/2021
 
 * Purpose: The GUI pane where users enter information for a generic
  			event.
 
 * Methods:
  		~ NewEventPane: void - constructor
   									
  * Attributes: 
  		Manager: mgr
  		GridPane: gridPane
  		TextField: name, month, day, year, hour, minute, finishHour,
  			       finishMinute
  		Button: btCreate
  		Label: nameLabel, monthLabel, dayLabel, yearLabel, hourLabel
  			   minuteLabel, finishHourLabel, finishMinuteLabel
   
 ************************************************************************/
//import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class NewEventPane extends GridPane {
	
	private Manager mgr = new Manager();
	private GridPane gridPane = new GridPane();
	private TextField name, month, day, year, hour, minute, finishHour, finishMinute;
	private Button btCreate;
	private Label nameLabel, monthLabel, dayLabel, yearLabel, hourLabel, minuteLabel, finishHourLabel, finishMinuteLabel;
	
	public NewEventPane() {
		name = new TextField();
		month = new TextField();
		day = new TextField();
		year = new TextField();
		hour = new TextField();
		minute = new TextField();
		finishHour = new TextField();
		finishMinute = new TextField();
		
		nameLabel = new Label("Name");
		monthLabel = new Label("Month");
		dayLabel = new Label("Day");
		yearLabel = new Label("Year");
		hourLabel = new Label("Hour");
		minuteLabel = new Label("Minute");
		finishHourLabel = new Label("Finish Hour");
		finishMinuteLabel = new Label("Finish Minute");
		
		btCreate = new Button("Create");
		
		gridPane.add(nameLabel, 0, 0);
		gridPane.add(name, 0, 1);
		gridPane.add(monthLabel, 0, 2);
		gridPane.add(month, 0, 3);
		gridPane.add(dayLabel, 1, 2);
		gridPane.add(day, 1, 3);
		gridPane.add(yearLabel, 2, 2);
		gridPane.add(year, 2, 3);
		gridPane.add(hourLabel, 0, 4);
		gridPane.add(hour, 0, 5);
		gridPane.add(minuteLabel, 1, 4);
		gridPane.add(minute, 1, 5);
		gridPane.add(finishHourLabel, 0, 6);
		gridPane.add(finishHour, 0, 7);
		gridPane.add(finishMinuteLabel, 1, 6);
		gridPane.add(finishMinute, 1, 7);
		gridPane.add(btCreate, 4, 9);
		
		
		btCreate.setOnAction(e -> {
			String nameEntry = name.getText();
			int monthEntry = Integer.parseInt(month.getText());
			int dayEntry = Integer.parseInt(day.getText());
			int yearEntry = Integer.parseInt(year.getText());
			int hourEntry = Integer.parseInt(hour.getText());
			int minuteEntry = Integer.parseInt(minute.getText());
			int finishHourEntry = Integer.parseInt(finishHour.getText());
			int finishMinuteEntry = Integer.parseInt(finishMinute.getText());
			mgr.createEvent(nameEntry, monthEntry, dayEntry, yearEntry, hourEntry, minuteEntry, finishHourEntry, finishMinuteEntry);
		});
		
	}
	

}