/************************************************************************
 * Final Project
 * Manager.java
 * CS 225 Spring 2021
 * Written by: Maegan Lucas
 * Date: 04/08/2021
 
 * Purpose: To manage the associated classes to pass to the GUI classes.
 
 * Methods:
  		~ emptyTest: void - prints a phrase to show that class
  							runs.
  		~ readDueDates: void - reads from a file and creates new
  							   DueDate objects with the information
  							   in the file.
  		~ readClassSchedule: void - reads from a file and creates new
  									Course objects with the information
  									in the file.
  		~ createEventInput: void - creates an event of choice using user
  								   input.
  		~ createEvent: void - creates an event with arguments taken from
  							  text fields in GUI screen.
  		~ saveSchedule: void - writes schedule list to a text file.
  		~ recallSchedule: void - reads from file of saved schedule and 
  							     creates events from the data.
  		~ testCases: void - uses arguments to attempt to create an event
  							checking for any wrong input types, or out of 
  							bounds input.
  									
  * Attributes: 
  		ArrayList: schedule
   
 ************************************************************************/


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Manager {
	

	private static List<Event> schedule = new ArrayList<>();
	
	public static void main(String[] args) {
		Manager mgr = new Manager();
				
			try {
				mgr.recallSchedule();
				
			} catch (Exception e) {
				System.out.print("No saved schedule");
			}
			
			
			
			try {
				mgr.readDueDates();
			} catch (FileNotFoundException e) {
				System.out.print("Error: duedates.txt not found.");
			}
			
			try {
				mgr.readClassSchedule();
			} catch(FileNotFoundException e) {
				System.out.print("Error: classschedule.txt not found");
			}
			
			// mgr.testCases("1a", "3", 12, 21, 2021, 5, 45, 6, 45); *CAUSES ERROR - PASSES TEST*
			// mgr.testCases("1b", "2.5", 12, 21, 2021, 5, 45, 6, 45); *DOES NOT CAUSE ERROR - FAILS TEST*
			// mgr.testCases("1c", "Lunch", 12, 21, 2021, 12, 45, 1, 45); *SETS NAME - PASSES TEST*
			// mgr.testCases("2a", "test 2", 3.5, 12, 2021, 4, 45, 5, 45); *CAUSES ERROR - PASSES TEST*
			// mgr.testCases("2b", "test 2", "March", 21, 2021, 3, 45, 4, 45); *CAUSES ERROR - PASSES TEST*
			// mgr.testCases("2c", "test2", 11, 12, 2021, 12, 30, 1, 30); *SETS MONTH - PASSES TEST*
			// mgr.testCases("3a", "test 3", 10, "Wednesday", 2021, 3, 20, 5, 20); *CAUSES ERROR - PASSES TEST*
			// mgr.testCases("3b", "test 3", 12, 5.5, 2021, 1, 30, 2, 30); *CAUSES ERROR - PASSES TEST*
			// mgr.testCases("3c", "test3", 12, 22, 2021, 12, 30, 1, 30); *SETS DAY - PASSES TEST*
			// mgr.testCases("4a", "test 4", 4, 12, "Twenty", 12, 00, 1, 00); *CAUSES ERROR - PASSES TEST*
			// mgr.testCases("4b", "test 4", 4, 12, 2021.5, 12, 00, 1, 00); *CAUSES ERROR - PASSES TEST*
			//mgr.testCases("4c", "test4", 4, 12, 2021, 12, 00, 1, 00); *SETS YEAR - PASSES TEST*
			// mgr.testCases("5a", "test5", 4, 12, 2021, 2.5, 15, 1, 15); *CAUSES ERROR - PASSES TEST*
			// mgr.testCases("5b", "test5", 4, 12, 2021, 0, 25, 1, 25); *NOT WITHIN BOUNDS - PASSES TEST*
			// mgr.testCases("5c", "test5", 4, 12, 2021, 1, 25, 2, 25); *SETS HOUR - PASSES TEST*
			// mgr.testCases("5d", "test5", 4, 12, 2021, 8, 30, 9, 30); *SETS HOUR - PASSES TEST*
			// mgr.testCases("5e", "test5", 4, 12, 2021, 12, 30, 4, 30); *SETS HOUR - PASSES TEST*
			// mgr.testCases("5f", "test5", 4, 12, 2021, 13, 30, 4, 30); *NOT WITHIN BOUNDS - PASSES TEST*
			
			mgr.createEventInput();
			
			mgr.saveSchedule();

			
			System.out.print("\nElements in Schedule: " + schedule.size());
	}
	
	public void readDueDates() throws FileNotFoundException {
		File dueDates = new File("duedates.txt");
		Scanner input =  new Scanner(dueDates);
		
		int month = 0; 
		int day = 0;
		int year;
		int hour = 0;
		int minute = 0;
		String sYear;
		
		if(dueDates.canRead()) {
			System.out.print("File can read.\n");
		}
		while(input.hasNext()) {
			DueDate dueDate = new DueDate();
			
			dueDate.setName(input.next());
			try {
				month = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.print("Month wrong input type.");
			}
			
			if((month < 1) || (month > 12)) {
				System.out.print("Month is not within bounds.");
			} else {
				dueDate.setMonth(month);
			}

			try {
				day = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.print("Day wrong input type");
			}
			
			
			if((day < 1) || (day > 31)) {
				System.out.print("Day is not within bounds.");
			} else {
				dueDate.setDay(day);
			}
			
			sYear = input.next();
			year = Integer.parseInt(sYear);
			dueDate.setYear(year);
			
			try {
				hour = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.print("Hour wrong input type.");
			}

			if((hour < 1) || (hour > 12)) {
				System.out.print("Hour not within bounds.");
			} else {
				dueDate.setHour(hour);
			}
			
			try {
				minute = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.print("Minute wrong input type.");
			}
						
			if((minute < 0) || (minute > 59)) {
				System.out.print("Minute not within bounds");
			} else {
				dueDate.setMinute(minute);
			}
					
			dueDate.selectCategory(input.next());
			dueDate.setClassName(input.next());
			
			System.out.println("\nName: " + dueDate.getName() + "\nTime: " + dueDate.getHour() + ":" + dueDate.getMinute()+ "\nDate: " + dueDate.getMonth() + "/" + dueDate.getDay() + "/" + dueDate.getYear() + "\nCategory: " + dueDate.getCategory() + "\nClass: " + dueDate.getClassName());
			schedule.add(dueDate);
				
			}
		
		input.close();
	}
	
	public void readClassSchedule() throws FileNotFoundException {
		File classes = new File("classschedule.txt");
		Scanner input = new Scanner(classes);
		int hour = 0;
		int minute = 0;
		int finishHour = 0;
		int finishMinute = 0;
		
		try {
			if(classes.canRead()) {
				System.out.print("\nFile can read.");
			}
			while(input.hasNext()) {
				Course classSchedule = new Course();
				classSchedule.setName(input.next());
				try { 
					hour = input.nextInt();
				} catch (InputMismatchException e) {
					System.out.print("Hour wrong input type.");
				}
				
				if((hour < 1) || (hour > 12)) {
					System.out.print("Hour not within bounds.");
				} else {
					classSchedule.setHour(hour);
				}
				
				try {
					minute = input.nextInt();
				} catch (InputMismatchException e) {
					System.out.print("Minute wrong input type.");
				}
				
				if((minute < 0) || (minute > 59)) {
					System.out.print("Minute not within bounds.");
				} else {
					classSchedule.setMinute(minute);
				}
				
				try {
					finishHour = input.nextInt();
				} catch (InputMismatchException e) {
					System.out.print("Finish hour wrong input type");
				}
				
				if ((finishHour < 1) || (finishHour > 12)) {
					System.out.print("Finish hour not within bounds.");
				} else {
					classSchedule.setFinishHour(finishHour);
				}
				
				try {
					finishMinute = input.nextInt();
				} catch (InputMismatchException e) {
					System.out.print("Finish minute wrong input type.");
				}
				
				if ((finishMinute < 0) || (finishMinute > 59)) {
					System.out.print("Finish minute not within bounds");
				} else {
					classSchedule.setFinishMinute(finishMinute);
				}
				
				classSchedule.setRoomNumber(input.next());
				classSchedule.setBuilding(input.next());
				classSchedule.setTeacher(input.next());
				System.out.println("\nName: " + classSchedule.getName() + "\nTime: " + classSchedule.getHour() + ":" + classSchedule.getMinute()+ "-" + classSchedule.getFinishHour() + ":" + classSchedule.getFinishMinute() + "\nLocation: " + classSchedule.getBuilding() + " " + classSchedule.getRoomNumber() + "\nTeacher: " + classSchedule.getTeacher());
				schedule.add(classSchedule);
			}
		} catch(InputMismatchException e) {
			System.out.print("Error: Wrong input found int classschedule.txt");
		}
		
		input.close();
	}
	
	public void saveSchedule() {
		File scheduleFile = new File("schedule.txt");
		try {
			FileWriter fileWriter = new FileWriter(scheduleFile, false);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for(int i = 0; i < schedule.size(); i++) {
				bufferedWriter.write(schedule.get(i).getName());
				bufferedWriter.write(" " + schedule.get(i).getMonth());
				bufferedWriter.write(" " + schedule.get(i).getDay());
				bufferedWriter.write(" " + schedule.get(i).getYear());
				bufferedWriter.write(" " + schedule.get(i).getHour());
				bufferedWriter.write(" " + schedule.get(i).getMinute());
				bufferedWriter.write(" " + schedule.get(i).getFinishHour());
				bufferedWriter.write(" " + schedule.get(i).getFinishMinute());
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void recallSchedule() throws FileNotFoundException{
		File scheduleFile = new File("schedule.txt");
		Scanner input = new Scanner(scheduleFile);
		int hourCheck;
		int minute;
		int finishMinute;
		int hour;
		int month;
		int day;
		int year;
		
		while(input.hasNext()) {
			Event event = new Event();
			event.setName(input.next());
			month = input.nextInt();
			day = input.nextInt();
			year = input.nextInt();
			hour = input.nextInt();
			minute = input.nextInt();
			hourCheck = input.nextInt();
			finishMinute = input.nextInt();
			
			if(month != 0) {
				event.setMonth(month);
				event.setDay(day);
				event.setYear(year);
			}
			
			event.setHour(hour);
			event.setMinute(minute);
			
			if(hourCheck != 0) {
				event.setFinishHour(hourCheck);
				event.setFinishMinute(finishMinute);
			} 
			schedule.add(event);
		}
		
		input.close();
	}
		
	public void createEvent(String name, int month, int day, int year, int hour, int minute, int finishHour, int finishMinute) {
		Event event = new Event();
		try {
			Double.parseDouble(name);
			Integer.parseInt(name);
			System.out.print("Name wrong input type.");
		} catch (Exception e) {
			event.setName(name);
		}
		
		if((month < 1) || (month > 12)) {
			System.out.print("Month is not within bounds.");
		} else {
			event.setMonth(month);
		}
		
		if((day < 1) || (day > 31)) {
			System.out.print("Day is not within bounds.");
		} else {
			event.setDay(day);
		}
		event.setYear(year);
		
		if((hour < 1) || (hour > 12)) {
			System.out.print("Hour not within bounds.");
		} else {
			event.setHour(hour);
		}
		
		if((minute < 0) || (minute > 59)) {
			System.out.print("Minute not within bounds.");
		} else {
			event.setMinute(minute);
		}
		
		if ((finishHour < 1) || (finishHour > 12)) {
			System.out.print("Finish hour not within bounds.");
		} else {
			event.setFinishHour(finishHour);
		}
		
		if ((finishMinute < 0) || (finishMinute > 59)) {
			System.out.print("Finish minute not within bounds");
		} else {
			event.setFinishMinute(finishMinute);
		}
		
		schedule.add(event);
	}
	
	public void createEventInput() {
		Scanner input = new Scanner(System.in);
		int selection;
		System.out.print("1- General Event\t2- Due Date\t3- Course\t4- Break");
		System.out.print("\nPlease enter selection: ");
		selection = input.nextInt();
		if (selection == 1) {
			Event event = new Event();
			System.out.print("Please enter event name: ");
			event.setName(input.next());
			System.out.print("Please enter event month: ");
			event.setMonth(input.nextInt());
			System.out.print("Please enter event day: ");
			event.setDay(input.nextInt());
			System.out.print("Please enter event year: ");
			event.setYear(input.nextInt());
			System.out.print("Please enter event hour: ");
			event.setHour(input.nextInt());
			System.out.print("Please enter event minute: ");
			event.setMinute(input.nextInt());
			System.out.print("Please enter event finish hour: ");
			event.setFinishHour(input.nextInt());
			System.out.print("Please enter event finish minute: ");
			event.setFinishMinute(input.nextInt());
			schedule.add(event);
		} else if (selection == 2) {
			DueDate dueDate = new DueDate();
			System.out.print("Please enter due date name: ");
			dueDate.setName(input.next());
			System.out.print("Please enter due date month: ");
			dueDate.setMonth(input.nextInt());
			System.out.print("Please enter due date day: ");
			dueDate.setDay(input.nextInt());
			System.out.print("Please enter due date year: ");
			dueDate.setYear(input.nextInt());
			System.out.print("Please enter due date hour: ");
			dueDate.setHour(input.nextInt());
			System.out.print("Please enter due date minute: ");
			dueDate.setMinute(input.nextInt());
			schedule.add(dueDate);
		} else if (selection == 3) {
			Course course = new Course();
			System.out.print("Please enter course name: ");
			course.setName(input.next());
			System.out.print("Please enter course hour: ");
			course.setHour(input.nextInt());
			System.out.print("Please enter course minute: ");
			course.setMinute(input.nextInt());
			System.out.print("Please enter course finish hour: ");
			course.setFinishHour(input.nextInt());
			System.out.print("Please enter course finish minute: ");
			course.setFinishMinute(input.nextInt());
			System.out.print("Please enter course teacher: ");
			course.setTeacher(input.next());
			System.out.print("Please enter building: ");
			course.setBuilding(input.next());
			System.out.print("Please enter room number: ");
			course.setRoomNumber(input.next());
			schedule.add(course);
		} else if (selection == 4) {
			Break breakEvent = new Break();
			System.out.print("Please enter break name: ");
			breakEvent.setName(input.next());
			System.out.print("Please enter break month: ");
			breakEvent.setMonth(input.nextInt());
			System.out.print("Please enter break day: ");
			breakEvent.setDay(input.nextInt());
			System.out.print("Please enter break year: ");
			breakEvent.setYear(input.nextInt());
			System.out.print("Please enter break hour: ");
			breakEvent.setHour(input.nextInt());
			System.out.print("Please enter break minute: ");
			breakEvent.setMinute(input.nextInt());
			System.out.print("Please enter break finish hour: ");
			breakEvent.setFinishHour(input.nextInt());
			System.out.print("Please enter break finish minute: ");
			breakEvent.setFinishMinute(input.nextInt());
			schedule.add(breakEvent);
		} else {
			System.out.print("Invalid selection");
		}
		input.close();
	}

	public void testCases(String testCaseID, String name, int month, int day, int year, int hour, int minute, int finishHour, int finishMinute) {
		System.out.print("Test Case ID: " + testCaseID + "\n");
		createEvent(name, month, day, year, hour, minute, finishHour, finishMinute);
		System.out.print("\n");
	}

	
}