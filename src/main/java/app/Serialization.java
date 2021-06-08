package app;

import app.controller.App;

import java.io.*;

public class Serialization implements Serializable {

    public Serialization(){

    }

    /**
     * Save application data.
     *
     * @param app      the app
     * @param filePath the file path
     */
    public static void saveApp(App app, String filePath) {
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            try {
                outputStream.writeObject(app);
            } finally {
                outputStream.close();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Binary File not found on saving process!");
        } catch (IOException ex) {
            System.out.println("Binary File problems with the input and output save! #1");
            ex.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException ex) {
                System.out.println("Binary File problems with the input and output save! #2");
            }
        }
    }

    /**
     * Load aplication pot data.
     *
     * @param filePath the file path
     * @return the application pot
     */
    public static App loadApp (String filePath){
        App app;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath));
            try {
                app = (App) in.readObject();
            } finally {
                in.close();
            }
            return app;
        } catch (FileNotFoundException ex) {
            System.out.println("Binary File not found on loading process!");
        } catch (IOException ex) {
            System.out.println("Binary File problems with the input and output load!");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("Binary File problems with loading process ( class App not found )!");
        }
        return null;
    }

}
