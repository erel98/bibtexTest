package org.group1;

import java.util.ArrayList;
import java.util.List;

public class BibTeXLibrary {
    String name;
    List<BibTeXObject> bibTeXEntries = null;

    public BibTeXLibrary(String name) {
        bibTeXEntries = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addToLibrary(BibTeXObject object) {
        bibTeXEntries.add(object);
    }

    public List<BibTeXObject> getListEntries() {
        return bibTeXEntries;
    }

    public List<BibTeXObject> searchInLibrary(String searchString) {
        List<BibTeXObject> returnList = new ArrayList<>();
//        for (org.fastex.org.group1.BibTeXObject object: bibTeXEntries) {
//            if (object.getAuthor().contains(searchString)) {
//                returnList.add(object);
//            }
//            else if (object.getTitle().contains(searchString)) {
//                returnList.add(object);
//            }
//        }
        return returnList;
    }
}
