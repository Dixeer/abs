/**
 * Created by Damian on 2015-12-24.
 */
public interface DistributedModuleFactory {
    Data CreateData();
    Importer CreateImporter();
    Exporter CreateExporter();
}

