package com.oms.gemfire;

import org.apache.geode.cache.CacheLoader;
import org.apache.geode.cache.CacheLoaderException;
import org.apache.geode.cache.LoaderHelper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Properties;

public class GemfireCacheLoader<T> implements CacheLoader<String, T> {

    private JpaRepository<T, String> repository;

    public void setRepository(JpaRepository<T, String> repository) {
        this.repository = repository;
    }

    @Override
    public T load(LoaderHelper<String, T> loaderHelper) throws CacheLoaderException {
        return repository.findById(loaderHelper.getKey()).get();
    }

    @Override
    public void close() {

    }

    @Override
    public void init(Properties props) {

    }
}
