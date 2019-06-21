package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private String alternateEmail;
	private int mailboxCapacity = 500;
	private int defaultPwLength = 8;
	
	//constructor to receive first name and last name
	public Email(String firstName, String lastName) {
		System.out.print("Welcome to the new employee email registration setup portal..");

		this.firstName = getFirstName();
		this.lastName = getLastName();
		
		//get users department
		this.department = setDepartment();
		
		this.email = this.firstName.toLowerCase() + '.'+ this.lastName.toLowerCase()+"@"+ this.department+".mycompany.com";

		//generate random password for new email account
		this.password = randomPassword(defaultPwLength);

	}
	
	@SuppressWarnings("resource")
	private String getFirstName() {
		System.out.print("\n \n What is the first name of the new employee? ");
		Scanner firstName = new Scanner (System.in);
		String newFirstName = firstName.next();
		return newFirstName;
	}
	@SuppressWarnings("resource")
	private String getLastName() {
		System.out.print("\n What is the last name of the new employee? ");
		Scanner lastName = new Scanner (System.in);
		String newlastName = lastName.next();
		return newlastName;
	}
	
	private String setDepartment() {
		System.out.print("Enter the Department \n 1 for sales \n 2 for development \n 3 for accounting \n 0 for none \n \n Please enter the department code: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if(depChoice == 1) {
			return "Sales";
		} else if(depChoice == 2) {
			return "Development";
		} else if (depChoice == 3) {
			return "Accounting";
		} else {
			return "staff";
		}
	}
	
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
		char [] password = new char[length];
		
		for (int i = 0; i<length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		
		return new String(password);
		
	}
	
	
	
	
	public String ShowInfo() {
		return "EMPLOYEE NAME: " + firstName + " " + lastName +
				"\nCOMPANY EMAIL: " + email +
				"\nCAPACITY: " + mailboxCapacity +"mb" +
				"\nPASSWORD: " + password;
	}


}
