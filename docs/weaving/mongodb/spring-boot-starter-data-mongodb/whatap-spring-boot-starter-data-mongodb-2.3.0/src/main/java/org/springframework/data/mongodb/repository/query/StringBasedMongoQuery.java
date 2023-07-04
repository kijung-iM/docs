package org.springframework.data.mongodb.repository.query;

import org.springframework.data.mongodb.core.query.Query;

import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;

@Weaving
public class StringBasedMongoQuery extends AbstractMongoQuery {
    private String query;
    protected Query createQuery(ConvertingParameterAccessor accessor) {
        super.hookQuery = this.query;
        return OriginMethod.call();
    }
}
