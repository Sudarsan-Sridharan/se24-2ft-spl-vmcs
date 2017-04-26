package sg.edu.nus.iss.vmcs.membership;

import sg.edu.nus.iss.vmcs.customer.TransactionController;
import sg.edu.nus.iss.vmcs.system.MembershipLoader;

/**
 * Created by Administrator on 2017/4/26.
 */
public class MembershipController {
    private TransactionController txCtrl;
    private MembershipLoader mloader;
    private boolean logged;
    /**
     * This constructor creates an instance of the object.
     * @param txCtrl the membership Controller
     */
    public MembershipController(TransactionController txCtrl, MembershipLoader memloader){
        this.txCtrl=txCtrl;
        this.mloader = memloader;
    }

    /**
     * This method is to check membership password is correct or not
     */
    public boolean Login(Member member) {
        int memberSize = mloader.getNumOfItems();
        for(int i=0;i<memberSize;i++) {
           if (mloader.getItem(i).userName == member.userName &&
                    mloader.getItem(i).pwd == member.pwd) {
               this.logged = true;
               return true;
           }
        }
        return false;
    }
    /**
     * This method is to display login panel
     */
    public void displayLoginPanel() {

    }

    /**
     * This method is to check membership password is correct or not
     */
    public void logout() {
        this.logged = false;
    }



}
