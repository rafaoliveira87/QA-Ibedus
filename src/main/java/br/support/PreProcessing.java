package br.support;

public class PreProcessing {
    String[] myUrls = null;

    public PreProcessing(String[] myUrls)
    {
        this.myUrls = myUrls;
    }
    public PreProcessing(){this.myUrls = null;}


    public void setUrls()
    {
        for (int i=0; i<myUrls.length; i++)
        {
            System.out.println("Entrada "+myUrls[i]+" saida: "+getPureURL(myUrls[i]));
        }
    }

    public String getPureURL(String urlFromJSON)
    {
        //univem.edu.br " " ""
        String clearURL = null;
        try {
            if (urlFromJSON.contains("www.")) {
                clearURL = urlFromJSON.substring(urlFromJSON.lastIndexOf("www.")+4);
                return clearURL;
            }
            else if (urlFromJSON.startsWith("http://") || urlFromJSON.startsWith("https://"))
            {
                clearURL = urlFromJSON.substring(urlFromJSON.lastIndexOf("://")+3);
                return clearURL;
            }
            else if (urlFromJSON.contains("."))
                return urlFromJSON;
            else
                return null;
              //  myString = urlFromJSON.substring(urlFromJSON.indexOf("."));
        }catch (Exception e)
        {
            clearURL = null;
        }
        return clearURL;
    }


}
