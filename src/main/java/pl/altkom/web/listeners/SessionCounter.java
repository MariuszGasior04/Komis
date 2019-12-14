package pl.altkom.web.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionCounter implements HttpSessionListener {

    private static int  counter = 0;

    public static int getCounter() {
        return counter;
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        counter++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        counter --;
    }
}

