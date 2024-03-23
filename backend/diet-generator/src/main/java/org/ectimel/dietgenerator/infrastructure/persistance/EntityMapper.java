package org.ectimel.dietgenerator.infrastructure.persistance;

public interface EntityMapper<D, E> {
    D mapToDomain(E entityObject);
    E mapToEntity(D domainObject);
}
