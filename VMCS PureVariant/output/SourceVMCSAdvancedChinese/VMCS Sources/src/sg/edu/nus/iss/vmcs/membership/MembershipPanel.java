package sg.edu.nus.iss.vmcs.membership;

import sg.edu.nus.iss.vmcs.system.SimulatorControlPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author: HieuTranNgoc
 * @since: 27/4/17.
 */
public class MembershipPanel extends Dialog {
    private Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
    private int frameX=0;
    private int frameY=0;
    private int frameWidth=300;
    private int frameHeight=200;
    private int screenWidth=screen.width;
    private int screenHeight=screen.height;

    private static final String TITLE = "Membership Panel";
    private MembershipController memController;

    private Panel pan0=new Panel();
    private Label lblUserName = new Label("User Name: ");
    private Label lblPassword = new Label("Password: ");
    private JTextField txtUserName = new JTextField(10);
    private JTextField txtPassword = new JTextField(10);
    private JButton btnSubmit = new JButton("Submit");

    /**
     * This constructor creates an instance of the Membership Panel&#46;
     *
     * @param fr the parent frame
     * @param ctrl the Membership Controller
     */
    public MembershipPanel(Frame fr, MembershipController ctrl) {
        super(fr, TITLE, false);

        this.memController = ctrl;

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                memController.nullifyMembershipPanel();
            }
        });

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(">>> Submit " + txtUserName.getText() + ", pwd: " + txtPassword.getText());
                memController.enterMembershipDetails(txtUserName.getText(), txtPassword.getText());
            }
        });

        pan0.setLayout(new GridBagLayout());
        pan0.add(lblUserName,new GridBagConstraints(0,0,1,1,1.0,0.0,
                GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,
                new Insets(5,0,0,0),10,0));
        pan0.add(txtUserName,new GridBagConstraints(1,0,1,1,1.0,0.0,
                GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,
                new Insets(5,0,0,0),10,0));
        pan0.add(lblPassword,new GridBagConstraints(0,1,1,1,1.0,0.0,
                GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,
                new Insets(5,0,0,0),10,0));
        pan0.add(txtPassword,new GridBagConstraints(1,1,1,1,1.0,0.0,
                GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,
                new Insets(5,0,0,0),10,0));
        pan0.add(btnSubmit, new GridBagConstraints(0,2,1,1,1.0,0.0,
                GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,
                new Insets(5,0,0,0),10,0));


        setLayout(new BorderLayout());
        add(pan0,BorderLayout.CENTER);

        pack();
        frameWidth=this.getWidth();
        frameHeight=this.getHeight();
        frameX=(screenWidth-frameWidth)/2;
        frameY=(screenHeight-frameHeight)/2;
        setBounds(frameX,frameY,frameWidth, frameHeight);
    }

    /**
     * Display the Customer Panel&#46; This will be achieved by displaying the frame
     * of the panel and then sending messages to its constituent objects
     * instructing them to display themselves.
     */
    public void display() {
        this.setVisible(true);
    }
}
