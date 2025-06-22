public class Terreno {
    private int code;
    private double base;
    private double height;
    private double monthValue;
    private Proprietario owner;
    private boolean construction;

    public Terreno(int code, double base, double height, double monthValue, Proprietario owner, boolean construction) {
        this.code = code;
        this.base = base;
        this.height = height;
        this.monthValue = monthValue;
        this.owner = owner;
        this.construction = construction;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getMonthValue() {
        return monthValue;
    }

    public void setMonthValue(double monthValue) {
        this.monthValue = monthValue;
    }

    public Proprietario getOwner() {
        return owner;
    }

    public void setOwner(Proprietario owner) {
        this.owner = owner;
    }

    public boolean isConstruction() {
        return construction;
    }

    public void setConstruction(boolean construction) {
        this.construction = construction;
    }

    public double calcularArea() {
        return base*height;
    }

    public String toString() {
        return "Terreno{" + "code=" + code +
                ", base=" + base
                + ", height=" + height
                + ", monthValue=" + monthValue
                + ", owner=" + owner
                + ", construction=" + construction + '}';
    }
}
