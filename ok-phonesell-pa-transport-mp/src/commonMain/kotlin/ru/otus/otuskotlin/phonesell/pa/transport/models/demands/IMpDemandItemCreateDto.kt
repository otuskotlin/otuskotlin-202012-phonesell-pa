package ru.otus.otuskotlin.phonesell.pa.transport.models.demands

interface IMpDemandItemCreateDto {
    val lastName: String?
    val firstName: String?
    val contactPhone: String?
    val email: String?
    val products: Set<DemandProductsDto>?
}