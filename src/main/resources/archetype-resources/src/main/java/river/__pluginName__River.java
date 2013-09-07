package ${package}.river;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.river.AbstractRiverComponent;
import org.elasticsearch.river.River;
import org.elasticsearch.river.RiverName;
import org.elasticsearch.river.RiverSettings;

public class ${pluginName}River extends AbstractRiverComponent implements River {
    private final Client client;

    private ${pluginName}RiverLogic riverLogic;

    @Inject
    public ${pluginName}River(final RiverName riverName, final RiverSettings settings,
            final Client client) {
        super(riverName, settings);
        this.client = client;

        logger.info("CREATE ${pluginName}River");

        // TODO Your code..

    }

    @Override
    public void start() {
        logger.info("START ${pluginName}River");

        riverLogic = new ${pluginName}RiverLogic();
        new Thread(riverLogic).start();
    }

    @Override
    public void close() {
        logger.info("CLOSE ${pluginName}River");

        // TODO Your code..
    }

    private class ${pluginName}RiverLogic implements Runnable {

        @Override
        public void run() {
            logger.info("START ${pluginName}RiverLogic: " + client.toString());

            // TODO Your code..
        }
    }
}
