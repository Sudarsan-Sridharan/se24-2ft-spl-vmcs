package sg.edu.nus.iss.vmcs.membership;

/**
 * Created by Administrator on 2017/4/26.
 */
public class Member {
    /**This attribute hold the size of the Member*/
    protected String userName;
    /**This attribute hold the size of the Member*/
    protected String pwd;

    /**
     * This constructor creates an instance of Member object.
     */
    public Member() {
    }

    /**
     * This constructor creates an instance of Member object.
     */
    public Member(String n, String pd) {
        userName = n;
        pwd = pd;
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
}
