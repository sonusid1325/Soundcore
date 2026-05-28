/*
 * SoundCore (2026)
 * Â© Chartreux Westia â€” github.com/koiverse
 * GPL-3.0 License | Contributors: see git history
 * Do not remove or alter this notice. - Per GPL-3.0 Section 4 & Section 5
 */

package app.sonusid.soundcore.ai

import androidx.compose.runtime.Immutable
import app.sonusid.soundcore.constants.AiProvider

@Immutable
data class AiModelOption(
    val id: String,
    val displayName: String,
)

@Immutable
data class AiServiceConfig(
    val provider: AiProvider,
    val apiKey: String,
    val customEndpoint: String,
    val model: String,
) {
    val canCallApi: Boolean
        get() = provider != AiProvider.NONE &&
            apiKey.isNotBlank() &&
            (provider != AiProvider.CUSTOM || customEndpoint.isNotBlank())
}
