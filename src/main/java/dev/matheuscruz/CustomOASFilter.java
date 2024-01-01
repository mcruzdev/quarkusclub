package dev.matheuscruz;

import io.quarkus.smallrye.openapi.OpenApiFilter;
import io.quarkus.smallrye.openapi.OpenApiFilter.RunStage;
import org.eclipse.microprofile.openapi.OASFilter;
import org.eclipse.microprofile.openapi.models.Operation;
import org.jboss.jandex.IndexView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@OpenApiFilter(RunStage.BUILD)
public class CustomOASFilter implements OASFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomOASFilter.class);
    private IndexView jandex;

    public CustomOASFilter(IndexView jandex) {
        this.jandex = jandex;
    }


    @Override
    public Operation filterOperation(Operation operation) {
        return operation.description(operation.getDescription() + " [Additional]");
    }
}
