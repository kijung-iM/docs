package com.mongodb.internal.connection;

import com.mongodb.connection.ClusterDescription;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.selector.ServerSelector;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;

@Weaving
abstract class BaseCluster {
    private volatile ClusterDescription description;

    public void selectServerAsync(final ServerSelector serverSelector, final SingleResultCallback<Server> callback) {
        DefaultServerConnection.weaveClusterDescription = description;
        OriginMethod.call();
    }
}
