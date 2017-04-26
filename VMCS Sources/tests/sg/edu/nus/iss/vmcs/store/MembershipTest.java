package sg.edu.nus.iss.vmcs.store;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sg.edu.nus.iss.vmcs.membership.Member;
import sg.edu.nus.iss.vmcs.membership.MembershipController;
import sg.edu.nus.iss.vmcs.system.MainController;

/**
 * Created by Administrator on 2017/4/26.
 */
public class MembershipTest extends TestCase {
    @Before
    public void setup() throws Exception{
    }

    @After
    public void tearDown() throws Exception{
    }

    @Test
    public void testLogin_1() throws Exception {
        Member mem = new Member("Gao", "123");
        MainController mainCtrl=new MainController("vmcs.properties");
        mainCtrl.initialize();
        MembershipController membershipController=mainCtrl.getMembershipController();
        assert(true == membershipController.Login(mem));
    }

    @Test
    public void testLogin_2() throws Exception {
        Member mem = new Member("Tran", "123");
        MainController mainCtrl=new MainController("vmcs.properties");
        mainCtrl.initialize();
        MembershipController membershipController=mainCtrl.getMembershipController();
        assert(true == membershipController.Login(mem));
    }

    @Test
    public void testLogin_3() throws Exception {
        Member mem = new Member("Wang", "123");
        MainController mainCtrl=new MainController("vmcs.properties");
        mainCtrl.initialize();
        MembershipController membershipController=mainCtrl.getMembershipController();
        assert(true == membershipController.Login(mem));
    }

    @Test
    public void testLogin_4() throws Exception {
        Member mem = new Member("Chen", "123");
        MainController mainCtrl=new MainController("vmcs.properties");
        mainCtrl.initialize();
        MembershipController membershipController=mainCtrl.getMembershipController();
        assert(true == membershipController.Login(mem));
    }
}
