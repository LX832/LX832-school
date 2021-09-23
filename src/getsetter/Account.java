package getsetter;

public class Account {
	String accountnumber;//자동 초기화, null =>
	String accountname;//null =>
	int initValue;

	public Account(String accountnumber, String accountname, int initValue) {
		this.accountnumber = accountnumber;
		this.accountname = accountname;
		this.initValue = initValue;
	}

	// getter & setter setting
	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getAccountname() {
		return accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public int getInitValue() {
		return initValue;
	}

	public void setInitValue(int initValue) {
		this.initValue = initValue;
	}



	
	
}
