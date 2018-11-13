package org.rixon;

import java.awt.*;

public class MouseMover {
    public static void main(String... args) throws Exception {
        int x = 960;
        Robot robot = new Robot();
        while (true) {
            robot.mouseMove(x++,540);
            Thread.sleep(100000);
        }
    }
}