import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]){
        TextdateienVerwaltung textdateienVerwaltung = new TextdateienVerwaltung("Gerichte.txt");

        Boolean[] kochtage = kochtageErmitteln(textdateienVerwaltung);
        Gerichtsplaner gerichtsplaner = new Gerichtsplaner(erzeugeGerichte(textdateienVerwaltung),kochtage[0],kochtage[1],kochtage[2],kochtage[3],kochtage[4],kochtage[5],kochtage[6]);
        List<Woche> wochen = gerichtsplaner.getWochen();

        for(int i = 0; i < wochen.size(); i++){
            List<Tag> tage = wochen.get(i).getTage();
            System.out.println("Woche " + i);
            for(int j = 0; j< tage.size(); j++){
                System.out.println(tage.get(j).getTagNr() + ":" + tage.get(j).getGerichtsname());
            }
        }

        PdfExport pdfExport = new PdfExport("Gerichtsplan.pdf");
        pdfExport.addHeading();

        for (int i = 0; i < wochen.size(); i++){
            String GerichtsNameAnTagNr[] ={"-","-","-","-","-","-","-"};
            List<Tag> tage = wochen.get(i).getTage();
            for(int j = 0; j < tage.size(); j++){
                if(tage.get(j).getGerichtsname() != null){
                    GerichtsNameAnTagNr[j] = tage.get(j).getGerichtsname();
                }
            }
            pdfExport.addWoche(i,GerichtsNameAnTagNr[0],GerichtsNameAnTagNr[1],GerichtsNameAnTagNr[2],
                    GerichtsNameAnTagNr[3], GerichtsNameAnTagNr[4], GerichtsNameAnTagNr[5],
                    GerichtsNameAnTagNr[6]);
        }

        pdfExport.close();

    }

    public static Boolean[] kochtageErmitteln(TextdateienVerwaltung tv){
        Boolean[] b = {false, false, false, false, false, false, false};
        String kochtageRaw = tv.dateiLesen().get(0);
        String[] kochtage = kochtageRaw.split(",");
        for(int i = 0; i < kochtage.length; i++){
            switch (kochtage[i]){
                case "Mo":
                    b[0] = true;
                    break;
                case "Di":
                    b[1] = true;
                    break;
                case "Mi":
                    b[2] = true;
                    break;
                case "Do":
                    b[3] = true;
                    break;
                case "Fr":
                    b[4] = true;
                    break;
                case "Sa":
                    b[5] = true;
                    break;
                case "So":
                    b[6] = true;
                    break;
            }
        }
        return b;
    }


    public static List<Gericht> erzeugeGerichte(TextdateienVerwaltung tv){
        List<Gericht> gerichte = new ArrayList<>();

        List<String> gerichteRaw = tv.dateiLesen();
        for(int i = 1; i < gerichteRaw.size(); i++){
            String gerichtRaw = gerichteRaw.get(i);
            String[] gerichtArray = gerichtRaw.split(",");
            String name = gerichtArray[0];
            int dauer = Integer.parseInt(gerichtArray[1]);
            boolean montag, dienstag, mittwoch, donnerstag, freitag, samstag, sonntag;
            montag = dienstag = mittwoch = donnerstag = freitag = samstag = sonntag = false;

            for(int j = 0 ; j + 2< gerichtArray.length; j++){
                switch (gerichtArray[j + 2]){
                    case "Mo":
                        montag = true;
                        break;
                    case "Di":
                        dienstag = true;
                        break;
                    case "Mi":
                        mittwoch = true;
                        break;
                    case "Do":
                        donnerstag = true;
                        break;
                    case "Fr":
                        freitag = true;
                        break;
                    case "Sa":
                        samstag = true;
                        break;
                    case "So":
                        sonntag = true;
                        break;
                }
            }

            gerichte.add(new Gericht(name, dauer, montag, dienstag, mittwoch, donnerstag, freitag, samstag, sonntag));

        }

        return gerichte;
    }
}
