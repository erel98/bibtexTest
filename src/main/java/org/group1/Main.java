package org.group1;

import org.jbibtex.*;

import java.io.*;

public class Main {

    public final static String dir = System.getProperty("user.dir");

    public static void main(String[] args) throws IOException, ParseException {
        File file1 = new File(
                Main.class.getClassLoader().getResource("java.bib").getFile()
        );

        BibTeXLibrary library1 = BibTeXUtil.parse(file1);

        for (BibTeXObject object : library1.getListEntries()) {
            System.out.println(object.toString());
        }

        BibTeXObject newObject = new BibTeXObject();
        newObject.setType("Article");
        newObject.addField("author", "Erel Öztürk");
        newObject.addField("title", "Bib Test");
        newObject.addField("year", "1998");
        library1.addToLibrary(newObject);

        BibTeXUtil.format(library1, dir);

        BibTeXLibrary newLibrary = new BibTeXLibrary("newTestLibrary.bib");
        BibTeXObject newTestEntry = new BibTeXObject();
        newTestEntry.setType("Article");
        newTestEntry.addField("Author", "Group1");
        newTestEntry.addField("Title", "How to make a bibtex project");

        newLibrary.addToLibrary(newTestEntry);

        BibTeXUtil.format(newLibrary, dir);
    }
}
