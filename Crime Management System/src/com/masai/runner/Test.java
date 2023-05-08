package com.masai.runner;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.masai.entities.Crime;
import com.masai.entities.Criminal;
//import com.masai.entities.Customer;
//import com.masai.entities.Product;
import com.masai.exceptions.AdminAlreadyExistsException;
import com.masai.exceptions.CrimeNotFoundException;
import com.masai.exceptions.CriminalNotFoundException;
import com.masai.exceptions.InvalidDataEntryException;
import com.masai.exceptions.InvalidDataException;
import com.masai.exceptions.InvalidDetailsException;
import com.masai.services.CrimeImp;
import com.masai.services.CrimeInterfaceImpl;
import com.masai.services.CriminalIm;
import com.masai.services.CriminalImp;
import com.masai.utility.Admin;
//import com.masai.exceptions.InvalidDetailsException;
//import com.masai.exceptions.ProductException;
//import com.masai.exceptions.TransactionException;
//import com.masai.service.CustomerService;
//import com.masai.service.CustomerServiceImpl;
//import com.masai.service.ProductService;
//import com.masai.service.ProductServicesImpl;
//import com.masai.service.TransactionService;
//import com.masai.service.TransactionServiceImpl;
import com.masai.utility.FileExists;
import com.masai.utility.IDGeneration;

public class Test {
	private static Scanner scanner = new Scanner(System.in);

	private static Map<Integer, Crime> crimeMap;

