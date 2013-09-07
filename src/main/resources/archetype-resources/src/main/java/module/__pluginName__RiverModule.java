package ${package}.module;

import ${package}.river.${pluginName}River;
import org.elasticsearch.common.inject.AbstractModule;
import org.elasticsearch.river.River;

public class ${pluginName}RiverModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(River.class).to(${pluginName}River.class).asEagerSingleton();
    }
}
