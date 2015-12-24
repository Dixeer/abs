/**
 * Created by Damian on 2015-12-24.
 */
public class TextExporter implements Exporter {

    private Data data;

    public TextExporter(String textToBeExported){
        data = new TextData(textToBeExported);
    }

    public Data ExportData() {
        if (data == null) {
            return new TextData("");
        }else {
            Data exportedData = data;
            data = null;
            return exportedData;
        }
    }
}