package com.martijndashorst;

import java.util.List;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hxindicator")
public class HxIndicatorPage {
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance page(List<String> speakers);
        public static native TemplateInstance page$speakers(List<String> speakers);
    }

    @Inject
    Conference conference;

    @GET
    public TemplateInstance page() {
        var tmp = conference.randomSpeakers(7);
        return Templates.page(tmp);
    }

    @GET
    @Path("/speakers")
    public TemplateInstance speakers() {
        var tmp = conference.randomSpeakers(7);
        try {
            Thread.sleep(4_000);
        } catch (InterruptedException e) {
        }
        return Templates.page$speakers(tmp);
    }
}
