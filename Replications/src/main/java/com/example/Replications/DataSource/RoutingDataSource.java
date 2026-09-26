/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
 *  org.springframework.transaction.support.TransactionSynchronizationManager
 */
package com.example.Replications.DataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class RoutingDataSource
extends AbstractRoutingDataSource {
    protected Object determineCurrentLookupKey() {
        boolean readOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
        String key = readOnly ? "REPLICA" : "MASTER";
        System.out.println("RoutingDataSource -> readOnly=" + readOnly + ", datasource=" + key);
        return key;
    }
}