	public static void main(String[] args) throws AdminAlreadyExistsException, CrimeNotFoundException,
			CriminalNotFoundException, InvalidDetailsException {

//		Map<Integer, Product> products = FileExists.productFile();
//		Map<String, Customer> customers = FileExists.customerFile(

		Map<Integer, Criminal> criminalMap = FileExists.getCriminalData();
		Map<Integer, Crime> crimeMap = FileExists.getCrimeData();
		Scanner scanner = new Scanner(System.in);
		// Load data from files
//        adminMap = FileExists.getAdminData();
//        criminalMap = FileExists.getCriminalData();
//        crimeMap = FileExists.getCrimeData();

		System.out.println("Welcome to the Crime Management System\n");

		try {
			int preference = 0;
			do {

				System.out.println("1. Admin ");
//					System.out.println("2. Public Access");
				System.out.println("0. Exit");
				preference = scanner.nextInt();
				scanner.nextLine();

				switch (preference) {
				case 1:
					adminFunctionality(scanner, crimeMap, criminalMap);
					break;
//				case 2:
//					publicAccess();
//					break;
				case 0:
					System.out.println("Thank you for using the Crime Management System.");
					break;
				default:
					throw new InvalidDetailsException("Invalid Selection");

				}

			} while (preference != 0);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			// serialization (finally always executed)
			try {
				ObjectOutputStream poos = new ObjectOutputStream(new FileOutputStream("Crime.ser"));
				poos.writeObject(crimeMap);
				ObjectOutputStream coos = new ObjectOutputStream(new FileOutputStream("Criminal.ser"));
				coos.writeObject(criminalMap);
//
//					ObjectOutputStream toos = new ObjectOutputStream(new FileOutputStream("Transactions.ser"));
//					toos.writeObject(transactions);
				// System.out.println("serialized..........");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
	}

	// Save data to files

//		FileExists.saveDataToFile(FileExists.CRIMINAL_FILE_PATH, criminalMap);
//		FileExists.saveDataToFile(FileExists.CRIME_FILE_PATH, crimeMap);

//	private static void getInto(Scanner sc)
//			throws AdminAlreadyExistsException, CrimeNotFoundException, CriminalNotFoundException {
//		int option = 0;
//
//		while (option != 2) {
//			System.out.println("Admin Main Page\n");
//			System.out.println("1. Sign In");
//			System.out.println("2. Sign Up");
//
//			try {
//				option = sc.nextInt();
//				scanner.nextLine();
//
//				switch (option) {
//				case 1:
//					adminLogin1(sc);
//					break;
//				case 2:
//					signUp();
//					break;
//				default:
//					System.out.println("Invalid option. Please try again.");
//					break;
//				}
//			} catch (InputMismatchException e) {
//				System.out.println("Invalid input. Please try again.");
//				scanner.nextLine();
//			}
//		}
//	}
//	
	public static void adminLogin(Scanner sc) throws InvalidDataEntryException {

		System.out.println("Enter the user name");
		String userName = sc.next();
		System.out.println("Enter the password");
		String password = sc.next();
		if (userName.equals(Admin.username) && password.equals(Admin.password)) {

			System.out.println("successfully login");
		} else {
			throw new InvalidDataEntryException("Invalid Admin Credentials");
		}
	}
//
//	private static void adminLogin1(Scanner sc)
//			throws AdminAlreadyExistsException, CrimeNotFoundException, CriminalNotFoundException {
//		adminMap = FileExists.getAdminData();
//		criminalMap = FileExists.getCriminalData();
//		crimeMap = FileExists.getCrimeData();
//		System.out.println("Enter your email address:");
//		String email = scanner.nextLine();
//
//		System.out.println("Enter your password:");
//		String password = scanner.nextLine();
//
//		if (adminMap.containsKey(email.hashCode())) {
//			Admin admin = adminMap.get(email.hashCode());
//
//			if (admin.getPassword().equals(password)) {
//				System.out.println("Successfully signed in as " + admin.getUsername());
//				loggedInAdmin = admin;
//				adminFunctionality(sc, crimeMap, criminalMap, adminMap);
//			} else {
//				System.out.println("Incorrect password. Please try again.");
//			}
//		} else {
//			System.out.println("Admin account not found. Please try Signing Up.");
//
//		}
//	}

//	private static void signUp() throws AdminAlreadyExistsException {
//		System.out.println("Enter your name:");
//		String name = scanner.nextLine();
//
//		System.out.println("Enter your email address:");
//		String email = scanner.nextLine();
//
//		System.out.println("Enter your password:");
//		String password = scanner.nextLine();
//
//		if (adminMap.containsKey(email.hashCode())) {
//			throw new AdminAlreadyExistsException("An admin account with this email already exists.");
//		} else {
//			Admin admin = new Admin(name, email, password);
//			adminMap.put(email.hashCode(), admin);
//			System.out.println("Successfully signed up as " + admin.getUsername());
//			loggedInAdmin = admin;
//		}
//
//		// Save the updated admin map to file
//		FileExists.saveDataToFile(FileExists.ADMIN_FILE_PATH, adminMap);
//	}

	private static void adminFunctionality(Scanner sc, Map<Integer, Crime> crime, Map<Integer, Criminal> criminal)
			throws AdminAlreadyExistsException, CrimeNotFoundException, CriminalNotFoundException,
			InvalidDataEntryException {
		// admin login

		adminLogin(sc);
		CrimeImp cImp1 = new CrimeInterfaceImpl();
		CriminalImp crim = new CriminalImp();

//		CrimeImp crime1 = new CrimeInterfaceImpl();
//		CustomerService cusService = new CustomerServiceImpl();
//		TransactionService trnsactionService = new TransactionServiceImpl();
		int choice = 0;
		try {
			do {
				System.out.println("Press 1 add the Crime");
				System.out.println("Press 2 view all the Crime");
				System.out.println("Press 3 delete he crime");
				System.out.println("Press 4 update the Crime");
				System.out.println("Press 5 add Criminals");
//				System.out.println("Press 6 to view all transactions");
				System.out.println("Press 7 to log out");
				choice = sc.nextInt();

				switch (choice) {
				case 1:
					String added = adminAddCrime(sc, crime, cImp1);
					System.out.println(added);
					break;
				case 2:

					adminViewAllCrimes(crime, cImp1);
					break;
				case 3:

					adminDeleteProduct(sc, crime,cImp1);
					break;
				case 4:

					String upt = adminUpdateCrime(sc, crime, cImp1);
					System.out.println(upt);
					break;
				case 5:
					adminAddCriminal(sc,criminal, crim);

					break;
//				case 6:
//					adminViewAllTransactions(transactions, trnsactionService);
//					break;
//				case 7:
//					System.out.println("admin has successfully logout");
//					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}

			} while (choice <= 6);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static String adminAddCrime(Scanner sc, Map<Integer, Crime> crime, CrimeImp cImp1)
			throws InvalidDataException {

		String str = null;
		System.out.println("please enter the crime details");

		System.out.println("Enter the Crime Type ( Robbery, Theft, Homicide)");
		String type = sc.next();
		sc.nextLine();
		System.out.println("Enter the description of the crime");
		String desc = sc.nextLine();
		System.out.println("Enter the Police Station Area");
		String psArea = sc.nextLine();
		System.out.println("Enter Crime date in format yyyy-MM-dd: ");
		String inputDate = sc.nextLine();
		LocalDate date = LocalDate.parse(inputDate);
		System.out.println("Enter the name of the Victim");
		String name = sc.nextLine();

		Crime c = new Crime(IDGeneration.generateId(), type, desc, psArea, date, name);

		str = cImp1.addCrime(c, crime);// considering all details are valid

		return str;
	}

//	public static void adminLogin(Scanner sc) throws InvalidDetailsException {
//
//		System.out.println("Enter the user name");
//		String userName = sc.next();
//		System.out.println("Enter the password");
//		String password = sc.next();
//		if (userName.equals(Admin.username) && password.equals(Admin.password)) {
//
//			System.out.println("successfully login");
//		} else {
//			throw new InvalidDetailsException("Invalid Admin Credentials");
//		}
//	}
//
////	public static String adminAddProduct(Scanner sc, Map<Integer, Product> products, ProductService prodService) {
////
////		String str = null;
////		
////
////	}
//
	public static void adminViewAllCrimes(Map<Integer, Crime> crime, CrimeImp cImp1) throws CrimeNotFoundException {
		cImp1.viewAllCrimes(crime);
	}

//
	public static void adminDeleteProduct(Scanner sc, Map<Integer, Crime> crime, CrimeImp cImp1)
			throws CrimeNotFoundException {

		System.out.println("please enter the id of Crime to be deleted");
		int id = sc.nextInt();
		cImp1.deleteCrime(id, crime);
	}
//
	public static String adminUpdateCrime(Scanner sc, Map<Integer, Crime> crime, CrimeImp cImp1)
			throws InvalidDataException, CrimeNotFoundException {
		String str = null;
		System.out.println("please enter the Crime Id which is to be updated");
		int id = sc.nextInt();
		System.out.println("please enter the crime details");

		System.out.println("Enter the Crime Type ( Robbery, Theft, Homicide)");
		String type = sc.next();
		sc.nextLine();
		System.out.println("Enter the description of the crime");
		String desc = sc.nextLine();
		System.out.println("Enter the Police Station Area");
		String psArea = sc.nextLine();
		System.out.println("Enter Crime date in format yyyy-MM-dd: ");
		String inputDate = sc.nextLine();
		LocalDate date = LocalDate.parse(inputDate);
		System.out.println("Enter the name of the Victim");
		String name = sc.nextLine();

		Crime c = new Crime(id, type, desc, psArea, date, name);

		str = cImp1.updateCrime(id, c, crime);// considering all details are valid

		return str;
	}
	
	public static String adminAddCriminal(Scanner sc, Map<Integer, Criminal> criminal, CriminalIm crim) throws InvalidDataException, CrimeNotFoundException {
		String str = null;
		
//		System.out.println("please enter the Criminal Id which is to be updated");
//		int id = sc.nextInt();
		System.out.println("please enter the criminal details");

		System.out.println("Enter the Criminal Name");
		String name = sc.next();
		sc.nextLine();
		System.out.println("Enter Crime date in format yyyy-MM-dd: ");
		String DOB = sc.nextLine();
		LocalDate date = LocalDate.parse(DOB);
		System.out.println("Enter the gender of Criminal");
		String gender = sc.nextLine();
		System.out.println("Enter the identifying marks");
		String idenMarks = sc.nextLine();
		System.out.println("Enter First arrest date in format yyyy-MM-dd: ");
		String arrestDate = sc.nextLine();
		LocalDate aDate = LocalDate.parse(arrestDate);
		System.out.println("Enter the arrested Police Area");
		String psArea = sc.nextLine();

		Criminal cr = new Criminal(IDGeneration.generateId(), name, date, gender, idenMarks, aDate,psArea);

		str = crim.addCriminals( cr, criminal);// considering all details are valid

		
		return str;
	}
//
//	public static void adminViewAllCustomers(Map<String, Customer> customers, CustomerService cusService)
//			throws ProductException {
//		List<Customer> list = cusService.viewAllCustomers(customers);
//
//		for (Customer c : list) {
//			System.out.println(c);
//		}
//	}
//
//	public static void adminViewAllTransactions(List<Transaction> transactions, TransactionService trnsactionService)
//			throws TransactionException {
//		List<Transaction> allTransactions = trnsactionService.viewAllTransactions(transactions);
//
//		for (Transaction tr : allTransactions) {
//			System.out.println(tr);
//		}
//
//	}

}