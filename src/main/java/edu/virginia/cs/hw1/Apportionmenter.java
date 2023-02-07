package edu.virginia.cs.hw1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class Apportionmenter {
    private String datapure = "Delaware, 242234\nVirginia, 32342\nNew Mexico, 34356";
    private HashMap<String, Integer> input = new HashMap<String, Integer>();
    private HashMap<String, Integer> output = new HashMap<String, Integer>();
    private int numRep = 435;
    private int totalpop = 0;
    private String toret = "";
    private double divide = 1;
    private int totalcurrep = 0;
    private double poptorep = 0;
    private int max = 0;
    private String maxkey = "";
    private String tempforinputnum="";
    public Apportionmenter(int numRepin){
        //datapure = inputin;
        numRep = numRepin;
        calc();
    }
    public Apportionmenter() {
        calc();
    }
    private void calc() {
        inputMap();
        caltotal();
        calcinit();
        calcfinal();
    }
    //&& datapure.indexOf("\n") !=-1
    private String inputMap() {
        int temp = 0;
        PopulationReader pr = new PopulationReader();
        try{
            BufferedReader reader = new BufferedReader(pr.getAPIReader());
            String curString;
            while((curString = reader.readLine()) != null) {
                tempforinputnum = curString.substring(curString.indexOf(",")+1);
                if(!tempforinputnum.equals(" Pop")) {
                    input.put(curString.substring(0, curString.indexOf(",")), Integer.parseInt(tempforinputnum));
                }
            }

        }
        catch(IOException ex){
            System.out.println(ex.toString());
            return null;
        }

        input.entrySet().forEach( entry -> {
            toret = toret + entry.getKey() + " : " + entry.getValue() + "\n";
        });
        return toret;
    }

    private void caltotal() {
        input.entrySet().forEach( entry -> {
            totalpop = totalpop + entry.getValue();
        });
    }

    private void calcinit() {
        input.entrySet().forEach( entry -> {
            divide = 1.0*entry.getValue()/totalpop;
            output.put(entry.getKey(), (int)(numRep*divide));
            totalcurrep+=(int)(numRep*divide);
            poptorep = 1.0*totalpop/numRep;
            input.put(entry.getKey(), (entry.getValue() - (int)(output.get(entry.getKey()) *poptorep)));
        });
    }

    private void calcfinal()  {
        System.out.println(totalcurrep);
        for(int i = numRep - totalcurrep; i > 0; i--) {
            input.entrySet().forEach( entry -> {
                if(entry.getValue() > max) {
                    maxkey = entry.getKey();
                    max = entry.getValue();
                }
            });
            input.put(maxkey, 0);
            output.put(maxkey, output.get(maxkey)+1);
            max = 0;
            maxkey = "";
        }
    }
    public void printfinal() {
        output.entrySet().forEach( entry -> {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        });
    }
}

