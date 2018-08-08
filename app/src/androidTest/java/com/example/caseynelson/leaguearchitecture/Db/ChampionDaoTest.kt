package com.example.caseynelson.leaguearchitecture.Db

import android.support.test.runner.AndroidJUnit4
import com.example.caseynelson.leaguearchitecture.Util.LiveDataTestUtil
import com.example.caseynelson.leaguearchitecture.model.ChampionDto
import junit.framework.Assert.assertTrue
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ChampionDaoTest : DbTest() {

    @Test
    fun getChampion_shouldGetNoItem_IfTable_IsEmpty() {
        val item = LiveDataTestUtil.getValue(db.ChampionDao().getChampion("Ashe"))
        assertThat(item, nullValue())
    }

    @Test
    fun getChampionList_shouldGetEmptyList_IfTable_IsEmpty() {
        val list: List<ChampionDto> = LiveDataTestUtil.getValue(db.ChampionDao().getAllChampions())
        assertTrue(list.isEmpty())
    }

    @Test
    fun insertAndRead() {
        val champion = ChampionDto(1, "Queen of Arrows", "Ashe")
        db.ChampionDao().insert(champion)

        val item = LiveDataTestUtil.getValue(db.ChampionDao().getChampion("Ashe"))
        assertThat(item, notNullValue())
        assertThat(item.name, `is`("Ashe"))
        assertThat(item.title, `is`("Queen of Arrows"))
        assertThat(item.id, `is`(1))
    }

    @Test
    fun insertAllAndRead() {
        val ashe = ChampionDto(1, "Queen of Arrows", "Ashe")
        val bardock = ChampionDto(2, "Goku's Dad", "Bardock")
        val list = arrayListOf(ashe,bardock)
        db.ChampionDao().insertAll(list)

        val item = LiveDataTestUtil.getValue(db.ChampionDao().getAllChampions())
        assertThat(item, notNullValue())
        assertThat(item.size, `is`(2))
        assertThat(item[0], `is`(ashe))
        assertThat(item[1], `is`(bardock))
    }
}