public class Terreno {
    private int codigo;
    private double base;
    private double altura;
    private double valorMensal;
    private Proprietario proprietario;
    private boolean construcao;

    public Terreno(int codigo, double base, double altura, double valorMensal, Proprietario proprietario, boolean construcao) {
        this.codigo = codigo;
        this.base = base;
        this.altura = altura;
        this.valorMensal = valorMensal;
        this.proprietario = proprietario;
        this.construcao = construcao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public boolean isConstrucao() {
        return construcao;
    }

    public void setConstrucao(boolean construcao) {
        this.construcao = construcao;
    }

    public double calcularArea() {
        return base*altura;
    }

    public String toString() {
        return "Terreno{" + "código=" + codigo +
                ", base=" + base
                + ", altura=" + altura
                + ", valorMensal=" + valorMensal
                + ", proprietario=" + proprietario
                + ", construcao=" + construcao + '}';
    }
}
