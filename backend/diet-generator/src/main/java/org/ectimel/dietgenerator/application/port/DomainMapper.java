package org.ectimel.dietgenerator.application.port;

public interface DomainMapper<D, E> {
    D mapToDomain(E entityObject);
    E mapFromDomain(D domainObject);
}
