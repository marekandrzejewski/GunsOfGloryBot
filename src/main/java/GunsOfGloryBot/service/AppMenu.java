package GunsOfGloryBot.service;

public class AppMenu {
    int id;
    Thread name;

    public AppMenu(int id, Thread name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Thread getName() {
        return name;
    }
}
