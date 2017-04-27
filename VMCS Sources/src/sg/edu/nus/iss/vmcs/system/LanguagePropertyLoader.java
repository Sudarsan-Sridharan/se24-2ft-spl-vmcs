package sg.edu.nus.iss.vmcs.system;

import sg.edu.nus.iss.vmcs.store.DrinksBrand;
import sg.edu.nus.iss.vmcs.store.DrinksStoreItem;
import sg.edu.nus.iss.vmcs.store.StoreItem;

import java.io.*;
import java.util.Properties;

/**
 * Created by wangxuemin on 26/4/17.
 */
public class LanguagePropertyLoader {

    private Properties prop;
    private String fileName;

    /*
    private static final String L_SIMUL_BEGIN  = "L_SIMUL_BEGIN";
    private static final String L_SIMUL_END    = "L_SIMUL_END";
    private static final String L_ACT_MAINTAINER = "L_ACT_MAINTAINER";
    private static final String L_ACT_MACHINERY = "L_ACT_MACHINERY";
    private static final String L_ACT_CUSTOMER = "L_ACT_CUSTOMER";
    */

    public LanguagePropertyLoader(String fileName) {
        this.fileName = fileName;
    }

    public void initialize() throws IOException {
        /*
        prop = new Properties(System.getProperties());
        FileInputStream stream = new FileInputStream(fileName);
        prop.load(stream);
        stream.close();
        */
        prop = new Properties();
        //InputStream inputStream = this.getClass().getResourceAsStream("fileName");
        FileInputStream inputStream = new FileInputStream(fileName);
        BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
        prop.load(bf);
        inputStream.close();
        //System.out.println(properties.getProperty("a"));
    }

    public void saveProperty() throws IOException {
        FileOutputStream stream = new FileOutputStream(fileName);
        prop.store(stream, "");
        stream.close();
    }

    public String getValue(String key) {
        return prop.getProperty(key);
    }

    public void setValue(String key, String value) {
        prop.setProperty(key, value);
    }

/*
    public StoreItem getItem(int index) {
        int idx = index + 1;
        DrinksBrand brand = new DrinksBrand();

        String name = new String(NAME_LABEL + idx);
        String value = getValue(name);
        brand.setName(value);

        name = new String(PRICE_LABEL + idx);
        value = getValue(name);
        brand.setPrice(Integer.parseInt(value));

        name = new String(QUANTITY_LABEL + idx);
        value = getValue(name);
        int qty = Integer.parseInt(value);

        DrinksStoreItem item = new DrinksStoreItem(brand, qty);
        return item;

    }
    */

    /**
     * This method updates the hash table with the data from the DrinkStoreItem.
     * @param index the index of the store item.
     * @param drinksItem the store item of the given index.
     */
    /*
    public void setItem(int index, StoreItem drinksItem) {
        int idx = index + 1;

        DrinksStoreItem item = (DrinksStoreItem) drinksItem;
        DrinksBrand brand = (DrinksBrand) item.getContent();
        String itn = new String(NAME_LABEL + idx);
        setValue(itn, brand.getName());

        itn = new String(PRICE_LABEL + idx);
        setValue(itn, String.valueOf(brand.getPrice()));

        itn = new String(QUANTITY_LABEL + idx);
        setValue(itn, String.valueOf(item.getQuantity()));

    }
    */

}
