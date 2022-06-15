package com.fintonic.beers.model.data.entitiesVO.mappers

import com.fintonic.beers.model.data.entities.Beer
import com.fintonic.beers.model.data.entitiesVO.BeerVo

class BeerVOMapper {

    fun Beer.entityToEntityVO() = BeerVo(
        id = this.id,
        imgUrl = this.imageUrl,
        name = this.name,
        description = this.description
    )
}