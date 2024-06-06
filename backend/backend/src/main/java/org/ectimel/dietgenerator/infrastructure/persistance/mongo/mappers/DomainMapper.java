package org.ectimel.dietgenerator.infrastructure.persistance.mongo.mappers;

public interface DomainMapper<D, E> {
    D mapToDomain(E entityObject);
    E mapFromDomain(D domainObject);
}

