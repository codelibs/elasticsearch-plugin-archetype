package ${package}.service;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.common.component.AbstractLifecycleComponent;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;

public class ${pluginName}Service extends AbstractLifecycleComponent<${pluginName}Service> {

    @Inject
    public ${pluginName}Service(final Settings settings) {
        super(settings);
        logger.info("CREATE ${pluginName}Service");

        // TODO Your code..
    }

    @Override
    protected void doStart() throws ElasticsearchException {
        logger.info("START ${pluginName}Service");

        // TODO Your code..
    }

    @Override
    protected void doStop() throws ElasticsearchException {
        logger.info("STOP ${pluginName}Service");

        // TODO Your code..
    }

    @Override
    protected void doClose() throws ElasticsearchException {
        logger.info("CLOSE ${pluginName}Service");

        // TODO Your code..
    }

}
