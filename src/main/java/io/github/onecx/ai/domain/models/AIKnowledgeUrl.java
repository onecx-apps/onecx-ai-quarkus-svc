package io.github.onecx.ai.domain.models;

import static jakarta.persistence.FetchType.LAZY;

import jakarta.persistence.*;

import org.hibernate.annotations.TenantId;
import org.tkit.quarkus.jpa.models.TraceableEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "AI_KNOWLEDGE_URL")
@NamedEntityGraph(name = AIKnowledgeUrl.AI_KNOWLEDGE_URL_LOAD, includeAllAttributes = true)
public class AIKnowledgeUrl extends TraceableEntity {

    public static final String AI_KNOWLEDGE_URL_LOAD = "AI_KNOWLEDGE_URL_LOAD";

    @TenantId
    @Column(name = "TENANT_ID")
    private String tenantId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "URL")
    private String url;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "CONTEXT_ID")
    private AIContext aiContext;

}
