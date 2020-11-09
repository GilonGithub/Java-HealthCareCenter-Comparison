import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class Driver {
	
	public static Scanner input = new Scanner(System.in);
	
	public static Appointments setAppoitment(Patient patient) {
		LocalDateTime dateTime;
		do {
			Scanner input = new Scanner(System.in);
			System.out.println("\nEnter the date in format yyyy-mm-dd hh:mm");
			String userDate = input.nextLine();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
			dateTime = LocalDateTime.parse(userDate, formatter);
			
		} while (Objects.isNull(dateTime) || dateTime.isBefore(LocalDateTime.now()));
				
		return(new Appointments(patient, dateTime));
		
	}
	
	public static User searchForUser(ArrayList<User> users) {
		
		boolean isFound = true;
		int userInput;
		
		do {

			if(!isFound) {
				System.err.println("\nUser not found!");
			}
			
			System.out.println("\nEnter the ID: ");
			userInput = input.nextInt();
			
			for (User u : users) {
				if (u.getID() == userInput) {
					return u;
				}
			}
			
			isFound = false;
			
		} while (!isFound);
		
		return null;
	}
	
	public static Doctor findADoctor(ArrayList<User> users) {

		User doctor = null; //initiate a null doctor
		
		do {
			System.out.println("\nFIND A DOCTOR");
			doctor = searchForUser(users);
			
			if(!(doctor instanceof Doctor)) {
				System.err.println("\nThe selected user is not a doctor!");
			}
			
		} while(!(doctor instanceof Doctor)); //find user until a doctor is found
		
		return (Doctor) doctor; //downcast the user to a doctor
	}
	
	public static void printAppointment(Patient patient, Appointments newAppointment, Doctor doctor) {
		
		System.out.println("\nPatient: " + patient.getFirstName() + " " + patient.getLastName()
							+ newAppointment 
							+ " with doctor " + doctor.getFirstName() + " " + doctor.getLastName());
	}
	
	public static void main(String[] args) {
		
		Patient p1 = new Patient(8888, "John", "Smith", "847 978 0877", "john@gmail.com", "male", LocalDate.of(1974, 9, 18));
		Patient p2 = new Patient(8476, "Jim", "Earl", "847 978 0877", "john@gmail.com", "male", LocalDate.of(1974, 9, 18));
		Patient p3 = new Patient(32678, "Patrick", "Abc", "847 978 0877", "john@gmail.com", "male", LocalDate.of(1974, 9, 18));
		Patient p4 = new Patient(425, "Len", "DEJ", "847 978 0877", "john@gmail.com", "male", LocalDate.of(1974, 9, 18));
		Patient p5 = new Patient(57543, "Monica", "Dnl", "847 978 0877", "john@gmail.com", "male", LocalDate.of(1974, 9, 18));
		Patient p6 = new Patient(8655, "Carol", "Edd", "847 978 0877", "john@gmail.com", "male", LocalDate.of(1974, 9, 18));
		Patient p7 = new Patient(8540, "Gil", "Fadr", "847 978 0877", "john@gmail.com", "male", LocalDate.of(1974, 9, 18));
		Patient p8 = new Patient(18739008, "Peter", "Gedn", "847 978 0877", "john@gmail.com", "male", LocalDate.of(1974, 9, 18));
		Patient p9 = new Patient(7898, "", "Led", "847 978 0877", "john@gmail.com", "male", LocalDate.of(1974, 9, 18));
		Patient p10 = new Patient(654, "Lucy", "Medd", "847 978 0877", "john@gmail.com", "male", LocalDate.of(1974, 9, 18));
		//System.out.println(p1);
		
		ArrayList<Patient> patients = new ArrayList<>();
		patients.add(p1);
		patients.add(p2);
		patients.add(p3);
		patients.add(p4);
		patients.add(p5);
		patients.add(p6);
		patients.add(p7);
		patients.add(p8);
		patients.add(p9);
		patients.add(p10);
		
		
		Appointments apt1 = new Appointments(p1, LocalDateTime.of(2020, 11, 20, 10, 15));
		Appointments apt2 = new Appointments(p2, LocalDateTime.of(2020, 12, 20, 13, 15));
		
		
		Doctor d1 = new Doctor(7777, "Jack", "Novy", "797 384 8364", "jackN@gmail.com", "gynecologist");
		Doctor d2 = new Doctor(9999, "Jim", "Stary", "797 384 8364", "jackN@gmail.com", "gynecologist");
		Doctor d3 = new Doctor(07544, "Peter", "Bow", "797 384 8364", "jackN@gmail.com", "gynecologist");
		Doctor d4 = new Doctor(076, "Patricia", "Apple", "797 384 8364", "jackN@gmail.com", "gynecologist");
		
		ArrayList<Doctor> doctors = new ArrayList<>();
		doctors.add(d1);
		doctors.add(d2);
		doctors.add(d3);
		doctors.add(d4);
			
		d1.addAppointment(apt1);
		d1.addAppointment(apt2);
		
		ArrayList<User> users = new ArrayList<>();
		users.add(d1);
		users.add(d2);
		users.add(d3);
		users.add(d4);
		users.add(p1);
		users.add(p2);
		users.add(p3);
		users.add(p4);
		users.add(p5);
		users.add(p6);
		users.add(p7);
		users.add(p8);
		users.add(p9);
		users.add(p10);
		
		Collections.sort(users, new UserSorter.SortByLastName());
		for (User u: users) {
			System.out.println(u.printInfo() + "\n");
		}

		
		User foundUser = searchForUser(users);

		if(foundUser instanceof Patient) {
			
			Patient p = (Patient) foundUser; //downcast the user to a patient
			
			System.out.println(p); //print the patient info
			
			Appointments newAppointment = setAppoitment(p); //get the appointment from user
			
			Doctor foundDoctor = findADoctor(users); //find a doctor
		
			printAppointment(p, newAppointment, foundDoctor); //print appointment
			
		} else if(foundUser instanceof Doctor) {
			
			Doctor d = (Doctor) foundUser; //downcast user to a doctor
			
			System.out.println(d); //print doctor info and his appointments
		}
		
		
}
}
