import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class Driver {
	
	public static Scanner input = new Scanner(System.in);
	
	
	
	
	
	public static void getUser(ArrayList<User> users) {
		int userChoice;
		boolean isFound;
		do {
			System.out.println("\nEnter your ID: ");
			userChoice = input.nextInt();
			isFound = (userChoice, doctors);
		} while (!isFound);
		
		for (Doctor d : doctors) {
			if (d.getDoctorId() == userChoice) {
				System.out.println(d);
			}
		}
		
	}
	
	public static boolean searchForDoctor(int doctorId, ArrayList<Doctor> doctors) {
		boolean isFound = false;
		for (Doctor d : doctors) {
			if (d.getDoctorId() == doctorId) {
				isFound = true;
			}
		}
				return isFound;	
	}
	
	

	public static Doctor searchForDoctorAddApt(ArrayList<Doctor> doctors, Appointments appointment) {
		int userChoice;
		boolean isFound;
		do {
			System.out.println("\nEnter doctor's ID: ");
			userChoice = input.nextInt();
			isFound = searchForDoctor(userChoice, doctors);
		} while (!isFound);
		
		for (Doctor d : doctors) {
			if (d.getDoctorId() == userChoice) {
				d.addAppointment(appointment);
				return d;
			}
		}
		return null;		
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
			System.out.println(u.getLastName());
		}
		/*
		Collections.sort(d1.getListOfAppointments());
		for (Appointments a: d1.getListOfAppointments()) {
			System.out.println(a);
		}
		*/
		
		System.out.println("Enter your ID:");
		int userId = input.nextInt();
		
		if (userId instanceof Patient) {
			
		}
			
}
}
