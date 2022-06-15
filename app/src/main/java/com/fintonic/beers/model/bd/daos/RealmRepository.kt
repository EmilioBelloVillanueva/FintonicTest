package com.fintonic.beers.model.bd.daos

import io.realm.Realm
import io.realm.RealmModel
import io.realm.RealmQuery
import org.modelmapper.ModelMapper
import kotlin.streams.toList

class RealmRepository<In, Out>(private val typeIn: Class<In>, private val typeOut: Class<Out>) {

    fun save(entity: In) {
        val realm = realm
        val modelMapper = ModelMapper()
        val entityRealm: Out = modelMapper.map(entity, typeOut)
        realm.beginTransaction()
        realm.insertOrUpdate(entityRealm as RealmModel)
        realm.commitTransaction()
        realm.close()
    }

    fun save(entities: List<In>) {
        if (entities.isNotEmpty()) {
            val modelMapper = ModelMapper()
            val entitiesOut: List<Out> = entities.stream().map {
                val entityRealm: Out = modelMapper.map(it, typeOut)
                entityRealm
            }.toList()

            val realm = realm
            realm.beginTransaction()
            realm.insertOrUpdate(entitiesOut as Collection<RealmModel>)
            realm.commitTransaction()
            realm.close()
        }
    }

    fun saveDAO(entities: List<Out>) {
        if (entities.isNotEmpty()) {
            val realm = realm
            realm.beginTransaction()
            realm.insertOrUpdate(entities as Collection<RealmModel>)
            realm.commitTransaction()
            realm.close()
        }
    }

    fun fetchAll(query: RealmQuery<RealmModel>): List<In> {
        return fetchQuery(query)
    }

    fun fetch(query: RealmQuery<RealmModel>): In? {
        val entities: List<In> = fetchQuery(query)
        return if (entities.isNotEmpty()) {
            entities[0]
        } else {
            null
        }
    }

    private fun fetchQuery(query: RealmQuery<RealmModel>): List<In> {
        val entitiesDAO = query.findAll()
        val modelMapper = ModelMapper()

        val entities: List<In> = entitiesDAO.stream().map {
            val entity: In = modelMapper.map(it, typeIn)
            entity
        }.toList()

        return entities
    }

    fun update(entity: In) {
        save(entity)
    }

    fun update(entities: List<In>) {
        save(entities)
    }

    fun delete(query: RealmQuery<RealmModel?>) {
        val realm = realm
        realm.beginTransaction()
        val result = query.findAll()
        result.deleteAllFromRealm()
        realm.commitTransaction()
        realm.close()
    }

    private val realm: Realm
        get() = Realm.getDefaultInstance()
}