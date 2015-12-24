/**
 * Created by Damian on 2015-12-24.
 */
public class DistributedModuleTextFactory implements DistributedModuleFactory{

    private String txt;

    public DistributedModuleTextFactory(String textToForFactory) {
        txt = textToForFactory;
    }

    @Override
    public Exporter CreateExporter() {
        return new TextExporter(txt);
    }

    @Override
    public Data CreateData() {
        return new TextData(txt);
    }

    @Override
    public Importer CreateImporter() {
        return new TextImporter();
    }
}
