package app.ui.console.functionalities;

import app.domain.model.testrelated.Test;

import java.io.IOException;

public interface Notification {
    void notification(Test test) throws IOException;
}
