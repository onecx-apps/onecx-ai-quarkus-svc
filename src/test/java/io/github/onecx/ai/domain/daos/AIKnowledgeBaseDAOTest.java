package io.github.onecx.ai.domain.daos;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.tkit.quarkus.jpa.exceptions.DAOException;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class AIKnowledgeBaseDAOTest {
    @Inject
    AIKnowledgeBaseDAO dao;

    @InjectMock
    EntityManager em;

    @BeforeEach
    void beforeAll() {
        Mockito.when(em.getCriteriaBuilder()).thenThrow(new RuntimeException("Test technical error exception"));
    }

    @Test
    void methodExceptionTests() {
        methodExceptionTests(() -> dao.findById(null),
                AIKnowledgeBaseDAO.ErrorKeys.FIND_ENTITY_BY_ID_FAILED);
        methodExceptionTests(() -> dao.findAIKnowledgeBasesByCriteria(null),
                AIKnowledgeBaseDAO.ErrorKeys.ERROR_FIND_KBS_BY_CRITERIA);
        methodExceptionTests(() -> dao.findAll(0, 2),
                AIKnowledgeBaseDAO.ErrorKeys.ERROR_FIND_ALL_KB_PAGE);
    }

    void methodExceptionTests(Executable fn, Enum<?> key) {
        var exc = Assertions.assertThrows(DAOException.class, fn);
        Assertions.assertEquals(key, exc.key);
    }
}
