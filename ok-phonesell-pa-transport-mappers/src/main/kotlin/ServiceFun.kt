import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContext
import ru.otus.otuskotlin.phonesell.pa.common.be.models.MpDemandModel
import ru.otus.otuskotlin.phonesell.pa.common.be.models.MpDemandProductsIdModel
import ru.otus.otuskotlin.phonesell.pa.common.be.models.MpDemandProductsModel
import ru.otus.otuskotlin.phonesell.pa.transport.models.demands.DemandProductsDto
import ru.otus.otuskotlin.phonesell.pa.transport.models.demands.MpRequestDemandCreate

private fun MpBeContext.setQuery(request: MpRequestDemandCreate){
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
        quantity=this.quantity?: "",
        price=this.price?: "",
    )