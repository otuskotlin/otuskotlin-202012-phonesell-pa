package ru.otus.otuskotlin.phonesell.pa.transport.mappers

import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContext
import ru.otus.otuskotlin.phonesell.pa.common.be.models.*
import ru.otus.otuskotlin.phonesell.pa.transport.models.demands.*
import java.math.BigDecimal

fun MpBeContext.setQuery(request: MpRequestDemandCreate){
    requestDemand= MpDemandModel(
        lastName = request.createData?.lastName?:"",
        firstName = request.createData?.firstName?:"",
        contactPhone = request.createData?.contactPhone?:"",
        email = request.createData?.email?:"",
        products = request.createData?.products?.map { it.toDemandProductModel() }?.toMutableSet()?: mutableSetOf()
    )
}
private fun DemandProductsDto.toDemandProductModel() =
    MpDemandProductsModel(
        id = this.id?.let { MpDemandProductsIdModel(it) }?: MpDemandProductsIdModel.NONE,
        idProduct = this.idProduct?: "",
        quantity =this.quantity?.toIntOrNull()?:0,
        price = this.price?.toBigDecimalOrNull()?: BigDecimal.ZERO,

        )




fun MpBeContext.setQuery(query: MpRequestDemandRead) = apply {
    requestDemandId = query.demandId?.let { MpDemandIdModel(it) }?: MpDemandIdModel.NONE

    stubCase = when (query.stubCase) {
        MpRequestDemandRead.StubCase.SUCCESS -> MpStubCase.DEMAND_READ_SUCCESS

        else -> MpStubCase.NONE
    }
}



fun MpBeContext.respondDemandGet() = MpResponseDemandRead(
    demand = responseDemand.takeIf { it != MpDemandModel.NONE }?.toTransport()
)

private fun MpDemandModel.toTransport() = MpDemandDto(
    id = id.id.takeIf { it.isNotBlank()},
    firstName = firstName.takeIf {it.isNotBlank()},
    lastName = lastName.takeIf {it.isNotBlank()},
    contactPhone = contactPhone.takeIf {it.isNotBlank()},
    email =email.takeIf {it.isNotBlank()},
    products = products?.map { it.toDemandProductsDto() }?.toMutableSet()?: mutableSetOf()
)


private fun MpDemandProductsModel.toDemandProductsDto() =
    DemandProductsDto(
        id = this.id?.toString(),
        idProduct = this.idProduct?: "",
        quantity =this.quantity?.toString(),
        price = this.price?.toString(),

        )