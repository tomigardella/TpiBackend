package com.backend.api_gateway.rutas;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayRutas {


    @Bean
    public RouteLocator configurarRutas(RouteLocatorBuilder builder,
                                    @Value("${api-gateway.url.solicitud-microservice}") String uriSolicitud,
                                    @Value("${api-gateway.url.camiones-microservice}") String uriCamiones,
                                    @Value("${api-gateway.url.rutas-microservice}") String uriRutas
                                    )
    {
        return builder.routes()
                .route(p -> p.path("/solicitud/**").uri(uriSolicitud))
                .route(p -> p.path("/clientes/**").uri(uriSolicitud))
                .route(p -> p.path("/estados/**").uri(uriSolicitud))
                .route(p -> p.path("/tarifas/**").uri(uriSolicitud))
                .route(p -> p.path("/cambios-estado/**").uri(uriSolicitud))
                .route(p -> p.path("/camiones/**").uri(uriCamiones))
                .route(p -> p.path("/transportistas/**").uri(uriCamiones))
                .route(p -> p.path("/rutas/**").uri(uriRutas))
                .route(p -> p.path("/tipos-tramo/**").uri(uriRutas))
                .route(p -> p.path("/estados/**").uri(uriRutas))
                .route(p -> p.path("/tramos/**").uri(uriRutas))
                .build();
    }
}
