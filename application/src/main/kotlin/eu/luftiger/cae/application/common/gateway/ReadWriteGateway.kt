package eu.luftiger.cae.application.common.gateway

interface ReadWriteGateway<T, ID> {
    fun save(entity: T): T
    fun findById(id: ID): T?
    fun deleteById(id: ID)
}