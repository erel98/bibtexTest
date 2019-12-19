package org.group1;

import org.jbibtex.*;

import java.io.*;
import java.util.Collection;
import java.util.Map;

public class BibTeXUtil {
    public static BibTeXLibrary parse(File file) throws FileNotFoundException, ParseException {
        Reader reader = new FileReader(file);
        CharacterFilterReader filterReader = new CharacterFilterReader(reader);
        BibTeXParser bibTeXParser = new BibTeXParser(){
            @Override
            public void checkStringResolution(org.jbibtex.Key key, org.jbibtex.BibTeXString string){
            }

            @Override
            public void checkCrossReferenceResolution(org.jbibtex.Key key, org.jbibtex.BibTeXEntry entry){

            }
        };
        BibTeXDatabase database = bibTeXParser.parseFully(filterReader);

        BibTeXLibrary library = new BibTeXLibrary(file.getName());
        Map<Key, BibTeXEntry> entryMap = database.getEntries();

        Collection<BibTeXEntry> entries = entryMap.values();
        for(BibTeXEntry entry : entries) {
            BibTeXObject bibTeXObject = new BibTeXObject();

            Value address = entry.getField(BibTeXEntry.KEY_ADDRESS);
            if(address != null){
                bibTeXObject.addField("address", address.toUserString());
            }

            Value annote = entry.getField(BibTeXEntry.KEY_ANNOTE);
            if(annote != null){
                bibTeXObject.addField("annote", annote.toUserString());
            }

            Value author = entry.getField(BibTeXEntry.KEY_AUTHOR);
            if(author != null){
                bibTeXObject.addField("author", author.toUserString());
            }

            Value booktitle = entry.getField(BibTeXEntry.KEY_BOOKTITLE);
            if(booktitle != null){
                bibTeXObject.addField("booktitle", booktitle.toUserString());
            }

            Value chapter = entry.getField(BibTeXEntry.KEY_CHAPTER);
            if(chapter != null){
                bibTeXObject.addField("chapter", chapter.toUserString());
            }

            Value crossref = entry.getField(BibTeXEntry.KEY_CROSSREF);
            if(crossref != null){
                bibTeXObject.addField("crossref", crossref.toUserString());
            }

            Value doi = entry.getField(BibTeXEntry.KEY_DOI);
            if(doi != null){
                bibTeXObject.addField("doi", doi.toUserString());
            }

            Value edition = entry.getField(BibTeXEntry.KEY_EDITION);
            if(edition != null){
                bibTeXObject.addField("edition", edition.toUserString());
            }

            Value editor = entry.getField(BibTeXEntry.KEY_EDITOR);
            if(editor != null){
                bibTeXObject.addField("editor", editor.toUserString());
            }

            Value eprint = entry.getField(BibTeXEntry.KEY_EPRINT);
            if(eprint != null){
                bibTeXObject.addField("eprint", eprint.toUserString());
            }

            Value howpublished = entry.getField(BibTeXEntry.KEY_HOWPUBLISHED);
            if(howpublished != null){
                bibTeXObject.addField("howpublished", howpublished.toUserString());
            }

            Value institution = entry.getField(BibTeXEntry.KEY_INSTITUTION);
            if(institution != null){
                bibTeXObject.addField("institution", institution.toUserString());
            }

            Value journal = entry.getField(BibTeXEntry.KEY_JOURNAL);
            if(journal != null){
                bibTeXObject.addField("journal", journal.toUserString());
            }

            Value month = entry.getField(BibTeXEntry.KEY_MONTH);
            if(month != null){
                bibTeXObject.addField("month", month.toUserString());
            }

            Value note = entry.getField(BibTeXEntry.KEY_NOTE);
            if(note != null){
                bibTeXObject.addField("note", note.toUserString());
            }

            Value number = entry.getField(BibTeXEntry.KEY_NUMBER);
            if(number != null){
                bibTeXObject.addField("number", number.toUserString());
            }

            Value organization = entry.getField(BibTeXEntry.KEY_ORGANIZATION);
            if(organization != null){
                bibTeXObject.addField("organization", organization.toUserString());
            }

            Value pages = entry.getField(BibTeXEntry.KEY_PAGES);
            if(pages != null){
                bibTeXObject.addField("pages", pages.toUserString());
            }

            Value publisher = entry.getField(BibTeXEntry.KEY_PUBLISHER);
            if(publisher != null){
                bibTeXObject.addField("publisher", publisher.toUserString());
            }

            Value school = entry.getField(BibTeXEntry.KEY_SCHOOL);
            if(school != null){
                bibTeXObject.addField("school", school.toUserString());
            }

            Value series = entry.getField(BibTeXEntry.KEY_SERIES);
            if(series != null){
                bibTeXObject.addField("series", series.toUserString());
            }

            Value title = entry.getField(BibTeXEntry.KEY_TITLE);
            if(title != null){
                bibTeXObject.addField("title", title.toUserString());
            }

            Value url = entry.getField(BibTeXEntry.KEY_URL);
            if(url != null){
                bibTeXObject.addField("url", url.toUserString());
            }

            Value volume = entry.getField(BibTeXEntry.KEY_VOLUME);
            if(volume != null){
                bibTeXObject.addField("volume", volume.toUserString());
            }

            Value year = entry.getField(BibTeXEntry.KEY_YEAR);
            if(year != null){
                bibTeXObject.addField("year", year.toUserString());
            }

            String key = entry.getKey().getValue();
            bibTeXObject.setKey(key);

            String type = entry.getType().getValue();
            bibTeXObject.setType(type);

            library.addToLibrary(bibTeXObject);
        }

        return library;
    }


    public static void format(BibTeXLibrary library, String directory) throws IOException {
        String dirPath = directory + "/new/";
        File newFolder = new File(dirPath);
        if (!newFolder.exists())
            newFolder.mkdir();

        File file = new File(dirPath + library.getName());
        file.createNewFile();

        PrintWriter printWriter = new PrintWriter(file);
        for (BibTeXObject object : library.getListEntries()) {
            printWriter.print("@" + object.getType() + "{");
            if (object.getKey() != null)
                printWriter.print(object.getKey());
            printWriter.print(",");
            printWriter.println();
            Collection<Map.Entry<String, String>> fields = (object.getFields()).entrySet();
            for (Map.Entry<String, String> field : fields) {
                printWriter.println("\t\t" + field.getKey() + " = \"" + field.getValue() + "\",");
            }
            printWriter.println("}\n");
        }

        printWriter.close();
    }

}
