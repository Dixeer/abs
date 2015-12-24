/**
 * Created by Damian on 2015-12-24.
 */
public class TextImporter implements Importer {

    private Data data;

    public void ImportData(Data data) {
        this.data = data;
    }

    public String ImportedText() {
        return data.Text();
    }
}
