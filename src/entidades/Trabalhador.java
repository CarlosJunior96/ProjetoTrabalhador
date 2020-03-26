package entidades;

import entidades.enums.NivelTrabalhador;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Trabalhador {
    private String nome;
    private NivelTrabalhador nivel;
    private Double salarioBase;

    // INÍCIO ASSOCIAÇÕES
    private Departamento departamento;
    // INICIALIZANDO A LISTA ELA NÃO DEVE SER INICIALIZADA NO CONSTRUTOR
    private List<HoraContrato> contratos = new ArrayList<>();
    // FIM DAS ASSOCIAÇÕES

    public Trabalhador(){
    }

    // FAZENDO INICIALIZAÇÃO DO MEUS ATRIBUTOS PARA A CLASSE TRABALHADOR
    public Trabalhador(String nome, NivelTrabalhador nivel, Double salarioBase, Departamento departamento){
        this.nome = nome;
        this.nivel = nivel;
        this.salarioBase = salarioBase;
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NivelTrabalhador getNivel() {
        return nivel;
    }

    public void setNivel(NivelTrabalhador nivel) {
        this.nivel = nivel;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<HoraContrato> getContratos() {
        return contratos;
    }

    //MÉTODOS DA CLASSE

    public void addContrato(HoraContrato contrato){

        contratos.add(contrato);
    }

    public void removerContrato(HoraContrato contrato){

        contratos.remove(contrato);
    }

    public double renda(int ano, int mes){
        //INSTANCIANDO O OBJETO CALENDÁRIO
        double soma = salarioBase;
        Calendar calendario = Calendar.getInstance();

        for (HoraContrato c : contratos){
            // DEFININDO A DATA DO CONTRATO COMO SENDO A DATA DO CALENDÁRIO
            calendario.setTime(c.getData());
            int anoF = calendario.get(Calendar.YEAR);
            int mesF = 1 + calendario.get(Calendar.MONTH);
            if (ano == anoF && mes == mesF){
                soma = soma + c.valorTotal();
            }
        }
        return soma;
    }
}
