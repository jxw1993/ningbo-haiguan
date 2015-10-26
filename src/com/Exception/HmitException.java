package com.Exception;

public class HmitException extends Exception {

	//private String errMsg;

	public HmitException(String errMsg) {
		super(errMsg);
		//this.errMsg = errMsg;
	}

	@Override
	public StackTraceElement[] getStackTrace() {
		// TODO Auto-generated method stub
		return super.getStackTrace();
		
	}

	@Override
	public String getLocalizedMessage() {
		// TODO Auto-generated method stub
		return super.getLocalizedMessage();
	}

	@Override
	public Throwable getCause() {
		// TODO Auto-generated method stub
		return super.getCause();
	}

	@Override
	public void setStackTrace(StackTraceElement[] stackTrace) {
		// TODO Auto-generated method stub
		super.setStackTrace(stackTrace);
	}
}
