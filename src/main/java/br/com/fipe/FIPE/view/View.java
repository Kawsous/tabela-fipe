package br.com.fipe.FIPE.view;

import br.com.fipe.FIPE.models.Dados;
import br.com.fipe.FIPE.models.Modelos;
import br.com.fipe.FIPE.models.Veiculos;
import br.com.fipe.FIPE.services.ConverteDados;
import br.com.fipe.FIPE.services.CreateURI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class View {
    CreateURI createURI = new CreateURI();
    ConverteDados converteDados = new ConverteDados();
    Scanner sc = new Scanner(System.in);
    private final String URI_FIXO = "https://parallelum.com.br/fipe/api/v1/";

    public void exibirView() {
        System.out.println("Carros: carros\nMotos: motos\nCaminhões: caminhoes");
        System.out.println("Digite o tipo de veículo: ");
        var opcao = sc.nextLine();
        String endereco;

        if (opcao.toLowerCase().contains("car")) {
            endereco = URI_FIXO + "carros/marcas";
        } else if (opcao.toLowerCase().contains("mot")) {
            endereco = URI_FIXO + "motos/marcas";
        } else {
            endereco = URI_FIXO + "caminhoes/marcas";
        }

        String json = createURI.obterAPI(endereco);
        System.out.println(json);

        //salvando os dados encontrados no marcas
        var marcas = converteDados.obterLista(json, Dados.class);

        //usando o stream no marcas
        marcas.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("Informe o código da marca para consulta: ");
        var codigoMarca = sc.nextLine();

        endereco = endereco + "/" + codigoMarca + "/modelos";
        json = createURI.obterAPI(endereco);

        var modeloLista = converteDados.obterDados(json, Modelos.class);

        System.out.println("Modelos dessa marca:");
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("Digite um trecho do nome a ser buscado: ");

        var nomeVeiculo = sc.nextLine();

        List<Dados> modelosFiltrados = modeloLista.modelos()
                .stream()
                .filter(m -> m.nome().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("\nModelos filtrados: ");
        modelosFiltrados.forEach(System.out::println);

        System.out.println("Digite por favor o codigo do modelo: ");
        var codigoModelo = sc.nextLine();
        endereco = endereco + "/" + codigoModelo + "/anos";
        json = createURI.obterAPI(endereco);
        List<Dados> anos = converteDados.obterLista(json, Dados.class);

        List<Veiculos> veiculos = new ArrayList<>();

        for (int i = 0; i < anos.size(); i++) {
            var enderecoAnos = endereco + "/" + anos.get(i).codigo();
            json = createURI.obterAPI(enderecoAnos);
            Veiculos veiculo = converteDados.obterDados(json, Veiculos.class);
            veiculos.add(veiculo);
        }
        System.out.println("\nTodos os veiculos filtrados:");
        veiculos.forEach(System.out::println);
    }
}
