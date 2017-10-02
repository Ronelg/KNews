package com.knews.android.model.dao

import android.arch.persistence.room.*
import com.knews.android.data.Source

/**
 * Created by ronelg on 10/2/17.
 */
@Dao
interface SourceDao {

    /**
     * Select all sources from the sources table.
     *
     * @return all sources.
     */
    @Query("SELECT * FROM Sources")
    fun getSources(): List<Source>

    /**
     * Select a source by id.
     */
    @Query("SELECT * FROM Sources WHERE id = :sourceId")
    fun getSourceById(sourceId: String): Source

    /**
     * Insert a source in the database. If the source already exists, replace it.
     *
     * @param source the source to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSource(source: Source)

    /**
     * Update a source.
     *
     * @param source task to be updated
     * @return the number of source updated. This should always be 1.
     */
    @Update
    fun updateSource(source: Source): Int


    /**
     * Delete all sources.
     */
    @Query("DELETE FROM Sources")
    fun deleteSources()
}