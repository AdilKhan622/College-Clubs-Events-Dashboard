package main;

import java.util.*;

public class Router {

    private static final Stack<String> history = new Stack<>();

    public static void goTo(String pageName) {
        if (MainFrame.instance != null) {
            history.push(pageName);
            MainFrame.instance.cardLayout.show(MainFrame.instance.mainPanel, pageName);
        }
    }

    public static void back() {
        if (history.size() <= 1)
            return;

        history.pop();
        String previousPage = history.peek();
        MainFrame.instance.cardLayout.show(MainFrame.instance.mainPanel, previousPage);
    }

    public static String current() {
        return history.isEmpty() ? null : history.peek();
    }
}
