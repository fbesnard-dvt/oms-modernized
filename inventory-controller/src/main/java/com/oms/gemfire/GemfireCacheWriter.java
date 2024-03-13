package com.oms.gemfire;

import org.apache.geode.cache.CacheWriter;
import org.apache.geode.cache.CacheWriterException;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.RegionEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Properties;

public class GemfireCacheWriter<T> implements CacheWriter<String, T> {

    private JpaRepository<T, String> repository;

    public void setRepository(JpaRepository<T, String> repository) {
        this.repository = repository;
    }

    @Override
    public void beforeUpdate(EntryEvent<String, T> entryEvent) throws CacheWriterException {
        repository.save(entryEvent.getNewValue());
    }

    @Override
    public void beforeCreate(EntryEvent<String, T> entryEvent) throws CacheWriterException {
        repository.save(entryEvent.getNewValue());
    }

    @Override
    public void beforeDestroy(EntryEvent<String, T> entryEvent) throws CacheWriterException {

    }

    @Override
    public void beforeRegionDestroy(RegionEvent<String, T> regionEvent) throws CacheWriterException {

    }

    @Override
    public void beforeRegionClear(RegionEvent<String, T> regionEvent) throws CacheWriterException {

    }

    @Override
    public void close() {

    }

    @Override
    public void init(Properties props) {

    }
}
