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
@Table(name = "AI_KNOWLEDGE_VDB")
@NamedEntityGraph(name = AIKnowledgeVectorDb.AI_KNOWLEDGE_VDB_LOAD, includeAllAttributes = true)
public class AIKnowledgeVectorDb extends TraceableEntity {

    public static final String AI_KNOWLEDGE_VDB_LOAD = "AI_KNOWLEDGE_VDB_LOAD";

    @TenantId
    @Column(name = "TENANT_ID")
    private String tenantId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "VDB")
    private String vdb;

    @Column(name = "VDB_COLLECTION")
    private String vdbCollection;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "CONTEXT_ID")
    private AIContext aiContext;

}
