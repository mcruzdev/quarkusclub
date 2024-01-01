package dev.matheuscruz;

import java.net.URI;
import java.util.UUID;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.matheuscruz.quarkusclub.extension.runtime.SimpleMessager;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/packages")
public class PackageResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(PackageResource.class);

    @Inject
    SimpleMessager simpleMessager;

    @POST
    @Operation(summary = "Quarkus Club API", description = "Create package")
    public Response create(final CreatePackageRequest request) {
        // LogHandler
        LOGGER.info("creating package");

        // Created by the extension
        simpleMessager.send();

        return Response.created(URI.create("/packages/" + UUID.randomUUID())).build();
    }
}
