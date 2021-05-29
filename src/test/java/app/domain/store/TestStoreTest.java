package app.domain.store;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestStoreTest {

    @Test(expected = IllegalArgumentException.class)
    public void barcodeValidation1() {
        TestStore testStore = new TestStore();
        String barcode ="    ";

        testStore.barcodeValidation(barcode);

    }

    @Test(expected = IllegalArgumentException.class)
    public void barcodeValidation2() {
        TestStore testStore = new TestStore();
        String barcode ="12345678901234456";

        testStore.barcodeValidation(barcode);

    }

    @Test
    public void getTestByBarcode() {



    }
}