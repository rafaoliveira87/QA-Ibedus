package com.ibedus;

import br.support.PreProcessing;
import com.ibedus.pojos.University;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
// Teste Eduardo 04/01/2022
public class TestingPreProcessingFromAPI {

    //private static final String SERVICO = new String("https://api.testeib.com.br/api"); //endereço
    private static final String SERVICO = new String("https://api.ibedus.com.br/api");
    private static final String UNIVERSIDADE_STRING = new String("/universidades");
    private static final PreProcessing preProcessingURL = new PreProcessing();


    @ParameterizedTest(name = "#{index} - EndPoint Universidades id ={0}")
    @CsvFileSource(resources = "/TestDataIbedus-thirty.csv") // 30 registers
    //@CsvFileSource(resources = "/TestDataIbedus-5Hundred.csv") // 500 registers
    //@CsvFileSource(resources = "/TestDataIbedus-Tousand.csv") // 1k registers
    //@CsvFileSource(resources = "/TestDataIbedus-Universities.csv") // 4k+ registers
   // @ValueSource(ints = {2345, 678, 2346, 1800, 2300, 567, 978}) // some registers
    //@ValueSource(ints = {2300})

    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    @DisplayName("Quando eu buscar um curso valido pelo endpoint"+
            " Entao a API retorna uma string valida ...")
    public void itHasURL(int idIbedus)
    {
        RestAssured.baseURI = SERVICO+UNIVERSIDADE_STRING;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/"+Integer.toString(idIbedus));
        University university = response.as(University.class);
        // verificar se consigo puxar a serialização somente do campo website ...

        System.out.println("---------------------------------------------------");
        System.out.println("Id:"+university.getID()+" Name:"+university.getName());
        System.out.println("\t Domain: "+university.getWebsite());

        try {
            if (university.getWebsite().equals("null")  ||
                    university.getWebsite().equals("")  ||
                    university.getWebsite().equals(" ") ||
                    university.getWebsite().equals(null)
            ) {
                System.out.println("Null domain");
                fail();
            } else {
                String pureURL = preProcessingURL.getPureURL(university.getWebsite());
                System.out.println("Clean domain: " + pureURL);
                System.out.println("\t Pure domain: " + "\t" + reportComplement(pureURL));
                System.out.println("\t www.:        " + "\t" + reportComplement("www." + pureURL));
                System.out.println("\t https://" + "\t" + reportComplement("https://" + pureURL));
                System.out.println("\t https://www." + "\t" + reportComplement("https://www." + pureURL));
                System.out.println("\t http://" + "\t" + reportComplement("http://" + pureURL));
                System.out.println("\t http://www." + "\t" + reportComplement("http://www." + pureURL));
            }
            System.out.println("---------------------------------------------------");
        }catch (Exception e)
        {
            System.out.println("Null domain");
            fail();
            System.out.println("---------------------------------------------------");
        }
    }

    private String reportComplement(String url)
    {
        try {
            if (validURL(url))
                return "PASS " + url;
            else
                return "FAIL " + url;
        }catch (Exception e)
        {
            return "FAIL " + url;
        }
    }


    private boolean validURL(String urlUniversity)
    {
        RestAssured.baseURI = urlUniversity;
        RequestSpecification httpRequest = RestAssured.given();
        Response webSiteResponse = httpRequest.get();
        if (webSiteResponse.getStatusCode() == 200)
            return true;
        else
            return false;
    }



}
