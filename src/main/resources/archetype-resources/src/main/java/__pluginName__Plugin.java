package ${package};

import java.util.Collection;

import ${package}.module.${pluginName}Module;
import ${package}.module.${pluginName}RiverModule;
import ${package}.rest.${pluginName}RestAction;
import ${package}.service.${pluginName}Service;
import org.elasticsearch.common.collect.Lists;
import org.elasticsearch.common.component.LifecycleComponent;
import org.elasticsearch.common.inject.Module;
import org.elasticsearch.plugins.AbstractPlugin;
import org.elasticsearch.rest.RestModule;
import org.elasticsearch.river.RiversModule;

public class ${pluginName}Plugin extends AbstractPlugin {
    @Override
    public String name() {
        return "${pluginName}Plugin";
    }

    @Override
    public String description() {
        return "This is a ${artifactId} plugin.";
    }

    // for Rest API
    public void onModule(final RestModule module) {
        module.addRestAction(${pluginName}RestAction.class);
    }

    // for River
    public void onModule(final RiversModule module) {
        module.registerRiver("${artifactId}", ${pluginName}RiverModule.class);
    }

    // for Service
    @Override
    public Collection<Class<? extends Module>> modules() {
        final Collection<Class<? extends Module>> modules = Lists
                .newArrayList();
        modules.add(${pluginName}Module.class);
        return modules;
    }

    // for Service
    @SuppressWarnings("rawtypes")
    @Override
    public Collection<Class<? extends LifecycleComponent>> services() {
        final Collection<Class<? extends LifecycleComponent>> services = Lists
                .newArrayList();
        services.add(${pluginName}Service.class);
        return services;
    }
}
