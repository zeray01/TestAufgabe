package com.example.testaufgabe.data.mapper

import com.example.testaufgabe.domain.model.SWItem
import com.example.testaufgabe.domain.model.SwapiResourceType

interface SWItemMapper {
    fun map(resourceType: SwapiResourceType, raw: Map<String, Any?>): SWItem
}
