package org.group1;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class BibTeXObject implements Serializable {
    private LinkedHashMap<String, String> fields = null;
    private String type;
    private String key;

    public BibTeXObject() {
        fields = new LinkedHashMap<>();
    }

    public void addField(String key, String value) {
        this.fields.put(key, value);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "org.fastex.org.group1.BibTeXObject{" +
                "fields=" + fields +
                ", type='" + type + '\'' +
                ", key='" + key + '\'' +
                '}';
    }

    public Map<String, String> getFields() {
        return Collections.unmodifiableMap(this.fields);
    }
}