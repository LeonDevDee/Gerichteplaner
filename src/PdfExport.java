import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PdfExport
{
    Document document;
    String path;
    public PdfExport(String path){
        this.path = path;
        document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(path));
            document.open();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public void addHeading(){
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDateTime localDateTime = LocalDateTime.now();
            Paragraph p1 = new Paragraph(new Chunk(
                    "Gerichtsplan - " + dateTimeFormatter.format(localDateTime),
                    FontFactory.getFont(FontFactory.HELVETICA, 22)));
            document.add(p1);

            Paragraph p2 = new Paragraph(new Chunk(
                    "erstellt mit 'Gerichtsplaner' von Leon Wehrwein",
                    FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 10)));
            document.add(p2);

        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        }

    }

    public void addWoche(int wochenID, String Mo, String Di, String Mi, String Do, String Fr, String Sa, String So){
        try {
            Paragraph p1 = new Paragraph(new Chunk(
                    "Woche " + (wochenID + 1),
                    FontFactory.getFont(FontFactory.HELVETICA, 18)));
            document.add(p1);

            Paragraph p2 = new Paragraph(new Chunk(
                    "Montag : " + Mo + "\n" +
                            "Dienstag : " + Di + "\n" +
                            "Mittwoch : " + Mi + "\n" +
                            "Donnerstag : " + Do + "\n" +
                            "Freitag : " + Fr + "\n" +
                            "Samstag : " + Sa + "\n" +
                            "Sonntag : " + So
                    ,
                    FontFactory.getFont(FontFactory.HELVETICA, 12)));
            document.add(p2);

        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        }


    }

    public void close(){
        document.close();
    }

}
