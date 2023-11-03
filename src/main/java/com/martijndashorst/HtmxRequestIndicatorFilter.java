package com.martijndashorst;

import java.io.IOException;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

@Provider
public class HtmxRequestIndicatorFilter implements ContainerResponseFilter {
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
            throws IOException {
        var isHtmx = "true".equalsIgnoreCase(requestContext.getHeaderString("HX-Request"));
        if (isHtmx) {
            var response = responseContext.getEntity();
            var color = isHtmx ? "danger" : "info";
            var label = isHtmx ? "HTMX" : "HTTP";

            var badge = String.format("<span class='badge text-bg-%s' hx-swap-oob='outerHTML:#htmx'>%s</span>", color,
                    label);

            responseContext.setEntity(response + "\n"
                    + badge);
        }
    }
}
