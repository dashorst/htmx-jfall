package com.martijndashorst;

import java.util.List;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/hxboost")
public class HxBoostPage {
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance page(int pagenr, List<String> speakers, int nrOfPages);
    }

    @Inject
    Conference conference;

    @GET
    public TemplateInstance page() {
        return page(1);
    }

    @GET
    @Path("{pagenr}")
    public TemplateInstance page(@PathParam("pagenr") @DefaultValue("1") int pagenr) {
        var tmp = conference.speakers();
        int pageSize = 7;
        int startIndex = Math.max(0, Math.min((pagenr - 1) * pageSize, tmp.size()));
        int endIndex = Math.max(0, Math.min(pagenr  * pageSize, tmp.size()));
        return Templates.page(pagenr, tmp.subList(startIndex, endIndex), 1 + tmp.size()/pageSize);
    }
}
