package sg.edu.nus.iss.vmcs.membership;

import sg.edu.nus.iss.vmcs.customer.CustomerPanel;
import sg.edu.nus.iss.vmcs.customer.TransactionController;
import sg.edu.nus.iss.vmcs.system.MembershipLoader;
import sg.edu.nus.iss.vmcs.system.SimulatorControlPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Administrator on 2017/4/26.
 */
public class MembershipController {
    private TransactionController txCtrl;
    private MembershipLoader mloader;
    private MembershipPanel memPanel;
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
           if (mloader.getItem(i).userName.equals(member.userName) &&
                    mloader.getItem(i).pwd.equals(member.pwd) ) {
               this.logged = true;
               return true;
           }
        }
        return false;
    }
    /**
     * This method is to display Membership panel
     */
    public void displayMembershipPanel() {
        SimulatorControlPanel scp = txCtrl.getMainController().getSimulatorControlPanel();
        memPanel = new MembershipPanel((Frame) scp, this);
        memPanel.display();
    }

    /**
     * This method is to check membership password is correct or not
     */
    public void logout() {
        this.logged = false;
    }

    public void nullifyMembershipPanel() {
        memPanel.dispose();
        memPanel = null;
    }

    /**
     * This method check if membership details is corrected and update
     */
    public void enterMembershipDetails(String username, String password) {
        int numOfItems = mloader.getNumOfItems();
        Member member = null;
        for (int i = 0; i < numOfItems; i++) {
            Member m = mloader.getItem(i);
            if (username.equals(m.getUserName()) && password.equals(m.getPwd())) {
                member = m;
            }
        }
        if (member != null) {
            System.out.println(">>> Found Member: " + member.toString());
            nullifyMembershipPanel();
            float balance = member.getBalance();
            //Price in Dollar
            float price = (float)(txCtrl.getPrice()) / 100;
            if (balance < price) {
                System.out.println(">>> Your balance is less than selected price " + price);
                JOptionPane.showMessageDialog(null, "Your balance of $" + balance + " is less than selected price $" + price);
            } else {
                member.setBalance(balance - price);
                txCtrl.completeTransaction();
                System.out.println(">>> Complete transaction, balance: " + member.getBalance());
                JOptionPane.showMessageDialog(null, "Payment Completed! $" + price + " is successfully deducted from your balance. \nNew Balance: $" + member.getBalance());
                mloader.setMember(member);
                try {
                    mloader.saveProperty();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println(">>> Cannot found member with username and password");
            JOptionPane.showMessageDialog(null, "Cannot found member with username and password");
        }

    }


}
