package com.revature.exceptions;

//must extend runtime exception
public class UserNotFoundException extends RuntimeException {
	
	//constructor to pass in a message
	//if i decide to add this exception later
	public UserNotFoundException(String message) {
		//calling the supper constructor and passing the message I set
		super(message);
	}
	
}
