package org.ectimel.dietgenerator.infrastructure.persistance;

public interface DatabaseMapper<D, E> {
    D mapToDomain(E entityObject);
    E mapToEntity(D domainObject);
}
