package atlasgen;

import java.util.List;

/**
 * Created by manue on 19-06-18.
 */
public class CsvLine {
    List<String> fieldName;
    String[] value;

    public CsvLine(List<String> fieldName, String[] value) {
        this.fieldName = fieldName;
        this.value = value;
    }

    public List<String> getFieldName() {
        return fieldName;
    }

    public void setFieldName(List<String> fieldName) {
        this.fieldName = fieldName;
    }

    public String[] getValue() {
        return value;
    }

    public void setValue(String[] value) {
        this.value = value;
    }
}
