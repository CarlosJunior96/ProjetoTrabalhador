package programa;

import entidades.Departamento;
import entidades.HoraContrato;
import entidades.Trabalhador;
import entidades.enums.NivelTrabalhador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Programa{
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        NivelTrabalhador level;
        Scanner ler = new Scanner(System.in);

        System.out.print("Informe nome do Departamento: ");
        String departamento = ler.nextLine();
        System.out.println("Entre com os dados do Trabalhor");
        System.out.print("Nome: ");
        String nome = ler.nextLine();
        System.out.print("Nível: ");
        String nivel = ler.nextLine();
        System.out.print("Salário base: ");
        double salarioBase = ler.nextDouble();

        //INICIALIZANDO O CONSTRUTOR DO TRABALHADOR
        // ONDE POSSUÍ UM OBJETO ASSOCIADO A ELE(OBJETO DEPARTAMENTO)
        Trabalhador trabalhador = new Trabalhador(nome, NivelTrabalhador.valueOf(nivel), salarioBase, new Departamento(departamento));

        System.out.print("Informe o númerro de contratos vinculados ao Trabalhador: ");
        int n_contratos = ler.nextInt();

        for(int i = 1; i <= n_contratos; i++){
            System.out.println("CONTRATO #" + i);

            System.out.print("Data: ");
            // INSTANCIANDO E ATRIBUINDO A DATA DO CONTRATO A VARIÁVEL DO TIPO DATE
            Date dataContrato = sdf.parse(ler.next());

            System.out.print("Valor por Hora: ");
            double valorHora = ler.nextDouble();
            System.out.print("Duração do Contrato (em Horas): ");
            int horasContrato = ler.nextInt();

            // INSTANCIANDO E INICIALIZANDO O OBJETO CONTRATO COM OS SEUS ATRIBUTOS
            HoraContrato contrato = new HoraContrato(dataContrato, valorHora, horasContrato);

            //VINCULANDO O(S) OBJETO(S) CONTRATO(S) AO OBJETO TRABALHADOR POR MEIO DO MÉTODO NA CLASSE TRABALHADOR
            trabalhador.addContrato(contrato);
        }

        System.out.print("Entre com o mês e o ano para calcular a renda (MM/AAAA): ");
        String mes_ano = ler.next();
        //PEGANDO O MES E CONVERTENDO DE STRING PARA INT
        int mes = Integer.parseInt(mes_ano.substring(0, 2));
        //PEGANDO O ANO E CONVERTENDO DE STRING PARA INT
        int ano = Integer.parseInt(mes_ano.substring(3));

        System.out.print(trabalhador.getNome());
        System.out.print(trabalhador.getDepartamento().getNome());

        //CHAMANDO MÉTODO PARA CALCULO DA RENDA
        System.out.print(trabalhador.renda(ano, mes));

        ler.close();
    }
}
