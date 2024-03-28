package org.ectimel.dietgenerator.infrastructure.persistance.mongo;

import org.ectimel.dietgenerator.infrastructure.persistance.mongo.documents.MongoUUIDEntity;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidEntityEventListener extends AbstractMongoEventListener<MongoUUIDEntity> {

    @Override
    public void onBeforeConvert(BeforeConvertEvent<MongoUUIDEntity> event) {
        super.onBeforeConvert(event);
        MongoUUIDEntity mongoUUIDEntity = event.getSource();

        if(mongoUUIDEntity.getId() == null) {
            mongoUUIDEntity.setId(UUID.randomUUID());
        }
    }

}
