package org.ectimel.dietgenerator.infrastructure.persistance.mongo.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Getter
@SuperBuilder
public abstract class MongoUUIDEntity {

    @Id
    protected UUID id;

    public void setId(UUID id) {
        if (this.id != null) throw new UnsupportedOperationException("ID is already defined");

        this.id = id;
    }

}
