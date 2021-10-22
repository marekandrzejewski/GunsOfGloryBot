package GunsOfGloryBot.service;

public class CoordData {
    private int coordX;
    private int coordY;


    public int getCoordX() {
        return coordX;
    }

    public CoordData setCoordX(int coordX) {
        this.coordX = coordX;
        return this;
    }

    public int getCoordY() {
        return coordY;
    }

    public CoordData setCoordY(int coordY) {
        this.coordY = coordY;
        return this;
    }

    public CoordData(int coordX, int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    @Override
    public String toString() {
        return "CoordData{" +
                "coordX=" + coordX +
                ", coordY=" + coordY +
                '}';
    }
}
