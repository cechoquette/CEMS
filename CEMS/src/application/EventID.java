package CEMS.src.application;

public final class EventID {
    private Integer id;
    private final static EventID INSTANCE = new EventID();

    private EventID() {}

    public static EventID getInstance() {
        return INSTANCE;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public Integer getID() {
        return this.id;
    }
}
