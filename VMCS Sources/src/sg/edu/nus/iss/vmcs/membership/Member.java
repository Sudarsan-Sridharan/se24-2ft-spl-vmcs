package sg.edu.nus.iss.vmcs.membership;

/**
 * Created by Administrator on 2017/4/26.
 */
public class Member {
    /**This attribute hold the unique user name of the Member*/
    protected String userName;
    /**This attribute hold the password of the Member*/
    protected String pwd;
    /**This attribute hold the balance of the Member*/
    protected float balance;

    /**
     * This constructor creates an instance of Member object.
     */
    public Member(String userName, String pwd, float balance) {
    	this.userName = userName;
    	this.pwd = pwd;
    	this.balance = balance;
    }
    
    public Member(String userName, String pwd, String balance) {
    	this(userName, pwd, Float.parseFloat(balance));
    }

    /**
     * This constructor creates an instance of Member object.
     */
    public Member(String n, String pd) {
        this(n, pd, 0);
    }

    /**
     * This method sets the name of the Member.
     * @param n the name of the Member.
     */
    public void setName(String n) {
        userName = n;
    }

    /**
     * This method sets the namber of the Member.
     * @param pd the name of the Member.
     */
    public void setPwd(String pd) {
        pwd = pd;
    }

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
    
}
