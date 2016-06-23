package ${package};

import java.util.Collection;

import ${package}.module.${pluginName}Module;
import ${package}.rest.${pluginName}RestAction;
import ${package}.service.${pluginName}Service;
import org.elasticsearch.common.component.LifecycleComponent;
import org.elasticsearch.common.inject.Module;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.rest.RestModule;

import com.google.common.collect.Lists;

public class ${pluginName}Plugin extends Plugin {
    @Override
    public String name() {
        return "${pluginName}Plugin";
    }

    @Override
    public String description() {
        return "This is a ${artifactId} plugin.";
    }

    public void onModule(final RestModule module) {
        module.addRestAction(${pluginName}RestAction.class);
    }

    @Override
    public Collection<Module> nodeModules() {
        final Collection<Module> modules = Lists.newArrayList();
        modules.add(new ${pluginName}Module());
        return modules;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Collection<Class<? extends LifecycleComponent>> nodeServices() {
        final Collection<Class<? extends LifecycleComponent>> services = Lists.newArrayList();
        services.add(${pluginName}Service.class);
        return services;
    }
}
