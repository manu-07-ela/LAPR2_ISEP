package app.adapter;

import app.domain.model.ExternalModuleBarcode;
import net.sourceforge.barbecue.Barcode;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//public class BarcodeAdapter implements ExternalModuleBarcode {

    /*@Override
    public Barcode getBarcode() throws IOException {
        Properties props = new Properties();
        InputStream in = new FileInputStream("Barcode.properties");
        props.load(in);
        in.close();

        // Reading properties
        props = readPropeties();
        // Getting class name to instantiate
        String classAux = props.getProperty("BarcodeAdapter.Class");
        // Getting class name to instantiate
        Class<?> oClass = Class.forName(classAux);
        PerformanceEvaluator evaluator = (PerformanceEvaluator) oClass.newInstance();
        return evaluator;
    }*/
//}
