package app.adapter;

import net.sourceforge.barbecue.Barcode;

import java.util.Properties;

public class BarcodeAdapter implements ExternalModuleBarcode {

    @Override
    public Barcode getBarcode() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Properties props = new Properties();
        // Getting class name to instantiate
        String classAux = props.getProperty("Controller.BarcodeAdapter.Class");
        // Getting class name to instantiate
        Class<?> oClass = Class.forName(classAux);
        Barcode barcode = (Barcode) oClass.newInstance();
        return barcode;
    }
}
