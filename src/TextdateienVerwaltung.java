import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TextdateienVerwaltung
{
    // Bezugsobjekte

    // Attribute
    String path  = "C:\\Users\\wel\\Documents\\";

    // Konstruktor
    public TextdateienVerwaltung(String filename)
    {
        path = path + filename;
    }
    // Dienste
    public void DateiBeschreiben(List<String> list){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));

            for(int i = 0; i < list.size(); i++){
                String line = list.get(i);
                bw.write(line);
                bw.newLine();
            }

            bw.close();
        }
        catch(IOException exception){
            exception.printStackTrace();
        }
    }

    public List<String> DateiLesen(){
        List<String> list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {


            String line = br.readLine();
            while (line != null) {
                list.add(line);
                line = br.readLine();
            }
            br.close();
        }catch(IOException exception){
            exception.printStackTrace();
        }
        return list;
    }
}
