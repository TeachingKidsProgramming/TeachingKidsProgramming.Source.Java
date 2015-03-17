package org.teachingkidsprogramming.util.persistence;

public interface ExecutableQuery
{
    public abstract String executeQuery(String query) throws Exception;
}