package com.cg.capbook.exceptions;
@SuppressWarnings("serial")
public class FriendshipAlreadyExistException extends Exception {
	public FriendshipAlreadyExistException() {
		super();
	}
	public FriendshipAlreadyExistException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}
	public FriendshipAlreadyExistException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	public FriendshipAlreadyExistException(String arg0) {
		super(arg0);
	}
	public FriendshipAlreadyExistException(Throwable arg0) {
		super(arg0);
	}
}
