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
@Table(name = "AI_KNOWLEDGE_DOCUMENT")
@NamedEntityGraph(name = AIKnowledgeDocument.AI_KNOWLEDGE_DOCUMENT_LOAD, includeAllAttributes = true)
public class AIKnowledgeDocument extends TraceableEntity {

    public static final String AI_KNOWLEDGE_DOCUMENT_LOAD = "AI_KNOWLEDGE_DOCUMENT_LOAD";

    @TenantId
    @Column(name = "TENANT_ID")
    private String tenantId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DOC_REF_ID")
    private String documentRefId;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private DocumentStatusType status;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "CONTEXT_ID")
    private AIContext aiContext;

    public enum DocumentStatusType {
        NEW,
        PROCESSING,
        EMBEDDED
    }

}
