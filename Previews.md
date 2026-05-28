# Preview Functions

A list of all preview-related functions found in the **ArchiveTune** project.

---

## 🎨 Composable Previews (`@Preview`)

These are Jetpack Compose functions annotated with `@Preview` used for UI previews in Android Studio.

### 1. `PalettePickerScreenPreview()`
- **File:** [`PalettePickerScreen.kt`](app/src/main/kotlin/moe/koiverse/soundcore/ui/screens/settings/PalettePickerScreen.kt#L1617-L1623)
- **Line:** 1619
- **Annotation:** `@Preview(showBackground = true)`
- **Visibility:** `private`
- **Description:** Renders a full preview of the `PalettePickerScreen` wrapped in `MaterialTheme` with a `rememberNavController()`.

---

### 2. `SelectableMiniPalettePreview()`
- **File:** [`PalettePickerScreen.kt`](app/src/main/kotlin/moe/koiverse/soundcore/ui/screens/settings/PalettePickerScreen.kt#L1625-L1638)
- **Line:** 1627
- **Annotation:** `@Preview(showBackground = true)`
- **Visibility:** `private`
- **Description:** Renders a row of `SelectableMiniPalette` items using `ThemePalettes.Default`, `OceanBlue`, and `EmeraldGreen` palettes — one selected, two unselected.

---

## 🖼️ Preview UI Component Functions

These are `@Composable` functions that serve as internal preview/display containers (not annotated with `@Preview`, but named and used as preview components).

### 3. `SimpleThemePreview(palette, modifier)`
- **File:** [`PalettePickerScreen.kt`](app/src/main/kotlin/moe/koiverse/soundcore/ui/screens/settings/PalettePickerScreen.kt#L1192-L1240)
- **Line:** 1193
- **Visibility:** `private`
- **Parameters:**
  - `palette: ThemeSeedPalette`
  - `modifier: Modifier = Modifier`
- **Description:** A Composable that renders a dynamic SVG-based theme color preview using a `TonalPalettes` computed from the seed palette colors. Displayed as a card with an aspect ratio of `1.38f`.

---

### 4. `PreviewContainer(payload, mediaMetadata, selectedGlassStyle, options, isCompactLayout, modifier)`
- **File:** [`LyricsShareDialog.kt`](app/src/main/kotlin/moe/koiverse/soundcore/ui/component/LyricsShareDialog.kt#L503-L501)
- **Line:** 504
- **Visibility:** `private`
- **Parameters:**
  - `payload: LyricsSharePayload`
  - `mediaMetadata: MediaMetadata?`
  - `selectedGlassStyle: LyricsGlassStyle`
  - `options: LyricsShareImageOptions`
  - `isCompactLayout: Boolean`
  - `modifier: Modifier = Modifier`
- **Description:** A Composable container that renders a live preview of the lyrics share image within the share dialog. Adapts the preview width fraction and max width based on the aspect ratio (`Square`, `Portrait`, `Story`) and whether the layout is compact.

---

## 🗄️ Database Query Preview Functions

These are Room DAO query functions that fetch a limited "preview" set of data rows from the database.

### 5. `artistSongsPreview(artistId, previewSize)`
- **File:** [`DatabaseDao.kt`](app/src/main/kotlin/moe/koiverse/soundcore/db/DatabaseDao.kt#L334-L341)
- **Line:** 338
- **Annotations:** `@Transaction`, `@Query`
- **Parameters:**
  - `artistId: String`
  - `previewSize: Int = 3`
- **Returns:** `Flow<List<Song>>`
- **Description:** Queries a limited number of songs (default: 3) by a given artist that are in the library, for use in preview/summary displays on artist pages.

---

### 6. `artistAlbumsPreview(artistId, previewSize)`
- **File:** [`DatabaseDao.kt`](app/src/main/kotlin/moe/koiverse/soundcore/db/DatabaseDao.kt#L548-L559)
- **Line:** 559
- **Annotations:** `@Query`
- **Parameters:**
  - `artistId: String`
  - `previewSize: Int = 6`
- **Returns:** `Flow<List<Album>>`
- **Description:** Queries a limited number of albums (default: 6) associated with a given artist, for use in preview/summary displays on artist pages.

---

## 🎵 Streaming / Playback Preview Detection

### 7. `isLikelyPreview(format, expectedDurationMs)`
- **File:** [`YTPlayerUtils.kt`](app/src/main/kotlin/moe/koiverse/soundcore/utils/YTPlayerUtils.kt#L890-L897)
- **Line:** 890
- **Visibility:** `private`
- **Parameters:**
  - `format: PlayerResponse.StreamingData.Format`
  - `expectedDurationMs: Long`
- **Returns:** `Boolean`
- **Description:** Heuristic utility that determines whether a given audio stream format is likely a short "preview clip" rather than the full track. Returns `true` if the stream's approximate duration is between 1ms and the lesser of 90 seconds or 90% of the expected full duration (and the full track is at least 90 seconds long).

---

## Summary

| # | Function Name | Type | File | Line |
|---|---------------|------|------|------|
| 1 | `PalettePickerScreenPreview` | `@Preview` Composable | `PalettePickerScreen.kt` | 1619 |
| 2 | `SelectableMiniPalettePreview` | `@Preview` Composable | `PalettePickerScreen.kt` | 1627 |
| 3 | `SimpleThemePreview` | UI Preview Component | `PalettePickerScreen.kt` | 1193 |
| 4 | `PreviewContainer` | UI Preview Component | `LyricsShareDialog.kt` | 504 |
| 5 | `artistSongsPreview` | DB Query (preview rows) | `DatabaseDao.kt` | 338 |
| 6 | `artistAlbumsPreview` | DB Query (preview rows) | `DatabaseDao.kt` | 559 |
| 7 | `isLikelyPreview` | Stream Detection Util | `YTPlayerUtils.kt` | 890 |
