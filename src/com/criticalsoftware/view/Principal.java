package com.criticalsoftware.view;

import com.criticalsoftware.controller.JogadorImpl;
import com.criticalsoftware.model.Jogador;

import java.nio.file.Paths;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Principal p = new Principal();
        JogadorImpl jogImpl = new JogadorImpl();
        String enderecoDir = "C:\\Users\\nmmarques\\Desktop";
        String nomeArquivo = "jogadores.txt";
        try {
            List<Jogador> listaDeJogadores = jogImpl.getListaDeJogadores(Paths.get(enderecoDir + "\\" + nomeArquivo));


            if (!jogImpl.verificarArquivoExiste(Paths.get(enderecoDir))) {
                System.out.println("Arquivo não encontrado");
            } else {

                jogImpl.imprimirJogadores(listaDeJogadores);

                jogImpl.imprimirJogadoresTime(listaDeJogadores,"Touriz");

                jogImpl.imprimirJogadoresTimeGols(listaDeJogadores, "Lagos");

                jogImpl.agruparJogadoresPorTime(listaDeJogadores);

                jogImpl.calcularMediaIdade(listaDeJogadores);

                jogImpl.imprimirJogadorMaisVelho(listaDeJogadores);

               jogImpl.imprimirJogadorMaisNovo(listaDeJogadores);

                jogImpl.imprimirJogadorArtilheiro(listaDeJogadores);

                jogImpl.imprimirSomatorioGols(listaDeJogadores);

                jogImpl.agruparJogadoresPeloTime(listaDeJogadores);

                jogImpl.ordenarJogadoresGols(listaDeJogadores);

                jogImpl.imprimirJogadoresTimeGols(listaDeJogadores, "lagos");

                jogImpl.jogadoresSub25(listaDeJogadores);

            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
