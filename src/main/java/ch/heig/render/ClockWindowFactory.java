package ch.heig.render;

public class ClockWindowFactory {

    public static ClockWindow createNum(){
        return new ClockWindow(new ClockCanavasNum());
    }
}
