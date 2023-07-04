package com.mongodb.internal.connection;

import com.mongodb.async.SingleResultCallback;
import com.mongodb.connection.ClusterDescription;
import com.mongodb.connection.Server;
import com.mongodb.selector.ServerSelector;
import whatap.agent.api.weaving.OriginMethod;
import whatap.agent.api.weaving.Weaving;

@Weaving
public class BaseCluster {
    private volatile ClusterDescription description;

    public void selectServerAsync(final ServerSelector serverSelector, final SingleResultCallback<Server> callback) {
        DefaultServerConnection.weaveClusterDescription = description;
        OriginMethod.call();
    }
}
