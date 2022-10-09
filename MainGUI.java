/************************************************************************
 * Final Project
 * MainGui.java
 * CS 225 Spring 2021
 * Written by: Maegan Lucas
 * Date: 04/08/2021
 
 * Purpose: The main GUI class. Helps control interactions between
 			other GUI classes.
 
 * Methods:
  		~ start: void - displays GUI to user.
  								
  * Attributes: 
  		BorderPane: borderPane
  		SchedulePane: schedulePane
  		NewEventPane: newEventPane
  		NewDueDatePane: newDueDatePane
  		NewBreakPane: newBreakPane
  		NewCoursePane: newCoursePane
  		MenuBar: menuBar
  		Menu: menuNew, menuFile, menuView
  		MenuItem: miCreateEvent, miCreateDueDate, miCreateBreak, 
  				  miCreateCourse, miSave, miImportDueDates,
  				  miImportCourses, miMonth, miWeek, miDay
   
 ************************************************************************/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainGUI extends Application{
	
	private BorderPane borderPane;
	private MenuBar menuBar;
	private Menu menuNew, menuFile, menuView;
	private MenuItem miCreateEvent, miCreateDueDate, miCreateBreak, miCreateCourse;
	private MenuItem miSave, miImportDueDates, miImportCourses;
	private MenuItem miMonth, miWeek, miDay;
	private SchedulePane schedulePane = new SchedulePane();
	private NewEventPane newEventPane = new NewEventPane();
	private NewDueDatePane newDueDatePane = new NewDueDatePane();
	private NewBreakPane newBreakPane = new NewBreakPane();
	private NewCoursePane newCoursePane = new NewCoursePane();
	
	public MainGUI() {
		borderPane = new BorderPane();
		
		menuNew = new Menu("New");
		miCreateEvent = new MenuItem("Event");
		miCreateDueDate = new MenuItem("Due Date");
		miCreateBreak = new MenuItem("Break");
		miCreateCourse = new MenuItem("Course");
		menuNew.getItems().addAll(miCreateEvent, miCreateDueDate, miCreateBreak, miCreateCourse);
		
		menuFile = new Menu("File");
		miSave = new MenuItem("Save");
		miImportDueDates = new MenuItem("Import Due Dates");
		miImportCourses = new MenuItem("Import Courses");
		menuFile.getItems().addAll(miSave, miImportDueDates, miImportCourses);
		
		menuView = new Menu("View");
		miMonth = new MenuItem("Month");
		miWeek = new MenuItem("Week");
		miDay = new MenuItem("Day");
		menuView.getItems().addAll(miMonth, miWeek, miDay);
		
		menuBar = new MenuBar();
		menuBar.getMenus().addAll(menuNew, menuFile, menuView);
		borderPane.setTop(menuBar);
		
		miCreateEvent.setOnAction(e -> {
			borderPane.setCenter(newEventPane);
			newEventPane.requestFocus();
		});
		
	}
	
	@Override
	public void start(Stage stage) {
	Scene scene = new Scene(borderPane, 1000, 750);
	stage.setScene(scene);
	stage.setTitle("Schedule");
	
	
	
	stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}