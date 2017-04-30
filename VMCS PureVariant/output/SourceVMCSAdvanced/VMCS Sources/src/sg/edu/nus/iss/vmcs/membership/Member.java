package sg.edu.nus.iss.vmcs.membership;

/**
 * Created by Administrator on 2017/4/26.
 */
public class Member {
    /**This attribute hold the index of the item inside the list*/
    protected int index;
    /**This attribute hold the unique user name of the Member*/
    protected String userName;
    /**This attribute hold the password of the Member*/
    protected String pwd;
    /**This attribute hold the balance of the Member*/
    protected float balance;

    /**
     * This constructor creates an instance of Member object.
     */
    public Member(String userName, String pwd, String balance) {
        this(0, userName, pwd, balance);
    }
    public Member(int index, String userName, String pwd, float balance) {
        this.index = index;
    	this.userName = userName;
    	this.pwd = pwd;
    	this.balance = balance;
    }
    
    public Member(int index, String userName, String pwd, String balance) {
    	this(index, userName, pwd, Float.parseFloat(balance));
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

    public String getUserName() {
        return userName;
    }

    public String getPwd() {
        return pwd;
    }

    public int getIndex() {
        return index;
    }

    public void setBalance(float balance) {
		this.balance = balance;
	}

    @Override
    public String toString() {
        return "Member{" +
                "index=" + index +
                ", userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", balance=" + balance +
                '}';
    }
}
