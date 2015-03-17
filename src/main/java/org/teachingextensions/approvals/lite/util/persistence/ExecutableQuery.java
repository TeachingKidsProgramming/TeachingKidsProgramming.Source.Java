package org.teachingextensions.approvals.lite.util.persistence;

public interface ExecutableQuery
{
    public abstract String executeQuery(String query) throws Exception;
}