package main;

public class Router {

    public static MainFrame frame;

    public static void init(MainFrame f) {
        frame = f;
    }

    public static void goTo(String pageName) {
        frame.cardLayout.show(frame.mainPanel, pageName);
    }
}
