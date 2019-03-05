package com.sigma.sudokuworld.persistence.db.daos

import android.arch.persistence.room.*
import com.sigma.sudokuworld.persistence.db.entities.Game

@Dao
interface GameSaveDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg game: Game)

    @Update
    fun update(game: Game)

    @Query("DELETE FROM game_saves")
    fun deleteAll()

    @Query("SELECT * FROM game_saves")
    fun getAll(): List<Game>

    @Query("SELECT * FROM game_saves WHERE saveID == :saveID LIMIT 1")
    fun getGameSaveByID(saveID: Int): Game
}
