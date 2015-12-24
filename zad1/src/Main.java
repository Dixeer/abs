/**
 * Created by Damian on 2015-12-24.
 */
public class Main {

    static public void TestExporter() {
        String textToBeExported = "Ala ma kota";
        Exporter exporter = new TextExporter(textToBeExported);
        Data exportedData = exporter.ExportData();
        String exportedText = exportedData.Text();

        if (textToBeExported.equals(exportedText)) {
            System.out.println("textToBeExported rowne exportedText");
        }

        exportedData = exporter.ExportData();
        exportedText = exportedData.Text();
        textToBeExported = "";

        if (textToBeExported.equals(exportedText)) {
            System.out.println("textToBeExported rowne exportedText");
        }
    }

    static public void TestImporter() {
        String textToBeImporter = "Ala zgubila dolara";
        Data dataToBeImported = new TextData(textToBeImporter);
        Importer importer = new TextImporter();
        importer.ImportData(dataToBeImported);
        String dataSaveInImporter = importer.ImportedText();

        if (textToBeImporter.equals(dataSaveInImporter)) {
            System.out.println("textToBeImporter rowne dataSaveInImporter");
        }
    }

    static public void TestFactory(){
        final String textToForFactory = "Ali kot zjadl dolara";
        DistributedModuleFactory factory = new DistributedModuleTextFactory(textToForFactory);
        Data dataFromFactory = factory.CreateData();
        String textFromModule = dataFromFactory.Text();

        if(textToForFactory.equals(textFromModule)){
            System.out.println("textToForFactory rowne textFromModule");
        }

        Exporter exporter = factory.CreateExporter();
        textFromModule = exporter.ExportData().Text();

        if(textToForFactory.equals(textFromModule)){
            System.out.println("textToForFactory rowne textFromModule");
        }
        Importer importer = factory.CreateImporter();
    }

    public static void main(String[] args) {
        TestExporter();
        TestImporter();
        TestFactory();
    }
}