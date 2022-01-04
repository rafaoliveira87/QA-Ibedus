package com.ibedus;

import br.support.PreProcessing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestingPreProcessing {

    private static PreProcessing preProcess = new PreProcessing();

    @BeforeEach
    public void setUp()
    {
        preProcess = new PreProcessing();
    }

    @Test
    @DisplayName("Se estiver cadastrado c/ HTTPS, " +
            "Entao o pre processamento deve retornar o dominio limpo")
    public void testCaseHTTPS()
    {
        assertEquals("univem.edu.br/",
        preProcess.getPureURL("https://www.univem.edu.br/"));

        assertEquals("unidep.edu.br",
                preProcess.getPureURL("https://www.unidep.edu.br"));

        assertEquals("wyden.com.br/unifavip",
                preProcess.getPureURL("https://wyden.com.br/unifavip"));

    }

    @Test
    @DisplayName("Quando estiver cadastrado com HTTP, " +
            "Entao o pre processamento deve retornar o dominio limpo" )
    public void testCaseHTTP()
    {
        assertEquals("materdei.edu.br",
                preProcess.getPureURL("http://www.materdei.edu.br"));

        assertEquals("uem.br/",
                preProcess.getPureURL("http://www.uem.br/"));

        assertEquals("funortejanauba.com.br",
                preProcess.getPureURL("http://funortejanauba.com.br"));
    }

    @Test
    @DisplayName("Quando estiver cadastrado com www, " +
            "Entao o pre processamento deve retornar o dominio limpo")
    public void testCaseWWW()
    {
        assertEquals("fainc.com.br",
                preProcess.getPureURL(" www.fainc.com.br"));

        assertEquals("unifieo.br",
                preProcess.getPureURL("www.unifieo.br"));

        assertEquals("famesp.com.br",
                preProcess.getPureURL("www.famesp.com.br"));

        assertEquals("faculdadeoboe.edu.br",
                preProcess.getPureURL("www.faculdadeoboe.edu.br"));

        assertEquals("pe.senac.br",
                preProcess.getPureURL("www.pe.senac.br"));

        assertEquals("utfpr.edu.br",
                preProcess.getPureURL("www.utfpr.edu.br"));

        assertEquals("pitagoras.com.br",
                preProcess.getPureURL("www.pitagoras.com.br"));

        assertEquals("utp.br",
                preProcess.getPureURL("www.utp.br"));

        assertEquals("fadergs.edu.br",
                preProcess.getPureURL("www.fadergs.edu.br"));

        assertEquals("unioeste.br",
                preProcess.getPureURL("www.unioeste.br"));

        assertEquals("ufscar.br",
                preProcess.getPureURL("www.ufscar.br"));

        assertEquals("unipar.br/",
                preProcess.getPureURL("www.unipar.br/"));

        assertEquals("faculdadeunica.edu.br",
                preProcess.getPureURL("www.faculdadeunica.edu.br"));
    }

    @Test
    @DisplayName("Quando estiver cadastrado o dominio diretamente, " +
            "Entao o pre processamento deve identificar e retornar o endereco completo")
    public void testCaseDomain()
    {
        assertEquals("educacaosuperior.cnec.br/osorio",
                preProcess.getPureURL("educacaosuperior.cnec.br/osorio"));

        assertEquals("f2j.edu.br/",
                preProcess.getPureURL("f2j.edu.br/"));

        assertEquals("unetri.edu.br",
                preProcess.getPureURL("unetri.edu.br"));
    }

    @Test
    @DisplayName("Quando estiver cadastrado lixo, " +
            "Entao o pre processamento deve retornar uma string null")
    public void testCaseTrash()
    {
        assertNull(preProcess.getPureURL(""));
        assertNull(preProcess.getPureURL(" "));
        assertNull(preProcess.getPureURL("27 - 3207-5554"));
    }

    @Test
    @DisplayName("Quando estiver cadastrado null, " +
            "Entao o pre processamento deve retonar uma string null")
    public void testCaseNull()
    {
        assertNull(preProcess.getPureURL(null));
        assertNull(preProcess.getPureURL("null"));
    }
}
