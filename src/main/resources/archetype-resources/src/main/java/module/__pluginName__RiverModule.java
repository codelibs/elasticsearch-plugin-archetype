package ${package}.module;

import ${package}.river.${pluginName}River;
import org.elasticsearch.common.inject.AbstractModule;

public class ${pluginName}RiverModule extends AbstractModule {
    @Override
    protected void configure() {
        this.bind(${pluginName}River.class).asEagerSingleton();
    }
}
