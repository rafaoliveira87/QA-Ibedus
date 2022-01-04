package br.main;

import br.support.PreProcessing;

public class Main {

    public static void main (String args[])
    {
        String[] urls = {"",
        "www.novomilenio.br",
        "27 - 3207-5554",
        "www.fucape.br",
        "www.uninassau.edu.br",
        "www.fan.com.br",
        "http://funortejanauba.com.br",
        "null",
                " ",
                "www.unidom.com.br",
        "https://www.univem.edu.br/" };
        System.out.println("Meu pre processamento ... ");

        PreProcessing processing = new PreProcessing(urls);
        processing.setUrls();
    }


}
