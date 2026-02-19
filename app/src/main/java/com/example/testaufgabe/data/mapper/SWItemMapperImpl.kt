package com.example.testaufgabe.data.mapper

import com.example.testaufgabe.domain.model.SWItem
import com.example.testaufgabe.domain.model.SwapiResourceType

class SWItemMapperImpl : SWItemMapper {
    override fun map(
        resourceType: SwapiResourceType,
        raw: Map<String, Any?>
    ): SWItem {
        val url = raw["url"]?.toString().orEmpty()
        val id = url.trimEnd('/').substringAfterLast('/')

        return when (resourceType) {
            SwapiResourceType.PEOPLE -> SWItem(
                id = id,
                title = raw["name"]?.toString().orEmpty(),
                subtitle = "Gender: ${raw["gender"] ?: "unknown"}"
            )

            SwapiResourceType.PLANETS -> SWItem(
                id = id,
                title = raw["name"]?.toString().orEmpty(),
                subtitle = "Climate: ${raw["climate"] ?: "unknown"}"
            )

            SwapiResourceType.FILMS -> SWItem(
                id = id,
                title = raw["title"]?.toString().orEmpty(),
                subtitle = "Episode: ${raw["episode_id"] ?: "-"}"
            )

            SwapiResourceType.SPECIES -> SWItem(
                id = id,
                title = raw["name"]?.toString().orEmpty(),
                subtitle = "Classification: ${raw["classification"] ?: "unknown"}"
            )

            SwapiResourceType.VEHICLES -> SWItem(
                id = id,
                title = raw["name"]?.toString().orEmpty(),
                subtitle = "Model: ${raw["model"] ?: "unknown"}"
            )

            SwapiResourceType.STARSHIPS -> SWItem(
                id = id,
                title = raw["name"]?.toString().orEmpty(),
                subtitle = "Model: ${raw["model"] ?: "unknown"}"
            )
        }
    }
}
