package com.criticalsoftware.controller;

import com.criticalsoftware.model.Jogador;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static sun.security.krb5.Confounder.intValue;

public class JogadorImpl {
    public boolean verificarArquivoExiste(Path caminho){
        boolean ret = false;
        try {
            Stream<Path> stream = Files.list(caminho);
            Optional<Path> arq = stream.filter(p -> p.toString().endsWith("jogadores.txt")).findAny();
            ret = arq.isPresent(); //informa se o arquivo está presente
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return ret;
    }

    public List<Jogador> getListaDeJogadores(Path caminho) throws IOException {
        Stream<String> linhas = Files.lines(caminho, StandardCharsets.ISO_8859_1);
        List<String> listaDeLinhas = linhas.collect(Collectors.toList());
        List<Jogador> listaDeJogadores = new ArrayList<>();
        Jogador jogador;
        Iterator it = listaDeLinhas.listIterator();
        String str = null;
        while (it.hasNext()) {
            str = (String) it.next();
            String info[]  = str.split(",");

            jogador = new Jogador();

            jogador.setNome(info[0]);

            jogador.setPosicao(info[1]);

            jogador.setIdade(Integer.parseInt(info[2]));

            jogador.setTimeAtual(info[3]);

            jogador.setGolsMarcados(Integer.parseInt(info[4]));
            listaDeJogadores.add(jogador);
        }
        return listaDeJogadores;
    }
    public void imprimirJogadores(List<Jogador> jogadores) {
        jogadores.stream().forEach(System.out::println);
    }
    public void imprimirJogadoresTime(List<Jogador> jogadores, String time) {
        jogadores.stream().filter(jogador -> jogador.getTimeAtual().equals(time)).forEach(System.out::println);
    }
    public void imprimirJogadoresTimeGols(List<Jogador> jogadores, String time) {
        jogadores.stream().filter(jogador -> jogador.getTimeAtual().equals(time) && jogador.getGolsMarcados() > 10).
                forEach(System.out::println);
    }
    public void agruparJogadoresPorTime (List<Jogador> jogadores) {
        jogadores.stream().sorted(Comparator.comparing(Jogador::getTimeAtual)).forEach(System.out::println);
    }
    public void calcularMediaIdade (List<Jogador> jogadores){
        double media =  jogadores.stream().mapToInt(Jogador::getIdade).average().getAsDouble();
        System.out.println("Media de idades = " + (int) media );
    }
    public void imprimirJogadorMaisVelho(List<Jogador> jogadores) {
        Jogador jogador = jogadores.stream().max(Comparator.comparingInt(Jogador::getIdade)).get();
        System.out.println("Jogador mais velho: " + jogador.getNome());
    }
    public void imprimirJogadorMaisNovo(List<Jogador> jogadores) {
        Jogador jogador = jogadores.stream().min(Comparator.comparingInt(Jogador::getIdade)).get();
// .min((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()))
        System.out.println("Jogador mais novo: " + jogador.getNome());
    }
    public void imprimirJogadorArtilheiro(List<Jogador> jogadores) {
        Jogador jogador = jogadores.stream().max(Comparator.comparingInt(Jogador::getGolsMarcados)).get();

        System.out.println("Jogador Artilheiro: " + jogador.getNome());

    }
    public void imprimirSomatorioGols (List<Jogador> jogadores){
        int soma = jogadores.stream().mapToInt(jogador -> jogador.getGolsMarcados()).sum();

        System.out.println("Somatorio de Golos = " + soma);
    }
    public void agruparJogadoresPeloTime(List<Jogador> jogadores){
        Map<String, List<Jogador>> groupByTime = jogadores.stream().collect(
                Collectors.groupingBy(Jogador::getTimeAtual));
        System.out.println(groupByTime);
    }
    public void ordenarJogadoresGols(List<Jogador> jogadores){
        jogadores.stream().sorted(Comparator.comparingInt(Jogador::getGolsMarcados).
                reversed()).forEach(System.out::println);
    }

    public void jogadoresSub25(List<Jogador> jogadores){
//        List<Jogador> listaJogadores = new ArrayList<>();
        jogadores.stream().filter(jogador -> jogador.getIdade() <=25).forEach(System.out::println);
//        System.out.println("listaJogadores = " + listaJogadores);
    }
}
