package org.ectimel.dietgenerator.infrastructure.persistance.mongo.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@AllArgsConstructor
public class ProductAmount {

    @DBRef
    private ProductDocument product;
    private Double percentage;
}
