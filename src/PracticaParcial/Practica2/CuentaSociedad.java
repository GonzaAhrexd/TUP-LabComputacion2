package PracticaParcial.Practica2;

public class CuentaSociedad extends Cuenta{
    private String nombreEmpresa;
    private String tipoEmpresa;

    public CuentaSociedad(int numeroCuenta, float saldo, String nombreEmpresa, String tipoEmpresa) {
        super(numeroCuenta, saldo);
        this.nombreEmpresa = nombreEmpresa;
        this.tipoEmpresa = tipoEmpresa;
    }

    @Override
    void depositar(float cantidad) {
        this.saldo += cantidad;
    }

    @Override
    void retirar(float cantidad) {
        if(cantidad < this.saldo){
            this.saldo  -= cantidad;
        }else{
            System.out.println("No tiene saldo suficiente");
        }
    }

    public void mostrarInformacion(){
        System.out.println("Número de cuenta: "  + this.numeroCuenta);
        System.out.println("Nombre de la Empresa: "  + this.nombreEmpresa);
        System.out.println("Tipo de empresa: "  + this.tipoEmpresa);
        System.out.println("Saldo: " + this.saldo);

    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(String tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }
}
