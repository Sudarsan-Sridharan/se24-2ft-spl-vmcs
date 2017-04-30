package sg.edu.nus.iss.vmcs.membership;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sg.edu.nus.iss.vmcs.customer.TransactionController;

public class PayByMembershipButtonListener implements ActionListener{
	private TransactionController txCtrl;
	private MembershipController mbCtrl;
	
	/**
	 * This constructor creates an instance of the Terminate Button Listener.
	 * @param txCtrl the Transaction Controller.
	 */
	public PayByMembershipButtonListener(TransactionController txCtrl){
		this.txCtrl=txCtrl;
		this.mbCtrl=txCtrl.getMainController().getMembershipController();
	}
	
	/**
	 * This method performs actions in response to the terminate button being pressed.
	 */
	public void actionPerformed(ActionEvent ev){
		System.out.println(">>> Trigger Membership Controller");
		mbCtrl.displayMembershipPanel();
	}
}
