package app.adapter.interfaces;

import app.domain.model.testrelated.Test;
import java.io.IOException;


/**
 * interface that will be implemented by the classes responsible for notificating the Client about the disponibility of the results.
 * @author Pedro Rocha <1201382@isep.ipp.pt>
 */
public interface Notification {

    /**
     * Method that will create the text files in order to inform the client
     * @param test
     */
    void notification(Test test) throws IOException;
}
