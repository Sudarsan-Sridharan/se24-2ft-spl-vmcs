package sg.edu.nus.iss.vmcs.system;

import sg.edu.nus.iss.vmcs.membership.Member;
import sg.edu.nus.iss.vmcs.store.StoreItem;

/**
 * Created by Administrator on 2017/4/26.
 */
public class MembershipLoader extends FilePropertyLoader {
    private static final String NAME_LABEL     = "Name";
    private static final String PWD_LABLE   = "Password";
    private static final String BALANCE_LABEL = "Balance";

    /**
     * This constructor creates an instance of the MembershipLoader object.
     *
     * @param filen the file name of the drink property file.
     */
    public MembershipLoader(String filen) {
        super(filen);
    }

    /**
     * This method reads the data from the hash table and creates a CashStoreItem.
     *
     * @param index the index of the StoreItem.
     * @return StoreItem the store item of the given index.
     */
    public Member getItem(int index) {
        int idx = index + 1;

        String name_1 = new String(NAME_LABEL + idx);
        String value_1 = getValue(name_1);

        String name_2 = new String(PWD_LABLE + idx);
        String value_2 = getValue(name_2);
        
        String name_3 = new String(BALANCE_LABEL + idx);
        String value_3 = getValue(name_3);

        return new Member(value_1,value_2,value_3);
    }

	@Override
	public void setItem(int index, StoreItem item) {
		// TODO Auto-generated method stub
		
	}
}
