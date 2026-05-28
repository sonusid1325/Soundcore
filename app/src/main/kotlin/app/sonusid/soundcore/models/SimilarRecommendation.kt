/*
 * SoundCore (2026)
 * © Chartreux Westia — github.com/koiverse
 * GPL-3.0 License | Contributors: see git history
 * Do not remove or alter this notice. - Per GPL-3.0 Section 4 & Section 5
 */





package app.sonusid.soundcore.models

import app.sonusid.soundcore.innertube.models.YTItem
import app.sonusid.soundcore.db.entities.LocalItem

data class SimilarRecommendation(
    val title: LocalItem,
    val items: List<YTItem>,
)
