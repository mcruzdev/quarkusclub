package dev.matheuscruz;

import io.quarkus.smallrye.openapi.OpenApiFilter;
import io.quarkus.smallrye.openapi.OpenApiFilter.RunStage;
import org.eclipse.microprofile.openapi.OASFactory;
import org.eclipse.microprofile.openapi.OASFilter;
import org.eclipse.microprofile.openapi.models.OpenAPI;
import org.eclipse.microprofile.openapi.models.Operation;
import org.eclipse.microprofile.openapi.models.info.Info;
import org.jboss.jandex.IndexView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@OpenApiFilter(RunStage.BUILD)
public class CustomOASTwiceFilter implements OASFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomOASTwiceFilter.class);
    private IndexView jandex;

    public CustomOASTwiceFilter(IndexView jandex) {
        this.jandex = jandex;
    }

    @Override
    public void filterOpenAPI(OpenAPI openAPI) {
        LOGGER.info("Executing Twice");
        Info info = OASFactory.createInfo();
        info.contact(OASFactory.createContact().email("email@email.com"));
    }

    @Override
    public Operation filterOperation(Operation operation) {
        return operation.description(operation.getDescription() + " [Additional]");
    }
}
