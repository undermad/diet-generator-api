package org.ectimel.dietgenerator.domain.port;

public interface DomainMapper<D, E> {
    D mapToDomain(E entityObject);
    E mapFromDomain(D domainObject);
}
