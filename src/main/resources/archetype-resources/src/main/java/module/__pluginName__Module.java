package ${package}.module;

import ${package}.service.${pluginName}Service;
import org.elasticsearch.common.inject.AbstractModule;

public class ${pluginName}Module extends AbstractModule {

    @Override
    protected void configure() {
        bind(${pluginName}Service.class).asEagerSingleton();
    }
}
